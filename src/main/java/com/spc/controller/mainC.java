package com.spc.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainC {

    @RequestMapping("/")
    public  String index(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String auName = authentication.getAuthorities().toArray()[0].toString();
        if (auName.equals("教师")){
            System.out.println("run here teacher");
            return "manager/home";
        }else if(auName.equals("学生")){
            return "index";
        }else{
            return "index";
        }
    }

    @RequestMapping("/student/classes")
    public  String classes(){
        return "course/showClass";
    }

    @RequestMapping("/student/calendar")
    public String showTimeTable(){
        System.out.println("run here");
        return "student/calendar2";
    }
    @RequestMapping("/student/teacher_forms")
    public String teacherForms(){
        return "teacher_forms";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }



}
