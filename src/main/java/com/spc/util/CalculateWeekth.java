package com.spc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculateWeekth{
    public static int weekth(String firstWeek){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date firstWeekDate=sdf.parse(firstWeek);
            Date currentDate=new Date();
            int weekth= (int)Math.ceil((currentDate.getTime() - firstWeekDate.getTime()) / (1000 * 3600 * 24.0 * 7));
            return weekth;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }


//    public static void main(String[] args) {
//
//        System.out.println("\n"+weekth("2018-09-03"));
//    }
}
