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

        return classDao.selectClasses(departId, className,"", teaId,startWeek,endWeek,1);
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
        List<HashMap<String, Object>> lis = classDao.findCourseTable(teaId);
        String temp[][] = new String[10][7];
        for (HashMap<String, Object> li : lis) {
            String date = (String) li.get("classDateDescription");
            String classPlace = (String) li.get("classPlace");
            String teaName = (String) li.get("teaName");
            String startWeek = Integer.toString((Integer) li.get("startWeek"));
            String endWeek = Integer.toString((Integer) li.get("endWeek"));
            String classNum = Integer.toString((Integer) li.get("classNum"));
            String className = (String) li.get("className");

            String[] ints = date.split(":");
            Integer r = ints[0].toCharArray()[0]- '0';
            Integer l = ints[1].toCharArray()[0]- '0';

            String context = "★课程：" +className+ ','+"教室："+classPlace + ',' +"教师："+ teaName +','+ "周次："+startWeek + "-"+ endWeek+ ','+"班次："+classNum;

            temp[(r - 1) * 2][l - 1] = context;
            temp[(r - 1) * 2 + 1][l - 1] = context;
        }
        return temp;
    }
}
