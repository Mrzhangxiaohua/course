package com.spc.service.teacher;

import com.spc.model.ClassApplicationDomain;

import java.util.List;
import java.util.Map;

public interface TeacherService {

    public int addClassApplication(ClassApplicationDomain classApplicationDomain);

    String[][] findCourseTable(String teaId);

    List<Map<String,Object>> findApplication(String teaId);

    public int issueGrade(int classId);

}
