package com.spc.service.manage.impl;

import com.spc.dao.ClassDao;
import com.spc.dao.StudentApplicationDao;
import com.spc.dao.StudentDao;
import com.spc.model.StudentApplicationDomain;
import com.spc.service.manage.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private ClassDao classDao;

    @Autowired
    private StudentApplicationDao studentApplicationDao;

    @Override
    public String[][] findClasses(Integer stuId) {
        List<HashMap<String,Object>> lis =  studentDao.findClasses(stuId);
        String temp[][] = new String[10][7];
        for (HashMap<String,Object> li : lis){
            String date = (String) li.get("classDateDescription");
            String classPlace = (String) li.get("classPlace");
            String teaName = (String) li.get("teaName");
            String className = (String) li.get("className");
            String startWeek = Integer.toString((Integer) li.get("startWeek"));
            String endWeek = Integer.toString((Integer) li.get("endWeek"));
            String classNum = Integer.toString((Integer) li.get("classNum"));

            String[] ints = date.split(":");
            Integer r = ints[0].toCharArray()[0]- '0';
            Integer l = ints[1].toCharArray()[0]- '0';

            String context =  className+ ','+classPlace + ',' + teaName +','+ startWeek + "-"+ endWeek+','+classNum;

            temp[(r-1) *2][l-1] =context;
            temp[(r-1) *2 +1][l-1] =context;
        }
        return temp;
    }

    @Override
    public String[][] bigTable() {

        List<HashMap<String,Object>> lis = classDao.findAllClasseSimpleMess();
        String temp[][] = new String[10][7];
        for (HashMap<String,Object> li : lis){
//            System.out.println(li);
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
            temp[(l-1) *2][r-1]=temp[(l-1) *2][r-1] !=null ? temp[(l-1) *2][r-1] +","+context :context;
            temp[(l-1) *2 +1][r-1] = temp[(l-1) *2 +1][r-1] !=null ?temp[(l-1) *2 +1][r-1]  +","+context :context;
        }
        return temp;
    }

    @Override
    public List<StudentApplicationDomain> checkedMessage(int key) {
        return studentApplicationDao.findall(key);
    }
}
