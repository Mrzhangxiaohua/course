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


    public UserInfoDto userDetails(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfoDto userDetails = (UserInfoDto) authentication.getPrincipal();
        return userDetails;
    }

    public String userId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfoDto userDetails = (UserInfoDto) authentication.getPrincipal();
        String stuId = userDetails().getUserno();
        return stuId;
    }

}
