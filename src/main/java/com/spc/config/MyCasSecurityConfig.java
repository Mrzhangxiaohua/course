//package com.spc.config;
//
//import com.spc.controller.MainController;
//import com.spc.model.CASUserDomain;
//import com.spc.service.user.CasUserDetailsService;
//import com.spc.service.user.CustomUserService;
//import org.jasig.cas.client.session.SingleSignOutFilter;
//import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
//import org.jasig.cas.client.validation.Saml11TicketValidator;
//import org.jasig.cas.client.validation.TicketValidator;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.event.EventListener;
//import org.springframework.security.cas.ServiceProperties;
//import org.springframework.security.cas.authentication.CasAuthenticationProvider;
//import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
//import org.springframework.security.cas.web.CasAuthenticationFilter;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.authentication.logout.LogoutFilter;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//
//import javax.servlet.http.HttpSessionEvent;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
//public class MyCasSecurityConfig {
//    //cas服务
//    @Value("${cas.server.url:https://cas.xjtu.edu.cn/login}")
//    private String casServerUrl;
//
//
////    @Autowired
////    private CustomUserService customUserService;
//
//    @Bean
//    public ServiceProperties serviceProperties() {
//        ServiceProperties serviceProperties = new ServiceProperties();
//        //本机服务，访问/login/cas时进行校验登录
//        serviceProperties.setService("http://localhost:8080/login/cas");
//        serviceProperties.setSendRenew(false);
//        return serviceProperties;
//    }
//
//    @Bean
//    @Primary
//    public AuthenticationEntryPoint authenticationEntryPoint( ServiceProperties sP) {
//
//        CasAuthenticationEntryPoint entryPoint = new CasAuthenticationEntryPoint();
//        //cas登录服务
//        entryPoint.setLoginUrl(casServerUrl + "/login");
//        entryPoint.setServiceProperties(sP);
//        return entryPoint;
//    }
//
////    @Bean
////    public CasAuthenticationFilter casAuthenticationFilter() throws Exception {
////        CasAuthenticationFilter casAuthenticationFilter = new CasAuthenticationFilter();
////        casAuthenticationFilter.setAuthenticationManager(authenticationManager());
////        casAuthenticationFilter.setFilterProcessesUrl(casProperties.getAppLoginUrl());
////        return casAuthenticationFilter;
////    }
//
//
//    @Bean
//    public TicketValidator ticketValidator() {
//        //指定cas校验器
//        return new Saml11TicketValidator(casServerUrl);
////        return new Cas30ServiceTicketValidator(casServerUrl);
//    }
//
//    //cas认证
//    @Bean
//    public CasAuthenticationProvider casAuthenticationProvider() {
//
//        CasAuthenticationProvider provider = new CasAuthenticationProvider();
//        provider.setAuthenticationUserDetailsService(casUserDetailsService());
//        provider.setServiceProperties(serviceProperties());
//        provider.setTicketValidator(ticketValidator());
//
//        //固定响应用户，在生产环境中需要额外设置用户映射
////        provider.setUserDetailsService(
//////                s -> new User(12,"auth-user", "123", null,3242, AuthorityUtils.createAuthorityList("ROLE_ADMIN")));
////        provider.setAuthenticationUserDetailsService(s->
////                new User(
////                        s.getName(),
////                        "",
////                        true,
////                        true,
////                        true,
////                        true,
////                        AuthorityUtils.createAuthorityList("ROLE_ADMIN")
////                ));
////        System.out.println("run here");AuthorityUtils.createAuthorityList("ROLE_ADMIN")
//
////        provider.setAuthenticationUserDetailsService(
////                s -> new User("auth-user", "123", true, true, true, true,
////                        AuthorityUtils.createAuthorityList("ROLE_ADMIN")));
//////        provider.setAuthenticationUserDetailsService(
////                (principal) -> {
////                    System.out.println("=============================");
////                    System.out.println(principal);
////                    return new CASUserDomain(principal.getName(), AuthorityUtils.createAuthorityList("ROLE_MTLS_USER"));
////                });
//        provider.setKey("CAS_PROVIDER_LOCALHOST_YUHONGCHAO66");
//        return provider;
//    }
//
//
//    @Bean
//    public AuthenticationUserDetailsService casUserDetailsService() {
//        return new CasUserDetailsService();
//    }
//
//    @Bean
//    public SecurityContextLogoutHandler securityContextLogoutHandler() {
//        return new SecurityContextLogoutHandler();
//    }
//
//    @Bean
//    public LogoutFilter logoutFilter() {
//        //退出后转发路径
//        LogoutFilter logoutFilter = new LogoutFilter(casServerUrl + "/logout", securityContextLogoutHandler());
//        //cas退出
//        logoutFilter.setFilterProcessesUrl("/logout/cas");
//        return logoutFilter;
//    }
//
//    @Bean
//    public SingleSignOutFilter singleSignOutFilter() {
//        //单点退出
//        SingleSignOutFilter singleSignOutFilter = new SingleSignOutFilter();
////        singleSignOutFilter.setCasServerUrlPrefix(casServerUrl);
//        singleSignOutFilter.setIgnoreInitConfiguration(true);
//        return singleSignOutFilter;
//    }
//
//
//
//    //设置退出监听
//    @EventListener
//    public SingleSignOutHttpSessionListener singleSignOutHttpSessionListener( HttpSessionEvent event) {
//        return new SingleSignOutHttpSessionListener();
//    }
//
////    @Bean
////    public CasAuthenticationFilter casAuthenticationFilter() throws Exception {
////        CasAuthenticationFilter casAuthenticationFilter = new CasAuthenticationFilter();
////        casAuthenticationFilter.setAuthenticationManager(authenticationManager());
////        casAuthenticationFilter.setFilterProcessesUrl(casProperties.getAppLoginUrl());
////        return casAuthenticationFilter;
////    }
//
//
//
//
//}
