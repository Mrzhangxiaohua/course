package com.spc.service.manage;

import com.spc.model.CourseAll;
import com.spc.model.CourseApplication;
import com.spc.model.TeacherInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2019-01-03 18:59
 **/
public interface CourseAllService {
    List<TeacherInfo> getTeachersByCourse(String courseId, String academicYear, String classSemester);

    int modifyCourseAll(CourseAll courseAll, String userId, String username);


    int addCourseApp(CourseApplication courseApp);

    int checkCourseApp(List<Integer>idList, int result,String username, String userId);

    List<CourseApplication> findAllCourseApp(String operatorId,String operatorName,String operateDate,int tabKey,String departId,int type);

    List<CourseApplication> findAllCourseApp(String operatorId,String operatorName,int tabKey,String departId, int type);

    int addCourseAll(CourseAll courseAll);

    List findCourseAll(String academicYear, String courseId, String courseName, int departId);

    CourseAll findCourseAll(int id);

    int makeSureCourseAll(String academicYear);

    String addDepartFormer(List<Integer> ids,String username,String userId);

    int commitApp(String academicYear,int departId);

    int modifyCourseApp(CourseApplication ca, String username, String userId);

    List findDepartCourseApp(int departId, String academicYear, String courseId, String courseName);

    int findFlag();

    int updateFlag(int flag);

    int cancelCheck(List<Integer> idList);

    List<Map<String, Object>> findCourseAllDepartList(String academicYear);

    List<Map<String, Object>> findCourseAllByYearAndDepart(String academicYear, int departId);

    int existCourseAll(CourseAll courseAll);

    int addFormerCourseAll(CourseAll courseAll);

    List<CourseAll> getCourseAll(String year, Integer departId);
}
