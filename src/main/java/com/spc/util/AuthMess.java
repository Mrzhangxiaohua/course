package com.spc.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class AuthMess {


//    private Authentication authentication;

//    public AuthMess(){
//        authentication= SecurityContextHolder.getContext().getAuthentication();
//    }

    public int userId(){
        return 2018000001;
//        return authentication.getAuthorities().toArray()[0];
    }

    public int teacherId(){
        return 2018124001;
    }

    public String userName(){
        return "于";
    }



}
