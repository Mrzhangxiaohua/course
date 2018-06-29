package com.spc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @RequestMapping("/home")
    public  String manager_home(){
        return "manager/home";
    }

    @RequestMapping("/department")
    public String manager_department(){
        return "manager/department";
    }
    @RequestMapping("/profession")
    public String manager_profession(){
        return "manager/profession";
    }

    @RequestMapping("/classes")
    public String manager_classes(){
        return "manager/classes";
    }

    @RequestMapping("/students")
    public String manager_students(){
        return "manager/students";
    }

    @RequestMapping("/teachers")
    public String manager_teachers(){
        return "manager/teachers";
    }
}
