package com.spc.service.manage.impl;

import com.spc.dao.TeacherInfoDao;
import com.spc.model.IceSelectDataSource;
import com.spc.model.TeacherInfo;
import com.spc.service.manage.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2018-12-30 14:42
 **/
@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {

    @Autowired
    private TeacherInfoDao teacherInfoDao;

    @Override
    public List<TeacherInfo> getAllTeachers(Integer departId, String teacherName) {
        return teacherInfoDao.selectAll(departId, teacherName);
    }
}
