package com.spc.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeConflict {
    public static boolean confilct(List<long[]> times, List<long[]> classTime) {//times是课程时间区间，classTime学生课表时间
        for (int i = 0; i < times.size(); i++) {    //
            long[] a = times.get(i);
            for (int j = 0; j < classTime.size(); j++) {
                long[] b = classTime.get(j);
                //a在b中
                if (a[0] < b[1] & a[0] > b[0]) {
                    return true;
                }
                if (a[1] < b[1] & a[1] > b[0]) {
                    return true;
                }
                //b在a中
                if (a[0] < b[0] & a[1] > b[0]) {
                    return true;
                }
                if (a[0] < b[1] & a[1] > b[1]) {
                    return true;
                }
                if (a[0] == b[0] & a[1] == b[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Map> maps = new ArrayList<Map>();
        Map temp = new HashMap();
        temp.put("startWeek",2);
        temp.put("endWeek",5);
        temp.put("classDateDescription","4:1");
        maps.add(temp);

        List<long[]> times = StudentTimeLoad.StudentTimeLoad(maps);
        System.out.println(times);
        for (long[] i:times){
            System.out.println(i[0]+"-"+i[1]);
        }


        Map temp2 = new HashMap();
        temp2.put("startWeek",4);
        temp2.put("endWeek",8);
        temp2.put("classDateDescription","3:1");

        List<long[]> classTime = StudentTimeLoad.TimeLoad(temp2);
        System.out.println(classTime);
        for (long[] i:classTime){
            System.out.println(i[0]+"-"+i[1]);
        }
        System.out.println(TimeConflict.confilct(times,classTime));
    }
}
