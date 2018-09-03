package com.spc.service.student;

import com.spc.model.ClassDomain;
import com.spc.model.StudentApplicationDomain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentService {
    public String[][] findClasses();

    public List<HashMap<String,Object>> findAllClassName(int student);

    public int addCourse(int classId);

    public int deleteCourse(int classId);


    public int addApplication(int classId, int states, String reason , int classNum);

    public List<ClassDomain> selectClassed(Map<String, Object> map);

    public Map getClassTime();
}
