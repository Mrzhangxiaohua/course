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
        String temp[][] = new String[5][7];
        for (HashMap<String,String> li : lis){
            String date = li.get("classDateDescription");
            String classPlace = li.get("classPlace");
            String teaName = li.get("teaName");
            String[] ints = date.split(":");
            Integer r = ints[0].toCharArray()[0]- '0';
            Integer l = ints[1].toCharArray()[0]- '0';
            System.out.println(r);
            System.out.println(l);
            System.out.println(li.get("className"));
            temp[r-1][l-1] =  li.get("className") + ','+classPlace + ',' + teaName;
        }
        return temp;
    }
}
