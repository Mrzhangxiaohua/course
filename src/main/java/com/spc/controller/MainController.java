package com.spc.controller;


import com.spc.util.RequestPayload;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.attribute.UserPrincipal;


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

    @RequestMapping("/login/cas")
    public String login(HttpServletRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getDetails());
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("run login");
        return "login";
    }
    @RequestMapping("/test/form")
    public String test(){
        return "test/form";
    }
}
