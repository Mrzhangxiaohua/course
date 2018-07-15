package com.spc.service.classes.impl;


import com.github.pagehelper.PageHelper;
import com.spc.dao.ClassDao;
import com.spc.model.ClassDomain;
import com.spc.service.classes.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "classService")
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    @Override
    public int addClass(ClassDomain classDomain) {
        return classDao.insert(classDomain);
    }

    @Override
    public List<ClassDomain> findAllClass(String depart,String className,int teaId) {

        return classDao.selectClasses(depart,className,teaId);
    }
}
