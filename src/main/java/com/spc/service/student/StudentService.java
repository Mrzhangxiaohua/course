package com.spc.service.student;

public interface StudentService {
    public String[][] findClasses(int stuId);

    public  int findNum(String name);

    public int addCourse(int stuId,int classId);
}
