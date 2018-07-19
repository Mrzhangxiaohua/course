package com.spc.service.student;

public interface StudentService {
    public String[][] findClasses(int stuId);


    public int addCourse(int stuId,int classId);
    public int deleteCourse(int stuId,int classId);
}
