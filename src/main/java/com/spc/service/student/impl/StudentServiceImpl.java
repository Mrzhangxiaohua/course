package com.spc.service.student.impl;

import com.github.pagehelper.PageHelper;
import com.spc.controller.Base;
import com.spc.dao.*;
import com.spc.model.ClassDomain;
import com.spc.model.GradeDomain;
import com.spc.service.student.StudentService;
import com.spc.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service(value = "studentService")
public class StudentServiceImpl extends Base implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ClassDao classDao;

    @Autowired
    private StudentApplicationDao studentApplicationDao;

    @Autowired
    private GradeDao gradeDao;

    @Autowired
    private TimeSwitchDao timeSwitchDao;


    @Override
    public String[][] findClasses(String stuId) {
//        int stuId = Integer.parseInt(authMess.userDetails().getUserid());
        List<HashMap<String, Object>> lis = studentDao.findClasses(stuId);
//        String temp[][] = new String[10][7];
//        System.out.println(lis);
//        if (!lis.isEmpty()) {
//            for (HashMap<String, Object> li : lis) {
//                System.out.println("=======检测============");
//                System.out.println(li.get("startWeek"));
//                String date = (String) li.get("classDateDescription");
//                String classPlace = (String) li.get("classPlace");
//                String teaName = (String) li.get("teaName");
//                System.out.println(li.get("startWeek"));
//                String startWeek = Integer.toString((Integer) li.get("startWeek"));
//                String endWeek = Integer.toString((Integer) li.get("endWeek"));
//                String classNum = Integer.toString((Integer) li.get("classNum"));
//                String className = (String) li.get("className");
//
//                String[] ints = date.split(":");
//                Integer r = ints[0].toCharArray()[0] - '0';
//                Integer l = ints[1].toCharArray()[0] - '0';
//
//                String context = "★课程：" + className + ',' + "教室：" + classPlace + ',' + "教师：" + teaName + ',' + "周次：" + startWeek + "-" + endWeek + ',' + "班次：" + classNum;
//                temp[(l - 1) * 2][r - 1] = context;
//                temp[(l - 1) * 2 + 1][r - 1] = context;
//            }
//        }
//
//        return temp;
        return MakeTimeTable.makeBigTable(lis, 1);
    }

    private boolean timechongtu(String stuId, int classId) {
        List<Map> maps = classDao.findStudentClassTime(stuId);
        List<long[]> times = StudentTimeLoad.StudentTimeLoad(maps);
        Map map = classDao.findClassTimeById(classId);
        List<long[]> classTime = StudentTimeLoad.TimeLoad(map);

        return TimeConflict.confilct(times, classTime);
    }

    @Override
    public int addCourse(int classId, String stuId) {
        //首先得到学生id
        boolean weixuan = gradeDao.selectGrade(classId, stuId).isEmpty();
        if (weixuan) {
////            boolean noShijianchongtu = studentDao.findTimeChongTu(stuId, classId).isEmpty();

            boolean chongtu = timechongtu(stuId, classId);

            if (!chongtu) {
                ClassDomain course = classDao.findClassById(classId);
                boolean noChaobiao = course.getClassChooseNum() < course.getClassUpperLimit();
                if (noChaobiao) {
                    return addyuanzi(classId, stuId);
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    @Transactional
    public int addyuanzi(int classId, String stuId) {

        classDao.updateChooseNum(classId, 1);
        studentDao.addChooseCourse(stuId, classId);

        ClassDomain course = classDao.findClassById(classId);
        if (course.getClassChooseNum() > course.getClassUpperLimit()) {
            throw new RuntimeException();
        }
        return 0;
    }

    @Transactional
    @Override
    public int deleteCourse(int classId, String stuId) {
        if (!gradeDao.selectGrade(classId, stuId).isEmpty()) {
            classDao.updateChooseNum(classId, -1);
            return studentDao.deleteChooseCourse(stuId, classId);
        } else {
            return 0;
        }
    }


    @Override
    public int addApplication(int classId, int states, String reason, int classNum, String stuId) {
        return studentApplicationDao.add(stuId, classId, states, reason, 2, classNum);
    }

    @Override
    public List<ClassDomain> selectClassed(Map<String, Object> map) {

        //获得学生id
        String stuId = (String) map.get("stuId");
        Integer currentPage = (Integer) map.get("currentPage");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer startWeek = (Integer) map.get("startWeek");
        Integer endWeek = (Integer) map.get("endWeek");
        Integer departId = (Integer) map.get("departId");
        Integer modelsId = (Integer) map.get("modelsId");
        String teaId = (String) map.get("teaId");
        String classname = (String) map.get("classname");
        String teaname = (String) map.get("teaname");
        Integer hasWaiGuoYu = (Integer) map.get("hasWaiGuoYu");
        Integer classNum = (Integer) map.get("classNum");
        Integer classChooseNum = (Integer) map.get("classChooseNum");

        //这个是学生选择的课程
        List<GradeDomain> gradeDomains = gradeDao.selectGrade(88888888, stuId);

        System.out.println("\n");
        System.out.printf("startWeek = %d", startWeek);
        System.out.printf("endWeek = %d", endWeek);


        PageHelper.startPage(currentPage, pageSize);
        List<ClassDomain> classes = classDao.selectClasses(departId, classname, teaname, teaId, startWeek, endWeek, hasWaiGuoYu, modelsId, classNum, classChooseNum);

        System.out.println(classes);
        Set<Integer> haveAddClass = new HashSet<>();
        if (!gradeDomains.isEmpty()) {
            for (int j = 0; j < gradeDomains.size(); j++) {
                int id = gradeDomains.get(j).getClassId();
                System.out.println("\n");
                System.out.printf("id %d", id);
                haveAddClass.add(id);
            }
        }
        for (int i = 0; i < classes.size(); i++) {
            int classId = classes.get(i).getClassId();
            int limit = classes.get(i).getClassUpperLimit();
            int chooseNum = classes.get(i).getClassChooseNum();
            if (haveAddClass.contains(classId)) {
                classes.get(i).setShowDeleteButton(true);//显示取消按钮
                classes.get(i).setNotShowAddButton(true);//不显示添加按钮
            } else if (!haveAddClass.contains(classId) & limit == chooseNum) {
                classes.get(i).setShowDeleteButton(false);//不显示取消按钮
                classes.get(i).setNotShowAddButton(true);//不显示添加按钮
            } else if (!haveAddClass.contains(classId) & limit > chooseNum) {
                classes.get(i).setShowDeleteButton(false);//不显示取消按钮
                classes.get(i).setNotShowAddButton(false);//显示添加按钮
            }
//            if (limit == chooseNum){
//                Collections.swap(classes,);
//            }

        }
        for (ClassDomain classDomain : classes) {
            System.out.println(classDomain.isNotShowAddButton() + ":" + classDomain.isShowDeleteButton());
            classDomain.setButtonGroup(Boolean.toString(!classDomain.isNotShowAddButton()) + ":" + Boolean.toString(classDomain.isShowDeleteButton()));
            String[] d = classDomain.getClassDateDescription().split(":");
            Integer a = Integer.parseInt(d[0]);
            Integer b = Integer.parseInt(d[1]);
            classDomain.setClassDateDescription(new String(CourseDateTrans.dateToString(a, b)));
        }
        return classes;
    }

    @Override
    public Map getClassTime(String stuId) {
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


//    @Override
//    public List<HashMap<String,Object>> findAllClassName(int student,String stuId) {
//        if(student==1){
//            List<HashMap<String, Object>> lis = studentDao.findClasses(stuId);
//            System.out.println(lis);
//            return lis;
//        }else {
//            List<HashMap<String, Object>> liM = studentDao.findAllClassName();
//            for (HashMap<String, Object> aM : liM) {
//                String className = (String) aM.get("className");
//                String classNum = Integer.toString((Integer) aM.get("classNum"));
//                aM.put("classStr", className + "(" + classNum + "班)");
//            }
//            System.out.println(liM);
//            return liM;
//        }
//    }


    @Override
    public List<HashMap<String, Object>> findAllClassName(int student, String stuId) {
        if (student == 1) {
            List<HashMap<String, Object>> lis = studentDao.findClasses(stuId);
            return lis;

        } else {
            List<HashMap<String, Object>> liM = studentDao.findAllClassName();
            for (HashMap<String, Object> aM : liM) {
                String className = (String) aM.get("className");
                String classNum = Integer.toString((Integer) aM.get("classNum"));
                aM.put("classStr", className + "(" + classNum + "班)");
            }
            return liM;
        }

    }

    @Override
    public int getTimeSwtich() {
        Map map = timeSwitchDao.get2();
        System.out.println("时间西段是："+map);
        java.sql.Timestamp start = (java.sql.Timestamp) map.get("start");
        java.sql.Timestamp end = (java.sql.Timestamp) map.get("end");
        System.out.println(start);

        Date now = null;
        java.util.Date sdate = new java.util.Date(start.getTime());
        java.util.Date edate = new java.util.Date(end.getTime());
        now = new Date();
        System.out.println("现在是=" + now + "开始是" + sdate + "结束时" + edate);
        if (now.before(sdate) || now.after(edate)) {
            return 0;
        }
        return 1;
    }
}
