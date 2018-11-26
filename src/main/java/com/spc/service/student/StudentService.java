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

    public int addCommentWeekly();

    public List<Map<String, Object>> addCommentWeeklyTrue();

    public int addCommentWeeklyFinal();

    public Map selectList1(String stuId);
}
