package com.spc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class mainC {

    @RequestMapping("/classes")
    public  String classes(){
        return "course/showClass";
    }

    @RequestMapping("/calendar")
    public String showTimeTable(){
        System.out.println("run here");
        return "student/calendar";
    }
    @RequestMapping("/teacher_forms")
    public String teacherForms(){
        return "teacher_forms";
    }
}
