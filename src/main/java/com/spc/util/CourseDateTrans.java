package com.spc.util;

import org.springframework.context.annotation.Configuration;


@Configuration
public class CourseDateTrans {

    public static StringBuilder dateToString(Integer a, Integer b, Integer c) {
        return aToString(a).append(bToString(b, c));
    }

    public static StringBuilder aToString(Integer a) {
        StringBuilder strs = new StringBuilder("");
        switch (a) {
            case 0:
                strs = strs.append("周一至周五");
                break;
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
            case 7:
                strs = strs.append("周日");
                break;
            default:
                break;
        }
        ;
        return strs;
    }

    public static StringBuilder bToString(Integer b, Integer c) {
        StringBuilder strs = new StringBuilder("");
        if (c == 1) {
            strs = strs.append("第" + b + "节");
        } else {
            switch (b) {
                case 1:
                    strs = strs.append((b + "-" + (b - 1 + c)) + "节");
                    break;
                case 2:
                    strs = strs.append((b + "-" + (b - 1 + c)) + "节");
                    break;
                case 3:
                    strs = strs.append((b + "-" + (b - 1 + c)) + "节");
                    break;
                case 4:
                    strs = strs.append((b + "-" + (b - 1 + c)) + "节");
                    break;
                case 5:
                    strs = strs.append((b + "-" + (b - 1 + c)) + "节");
                    break;
                case 6:
                    strs = strs.append((b + "-" + (b - 1 + c)) + "节");
                    break;
                case 7:
                    strs = strs.append((b + "-" + (b - 1 + c)) + "节");
                    break;
                case 8:
                    strs = strs.append((b + "-" + (b - 1 + c)) + "节");
                    break;
                case 9:
                    strs = strs.append((b + "-" + (b - 1 + c)) + "节");
                    break;
                case 10:
                    strs = strs.append((b + "-" + (b - 1 + c)) + "节");
                    break;
                case 11:
                    strs = strs.append((b + "-" + (b - 1 + c)) + "节");
                    break;
                case 12:
                    strs = strs.append((b + "-" + (b - 1 + c)) + "节");
                    break;
                case 13:
                    strs = strs.append((b + "-" + (b - 1 + c)) + "节");
                    break;
                default:
                    break;
            }
        }
        return strs;
    }



}
