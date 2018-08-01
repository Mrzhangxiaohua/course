package com.spc.controller;


import com.spc.util.RequestPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);


    @Autowired
    RequestPayload requestPayload;

    @RequestMapping("/login/cas")
    public String index(ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext() .getAuthentication();
        if (auth.isAuthenticated())
            System.out.println(auth.getName());
        else
            System.out.println("==================");
//        System.out.println(auth.getDetails().);
        if(auth != null
                && auth.getPrincipal() != null
                && auth.getPrincipal() instanceof UserDetails) {
            modelMap.put("username", ((UserDetails) auth.getPrincipal()).getUsername());
        }
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authentication);
        String authName = auth.getAuthorities().toArray()[0].toString();
        if (authName.equals("教师")) {
            System.out.println("run here teacher");
            return "teacher/index";
        } else if (authName.equals("学生")) {
            return "student/index";
        } else {
            return "manage/index";
        }
    }

    @RequestMapping("/student/classes")
    public String classes() {
        return "course/showClass";
    }

    @RequestMapping("/student/calendar")
    public String showTimeTable() {
        System.out.println("run here");
        return "student/calendar2";
    }

    @RequestMapping("/student/teacher_forms")
    public String teacherForms() {
        return "teacher_forms";
    }

    @RequestMapping("/login")
    public String login() {
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("run login");
        return "login";
    }

    @RequestMapping("/test/form")
    public String test() {
        return "test/form";
    }
}
