package com.spc.controller;

import com.spc.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/manage")
@Controller
public class ManageController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/select/classes")
    @ResponseBody
    public String[][] manageFindClasses(
            @RequestParam(required = false, defaultValue = "88888888") Integer stuId
        ){
        String[][] res = studentService.findClasses(stuId);
        System.out.println(res);
        return res;
    }
}
