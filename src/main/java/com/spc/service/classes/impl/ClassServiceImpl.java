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
    public int addClass(ClassDomain classDomain) {
        return classDao.insert(classDomain);
    }

    @Override
    public List<ClassDomain> findAllClass(Integer departId, String className, int teaId,int startWeek,int endWeek) {

        return classDao.selectClasses(departId, className, teaId,startWeek,endWeek);
    }

    @Override
    public List findStudent(String className, int classId) {
        return studentDao.findStudent(className, classId);
    }

    @Override
    public int updateScore(String className, int stuId, int score) {
        return classDao.updateScore(className, stuId, score);

    }

    @Override
    public String[][] findCourseTable(int teaId) {
        List<HashMap<String, String>> lis = classDao.findCourseTable(teaId);
        String temp[][] = new String[10][7];
        for (HashMap<String, String> li : lis) {
            String date = li.get("classDateDescription");
            String classPlace = li.get("classPlace");
            String teaName = li.get("teaName");

            String[] ints = date.split(":");
            Integer r = ints[0].toCharArray()[0] - '0';
            Integer l = ints[1].toCharArray()[0] - '0';

            String context = li.get("className") + ',' + classPlace + ',' + teaName;
            temp[(r - 1) * 2][l - 1] = context;
            temp[(r - 1) * 2 + 1][l - 1] = context;
        }
        return temp;
    }
}
