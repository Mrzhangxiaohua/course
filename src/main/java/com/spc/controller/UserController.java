package com.spc.controller;

import com.github.pagehelper.PageHelper;
import com.spc.model.UserDomain;
import com.spc.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/add")
    public int addUser(UserDomain user){
        return userService.addUser(user);
    }


    @RequestMapping("/find")
    public String findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize,
            @RequestParam(name = "userId", required = true)
                    String userId,
            Model model){
        //开始分页
        UserDomain user = userService.findUsersById(userId);
        model.addAttribute("users",user);
        return "hello";
    }
}
