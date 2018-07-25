package com.spc.service.student;

import com.spc.model.ClassDomain;
import com.spc.model.StudentApplicationDomain;

import java.util.List;
import java.util.Map;

public interface StudentService {
    public String[][] findClasses();

    public List<Map> findAllClassName();

    public int addCourse(int classId);
    public int deleteCourse(int classId);

    public List<StudentApplicationDomain> checkedMessage();

    public int addApplication(int classId,int states,String reason);

    public List<ClassDomain> selectClassed(Map<String,Object> map);

    public Map getClassTime();
}
