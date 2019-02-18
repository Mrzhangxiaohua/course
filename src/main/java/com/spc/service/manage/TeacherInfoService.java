package com.spc.service.manage;

import com.spc.model.TeacherInfo;

import java.util.List;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2018-12-30 14:41
 **/
public interface TeacherInfoService {
    List<TeacherInfo> getAllTeachers(Integer departId, String teacherName);
}
