package com.spc.service.manage;

import com.spc.model.CourseAll;
import com.spc.model.CourseApplication;
import com.spc.model.TeacherInfo;

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

    int ModifyCourseAll(CourseAll courseAll, String userId, String username);

    List<CourseAll> getCourseAllByYearAndDep(String year, int depId);

    int addYearCourseAll(List<CourseAll> courseList, String userId, String username,String year);

    int addCourseApp(CourseApplication courseApp);

    List<Map<String,Object>> findCourseApp(String date, String operatorId, String operatorName, int departId);

    int checkCourseApp(List<Integer>idList, int result,int departId);

    List<CourseApplication> findAllCourseApp();
}
