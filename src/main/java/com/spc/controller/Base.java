package com.spc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 基础服务类
 *
 * @author yuhongchao
 */

@Component
public class Base {
    //static：保证全局唯一性，静态变量属于类
    //public：确保任意包里的子类都可以调用这些属性。
    protected static String CURRENTSEMESTER = "2019-2020秋季";

    // 当时秋季学期的时候，请把这个字段设置为null
    protected static String PREVIOUSSEMESTER = null;

    public final Logger logger = LoggerFactory.getLogger(Base.class);

}
