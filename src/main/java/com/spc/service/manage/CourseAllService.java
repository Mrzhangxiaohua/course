package com.spc.service.manage;

import com.spc.model.CourseAll;

import java.util.List;
import java.util.Map;

/**
 * 排课Service
 *
 * @author yzk
 * @date 2018-12-25
 */
public interface CourseAllService {

    List<CourseAll> getCourseAll(Integer id, Integer departId, Integer moduleId,
                                 String courseId, String courseName, String teacherId, String teacherName,
                                 String classSemester, String classDateDesc, String classPlace);

    String[][] getTeacherTimetable(String teacherId, String classSemester);

    Map<String, Object> scheduleCourse(int id, int rowIndex, int colIndex, String classPlace, boolean force);

}
