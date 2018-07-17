package com.spc.util;

import org.springframework.context.annotation.Configuration;


@Configuration
public class CourseDateTrans{

    public StringBuilder dateToString(Integer a ,Integer b){
        return aToString(a).append(bToString(b));}

    public StringBuilder aToString(Integer a){
        StringBuilder strs = new StringBuilder(" ");
        switch(a)
        {
            case 1:
                strs =strs.append("星期一");
                break;
            case 2:
                strs =strs.append("星期二");
                break;
            case 3:
                strs =strs.append("星期三");
                break;
            case 4:
                strs =strs.append("星期四");
                break;
            case 5:
                strs =strs.append("星期五");
                break;
            case 6:
                strs =strs.append("星期六");
                break;
            default:
                strs =strs.append("星期日");
                break;
        };
        return strs;
    }
    public StringBuilder bToString(Integer b){
        StringBuilder strs = new StringBuilder(" ");
        switch(b)
        {
            case 1:
                strs =strs.append("一二节");
                break;
            case 2:
                strs =strs.append("三四节");
                break;
            case 3:
                strs =strs.append("五六节");
                break;
            case 4:
                strs =strs.append("七八节");
                break;
            default:
                strs =strs.append("九十节");
                break;
        };
        return strs;
    }


}
