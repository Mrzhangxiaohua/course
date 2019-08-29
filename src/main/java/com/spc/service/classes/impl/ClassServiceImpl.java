package com.spc.service.classes.impl;


import com.github.pagehelper.PageHelper;
import com.spc.dao.ClassDao;
import com.spc.dao.StudentDao;
import com.spc.model.ClassDomain;
import com.spc.service.classes.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "classService")
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public void addClass(ClassDomain classDomain) {
        classDao.insert(classDomain);
    }

    @Override
    public List<ClassDomain> findAllClass(Integer departId, String className, String teaId, int startWeek, int endWeek) {

        return classDao.selectClasses(departId, className, "", teaId, startWeek, endWeek, 1,88888888,1,0);
    }
    @Override
    public List<Map<String,Object>> findClass(Integer departId, String className, String teaId, int startWeek, int endWeek) {
        return classDao.findClasses(departId, className, "", teaId, startWeek, endWeek, 1,88888888,1,0);
    }

    @Override
    public List<Map<String, Object>> findWeekCourses(String teaId,String semester,int weekth) {
        System.out.println(teaId+","+semester+","+weekth);
        List<Map<String, Object>> weekCourses = classDao.findWeekCourses(teaId, semester, Integer.toString(weekth));
        System.out.println(teaId+","+semester+","+weekth);
       // List<Map<String, Object>> CoursesWithStatus = classDao.findWeekCourses(teaId, semester, weekth);
        for(Map<String,Object> course:weekCourses){
            int status=0;
            int count=classDao.weekCourseStatus(course.get("classId"));
            if(count>=1){
                status=1;//表示已评价
            }
            course.put("commentStatus",status);
        }

        return weekCourses;
    }

    @Override
    public ClassDomain findClassById(int classId) {
        return classDao.findClassById(classId);
    }

    @Override
    public int CommentStatus(String classId) {
        int chooseNumber=findClassById(Integer.parseInt(classId)).getClassChooseNum();
        int commentNumber=classDao.findCommentNumber(classId);
        int msg=-1;
        if(commentNumber==0){
            msg=0;//表示未评价
        }else if(commentNumber==chooseNumber){
            msg=1;//表示已评价
        }else if(commentNumber>0&&commentNumber<chooseNumber){
            msg=2;//表示部分未评价
        }
        return msg;
    }

    @Override
    public List<Map<String, Object>> findWeekComment(String stuId, int weekth, String classId) {
        return  classDao.findWeekComment(stuId, weekth, classId);


    }

    @Override
    public List findStudent(int classId) {
        return studentDao.findStudent(classId,"");
    }

    @Override
    public Map findClassId(String courseId, int classNum) {
        return  classDao.findClassId(courseId, classNum);
    }

    @Override
    public int findIsGrade(int classId) {
        return  classDao.findIsGrade(classId);
    }
  /*  @Override
    public List findWeekStudent(int classId,int weekth) {
        List<Map<String,Object>> students=studentDao.findStudent(classId);
        for(Map<String,Object> student:students){
            studentDao.findWeekComment((String) student.get("stuId"),weekth,classId);
            student.put()
        }
        return studentDao.findStudent(classId);
    }*/

//    @Override
//    public int updateScore1(String className,int classNum, String stuId, int wlzzxxGrade, int knskGrade) {
//        return classDao.updateScore1(className, classNum,stuId, wlzzxxGrade,knskGrade);
//    }
//
////    @Override
////    public int updateScore2(String className, int classNum,String stuId, int xbsjGrade) {
////        return classDao.updateScore2(className,classNum, stuId, xbsjGrade);
////    }
    @Override
    public int updateScore3(String className,int classNum, String stuId, int xbsjGrade,int wlzzxxGrade, int knskGrade) {
        return classDao.updateScore3(className,classNum, stuId, xbsjGrade, wlzzxxGrade,  knskGrade);
    }
    @Override
    public int zzGrade(String className, int classNum, String stuId, int zzGrade, int flag) {
        return classDao.zzGrade(className, classNum, stuId, zzGrade, flag);
    }

    @Override
    public List<Map<String, Object>> findTeachCourse(String teacherId,String academicYear,int depId) {
        List<Map<String, Object>> res = classDao.findTeachCourse(teacherId,academicYear,depId);
        for(Map course : res){
            String className = (String) course.get("className");
            if(course.get("schoolDistrictId")==null) continue;
            if((Integer)course.get("schoolDistrictId") == 1)  course.put("className", className+"(兴庆)");
            if((Integer)course.get("schoolDistrictId") == 2)  course.put("className", className+"(雁塔)");
            if((Integer)course.get("schoolDistrictId") == 3)  course.put("className", className+"(曲江)");
            if((Integer)course.get("schoolDistrictId") == 4)  course.put("className", className+"(苏州)");
            if((Integer)course.get("schoolDistrictId") == 5)  course.put("className", className+"(创新港)");
        }
        return res;
    }

    @Override
    public List<Map<String, Object>> findTeachCourse2(String teacherId,String academicYear) {
        List<Map<String, Object>> classes = classDao.findTeachCourse2(teacherId,academicYear);
        for(Map cl:classes){
            if(cl.get("KCH").equals("121066")) {
                cl.put("KCM","学术英语(一)");
            }
            if(cl.get("KCH").equals("121067")) {
                cl.put("KCM","学术英语(二)");
            }
            if(cl.get("KCH").equals("121068")) {
                cl.put("KCM","医学英语");
            }
            if(cl.get("KCH").equals("122036")) {
                cl.put("KCM","学术英语写作");
            }
        }
        return classes;
    }


    @Override
    public Map findClassInfo(String classStr) {
        return classDao.findClassInfo(classStr);
    }

    @Override
    public List<Map<String, Object>> findAllDepartment() {
        return  classDao.findAllDepartment();
    }

    @Override
    public void updateXbsjScore(int classId, String stuId, float xbsjGrade) {
        classDao.updateXbsjScore(classId,stuId,xbsjGrade);
    }

    @Override
    public void updateIsGrade(int classId) {
        classDao.updateIsGrade(classId);
    }

    @Override
    public List findClassIds() {
       return classDao.findClassIds();
    }


    @Override
    public List<Map<String, Object>> findKnskStudents(String JXBID) {
        return classDao.findKnskStudents(JXBID);
    }

    @Override
    public int findKnskIsGrade(String JXBID) {
        return  classDao.findKnskIsGrade(JXBID);
    }

    @Override
    public List<Map<String, Object>> findStudentsList() {
        return  classDao.findStudentsList();
    }


    @Override
    public void updateKnskGradeFlag(String JXBID) {
        classDao.updateKnskGradeFlag(JXBID);
    }

    @Override
    public Map<String, Object> findKnskClassById(String JXBID) {
        Map cl=classDao.findKnskClassById(JXBID);
        if(cl.get("KCH").equals("121066")) {
            cl.put("KCM","学术英语(一)");
        }
        if(cl.get("KCH").equals("121067")) {
            cl.put("KCM","学术英语(二)");
        }
        if(cl.get("KCH").equals("121068")) {
            cl.put("KCM","医学英语");
        }
        if(cl.get("KCH").equals("122036")) {
            cl.put("KCM","学术英语写作");
        }
        return cl;

    }

    @Override
    public List<Map<String, Object>> findAllXbsjCourse(int departId, String academicYear,String courseId,String className,String classNum,String teaName,int currentTab) {
        List<Map<String, Object>> courses=classDao.findAllXbsjCourse(departId,academicYear,courseId,className,classNum,teaName);
        List<Map<String, Object>> res=new ArrayList<>();
        if(courses.size()==0)
            return courses;
        for(Map course:courses) {
            String cName = (String) course.get("className");
            if(course.get("schoolDistrictId")!=null && (Integer)course.get("schoolDistrictId") == 1)  course.put("className", cName+"(兴庆)");
            if(course.get("schoolDistrictId")!=null && (Integer)course.get("schoolDistrictId") == 2)  course.put("className", cName+"(雁塔)");
            if(course.get("schoolDistrictId")!=null && (Integer)course.get("schoolDistrictId") == 3)  course.put("className", cName+"(曲江)");
            if(course.get("schoolDistrictId")!=null && (Integer)course.get("schoolDistrictId") == 4)  course.put("className", cName+"(苏州)");
            if(course.get("schoolDistrictId")!=null && (Integer)course.get("schoolDistrictId") == 5)  course.put("className", cName+"(创新港)");
            course.put("classNum", course.get("classNum")+"班");
            int classId = (int) course.get("classId");
            List<Map<String, Object>> students = studentDao.findStudent(classId, "");
            int uncheckedNum = 0;
            int checkedNum = 0;
            int recheckedNum = 0;
            for (Map student : students) {
                if ((int) student.get("isChecked") == 1)
                    checkedNum = checkedNum + 1;
                else if ((int) student.get("isChecked") == 2)
                    recheckedNum = recheckedNum + 1;
                else
                    uncheckedNum = uncheckedNum + 1;
            }
            if(checkedNum!=0 || recheckedNum!=0)
                course.put("isSubmit",1);
            if(recheckedNum!=0)
                course.put("status",2);
            else if(uncheckedNum!=0)
                course.put("status",0);
            else
                course.put("status",1);
            course.put("uncheckedNum", uncheckedNum);
            course.put("checkedNum", checkedNum);
            course.put("recheckedNum", recheckedNum);
            course.put("moduleId",0);
        }
        if(currentTab==3)
            return courses;
        for(Map stu:courses)
        {
            if((int)stu.get("status")==currentTab)
                res.add(stu);
        }
        return res;
    }

    @Override
    public List<Map<String, Object>> findAllKnskCourse( String academicYear,String courseId,String className,String classNum,String teaName,int currentTab) {
        List<Map<String, Object>> courses=classDao.findAllKnskCourse(academicYear,courseId,className,classNum,teaName);
        List<Map<String, Object>> res=new ArrayList<>();
        if(courses.size()==0)
            return courses;
        for(Map course:courses) {
            String classId = (String) course.get("classId");
            String KCH= (String) course.get("courseId");
            if(KCH.equals("121066")) {
                course.put("className","学术英语(一)");
            }
            else if(KCH.equals("121067")) {
                course.put("className","学术英语(二)");
            }
            else {
                course.put("className","学术英语写作");
            }
            String semesterName= (String) course.get("semesterName");
            if(semesterName.substring(9,11).equals("-1"))
                course.put("semesterName",semesterName.substring(0,9)+"秋季");
            else
                course.put("semesterName",semesterName.substring(0,9)+"春季");
            List<Map<String, Object>> students = classDao.findKnskStudents(classId);
            int uncheckedNum = 0;
            int checkedNum = 0;
            int recheckedNum = 0;
            for (Map student : students) {
                if ((int) student.get("isChecked") == 1)
                    checkedNum = checkedNum + 1;
                else if ((int) student.get("isChecked") == 2)
                    recheckedNum = recheckedNum + 1;
                else
                    uncheckedNum = uncheckedNum + 1;
            }
            if(checkedNum!=0 || recheckedNum!=0)
                course.put("isSubmit",1);
            if(recheckedNum!=0)
                course.put("status",2);
            else if(uncheckedNum!=0)
                course.put("status",0);
            else
                course.put("status",1);
            course.put("uncheckedNum", uncheckedNum);
            course.put("checkedNum", checkedNum);
            course.put("recheckedNum", recheckedNum);
            course.put("moduleId",1);
            course.put("departName","外国语学院");
        }
        if(currentTab==3)
            return courses;
        for(Map stu:courses)
        {
            if((int)stu.get("status")==currentTab)
                res.add(stu);
        }
        return res;
    }

    @Override
    public void updateXbsjChecked(int classId,String stuId) {
        classDao.updateXbsjChecked(classId,stuId);
    }

    @Override
    public void updateKnskChecked(String classId,String stuId) {
        classDao.updateKnskChecked(classId,stuId);
    }

    @Override
    public List<Map<String, Object>> findStuXbsjClass(String stuId) {
        return  classDao.findStuXbsjClass(stuId);
    }

    @Override
    public Map<String, Object> findCourseById(int classId) {
        return classDao.findCourseById(classId);
    }

    @Override
    public int findStudentIsChecked(int classId, String stuId) {

        return classDao.findStudentIsChecked( classId, stuId);
    }

    @Override
    public int findStudentKnskIsChecked(String JXBID, String stuId) {
        return classDao.findStudentKnskIsChecked(JXBID,stuId);
    }

    @Override
    public int findDepId(String teacherId) {
        return classDao.findDepId(teacherId);
    }


}


