package com.spc.controller;


import com.spc.model.UserDomain;
import com.spc.service.data.DataService;
import com.spc.service.user.UserService;
import com.spc.service.webservice.GetInfo;
import com.spc.service.xjtu.webservice.info.xsd.UserInfoDto;
import com.spc.util.AuthMess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 中心路由
 *
 * @author yuhongchao
 */
@Controller
public class MainController extends Base{


    @Autowired
    DataService dataService;
    @Autowired
    UserService userService;

    @Autowired
    GetInfo getInfo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {

//        //初始化参数
//        setPara();

        HttpSession httpSession = request.getSession();

        BaseInfo baseInfo = new BaseInfo();

        httpSession.setAttribute("authentication",baseInfo.getAuthentication());
        httpSession.setAttribute("username",baseInfo.getUsername());
        httpSession.setAttribute("userId",baseInfo.getUserId());
        httpSession.setAttribute("userRole",baseInfo.getUserRole());

        UserInfoDto userDetails = AuthMess.userDetails(baseInfo.getAuthentication());
        dataService.storeUserInformation(userDetails);

        logger.info("登录的用户是{}，角色是{}",baseInfo.getUsername(), baseInfo.getUserRole());

        String res = null;
        if (baseInfo.getUserRole().equals("学生")) {
            logger.info("登录的是学生端");
            res = "student/index";
        } else if (baseInfo.getUserRole().equals("教职工")) {//这个是教职工的情况
            UserDomain userDomain = userService.findUsersById(userDetails.getUserno());

            if (userDomain == null) {
                logger.info("登录的是教师端");
                res = "teacher/index";
            } else {
                if (userDomain.getRole().equals("学院管理员")) {
                    logger.info("登录的是学院管理员端");
                    res = "dmanage/index";
                } else if (userDomain.getRole().equals("超级管理员")) {
                    logger.info("登录的是超级管理员端");
                    res = "manage/index";
                }else{
                    logger.info("登录的是教师端");
                    res = "teacher/index";
                }
            }
        }
        return res;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        logger.info("{}退出了",request.getSession().getAttribute("username"));
        return "/psc/logout";
    }


}
