package com.spc.service.classes;

import com.spc.model.ClassDomain;

import java.util.List;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface ClassService {

    void addClass(ClassDomain classDomain);

    List<ClassDomain> findAllClass(Integer departId, String className, String teaId, int startWeek, int endWeek);

    List findStudent(int classId);


    int updateScore(String className, String stuId, int score);


}
