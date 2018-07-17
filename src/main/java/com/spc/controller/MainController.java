package com.spc.controller;


import com.spc.util.RequestPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class MainController {

    @Autowired
    RequestPayload requestPayload;

    @RequestMapping("/")
    public  String index(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authName = authentication.getAuthorities().toArray()[0].toString();
        if (authName.equals("教师")){
            System.out.println("run here teacher");
            return "teacher/index";
        }else if(authName.equals("学生")){
            return "student/index";
        }else{
            return "manage/index";
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
        System.out.println("login here");
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
        System.out.println("run login");
        return "login";
    }


    @RequestMapping("/test/form")
    public String test(){
        return "test/form";
    }

}
