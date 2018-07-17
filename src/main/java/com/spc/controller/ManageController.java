package com.spc.controller;

import com.spc.model.ClassDomain;
import com.spc.model.GradeDomain;
import com.spc.service.classes.ClassService;
import com.spc.service.student.StudentService;
import com.spc.view.ManageTablePdfView;
import com.spc.view.StudentScorePdfView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/find/classes")
    @ResponseBody
    public List<Map> getAllCourse() {
        List<ClassDomain> classes = classService.findAllClass(88888888, "", 88888888);
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
                                      @RequestParam(required = false,defaultValue = "88888888") Integer classId){


        List students = classService.findStudent(className,classId);
        Map res = new HashMap();
        System.out.println("run here");

        res.put("students", students);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        return new ModelAndView(new ManageTablePdfView(), model);
    }
}
