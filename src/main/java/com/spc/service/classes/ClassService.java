package com.spc.service.classes;

import com.spc.model.ClassDomain;

import java.util.List;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface ClassService {

    int addClass(ClassDomain classDomain);

    List<ClassDomain> findAllClass(int pageNum, int pageSize,String depart,String className);

}
