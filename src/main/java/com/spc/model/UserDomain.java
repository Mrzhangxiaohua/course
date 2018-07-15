package com.spc.model;

import java.lang.Integer;
import org.apache.ibatis.type.Alias;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Alias("UserDomain") //起别名
public class UserDomain {

    private Integer uid;

    private String userName; //用户的名称

    private String password; //用户的密码

    private RoleDomain role; //用户的角色

    private Integer stuId;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        return encode;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }


    public RoleDomain getRole() {
        return role;
    }

    public void setRole(RoleDomain role) {
        this.role = role;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }
}