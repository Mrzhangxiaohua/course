package com.spc.service.student.impl;

import com.spc.dao.StudentDao;
import com.spc.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service(value = "studentService")
public class StudentServiceImpl  implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public String[][] findClasses(int stuId) {
        List<HashMap<String,String>> lis = studentDao.findClasses(stuId);
        String temp[][] = new String[10][7];
        for (HashMap<String,String> li : lis){
            String date = li.get("classDateDescription");
            String classPlace = li.get("classPlace");
            String teaName = li.get("teaName");

            String[] ints = date.split(":");
            Integer r = ints[0].toCharArray()[0]- '0';
            Integer l = ints[1].toCharArray()[0]- '0';

            System.out.println(li.get("className"));
            String context = li.get("className") + ','+classPlace + ',' + teaName;
            temp[(r-1) *2][l-1] =context;
            temp[(r-1) *2 +1][l-1] =context;
        }
        return temp;
    }

    public  int findNum(String name){
        return studentDao.findNum(name);
    }

    @Override
    public int addCourse(int stuId, int classId) {
        return studentDao.addChooseCourse(stuId,classId);
    }

}
