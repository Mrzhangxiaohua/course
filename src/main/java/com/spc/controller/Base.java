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
    //static：保证全局唯一性，
    //public：确保任意包里的子类都可以调用这些属性。
    public static final Logger logger = LoggerFactory.getLogger(Base.class);
    public static Authentication authentication;
    public static String username;
    public static String userId;
    public static String userRole;

    public void setPara() {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        username = AuthMess.userName(authentication);
        userId = AuthMess.userId(authentication);
        userRole = AuthMess.userRole(authentication);
    }
}
