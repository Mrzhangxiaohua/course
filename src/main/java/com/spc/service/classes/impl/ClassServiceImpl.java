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

        return classDao.selectClasses(departId, className, "", teaId, startWeek, endWeek, 1,88888888);
    }

    @Override
    public List findStudent(int classId) {
        return studentDao.findStudent(classId);
    }

    @Override
    public int updateScore1(String className,int classNum, String stuId, int wlzzxxGrade, int knskGrade) {
        return classDao.updateScore1(className, classNum,stuId, wlzzxxGrade,knskGrade);
    }

    @Override
    public int updateScore2(String className, int classNum,String stuId, int xbsjGrade) {
        return classDao.updateScore2(className,classNum, stuId, xbsjGrade);
    }
    @Override
    public int updateScore3(String className,int classNum, String stuId, int xbsjGrade,int wlzzxxGrade, int knskGrade) {
        return classDao.updateScore3(className,classNum, stuId, xbsjGrade, wlzzxxGrade,  knskGrade);
    }



}


