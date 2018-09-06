package com.spc.filter;

import com.spc.service.xjtu.webservice.info.xsd.UserInfoDto;
import org.slf4j.MDC;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@Order(10)
//重点
@WebFilter(filterName = "mdcFilter", urlPatterns = "/*")
public class UserServletFilter implements Filter {

    private final String USER_KEY = "username";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("mdcFilter run=========================");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MDC.put(USER_KEY,authentication.getName());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
