package com.spc.service.manage.impl;

import com.spc.dao.CourseAllDao;
import com.spc.dao.TeacherInfoDao;
import com.spc.model.CourseAll;
import com.spc.model.TeacherInfo;
import com.spc.service.manage.CourseAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2019-01-03 19:00
 **/
@Service
public class CourseAllServiceImpl implements CourseAllService {

    @Autowired
    private CourseAllDao courseAllDao;

    @Autowired
    private TeacherInfoDao teacherInfoDao;

    @Override
    public List<TeacherInfo> getTeachersByCourse(String courseId, String academicYear, String classSemester) {
        CourseAll courseAll = courseAllDao.selectCourseAllWithParams(courseId, academicYear, classSemester);
        List<TeacherInfo> res = new ArrayList<>();
        List<String> teacherIds = new ArrayList<>();
        if (courseAll == null) {
            return res;
        }
        if (courseAll.getTeacherId() != null) {
            teacherIds.add(courseAll.getTeacherId());
        }
        if (courseAll.getTeachingTeamIds() != null && !courseAll.getTeachingTeamIds().isEmpty()) {
            String[] tmp = courseAll.getTeachingTeamIds().split(",");
            teacherIds.addAll(Arrays.asList(tmp));
        }

        if (teacherIds.isEmpty()) {
            return res;
        }

        return teacherInfoDao.selectByTeacherIds(teacherIds);
    }
}
