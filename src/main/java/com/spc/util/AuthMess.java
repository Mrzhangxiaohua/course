package com.spc.util;

import com.spc.service.xjtu.webservice.info.UserInfo;
import com.spc.service.xjtu.webservice.info.xsd.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Configuration
public class AuthMess {

    public static UserInfoDto userDetails(Authentication authentication){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfoDto userDetails = (UserInfoDto) authentication.getPrincipal();
        return userDetails;
    }

    public static String userId(Authentication authentication) {
        String stuId = userDetails(authentication).getUserno();
        return stuId;
    }
    public static String userName( Authentication authentication) {
        String username = userDetails(authentication).getUsername();
        return username;
    }

    public static String userRole( Authentication authentication) {
        List<GrantedAuthority> authentications = (List<GrantedAuthority>) userDetails(authentication).getAuthorities();
        return authentications.get(0).getAuthority();
    }



}
