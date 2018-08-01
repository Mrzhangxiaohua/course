package com.spc.model;

import java.lang.Integer;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Alias("UserDomain") //起别名
public class UserDomain implements  UserDetails{

    private Integer uid;

    private String userName; //用户的名称

    private String password; //用户的密码

    private RoleDomain role; //用户的角色

    private Integer stuId;

    private Set<AuthorityInfo> authorities = new HashSet<AuthorityInfo>();
    public void setAuthorities(Set<AuthorityInfo> authorities) {
        this.authorities = authorities;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encode = bCryptPasswordEncoder.encode(password);
//        return encode;
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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