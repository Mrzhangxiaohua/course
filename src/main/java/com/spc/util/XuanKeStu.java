package com.spc.util;

import com.spc.service.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 用于加载可以选课的学生名单
 */
@Component
public class XuanKeStu {
    private static List<Map<String, String>> stuName = null;

    private XuanKeStu(){};

    @Autowired
    DataService dataService;

    public synchronized List<Map<String,String>> getXuanKeNames(){
        if(stuName==null){
            stuName = (List<Map<String,String>>) dataService.allXuanKeStu();
        }
        return stuName;
    }
    public boolean inStuNames(Map map){
        System.out.println("======inStuNames方法======" + map.get("name") + ":" + map.get("stuId"));
        getXuanKeNames();
        boolean s = stuName.contains(map);
        System.out.println("是否包含学生信息" + s);
        return stuName.contains(map);
    }
}
