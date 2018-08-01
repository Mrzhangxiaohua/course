package com.spc.service.user;

import org.jasig.cas.client.validation.Assertion;
import org.springframework.security.cas.userdetails.AbstractCasAssertionUserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CasUserDetailsService extends AbstractCasAssertionUserDetailsService {

    @Override
    protected UserDetails loadUserDetails(final Assertion assertion) {
        System.out.println("================================run here==============================");
        final List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(
                assertion.getPrincipal().getName(),
                "",
                true,
                true,
                true,
                true,
                grantedAuthorities
        );
    }
}