package com.spc.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spc.util.RequestPayload;
import javax.servlet.http.HttpServletRequest;

@RequestMapping("/teacher")
@Controller
public class TeacherController {
    @Autowired
    RequestPayload requestPayload;

    @RequestMapping(value = "/course/add",method = RequestMethod.POST)
    @ResponseBody
    public String add(HttpServletRequest request){
        try {
            String json = requestPayload.getRequestPayload(request);
            System.out.println(json);
            JSONObject obj = new JSONObject(json);
            String pageName = obj.getString("teaName");
            System.out.println(pageName);
        }catch (Exception e){
            System.out.println("error");
        }
        return "sfsfs";
    }
}
