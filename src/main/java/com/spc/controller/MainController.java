package com.spc.controller;


import com.spc.util.RequestPayload;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.cas.authentication.CasAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);


    @Autowired
    RequestPayload requestPayload;

    @RequestMapping(value = "/login/cas", method = RequestMethod.GET)
    public String index(ModelMap modelMap, HttpServletRequest request) {
//        String netid = request.getParameter("netid");
//        System.out.println("netid: "+netid);
//        String cn = request.getParameter("cn");
//        System.out.println("cn: "+cn);
//        String en = request.getParameter("en");
//        System.out.println("en: "+en);
//        String json = requestPayload.getRequestPayload(request);
//        try {
//            JSONObject obj = new JSONObject(json);
////            String id = obj.getString("netid");
//            System.out.println("obj is "+obj);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
//        Map attributes = principal.getAttributes();

        System.out.println("principal:=" + principal);
        Authentication auth = SecurityContextHolder.getContext() .getAuthentication();


        if(auth != null
                && auth.getPrincipal() != null
                && auth.getPrincipal() instanceof UserDetails) {
            modelMap.put("username", ((UserDetails) auth.getPrincipal()).getUsername());
        }
        String authName = auth.getName();

        if (authName == null) {
            return "student/index";
        } else if (authName.equals("教师")) {
            System.out.println("=========run here teacher===========");
            return "teacher/index";
        } else if (authName.equals("学生")) {
            return "student/index";
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

    @RequestMapping("/student/teacher_forms")
    public String teacherForms() {
        return "teacher_forms";
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
