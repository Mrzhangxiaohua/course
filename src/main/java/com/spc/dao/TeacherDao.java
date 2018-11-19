package com.spc.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeacherDao {
    int addComment(@Param("stuId") String stuId, @Param("classType") String classType,
                   @Param("className") String className, @Param("words") String words,
                   @Param("totalScore") int totalScore, @Param("teaId") String teaId);

    List<Map<String, Object>> courseList(String teaId);
    List<Map<String, Object>> course2List(String teaId);
    List<Map<String, Object>> courseStudentList(String classId);
}

