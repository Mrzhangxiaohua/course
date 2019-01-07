package com.spc.controller;


import com.spc.model.UserDomain;
import com.spc.service.data.DataService;
import com.spc.service.user.UserService;
import com.spc.service.webservice.GetInfo;
import com.spc.service.xjtu.webservice.info.xsd.UserInfoDto;
import com.spc.util.AuthMess;
import com.spc.util.StudentTimeLoad;
import com.spc.util.XuanKeStu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 中心路由
 *
 * @author yuhongchao
 */
@Controller
public class MainController extends Base {


    @Autowired
    DataService dataService;
    @Autowired
    UserService userService;

    @Autowired
    GetInfo getInfo;

    @Autowired
    XuanKeStu xuanKeStu;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {


        HttpSession httpSession = request.getSession();

        httpSession = putInfo(httpSession);
        String res = null;

        String userRole = (String) httpSession.getAttribute("userRole");
        String userId = (String) httpSession.getAttribute("userId");
        String username = (String) httpSession.getAttribute("username");
        System.out.println("登录："+httpSession.getAttribute("depid"));
        //为了缓存老师更新的数据而在内存中建立的hashMap

        // just for test
//        userRole = "教职工";
//        userId = "007";

        if (userRole.equals("学生")) {
            if (InXuanKeStu(userId, username)) {
                logger.info("登录的是学生端");
                res = "student/index";
            } else {
                logger.info("该学生不在名单内！");
                res = "student/notIn";
            }
        } else if (userRole.equals("教职工")) {//这个是教职工的情况
            UserDomain userDomain = userService.findUsersById(userId);

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
                } else {
                    logger.info("登录的是教师端");
                    res = "teacher/index";
                }
            }
        }
        return res;
    }


    private HttpSession putInfo(HttpSession session) {

        //首先获得用户信息
        BaseInfo baseInfo = new BaseInfo();
        //将用户信息放置于session 中
        session.setAttribute("authentication", baseInfo.getAuthentication());
        session.setAttribute("username", baseInfo.getUsername());
        session.setAttribute("userId", baseInfo.getUserId());
        session.setAttribute("userRole", baseInfo.getUserRole());
        session.setAttribute("dep",baseInfo.getDep());
        session.setAttribute("departCode",baseInfo.getDepid());
        String departCode=baseInfo.getDepid();
        int departId=0;
        if(!(departCode==null&&departCode=="")){
            departId= (int) userService.findDepId(departCode).get("departId");
        }
        session.setAttribute("departId",departId);//改变
        //将这个用户信息存储与用户信息库里面
        UserInfoDto userDetails = AuthMess.userDetails(baseInfo.getAuthentication());
        dataService.storeUserInformation(userDetails);
        logger.info("登录的用户是{}，角色是{},学院id是{}", baseInfo.getUsername(), baseInfo.getUserRole(),departId);

        //存储一个更新分数的map
        Map updateScore = new HashMap<>();
        updateScore.put("operator", baseInfo.getUsername());
        session.setAttribute("updatescore", updateScore);

        return session;

    }

    private boolean InXuanKeStu(String stuId, String name) {
        Map map = new HashMap();
        map.put("name", name);
        map.put("stuId", stuId);
        return xuanKeStu.inStuNames(map);
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        logger.info("{}退出了", request.getSession().getAttribute("username"));
        return "/psc/logout";
    }

}
