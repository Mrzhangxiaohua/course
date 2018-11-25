package com.spc.service.teacher;

import com.spc.model.ClassApplicationDomain;

import java.util.List;
import java.util.Map;

public interface TeacherService {

    public int addClassApplication(ClassApplicationDomain classApplicationDomain);

    String[][] findCourseTable(String teaId);

    List<Map<String,Object>> findApplication(String teaId);

    List findStudentByClassnameAndNum(String className,int classNum);
     int issueGrade(int classId,int model1,int model2);

    int addComment(String classId, String suggestion, String teaId, List<String> scores, String stuId);

    List<Map<String, Object>> courseList(String teaId);

    List<Map<String, Object>> courseStudentList(String classId);

    List<Map<String, Object>> findStudentAndStatus(int classId,String teaId);

    Map<String,Object> findCommentByClassIdAndStuId(int classId, int stuId);

    Map<String,Object> findCurrentCalendar();
}
