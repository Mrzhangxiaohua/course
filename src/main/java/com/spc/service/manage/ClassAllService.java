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
                               String courseId,
                               String courseName,
                               String teacherId,
                               String teacherName,
                               String classPlaceId,
                               String selectDepartId);

    String[][] getTeacherTimetable(String teacherId, String academicYear, String classSemester);

    Map<String, String> scheduleClass(ClassAll classAll);

    Map<String, String> delClass(int id, String operatorId, String operatorName);

    String[][] getDepartTimeTable(int departId, String academicYear, String classSemester);

    List<Map<String, Object>> findDepartList(String academicYear, String classSemester);

    List<Map<String, Object>> getOneDimDepartTimeTable(int departId, String academicYear, String classSemester);

    List<Map<String, Object>> findRoomList(String academicYear, String classSemester);

    String[][] getRoomTimeTable(String roomName, String academicYear, String classSemester);

    List<Map<String, Object>> getOneDimRoomTimeTable(String roomName, String academicYear, String classSemester);

    List<ClassAll> getClassAllDepart(int departId, String academicYear, String classSemester, String courseId, String courseName, String teacherName);
}
