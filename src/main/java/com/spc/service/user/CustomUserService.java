package com.spc.service.user;

import com.spc.model.RoleDomain;
import com.spc.model.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CustomUserService implements UserDetailsService {

    @Autowired
    UserService userService;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserDomain user = userService.findUsersByName(name);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        //认证
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        RoleDomain role = user.getRole();
        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        System.out.printf("run he%s", role.getRoleName());
        System.out.println(user.getPassword());
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }
}
