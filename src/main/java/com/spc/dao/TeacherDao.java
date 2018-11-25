package com.spc.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeacherDao {
    int addComment(@Param("stuId") String stuId, @Param("classId") String classId, @Param("suggestion") String suggestion,
                   @Param("totalScore") int totalScore, @Param("teaId") String teaId);

    List<Map<String, Object>> courseList(String teaId);

    List<Map<String, Object>> courseStudentList(String classId);

    int findCommentStatus(@Param("stuId") String stuId,@Param("teaId") String teaId,@Param("classId") String classId);

    List<Map<String,Object>> findCommentByClassIdAndStuId(int classId, int stuId);
}

