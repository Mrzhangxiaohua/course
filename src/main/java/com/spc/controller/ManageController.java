package com.spc.controller;


import com.spc.model.ClassDomain;
import com.spc.model.StudentApplicationDomain;
import com.spc.service.classes.ClassService;
import com.spc.service.student.StudentService;
import com.spc.view.ManageTablePdfView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RequestMapping("/manage")
@Controller
public class ManageController {

    @Autowired
    private StudentService studentService;


    @Autowired
    private ClassService classService;




    @RequestMapping("/select/classes")
    @ResponseBody
    public String[][] manageFindClasses(
            @RequestParam(required = false, defaultValue = "88888888") Integer stuId
    ) {
        String[][] res = studentService.findClasses(stuId);
        System.out.println(res);
        return res;
    }

    @RequestMapping("/checked/message")
    @ResponseBody
    public Map<String,Object> checkedMessage(){

        List<StudentApplicationDomain> maps = studentService.checkedMessage();

        System.out.println(maps.size());
        Map<String,Object> res = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        res.put("status","SUCCESS");

        for(StudentApplicationDomain studentApplicationDomain:maps){
            if(studentApplicationDomain.getChecked()==1 & !map.containsKey("1")){
                System.out.println("run here");
                List<StudentApplicationDomain> li = new ArrayList<>();
                li.add(studentApplicationDomain);
                map.put("1",li);
            }else if(studentApplicationDomain.getChecked()==2 & !map.containsKey("2")){
                List<StudentApplicationDomain> li = new ArrayList<>();
                li.add(studentApplicationDomain);
                map.put("2",li);
            }
            else if(studentApplicationDomain.getChecked()==3 & !map.containsKey("3")){
                List<StudentApplicationDomain> li = new ArrayList<>();
                li.add(studentApplicationDomain);
                map.put("3",li);
            }else{
                String check = String.valueOf(studentApplicationDomain.getChecked());
                List<StudentApplicationDomain> lis = (List<StudentApplicationDomain>) map.get(check);
                lis.add(studentApplicationDomain);
            }

        }
        System.out.println(map);
        res.put("data",map);


        return res;
    }

    @RequestMapping("/find/classes")
    @ResponseBody
    public List<Map> getAllCourse() {
        List<ClassDomain> classes = classService.findAllClass(88888888, "", 88888888,88888888,88888888);
        List<Map> resList = new ArrayList<Map>();
        for (int i = 0; i < classes.size(); i++) {
            Map<String, Object> res = new HashMap<>();
            res.put("className", classes.get(i).getClassName());
            res.put("classId", classes.get(i).getClassId());
            resList.add(res);
        }
        return resList;
    }

    @RequestMapping("/download/table")
    public ModelAndView downloadTable(HttpServletResponse response,
                                      @RequestParam(required = false,defaultValue = "") String className,
                                      @RequestParam(required = false,defaultValue = "88888888") Integer classId
                                     ){
        System.out.printf("classId %d",classId);
        List students = classService.findStudent(className,classId);
        Map<String,Object> res = new HashMap<String, Object>();

        res.put("students", students);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style","wider");
        return new ModelAndView(new ManageTablePdfView(), model);
    }
}
