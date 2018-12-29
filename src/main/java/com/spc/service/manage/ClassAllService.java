package com.spc.service.manage;

import com.spc.model.ClassAll;
import com.spc.model.CourseAll;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 排课Service
 *
 * @author yzk
 * @date 2018-12-25
 */
public interface ClassAllService {

    List<ClassAll> getClassAll(Integer departId,
                               String academicYear,
                               String classSemester,
                               String courseName,
                               String teacherId,
                               String teacherName,
                               String classPlaceId);

    String[][] getTeacherTimetable(String teacherId, String academicYear, String classSemester);
//
//    Map<String, Object> scheduleCourse(int id, int rowIndex, int colIndex, String classPlace, boolean force);

}
