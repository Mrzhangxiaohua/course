package com.spc.service.classes;

import com.spc.model.ClassDomain;

import java.util.List;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface ClassService {

    int addClass(ClassDomain classDomain);

    List<ClassDomain> findAllClass(Integer departId, String className, int teaId, int startWeek, int endWeek);

    List findStudent(String className, int classId);

    int updateScore(String className, int stuId, int score);


}
