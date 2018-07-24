package com.spc.service.student;

import com.spc.model.ClassDomain;

import java.util.List;
import java.util.Map;

public interface StudentService {
    public String[][] findClasses(int stuId);


    public int addCourse(int stuId,int classId);
    public int deleteCourse(int stuId,int classId);

    public int addApplication(int  classId,int state,String reason);

    public List<ClassDomain> selectClassed(Map<String,Object> map);

    public List<Map> allClassName();
}
