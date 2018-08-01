package com.spc.service.user;

import com.spc.model.CASUserDomain;
import com.spc.model.RoleDomain;
import com.spc.model.UserDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class CustomUserService implements AuthenticationUserDetailsService {

    private static final Logger USER_SERVICE_LOGGER = LoggerFactory.getLogger(CustomUserService.class);
//
//    @Autowired
//    UserService userService;


//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        UserDomain user = userService.findUsersByName(name);
//        if (user == null) {
//            throw new UsernameNotFoundException("用户不存在");
//        }
//        //认证
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        RoleDomain role = user.getRole();
//        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//        System.out.printf("run he%s", role.getRoleName());
//        System.out.println(user.getPassword());
//        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
//    }

    @Override
    public UserDetails loadUserDetails(Authentication token) throws UsernameNotFoundException {
        System.out.println();
        USER_SERVICE_LOGGER.info("校验成功的登录名为: " + token.getName());
        System.out.printf("登录===========================",token);
        String login = token.getPrincipal().toString();
        System.out.println(login);
        String username = login.toLowerCase();
        List grantedAuthorities = new ArrayList();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new CASUserDomain(username, grantedAuthorities);
    }
}
