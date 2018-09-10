package com.spc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
