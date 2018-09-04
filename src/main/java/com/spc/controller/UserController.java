package com.spc.controller;

import com.spc.model.UserDomain;
import com.spc.service.user.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.basic.BasicHTML;

import com.spc.util.RequestPayload;

/**
 * 这个类提供用户管理的路由。
 *
 * @author yuhongchao
 * @version 1.0
 */
@Controller
@RequestMapping(path = "/user")
public class UserController extends Base {


    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping(value = "/add")
    public boolean addUser(HttpServletRequest request) {
        try {
            String json = RequestPayload.getRequestPayload(request);
            System.out.println(json);
            JSONObject obj = new JSONObject(json);

            UserDomain userDomain = new UserDomain();

            JSONObject sts = obj.getJSONObject("params").getJSONObject("values");

            userDomain.setStuId(sts.getString("stuId"));

            Integer roleId = sts.getInt("roleId");
            System.out.println("roleId");
            switch (roleId){
                case 1:
                    userDomain.setRole("学院管理员");
                    break;
                case 2:
                    userDomain.setRole("超级管理员");
                    break;
            }
            //多表关联插入
            return userService.addUser(userDomain);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
