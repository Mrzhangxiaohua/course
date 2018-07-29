package com.spc.service.student.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spc.dao.ClassDao;
import com.spc.dao.GradeDao;
import com.spc.dao.StudentApplicationDao;
import com.spc.dao.StudentDao;
import com.spc.model.ClassDomain;
import com.spc.model.GradeDomain;
import com.spc.model.StudentApplicationDomain;
import com.spc.service.student.StudentService;
import com.spc.util.AuthMess;
import com.spc.util.CourseDateTrans;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ClassDao classDao;

    @Autowired
    private StudentApplicationDao studentApplicationDao;

    @Autowired
    private GradeDao gradeDao;

    @Autowired
    private CourseDateTrans courseDateTrans;

    @Autowired
    private AuthMess authMess;

    @Override
    public String[][] findClasses() {
        int stuId = authMess.userId();

        List<HashMap<String, Object>> lis = studentDao.findClasses(stuId);
        String temp[][] = new String[10][7];
        for (HashMap<String, Object> li : lis) {
            String date = (String) li.get("classDateDescription");
            String classPlace = (String) li.get("classPlace");
            String teaName = (String) li.get("teaName");
            System.out.println(li.get("startWeek"));
            String startWeek = Integer.toString((Integer) li.get("startWeek"));
            String endWeek = Integer.toString((Integer) li.get("endWeek"));
            String classNum = Integer.toString((Integer) li.get("classNum"));
            String className = (String) li.get("className");

            String[] ints = date.split(":");
            Integer r = ints[0].toCharArray()[0] - '0';
            Integer l = ints[1].toCharArray()[0] - '0';

            String context = "★课程：" + className + ',' + "教室：" + classPlace + ',' + "教师：" + teaName + ',' + "周次：" + startWeek + "-" + endWeek + ',' + "班次：" + classNum;
            temp[(l - 1) * 2][r - 1] = context;
            temp[(l - 1) * 2 + 1][r - 1] = context;
        }
        return temp;
    }

    @Override
    public int addCourse(int classId) {
        //首先得到学生id
        int stuId = authMess.userId();
        List<Map<String, Object>> res = studentDao.findTimeChongTu(stuId, classId);
        if (gradeDao.selectGrade(classId, stuId).isEmpty() && res.isEmpty()) {
            classDao.updateChooseNum(classId, 1);
            return studentDao.addChooseCourse(stuId, classId);
        } else {
            return 0;
        }
    }

    @Override
    public int deleteCourse(int classId) {
        int stuId = authMess.userId();
        if (gradeDao.selectGrade(classId, stuId).isEmpty() != true) {
            classDao.updateChooseNum(classId, -1);
            return studentDao.deleteChooseCourse(stuId, classId);
        } else {
            return 0;
        }
    }


    @Override
    public int addApplication(int classId, int states, String reason) {
        int stuId = authMess.userId();
        return studentApplicationDao.add(stuId, classId, states, reason, 1);
    }

    @Override
    public List<ClassDomain> selectClassed(Map<String, Object> map) {

        //获得学生id
        Integer stuId = (Integer) map.get("stuId");
        Integer currentPage = (Integer) map.get("currentPage");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer startWeek = (Integer) map.get("startWeek");
        Integer endWeek = (Integer) map.get("endWeek");
        Integer departId = (Integer) map.get("departId");
        Integer teaId = (Integer) map.get("teaId");
        String classname = (String) map.get("classname");
        String teaname = (String) map.get("teaname");
        Integer hasWaiGuoYu = (Integer) map.get("hasWaiGuoYu");

        List<GradeDomain> gradeDomains = gradeDao.selectGrade(88888888, stuId);

        System.out.println("\n");
        System.out.printf("startWeek = %d", startWeek);
        System.out.printf("endWeek = %d", endWeek);


        PageHelper.startPage(currentPage, pageSize);
        List<ClassDomain> classes = classDao.selectClasses(departId, classname, teaname, teaId, startWeek, endWeek, hasWaiGuoYu);


        System.out.println(classes);
        if (!gradeDomains.isEmpty()) {
            for (int j = 0; j < gradeDomains.size(); j++) {
                int id = gradeDomains.get(j).getClassId();
                System.out.println("\n");
                System.out.printf("id %d", id);
                for (int i = 0; i < classes.size(); i++) {
                    int classId = classes.get(i).getClassId();
                    if (classId == id) {
                        classes.get(i).setShowDeleteButton(true);
                        classes.get(i).setNotShowAddButton(true);
                    }
                }
            }
        }
        for (ClassDomain classDomain : classes) {
            if (classDomain.getClassUpperLimit() == classDomain.getClassChooseNum()) {
                classDomain.setShowDeleteButton(false);
                classDomain.setNotShowAddButton(true);
            }
            classDomain.setButtonGroup(Boolean.toString(!classDomain.isNotShowAddButton()) + ":" + Boolean.toString(classDomain.isShowDeleteButton()));
            String[] d = classDomain.getClassDateDescription().split(":");
            Integer a = Integer.parseInt(d[0]);
            Integer b = Integer.parseInt(d[1]);
            classDomain.setClassDateDescription(new String(courseDateTrans.dateToString(a, b)));
        }

        return classes;
    }

    @Override
    public Map getClassTime() {
        int stuId = authMess.userId();
        List<Map<String, Object>> li1 = studentDao.getWaiStudyTime(stuId);
        List<Map<String, Object>> li2 = studentDao.getNotWaiStudyTime(stuId);

        int sum1 = 0;
        for (Map<String, Object> l : li1) {
            int temp = (int) l.get("classTime");
            sum1 += temp;
        }
        int sum2 = 0;
        for (Map<String, Object> l : li2) {
            int temp = (int) l.get("classTime");
            sum2 += temp;
        }

        Map<String, Object> res = new HashMap<>();
        res.put("waiguoyu", sum1);
        res.put("notwaiguoyu", sum2);
        return res;
    }


    public List<Map> findAllClassName() {
        return studentDao.findAllClassName();
    }
}
