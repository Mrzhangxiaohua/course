package com.spc.service.classes.impl;


import com.github.pagehelper.PageHelper;
import com.spc.dao.ClassDao;
import com.spc.dao.StudentDao;
import com.spc.model.ClassDomain;
import com.spc.service.classes.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service(value = "classService")
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public void addClass(ClassDomain classDomain) {
        classDao.insert(classDomain);
    }

    @Override
    public List<ClassDomain> findAllClass(Integer departId, String className, String teaId, int startWeek, int endWeek) {

        return classDao.selectClasses(departId, className, "", teaId, startWeek, endWeek, 1);
    }

    @Override
    public List findStudent(int classId) {
        return studentDao.findStudent(classId);
    }




    @Override
    public int updateScore(String className, String stuId, int score) {
        return classDao.updateScore(className, stuId, score);

    }
}


