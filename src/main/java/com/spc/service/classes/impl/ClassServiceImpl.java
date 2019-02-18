package com.spc.service.classes.impl;


import com.github.pagehelper.PageHelper;
import com.spc.dao.ClassDao;
import com.spc.dao.StudentDao;
import com.spc.model.ClassDomain;
import com.spc.service.classes.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List findStudent(int classId) { return studentDao.findStudent(classId); }
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

}


