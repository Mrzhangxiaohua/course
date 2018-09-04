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

        logger.info("登录的用户是%s，角色是%s\n", userDetails.getUsername(), userRole);

        String res = null;
        if (userRole.equals("学生")) {
            logger.info("登录的是学生端");
            res = "student/index";
        } else if (userRole.equals("教职工")) {//这个是教职工的情况
            UserDomain userDomain = userService.findUsersById(userDetails.getUserno());
            logger.info("登录的是教师端");
            if (userDomain == null) {
                res = "teacher/index";
            } else {
                if (userDomain.getRole().equals("学院管理员")) {
                    logger.info("登录的是学院管理员端");
                    res = "dmanage/index";
                } else if (userDomain.getRole().equals("超级管理员")) {
                    logger.info("登录的是超级管理员端");
                    res = "manage/index";
                }
            }
        }
        return res;
    }

//    @RequestMapping("/student/classes")
//    public String classes() {
//        return "course/showClass";
//    }

//    @RequestMapping("/student/calendar")
//    public String showTimeTable() {
//        System.out.println("run here");
//        return "student/calendar2";
//    }
//

//    @RequestMapping("/student/teacher_forms")
//    public String teacherForms() {
//        return "teacher_forms";
//    }


    @RequestMapping("/logout")
    public String logout() {
        System.out.println("run login");
        return "/psc/logout";
    }

//    @RequestMapping("/test/form")
//    public String test() {
//        return "test/form";
//    }
}
