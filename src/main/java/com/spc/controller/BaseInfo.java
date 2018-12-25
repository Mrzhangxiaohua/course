package com.spc.controller;

import com.spc.util.AuthMess;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 登录学生的基础信息类
 *
 */

public class BaseInfo {
    private Authentication authentication;
    private String username;
    private String userId;
    private String userRole;
    private String dep;


    BaseInfo() {
        this.authentication = SecurityContextHolder.getContext().getAuthentication();
        this.username = AuthMess.userName(authentication);
        this.userId = AuthMess.userId(authentication);
        this.userRole = AuthMess.userRole(authentication);
        this.dep=AuthMess.userDepart(authentication);
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = AuthMess.userName(authentication);
    }

    public String getUserId() {
        return userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String department) {
        this.dep = department;
    }
}
