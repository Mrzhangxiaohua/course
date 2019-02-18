package com.spc.service.manage;

import com.spc.model.TeacherInfo;

import java.util.List;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2019-01-03 18:59
 **/
public interface CourseAllService {
    List<TeacherInfo> getTeachersByCourse(String courseId, String academicYear, String classSemester);
}
