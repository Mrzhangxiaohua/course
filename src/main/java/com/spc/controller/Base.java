package com.spc.controller;

import com.spc.util.AuthMess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * 基础服务类
 *
 * @author yuhongchao
 */
@Service
public class Base {
    public static final Logger logger = LoggerFactory.getLogger(Base.class);
    protected  Authentication authentication ;
    protected  String username;
    protected  String userId;
    protected  String userRole;

    public void setPara(){
        authentication  = SecurityContextHolder.getContext().getAuthentication();
        username =  AuthMess.userName(authentication);
        userId =  AuthMess.userId(authentication);
        userRole =  AuthMess.userRole(authentication);
    }
}
