package com.spc.controller;

import com.spc.model.ClassDomain;
import com.spc.service.classes.ClassService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spc.util.RequestPayload;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RequestMapping("/teacher")
@Controller
public class TeacherController {
    @Autowired
    RequestPayload requestPayload;

    @Autowired
    ClassService classService;



    @RequestMapping(value = "/course/add",method = RequestMethod.POST)
    @ResponseBody
    public String add(HttpServletRequest request){
        try {
            String json = requestPayload.getRequestPayload(request);
            System.out.println(json);
            JSONObject obj = new JSONObject(json);

            ClassDomain classDomain = new ClassDomain();
            classDomain.setTeacherInfo(obj.getString("teacherInfo"));
            classDomain.setCourseInfo(obj.getString("courseInfo"));
            classDomain.setClassId(obj.getInt("classId"));
            classDomain.setTeaName(obj.getString("teaName"));
            classDomain.setTeaId(obj.getInt("teaId"));
            classDomain.setClassUpperLimit(obj.getInt("classUpperLimit"));
            classDomain.setClassNum(obj.getInt("classNum"));
            classDomain.setClassName(obj.getString("className"));
            classDomain.setClassChooseNum(0);
            classDomain.setClassLength(obj.getInt("classLength"));

            Integer daseA = obj.getInt("classDateDescriptionA");
            Integer daseB = obj.getInt("classDateDescriptionB");

            System.out.printf("a%s,b%s",daseA,daseB);

            classDomain.setClassDateDescription(Integer.toString(daseA) + Integer.toString(daseB) );
            classDomain.setClassPlace(obj.getString("classPlace"));
            classDomain.setDepartId(obj.getInt("departId"));
            classDomain.setClassModuleNum(obj.getInt("classModuleNum"));
            classDomain.setClassSemester(obj.getInt("classSemester"));

            try{
                classService.addClass(classDomain);
            }catch (Exception e){
                System.out.println(e);
            }

        }catch (Exception e){
            System.out.println("error");
        }
        return "";
    }
}
