//package com.spc.config;
//
//import org.jasig.cas.client.authentication.AuthenticationFilter;
//import org.jasig.cas.client.session.SingleSignOutFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.cas.ServiceProperties;
//import org.springframework.security.cas.web.CasAuthenticationFilter;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.authentication.logout.LogoutFilter;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private AuthenticationEntryPoint authenticationEntryPoint;
////
//    @Autowired
//    private AuthenticationProvider authenticationProvider;
//
//    @Autowired
//    private ServiceProperties serviceProperties;
//
//    @Autowired
//    private SingleSignOutFilter singleSignOutFilter;
//
//    @Autowired
//    private LogoutFilter logoutFilter;
//
////    @Autowired
////    private MyCasSecurityConfig myCasSecurityConfig;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //所有都需要认证才能访问
//        //由于设置了验证filter访问为，/login/cas，所以必须通过验证，否则出现死循环
//        http
//                .authorizeRequests().antMatchers("/login/cas").permitAll()
//                .and()
//                .authorizeRequests().anyRequest().authenticated()
//                .and()
//                .httpBasic().authenticationEntryPoint(authenticationEntryPoint)
//                .and()
//                .logout().logoutSuccessUrl("/logout")
////                .addFilter(casAuthenticationFilter(serviceProperties),CasAuthenticationFilter.class)
//                .and()
//                .addFilterBefore(singleSignOutFilter, CasAuthenticationFilter.class).addFilterBefore(logoutFilter, LogoutFilter.class);
////        http.addFilterBefore(new AuthenticationFilter(), BasicAuthenticationFilter.class);
//        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
//                .and()
//                .addFilter(casAuthenticationFilter(serviceProperties));
////                .addFilterBefore(casLogoutFilter(), LogoutFilter.class)
////                .addFilterBefore(singleSignOutFilter(), CasAuthenticationFilter.class);
//
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.authenticationProvider(authenticationProvider);
//    }
//
//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        //设置cas认证提供
//        return new ProviderManager(Arrays.asList(authenticationProvider));
//    }
//
//
//
//    @Bean
//    public CasAuthenticationFilter casAuthenticationFilter(ServiceProperties sp)
//            throws Exception {
//        //cas认证过滤器，当触发本filter时，对ticket进行认证
//        System.out.println("=============run here==============");
//        System.out.println(sp);
//        CasAuthenticationFilter filter = new CasAuthenticationFilter();
//        filter.setServiceProperties(sp);
//        filter.setAuthenticationManager(authenticationManager());
//        return filter;
//    }
//
////    @Bean
////    public CasAuthenticationFilter casAuthenticationFilter() throws Exception {
////        CasAuthenticationFilter casAuthenticationFilter = new CasAuthenticationFilter();
////        casAuthenticationFilter.setAuthenticationManager(authenticationManager());
////        casAuthenticationFilter.setFilterProcessesUrl("");
////        return casAuthenticationFilter;
////    }
//
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//    }
//}