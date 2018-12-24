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

    int insertWeekComment(@Param("stuId") String stuId, @Param("teaId") String teaId, @Param("classId") int classId,@Param("score1") String score1,@Param("score2") String score2,@Param("score3") String score3, @Param("score4") String score4,@Param("suggestion")String suggestion,@Param("weekth") int weekth,@Param("date") String date);

    void updateWeekComment(@Param("stuId") String stuId, @Param("teaId") String teaId, @Param("classId") int classId,@Param("score1") String score1,@Param("score2") String score2,@Param("score3") String score3, @Param("score4") String score4,@Param("suggestion")String suggestion,@Param("weekth") int weekth,@Param("date") String date);

    String findDepartment(@Param("teaId") String teaId);
}

