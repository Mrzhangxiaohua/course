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
        return strs;
    }

    public static StringBuilder bToString(Integer b, Integer c) {
        StringBuilder strs = new StringBuilder("");
        if (c == 1) {
            if (b <= 4) {
                strs = strs.append("第" + b + "节");
            } else if (b >= 5 && b <= 6) {
                strs = strs.append("第N" + (b - 4) + "节");
            } else {
                strs = strs.append("第" + (b - 2) + "节");
            }
        } else {
            strs = strs.append((convertFormat(b) + "-" + convertFormat(b - 1 + c) + "节"));
        }

        return strs;
}

    private static String convertFormat(Integer index) {
        String res = "";
        if (index <= 4) {
            res += index;
        } else if (index >= 5 && index <= 6) {
            res += ("N" + (index - 4));
        } else {
            res += (index - 2);
        }
        return res;
    }



}
