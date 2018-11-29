package com.spc.service.student;

import com.spc.model.ClassDomain;
import com.spc.model.StudentApplicationDomain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentService {
    public String[][] findClasses(String stuId);

    public List<HashMap<String,Object>> findAllClassName(int student,String stuId);

    public int addCourse(int classId,String stuId);

    public int deleteCourse(int classId,String stuId);

    public int addApplication(int classId, int states, String reason , int classNum, String stuId);

    public List<ClassDomain> selectClassed(Map<String, Object> map);

    public int getTimeSwtich();

    public Map getClassTime(String stuId);

    public int addComment(String stuId, String teaId, String[] score, String words);

    public List<Map<String, Object>> selectList(String stuId);

    public List<Map<String, Object>> showTeacomment(String stuId);

    public int addCommentWeekly(String stuId);

    public List<Map<String, Object>> addCommentWeeklyTrue(String stuId);

    public int addCommentWeeklyFinal(String stuId, String classId, String comment, String currWeek,
                                     String teaId, int score1, int score2, int score3, int score4);

    public List<Map<String, Object>> selectList1(String stuId);

    public List<Map<String, Object>> showCommentList(String stuId, String classId);
}
