package com.spc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/home")
    public  String admin_home(){
        return "admin/home";
    }

    @RequestMapping("/department")
    public String admin_department(){
        return "admin/department";
    }
    @RequestMapping("/profession")
    public String admin_profession(){
        return "admin/profession";
    }

    @RequestMapping("/classes")
    public String admin_classes(){
        return "admin/classes";
    }

    @RequestMapping("/students")
    public String admin_students(){
        return "admin/students";
    }

    @RequestMapping("/teachers")
    public String admin_teachers() { return "admin/teachers"; }
}
