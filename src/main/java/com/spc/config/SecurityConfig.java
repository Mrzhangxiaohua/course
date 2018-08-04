package com.spc.config;

import com.spc.service.user.CustomUserService;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;



@Configuration
@EnableWebSecurity //启用web权限
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用方法验证
@Order(10000)
//@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CasProperties casProperties;


    /**定义认证用户信息获取来源，密码校验规则等*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.authenticationProvider(casAuthenticationProvider());

    }

    /**定义安全策略*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests()//配置安全策略
                .anyRequest().authenticated()//其余的所有请求都需要验证
                .and()
                .logout()
                .logoutSuccessUrl("/logout");


        http.exceptionHandling().authenticationEntryPoint(casAuthenticationEntryPoint())
                .and()
                .addFilter(casAuthenticationFilter())
//                .addFilter(registWrapperFilter())
//                .addFilterBefore(registWrapperFilter(),SecurityContextHolderAwareRequestFilter.class)
                .addFilterBefore(casLogoutFilter(), LogoutFilter.class)
                .addFilterAfter(singleSignOutFilter(), CasAuthenticationFilter.class);

        //http.csrf().disable(); //禁用CSRF
    }

    /**认证的入口*/
    @Bean
    public CasAuthenticationEntryPoint casAuthenticationEntryPoint() {
        CasAuthenticationEntryPoint casAuthenticationEntryPoint = new CasAuthenticationEntryPoint();
        casAuthenticationEntryPoint.setLoginUrl(casProperties.getCasServerLoginUrl());
        casAuthenticationEntryPoint.setServiceProperties(serviceProperties());
        return casAuthenticationEntryPoint;
    }

    /**指定service相关信息*/
    @Bean
    public ServiceProperties serviceProperties() {
        ServiceProperties serviceProperties = new ServiceProperties();
        serviceProperties.setService(casProperties.getAppServerUrl() + casProperties.getAppLoginUrl());
        serviceProperties.setAuthenticateAllArtifacts(true);
        return serviceProperties;
    }

    /**CAS认证过滤器*/
    @Bean
    public CasAuthenticationFilter casAuthenticationFilter() throws Exception {
        CasAuthenticationFilter casAuthenticationFilter = new CasAuthenticationFilter();
        casAuthenticationFilter.setAuthenticationManager(authenticationManager());
        casAuthenticationFilter.setFilterProcessesUrl(casProperties.getAppLoginUrl());
        return casAuthenticationFilter;
    }



    /**cas 认证 Provider*/
    @Bean
    public CasAuthenticationProvider casAuthenticationProvider() {
        CasAuthenticationProvider casAuthenticationProvider = new CasAuthenticationProvider();
        casAuthenticationProvider.setAuthenticationUserDetailsService(customUserDetailsService());
        casAuthenticationProvider.setServiceProperties(serviceProperties());
        casAuthenticationProvider.setTicketValidator(cas20ServiceTicketValidator());
        casAuthenticationProvider.setKey("casAuthenticationProviderKey");
        return casAuthenticationProvider;
    }


    /**自定义的AuthenticationUserDetailsService*/
    @Bean
    public AuthenticationUserDetailsService<CasAssertionAuthenticationToken> customUserDetailsService(){
        return new CustomUserService();
    }
    @Bean
    public Cas20ServiceTicketValidator cas20ServiceTicketValidator() {
//        TicketValidator
        return new Cas20ServiceTicketValidator(casProperties.getCasServerUrl());
    }



    @Bean
    public FilterRegistrationBean wrapperFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new HttpServletRequestWrapperFilter());
        filterRegistrationBean.setOrder(0);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    /**单点登出过滤器*/
    @Bean
    public SingleSignOutFilter singleSignOutFilter() {
        System.out.println("sso run ===============");
        SingleSignOutFilter singleSignOutFilter = new SingleSignOutFilter();
//        singleSignOutFilter.setCasServerUrlPrefix(casProperties.getCasServerUrl());
        singleSignOutFilter.setIgnoreInitConfiguration(true);
        return singleSignOutFilter;
    }

//    @Bean
//    public FilterRegistrationBean securityFilterChain( @Qualifier(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME) Filter registWrapperFilter) {
//        FilterRegistrationBean registration = new FilterRegistrationBean(registWrapperFilter);
//        registration.setOrder(0);
//        registration
//                .setName(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME);
//        return registration;
//    }

//    @Bean
//    public HttpServletRequestWrapperFilter registWrapperFilter()
//    {
//
////        HttpServletRequestWrapperFilter filter = new HttpServletRequestWrapperFilter();
////        securityFilterChain(filter);
////        registration.setFilter(new HttpServletRequestWrapperFilter());
////        registration.addUrlPatterns("/login/*", "/*");
////        registration.setName("wrapperFilter");
//        System.out.println("=====================");
//        return new HttpServletRequestWrapperFilter();
//    }


    /**请求单点退出过滤器*/
    @Bean
    public LogoutFilter casLogoutFilter() {
        LogoutFilter logoutFilter = new LogoutFilter(casProperties.getCasServerLogoutUrl(), new SecurityContextLogoutHandler());
        logoutFilter.setFilterProcessesUrl(casProperties.getAppLogoutUrl());
        return logoutFilter;
    }
}
