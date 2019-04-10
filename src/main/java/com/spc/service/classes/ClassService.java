package com.spc.service.classes;

import com.spc.model.ClassDomain;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface ClassService {

    void addClass(ClassDomain classDomain);

    List<ClassDomain> findAllClass(Integer departId, String className, String teaId, int startWeek, int endWeek);

    List findStudent(int classId);

    Map findClassId(String courseId,int classNum);

    int findIsGrade(int classId);


//    int updateScore1(String className,int classNum, String stuId, int wlzzxxGrade,int knskGrade);
//    int updateScore2(String className,int classNum, String stuId, int xbsjGrade);
    int updateScore3(String className,int classNum, String stuId, int xbsjGrade,int wlzzxxGrade,int knskGrade);


    List<Map<String,Object>> findClass(Integer departId, String className, String teaId, int startWeek, int endWeek);

    List<Map<String, Object>> findWeekCourses(String teaId, String semester,int weekth);

    ClassDomain findClassById(int classId);

    int CommentStatus(String classId);
    List<Map<String,Object>> findWeekComment(@RequestParam("stuId") String stuId, @RequestParam("weekth") int weekth, @RequestParam("classId") String classId);

    int zzGrade(String className,int classNum, String stuId, int zzGrade, int flag);

    List<Map<String,Object>>  findTeachCourse(String teacherId,String academicYear);

    List<Map<String,Object>>  findTeachCourse2(String teacherId,String academicYear);

    Map findClassInfo(String classStr);

    List<Map<String,Object>> findAllDepartment();

    void updateXbsjScore(int classId,String stuId,float xbsjGrade);

    void updateIsGrade(int classId);

    List<Map<String, Object>> findClassIds();

    List<Map<String, Object>> findKnskStudents(String JXBID);

    int findKnskIsGrade(String JXBID);

    List<Map<String, Object>> findStudentsList();


    void updateKnskGradeFlag(String JXBID);

    Map<String,Object> findKnskClassById(String JXBID);

    List<Map<String, Object>> findAllXbsjCourse(int departId,String academicYear,String courseId,String className,String classNum,String teaName,int currentTab);

    List<Map<String, Object>> findAllKnskCourse(String academicYear,String courseId,String className,String classNum,String teaName,int currentTab);

    void updateXbsjChecked(int classId,String stuId);

    void updateKnskChecked(String classId,String stuId);

    List<Map<String, Object>> findStuXbsjClass(String stuId);

    Map<String,Object> findCourseById(int classId);
}
