package com.spc.service.teacher.impl;

import com.spc.dao.ClassApplicationDao;
import com.spc.dao.ClassDao;
import com.spc.dao.IssueGradeDao;
import com.spc.dao.StudentDao;
import com.spc.model.ClassApplicationDomain;
import com.spc.service.teacher.TeacherService;
import com.spc.util.MakeTimeTable;
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
    StudentDao studentDao;

    @Autowired
    IssueGradeDao issueGradeDao;




    @Override
    public int addClassApplication(ClassApplicationDomain classApplicationDomain) {
        return classApplicationDao.add(classApplicationDomain);
    }

    @Override
    public String[][] findCourseTable(String teaId) {

        List<HashMap<String, Object>> lis = classDao.findCourseTable(teaId);
////        System.out.println("教师端的课表：",lis);
//        String temp[][] = new String[10][7];
//        for (HashMap<String, Object> li : lis) {
//            String date = (String) li.get("classDateDescription");
//            String classPlace = (String) li.get("classPlace");
//            String teacherName = (String) li.get("teaName");
//            String startWeek = Integer.toString((Integer) li.get("startWeek"));
//            String endWeek = Integer.toString((Integer) li.get("endWeek"));
//            String classNum = Integer.toString((Integer) li.get("classNum"));
//            String className = (String) li.get("className");
//
//            String[] ints = date.split(":");
//            Integer r = ints[0].toCharArray()[0] - '0';
//            Integer l = ints[1].toCharArray()[0] - '0';
//
//            String context = "★课程：" + className + ',' + "教室：" + classPlace + ',' + "教师：" + teacherName + ',' + "周次：" + startWeek + "-" + endWeek + ',' + "班次：" + classNum;
//
//            temp[(l - 1) * 2][r - 1] = temp[(l - 1) * 2][r - 1] != null ? temp[(l - 1) * 2][r - 1] + "," + context : context;
//            temp[(l - 1) * 2 + 1][r - 1] = temp[(l - 1) * 2 + 1][r - 1] != null ? temp[(l - 1) * 2 + 1][r - 1] + "," + context : context;
//
//        }
        return MakeTimeTable.makeBigTable(lis,0);
    }

    @Override
    public  List<Map<String,Object>>  findApplication(String teaId) {
        return  classApplicationDao.findByTeaId(teaId);
    }

    @Override
    public List findStudentByClassnameAndNum(String className, int classNum) {
        int classId = (int) studentDao.findClassesByNameAndNum(className,classNum).get("classId");
        return studentDao.findStudent(classId);
    }

    @Override
    public int issueGrade(int classId,int model1,int model2) {
        if(issueGradeDao.select(classId)==null){
            issueGradeDao.insert(classId,model1,model2);
        }else{
            issueGradeDao.update(classId,model1,model2);
        }
        return 0;
    }
}
