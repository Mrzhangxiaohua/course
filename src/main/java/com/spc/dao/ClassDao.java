package com.spc.dao;

import com.spc.model.ClassDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassDao {

    int insert(ClassDomain record);

    List<ClassDomain> selectClasses(@Param("depart") String depart, @Param("className") String className);
}