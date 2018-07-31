package com.spc.service.manage.impl;

import com.github.pagehelper.PageHelper;
import com.spc.dao.*;
import com.spc.model.ClassApplicationDomain;
import com.spc.model.ClassDomain;
import com.spc.model.StudentApplicationDomain;
import com.spc.service.manage.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private ClassDao classDao;
    @Autowired
    private GradeDao gradeDao;

    @Autowired
    private StudentApplicationDao studentApplicationDao;

    @Autowired
    private ClassApplicationDao classApplicationDao;

    @Override
    public String[][] findClasses(Integer stuId) {
        List<HashMap<String, Object>> lis = studentDao.findClasses(stuId);
        String temp[][] = new String[10][7];
        for (HashMap<String, Object> li : lis) {
            String date = (String) li.get("classDateDescription");
            String classPlace = (String) li.get("classPlace");
            String teaName = (String) li.get("teaName");
            String className = (String) li.get("className");
            String startWeek = Integer.toString((Integer) li.get("startWeek"));
            String endWeek = Integer.toString((Integer) li.get("endWeek"));
            String classNum = Integer.toString((Integer) li.get("classNum"));

            String[] ints = date.split(":");
            Integer r = ints[0].toCharArray()[0] - '0';
            Integer l = ints[1].toCharArray()[0] - '0';

            String context = className + ',' + classPlace + ',' + teaName + ',' + startWeek + "-" + endWeek + ',' + classNum;

            temp[(r - 1) * 2][l - 1] = context;
            temp[(r - 1) * 2 + 1][l - 1] = context;
        }
        return temp;
    }

    @Override
    public String[][] bigTable() {

        List<HashMap<String, Object>> lis = classDao.findAllClasseSimpleMess();
        String temp[][] = new String[10][7];
        for (HashMap<String, Object> li : lis) {
//            System.out.println(li);
            String date = (String) li.get("classDateDescription");
            String classPlace = (String) li.get("classPlace");
            String teaName = (String) li.get("teaName");
            String startWeek = Integer.toString((Integer) li.get("startWeek"));
            String endWeek = Integer.toString((Integer) li.get("endWeek"));
            String classNum = Integer.toString((Integer) li.get("classNum"));
            String className = (String) li.get("className");

            String[] ints = date.split(":");
            Integer r = ints[0].toCharArray()[0] - '0';
            Integer l = ints[1].toCharArray()[0] - '0';

            String context = "★课程：" + className + ',' + "教室：" + classPlace + ',' + "教师：" + teaName + ',' + "周次：" + startWeek + "-" + endWeek + ',' + "班次：" + classNum;
            temp[(l - 1) * 2][r - 1] = temp[(l - 1) * 2][r - 1] != null ? temp[(l - 1) * 2][r - 1] + "," + context : context;
            temp[(l - 1) * 2 + 1][r - 1] = temp[(l - 1) * 2 + 1][r - 1] != null ? temp[(l - 1) * 2 + 1][r - 1] + "," + context : context;
        }
        return temp;
    }

    @Override
    public List<StudentApplicationDomain> checkedMessage(int key, int stuId) {

        return studentApplicationDao.findall(key, stuId);
    }

    @Override
    public List<StudentApplicationDomain> checkedMessageAndDate(int key, int stuId, Date date) {
        java.sql.Date dateSql = new java.sql.Date(date.getTime());
        System.out.println(dateSql);
        return studentApplicationDao.findallWithDate(key, stuId, dateSql);
    }

    @Override
    public int  chooseCourse(int classId,int stuId){
        classDao.updateChooseNum(classId, 1);
        studentDao.addChooseCourse(stuId, classId);
        return 0;
    }

    @Override
    public int deleteCourse(int classId, int stuId) {
        classDao.updateChooseNum(classId, -1);
        studentDao.deleteChooseCourse(stuId, classId);
        return 0;
    }

    @Override
    public int makeSure(int id,String classStr) {
        //通过的话就要将checked设置为1
        //通过的话要根据请求的内容做相应的调整
        StudentApplicationDomain studentApplicationDomain = studentApplicationDao.selectById(id);
        int stuId = studentApplicationDomain.getStuId();
        int classNum = studentApplicationDomain.getClassNum();
        int oldClassId = studentApplicationDomain.getClassId();

        switch (studentApplicationDomain.getCategory()){
            case "新增课程":
                System.out.println("新增课程");
                List<Map<String, Object>> res = studentDao.findTimeChongTu(stuId, oldClassId);
                boolean canAdd = gradeDao.selectGrade(oldClassId, stuId).isEmpty() && res.isEmpty();
                if (canAdd) {
                    chooseCourse(oldClassId,stuId);
                }
                break;
            case "调整班级":
                System.out.println("调整班级");
                deleteCourse(oldClassId,stuId);
                int newClassId = studentDao.findClassNewId(oldClassId,classNum);
                chooseCourse(newClassId,stuId);
                break;
            case "重修课程":
                System.out.println("重修课程");
                chooseCourse(oldClassId,stuId);
                break;
            case "退选计划":
                System.out.println("退选计划");
                chooseCourse(stuId,oldClassId);
                break;
        }
        return studentApplicationDao.checked(id, 1);
    }

    @Override
    public int makeSureClassApplication(int id) {
        return classApplicationDao.checkedClass(id, 1);
    }

    @Override
    public int reject(int id) {
        //拒绝的话就要将checked设置为3
        return studentApplicationDao.checked(id, 3);
    }

    @Override
    public int rejectClassApplication(int id) {
        return classApplicationDao.checkedClass(id, 3);
    }

    @Override
    public void addCourse(ClassDomain cd) {
       classDao.insert(cd);
    }

    @Override
    public void deleteCourse(int classId) {
        classDao.delete(classId);
    }



    @Override
    public int addCourseStudent(int stuId, String stuName, String classStr) {
        String newStr = classStr.replace("(",",").replace(")","");
        String[] strs = newStr.substring(0,newStr.length()-1).split(",");

        System.out.println(strs);
        String className = strs[0];
        Integer classNum = Integer.parseInt(strs[1]);
        int classId = (int) studentDao.findClassesByNameAndNum(className,classNum).get("classId");
        chooseCourse(classId,stuId);
        return 0;
    }

    @Override
    public int deleteCourseStudent(int stuId, String classStr) {
        String newStr = classStr.replace("(",",").replace(")","");
        String[] strs = newStr.substring(0,newStr.length()-1).split(",");

        System.out.println(strs);
        String className = strs[0];
        Integer classNum = Integer.parseInt(strs[1]);
        int classId = (int) studentDao.findClassesByNameAndNum(className,classNum).get("classId");
        deleteCourse(classId,stuId);
        return 0;
    }

    @Override
    public List findStudentByClassnameAndNum(String className, int classNum,int pageSize,int currentPage) {
        int classId = (int) studentDao.findClassesByNameAndNum(className,classNum).get("classId");

        PageHelper.startPage(currentPage, pageSize);
        return studentDao.findStudent(classId);
    }

    @Override
    public List<ClassApplicationDomain> checkedClassMessage(int shenQingRenId, String className, int tabKey) {
        return classApplicationDao.findall(shenQingRenId, className, tabKey);
    }

    @Override
    public List<ClassApplicationDomain> checkedClassMessageAndDate(int shenQingRenId, String className, Date date, int tabKey) {
        return classApplicationDao.findallWithDate(shenQingRenId, className, date, tabKey);
    }

}
