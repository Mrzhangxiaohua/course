package com.spc.service.user;

import com.spc.model.CASUserDomain;
import com.spc.model.UserDomain;
import org.jasig.cas.client.validation.Assertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;

import java.util.ArrayList;
import java.util.List;


public class CustomUserService implements AuthenticationUserDetailsService {
//public class CustomUserService implements  {

    private static final Logger USER_SERVICE_LOGGER = LoggerFactory.getLogger(CustomUserService.class);

    @Autowired
    UserService userService;

//    @Override
//    public UserDetails loadUserDetails(Assertion ass) throws UsernameNotFoundException {
//        System.out.println(ass);
//        String username ="学生";
//        List grantedAuthorities = new ArrayList();
//        grantedAuthorities.add(new SimpleGrantedAuthority(username));
//        return   new User(username,
//                            "",
//                            true,
//                            true,
//                            true,
//                            true,
//                grantedAuthorities);
//    }

//    protected UserDetails loadUserByAssertion(final Assertion assertion) {
//        return this.userDetailsService.loadUserByUsername(assertion.getPrincipal().getName());
//    }

    @Override
    public UserDetails loadUserDetails(Authentication token) throws UsernameNotFoundException {
        USER_SERVICE_LOGGER.info("校验成功的登录名为: " + token.getName());
        System.out.printf("=======================%s用户已登录===========================\n",token.getName());
        String username = token.getPrincipal().toString();
        UserDomain userDomain = userService.findUsersByName(username);
        String role = userDomain==null?"学生":userDomain.getRole().getRoleName();
        System.out.println(role);

        List grantedAuthorities = new ArrayList();
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
        return   new User(username,
                            "",
                            true,
                            true,
                            true,
                            true,
                grantedAuthorities);
    }
}
