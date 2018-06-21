package com.spc.dao;

import com.spc.model.ClassDomain;

import java.util.List;

public interface ClassDao {

    int insert(ClassDomain record);

    List<ClassDomain> selectClasses();
}
