package com.spc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2019-01-04 14:15
 **/
public class LoggerUtil {

    public static Logger getLogger(Class c) {
        return LoggerFactory.getLogger(c);
    }
}
