package com.spc.service.manage.impl;

import com.github.pagehelper.PageHelper;
import com.spc.dao.*;
import com.spc.model.ClassApplicationDomain;
import com.spc.model.ClassDomain;
import com.spc.model.StudentApplicationDomain;
import com.spc.service.manage.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private TimeSwitchDao timeSwitchDao;

    @Override
    public String[][] findClasses(String stuId) {
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
    public String[][] bigTable(String shenQingRenId, String shenQingRenName,String teaName) {

        List<HashMap<String, Object>> lis = classDao.findAllClasseSimpleMess( shenQingRenId,  shenQingRenName, teaName);
        String temp[][] = new String[10][7];
        for (HashMap<String, Object> li : lis) {
//            System.out.println(li);
            String date = (String) li.get("classDateDescription");
            String classPlace = (String) li.get("classPlace");
            String mainLecturer = (String) li.get("mainLecturer");
            String teacherName = (String) li.get("teaName");
            String startWeek = Integer.toString((Integer) li.get("startWeek"));
            String endWeek = Integer.toString((Integer) li.get("endWeek"));
            String classNum = Integer.toString((Integer) li.get("classNum"));
            String className = (String) li.get("className");

            String[] ints = date.split(":");
            Integer r = ints[0].toCharArray()[0] - '0';
            Integer l = ints[1].toCharArray()[0] - '0';

            String context = "★课程：" + className + ',' + "教室：" + classPlace + ',' + "授课教师：" + teacherName + ','+ "主讲教师：" + mainLecturer + ',' + "周次：" + startWeek + "-" + endWeek + ',' + "班次：" + classNum;
            temp[(l - 1) * 2][r - 1] = temp[(l - 1) * 2][r - 1] != null ? temp[(l - 1) * 2][r - 1] + "," + context : context;
            temp[(l - 1) * 2 + 1][r - 1] = temp[(l - 1) * 2 + 1][r - 1] != null ? temp[(l - 1) * 2 + 1][r - 1] + "," + context : context;
        }
        return temp;
    }

    @Override
    public List<StudentApplicationDomain> checkedMessage(int key, String stuId) {

        return studentApplicationDao.findall(key, stuId);
    }

    @Override
    public List<StudentApplicationDomain> checkedMessageAndDate(int key, String stuId, Date date) {
        java.sql.Date dateSql = new java.sql.Date(date.getTime());
        System.out.println(dateSql);
        return studentApplicationDao.findallWithDate(key, stuId, dateSql);
    }

    @Override
    @Transactional
    public int  chooseCourse(int classId,String stuId){
        if(classDao.haveStuInClass(classId,stuId)==null){
            classDao.updateChooseNum(classId, 1);
            studentDao.addChooseCourse(stuId, classId);
        }
        return 0;
    }

    @Override
    @Transactional
    public int deleteCourse(int classId, String stuId) {
        classDao.updateChooseNum(classId, -1);
        studentDao.deleteChooseCourse(stuId, classId);
        return 0;
    }

    @Override
    public int makeSure(int id,String classStr) {
        //通过的话就要将checked设置为1
        //通过的话要根据请求的内容做相应的调整
        StudentApplicationDomain studentApplicationDomain = studentApplicationDao.selectById(id);
        String stuId = studentApplicationDomain.getStuId();
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
//                chooseCourse(oldClassId,stuId);
                deleteCourse(oldClassId,stuId);
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
    public void deleteCourseRecord(int classId) {
        classDao.delete(classId);
    }



    @Override
    public int addCourseStudent(String stuId, String classStr) {
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
    public int deleteCourseStudent(String stuId, String classStr) {
        String newStr = classStr.replace("(",",").replace(")","");
        String[] strs = newStr.substring(0,newStr.length()-1).split(",");

        System.out.println(newStr);
        String className = strs[0];
        Integer classNum = Integer.parseInt(strs[1]);
        int classId = (int) studentDao.findClassesByNameAndNum(className,classNum).get("classId");
        deleteCourse(classId,stuId);
        return 0;
    }

    @Override
    public int getClassId(String className, int classNum) {
        return   (int) studentDao.findClassesByNameAndNum(className,classNum).get("classId");
    }

    @Override
    public int deleteApplication(int id) {
        classApplicationDao.deleteClassApp(id);
        return 0;
    }

    @Override
    public List findStudentByClassnameAndNum(String className, int classNum,int pageSize,int currentPage) {
        int classId = (int) studentDao.findClassesByNameAndNum(className,classNum).get("classId");

        PageHelper.startPage(currentPage, pageSize);
        return studentDao.findStudent(classId);
    }

    @Override
    public List<ClassApplicationDomain> checkedClassMessage(String shenQingRenId, String className,  int tabKey,String shenqingrenname) {
        return classApplicationDao.findallClass(shenQingRenId, className, tabKey,shenqingrenname);
    }

    @Override
    public List<ClassApplicationDomain> checkedClassMessageAndDate(String shenQingRenId, String className, Date date, int tabKey,String shenqingrenname) {
        java.sql.Date dateSql = new java.sql.Date(date.getTime());
        System.out.println("时间time是======"+dateSql);
        return classApplicationDao.findallClassWithDate(shenQingRenId, className, date, tabKey,shenqingrenname);
    }

    @Override
    public int addTimeSwitch(int timeSwitch) {
        return timeSwitchDao.add(timeSwitch);
    }

    @Override
    public int updateTimeSwitch(int timeSwitch) {
        return timeSwitchDao.updateTimeSwitch(timeSwitch);
    }


    @Override
    public List<Map> jilianSelect() {
        List<ClassDomain> classes = classDao.selectClasses(88888888, "", "", "", 88888888, 88888888, 1, 88888888);

        List<Map> res = new ArrayList<>();

        List<String> departTemp = new ArrayList<String>();
        List<String> classTemp = new ArrayList<String>();
        for (ClassDomain cd : classes) {
            //判断是否这个学院
            String departName = cd.getDepartName();
            int classId = cd.getClassId();
            String className = cd.getClassName();
            int classNum = cd.getClassNum();
            int departId = cd.getDepartId();
            String allClassName = cd.getDepartName() + cd.getClassName();

            boolean in = false;
            if(departTemp.size()!=0){
                for (String s : departTemp) {
                    if (s.equals(departName)) in = true;
                }
            }
            if(!in) departTemp.add(departName);
            //没有这个学院
            if (!in) {
                //创造课程
                //创造学院
                Map departM = creatClassOrDepartMap(departName, departId);
                Map classM = creatClassOrDepartMap(className, classId);
                Map classStrM = creatClassStrMap(className, classNum);
                addClassOrDepart(classM, classStrM);
                addClassOrDepart(departM, classM);

                res.add(departM);
                classTemp.add(allClassName);
                departTemp.add(departName);
                //有这个学院
            } else {
                //判断有没有这个课程
                boolean in2 = false;
                if(classTemp.size()!=0){
                    for (String s : classTemp) {
                        if (s.equals(allClassName)) in2 = true;
                    }
                }
                if(!in2) classTemp.add(allClassName);
//                System.out.println(allClassName);
                //没有这个课程
                if (!in2) {

                    Map classM = creatClassOrDepartMap(className, classId);
                    Map classStrM = creatClassStrMap(className, classNum);
                    addClassOrDepart(classM, classStrM);
                    for (Map everyDe : res) {
                        if (everyDe.get("label").equals(departName)) {
                            addClassOrDepart(everyDe, classM);
                        }
                    }
                } else {//有这个课程
                    Map classStrM = creatClassStrMap(className, classNum);
                    for (Map everyDe : res) {
                        if (everyDe.get("label").equals(departName)) {
                            List<Map> list = (List<Map>) everyDe.get("children");
                            for (Map everyClass : list) {
                                if (everyClass.get("label").equals(className)) {
                                    List<Map> list2 = (List<Map>) everyClass.get("children");
                                    list2.add(classStrM);
                                }
                            }
                        }
                    }
                }
            }


        }
        return res;
    }


    public Map creatClassStrMap(String className,int classNum){
        Map tempChild2 = new HashMap();
        tempChild2.put("value", className + "(" + classNum + "班)");
        tempChild2.put("label", classNum + "班");
        return tempChild2;
    }
    public Map creatClassOrDepartMap(String className,int classId){
        Map tempChild2 = new HashMap();
        tempChild2.put("value", classId);
        tempChild2.put("label", className);
        List<Map> res = new ArrayList<>();
        tempChild2.put("children", res);
        return tempChild2;
    }
    public Map addClassOrDepart(Map classMap ,Map classStrMap){
        List<Map> res  = (List<Map>) classMap.get("children");
        res.add(classStrMap);
        return classMap;
    }

}
