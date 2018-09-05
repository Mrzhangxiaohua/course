package com.spc.util;

import org.springframework.context.annotation.Configuration;


@Configuration
public class CourseDateTrans {

    public static StringBuilder dateToString(Integer a, Integer b) {
        return aToString(a).append(bToString(b));
    }

    public static StringBuilder aToString(Integer a) {
        StringBuilder strs = new StringBuilder("");
        switch (a) {
            case 1:
                strs = strs.append("周一");
                break;
            case 2:
                strs = strs.append("周二");
                break;
            case 3:
                strs = strs.append("周三");
                break;
            case 4:
                strs = strs.append("周四");
                break;
            case 5:
                strs = strs.append("周五");
                break;
            case 6:
                strs = strs.append("周六");
                break;
            default:
                strs = strs.append("周日");
                break;
        }
        ;
        return strs;
    }

    public static StringBuilder bToString(Integer b) {
        StringBuilder strs = new StringBuilder("");
        switch (b) {
            case 1:
                strs = strs.append("1-2节");
                break;
            case 2:
                strs = strs.append("3-4节");
                break;
            case 3:
                strs = strs.append("5-6节");
                break;
            case 4:
                strs = strs.append("7-8节");
                break;
            default:
                strs = strs.append("9-10节");
                break;
        }
        ;
        return strs;
    }


}
