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
    public String index() {

        //初始化参数
        setPara();

        UserInfoDto userDetails = AuthMess.userDetails(authentication);
        dataService.storeUserInformation(userDetails);

        logger.info("登录的用户是{}，角色是{}",username, userRole);

        String res = null;
        if (userRole.equals("学生")) {
            logger.info("登录的是学生端");
            res = "student/index";
        } else if (userRole.equals("教职工")) {//这个是教职工的情况
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
    public String logout() {
        logger.info("{}退出了",username);
        return "/psc/logout";
    }


}
