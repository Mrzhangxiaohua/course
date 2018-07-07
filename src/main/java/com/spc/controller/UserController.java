package com.spc.controller;

import com.github.pagehelper.PageHelper;
import com.spc.model.ClassDomain;
import com.spc.model.UserDomain;
import com.spc.service.user.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.spc.util.RequestPayload;
import com.spc.model.UserDomain;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {


    @Autowired
    RequestPayload requestPayload;


    @Autowired
    private UserService userService;



    @ResponseBody
    @PostMapping(value = "/add")
    public boolean addUser(HttpServletRequest request) {
        try {
            String json = requestPayload.getRequestPayload(request);
            System.out.println(json);
            JSONObject obj = new JSONObject(json);

            UserDomain userDomain= new UserDomain();

            userDomain.setStuId(obj.getInt("stuId"));
            userDomain.setPassword(obj.getString("password"));
            userDomain.setUserName(obj.getString("userName"));
            userDomain.setRole(null);

            Integer roleId = obj.getInt("roleId");

            return userService.addUser(userDomain,roleId);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    };


}
