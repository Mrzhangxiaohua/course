package com.spc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Configuration
public class AuthMess {

    public int userId() {
        return 2018000006;
    }

    public int teacherId() {
        return 2018124001;
    }

    public String userName() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        return userDetails.getUsername();
    }
    public String role() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();
        return String.valueOf(authorities.get(0));
    }


}
