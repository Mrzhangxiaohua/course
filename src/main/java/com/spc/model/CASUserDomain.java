package com.spc.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class CASUserDomain implements UserDetails ,Serializable {

    private String userName;

    private String password;

    private List<GrantedAuthority> lis;

    public CASUserDomain(String userName, List<GrantedAuthority> lis) {
        System.out.println("======================================");
        System.out.println(userName);
        this.userName = userName;
        this.lis = lis;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return lis;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
