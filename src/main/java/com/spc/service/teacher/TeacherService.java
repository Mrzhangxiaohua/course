package com.spc.service.teacher;

import com.spc.model.ClassApplicationDomain;

import java.util.List;
import java.util.Map;

public interface TeacherService {

    public int addClassApplication(ClassApplicationDomain classApplicationDomain);

    String[][] findCourseTable(String teaId);

    List<Map<String,Object>> findApplication(String teaId);

    List findStudentByClassnameAndNum(String className,int classNum);
    public int issueGrade(int classId,int model1,int model2);

    public int addComment(String classType, String className, String words, String teaId, String[] scores, String stuId);

    List<Map<String, Object>> courseList(String teaId);

    List<Map<String, Object>> courseStudentList(String classId);
}
