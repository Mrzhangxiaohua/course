package com.spc.util;

import java.util.HashMap;
import java.util.List;

public class MakeTimeTable {
    public static  String[][] makeBigTable(List<HashMap<String, Object>> lis){
        String temp[][] = new String[10][7];
        for (HashMap<String, Object> li : lis) {
            String date = (String) li.get("classDateDescription");
            String classPlace = (String) li.get("classPlace");
            String mainLecturer = (String) li.get("mainLecturer");
            String teacherName = (String) li.get("teaName");
            String startWeek = Integer.toString((Integer) li.get("startWeek"));
            String endWeek = Integer.toString((Integer) li.get("endWeek"));
            String classNum = Integer.toString((Integer) li.get("classNum"));
            String className = (String) li.get("className");

            String[] ints = date.split(":");
            Integer t = ints[0].toCharArray()[0] - '0';
            Integer l = ints[1].toCharArray()[0] - '0';
            if(t==0){
                for(int r=1;r<=5;r++){
                    String context = "★课程：" + className + ',' + "教室：" + classPlace + ',' + "授课教师：" + teacherName + ','+ "主讲教师：" + mainLecturer + ',' + "周次：" + startWeek + "-" + endWeek + ',' + "班次：" + classNum;
                    temp[(l - 1) * 2][r - 1] = temp[(l - 1) * 2][r - 1] != null ? temp[(l - 1) * 2][r - 1] + "," + context : context;
                    temp[(l - 1) * 2 + 1][r - 1] = temp[(l - 1) * 2 + 1][r - 1] != null ? temp[(l - 1) * 2 + 1][r - 1] + "," + context : context;
                }
            }else {
                int r=t;
                String context = "★课程：" + className + ',' + "教室：" + classPlace + ',' + "授课教师：" + teacherName + ',' + "主讲教师：" + mainLecturer + ',' + "周次：" + startWeek + "-" + endWeek + ',' + "班次：" + classNum;
                temp[(l - 1) * 2][r - 1] = temp[(l - 1) * 2][r - 1] != null ? temp[(l - 1) * 2][r - 1] + "," + context : context;
                temp[(l - 1) * 2 + 1][r - 1] = temp[(l - 1) * 2 + 1][r - 1] != null ? temp[(l - 1) * 2 + 1][r - 1] + "," + context : context;
            }
        }
        return temp;
    }
    public static  String[][] makeTable(List<HashMap<String, Object>> lis){
        String temp[][] = new String[10][7];
        System.out.println(lis);
        if (!lis.isEmpty()) {
            for (HashMap<String, Object> li : lis) {
                System.out.println("=======检测============");
                System.out.println(li.get("startWeek"));
                String date = (String) li.get("classDateDescription");
                String classPlace = (String) li.get("classPlace");
                String teaName = (String) li.get("teaName");
                System.out.println(li.get("startWeek"));
                String startWeek = Integer.toString((Integer) li.get("startWeek"));
                String endWeek = Integer.toString((Integer) li.get("endWeek"));
                String classNum = Integer.toString((Integer) li.get("classNum"));
                String className = (String) li.get("className");

                String[] ints = date.split(":");
                Integer r = ints[0].toCharArray()[0] - '0';
                Integer l = ints[1].toCharArray()[0] - '0';

                String context = "★课程：" + className + ',' + "教室：" + classPlace + ',' + "教师：" + teaName + ',' + "周次：" + startWeek + "-" + endWeek + ',' + "班次：" + classNum;
                temp[(l - 1) * 2][r - 1] = context;
                temp[(l - 1) * 2 + 1][r - 1] = context;
            }
        }

        return temp;
    }
}
