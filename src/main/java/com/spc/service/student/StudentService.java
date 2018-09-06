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


    public int addApplication(int classId, int states, String reason , int classNum,String stuId);

    public List<ClassDomain> selectClassed(Map<String, Object> map);

    public Map getClassTime(String stuId);
}
