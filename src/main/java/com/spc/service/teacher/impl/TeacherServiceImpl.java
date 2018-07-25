package com.spc.service.teacher.impl;

import com.spc.dao.ClassApplicationDao;
import com.spc.model.ClassApplicationDomain;
import com.spc.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    ClassApplicationDao classApplicationDao;
    @Override
    public int addClassApplication(ClassApplicationDomain classApplicationDomain) {
        return classApplicationDao.add(classApplicationDomain);
    }
}
