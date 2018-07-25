package com.spc.service.manage.impl;

import com.spc.dao.StudentDao;
import com.spc.service.manage.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private StudentDao studentDao;

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
}
