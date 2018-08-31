package com.spc.controller;


import com.spc.util.AuthMess;
import com.spc.util.RequestPayload;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.cas.authentication.CasAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;
import java.util.Map;


@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);


    @Autowired
    RequestPayload requestPayload;

    @Autowired
    AuthMess authName;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap, HttpServletRequest request) {
        String role = authName.role();
        System.out.printf("登录的用户是%s",role);
        System.out.println(authName.userName());
        if (role.equals("学生")) {
            return "student/index";
        } else if (role.equals("教师")) {
            System.out.println("=========run here teacher===========");
            return "teacher/index";
        }  else if (role.equals("学院管理员")) {
            System.out.println("=========run here teacher===========");
            return "manage/index";
        } else {
            System.out.println("==============run here============== "+authName);
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

//    @RequestMapping("/login")
//    public String login(){
//        return "/psc/logout";
//    }
    @RequestMapping("/student/teacher_forms")
    public String teacherForms() {
        return "teacher_forms";
    }


    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("run login");
        return "/psc/logout";
    }

    @RequestMapping("/test/form")
    public String test() {
        return "test/form";
    }
}
