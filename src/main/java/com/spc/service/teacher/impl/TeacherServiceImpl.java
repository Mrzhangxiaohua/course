package com.spc.service.teacher.impl;

import com.spc.dao.ClassApplicationDao;
import com.spc.dao.ClassDao;
import com.spc.dao.IssueGradeDao;
import com.spc.model.ClassApplicationDomain;
import com.spc.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    ClassApplicationDao classApplicationDao;

    @Autowired
    ClassDao classDao;

    @Autowired
    IssueGradeDao issueGradeDao;


    @Override
    public int addClassApplication(ClassApplicationDomain classApplicationDomain) {
        return classApplicationDao.add(classApplicationDomain);
    }

    @Override
    public String[][] findCourseTable(String teaId) {

        List<HashMap<String, Object>> lis = classDao.findCourseTable(teaId);
        String temp[][] = new String[10][7];
        for (HashMap<String, Object> li : lis) {
            String date = (String) li.get("classDateDescription");
            String classPlace = (String) li.get("classPlace");
            String teacherName = (String) li.get("teaName");
            String startWeek = Integer.toString((Integer) li.get("startWeek"));
            String endWeek = Integer.toString((Integer) li.get("endWeek"));
            String classNum = Integer.toString((Integer) li.get("classNum"));
            String className = (String) li.get("className");

            String[] ints = date.split(":");
            Integer r = ints[0].toCharArray()[0] - '0';
            Integer l = ints[1].toCharArray()[0] - '0';

            String context = "★课程：" + className + ',' + "教室：" + classPlace + ',' + "教师：" + teacherName + ',' + "周次：" + startWeek + "-" + endWeek + ',' + "班次：" + classNum;

            temp[(l - 1) * 2][r - 1] = context;
            temp[(l - 1) * 2 + 1][r - 1] = context;
        }
        return temp;
    }

    @Override
    public  List<Map<String,Object>>  findApplication(String teaId) {
        return  classApplicationDao.findByTeaId(teaId);
    }

    @Override
    public int issueGrade(int classId) {
        return issueGradeDao.insert(classId,1);
    }
}
