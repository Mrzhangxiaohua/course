package com.spc.dao;

import com.spc.model.CourseAll;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseAllDao {

    List<CourseAll> select(@Param("id") Integer id, @Param("departId") Integer departId,
                           @Param("moduleId") Integer moduleId, @Param("courseId") String courseId,
                           @Param("courseName") String courseName, @Param("teacherId") String teacherId,
                           @Param("teacherName") String teacherName, @Param("classSemester") String classSemester,
                           @Param("classDateDesc") String classDateDesc, @Param("classPlace") String classPlace);

    CourseAll selectCourseById(@Param("id") Integer id);

    // 获取某老师某学期已排课程
    List<CourseAll> selectCoursesByTeacherIdAndClassSemester(@Param("teacherId") String teacherId,
                                                             @Param("classSemester") String classSemester);

    // 获取某地点某学期已排课程
    List<CourseAll> selectCoursesByClassPlaceAndClassSemester(@Param("classPlace") String classPlace,
                                                              @Param("classSemester") String classSemester);

    // 更新排课结果
    int updateCourseSchedule(@Param("id") Integer id,
                             @Param("classDateDesc") String classDateDesc,
                             @Param("classPlace") String classPlace,
                             @Param("conflictDesc") String conflictDesc);
}
