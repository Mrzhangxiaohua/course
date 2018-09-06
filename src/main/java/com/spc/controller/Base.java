package com.spc.controller;

import com.spc.util.AuthMess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础服务类
 *
 * @author yuhongchao
 */

@Component
public class Base {
    //static：保证全局唯一性，静态变量属于类
    //public：确保任意包里的子类都可以调用这些属性。
    public  final Logger logger = LoggerFactory.getLogger(Base.class);
}
