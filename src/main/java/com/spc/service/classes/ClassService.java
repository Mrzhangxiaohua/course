package com.spc.service.classes;

import com.spc.model.ClassDomain;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface ClassService {

    void addClass(ClassDomain classDomain);

    List<ClassDomain> findAllClass(Integer departId, String className, String teaId, int startWeek, int endWeek);

    List findStudent(int classId);


//    int updateScore1(String className,int classNum, String stuId, int wlzzxxGrade,int knskGrade);
//    int updateScore2(String className,int classNum, String stuId, int xbsjGrade);
    int updateScore3(String className,int classNum, String stuId, int xbsjGrade,int wlzzxxGrade,int knskGrade);


    List<Map<String,Object>> findClass(Integer departId, String className, String teaId, int startWeek, int endWeek);

    List<Map<String, Object>> findWeekCourses(String teaId, String semester,int weekth);

    ClassDomain findClassById(int classId);

    int CommentStatus(String classId);
}
