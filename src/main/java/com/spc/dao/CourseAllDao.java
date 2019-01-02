package com.spc.dao;

import com.spc.model.CourseAll;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseAllDao {

    int insertCourse(@Param("departId") int departId, @Param("className") String className,
                     @Param("classModuleNum") int classModuleNum, @Param("classTime") int classTime,
                     @Param("teaId") String teaId, @Param("teaName") String teaName,
                     @Param("courseInfo") String courseInfo, @Param("teacherInfo") String teacherInfo,
                     @Param("courseId") String courseId);

    CourseAll selectCourseAll(@Param("courseId") String courseId);
}
