package com.spc.util;

import com.spc.controller.Base;

import java.util.*;

public class MakeTimeTable extends Base {
    public static String[][] makeBigTable(List<HashMap<String, Object>> lis, int student) {
        String temp[][] = new String[11][7];
        for (HashMap<String, Object> li : lis) {
            String date = (String) li.get("classDateDescription");
            String classPlace = (String) li.get("classPlace");
            String mainLecturer = (String) li.get("mainLecturer");
            String teacherName = (String) li.get("teaName");
            int schoolDistrictId = (int) li.get("schoolDistrictId");

            String startWeek = Integer.toString((Integer) li.get("startWeek"));
            String endWeek = Integer.toString((Integer) li.get("endWeek"));
            String classNum = Integer.toString((Integer) li.get("classNum"));
            String className = (String) li.get("className");


            String[] dates = date.split(",");
            for (String adate:dates){
                String[] ints = adate.split(":");

                Integer t = Integer.parseInt(ints[0]);//星期几
                Integer l = Integer.parseInt(ints[1]);//第几节开始
                if(l>=7){l=l-2;}
                Integer z = Integer.parseInt(ints[2]);//上几节课

                int r = t;
                String context =encode1(className,  classPlace,  teacherName, mainLecturer, startWeek,  endWeek,  classNum, student, schoolDistrictId);
                for (int i = 0; i< z; i++){
                    temp[l - 1 + i][r - 1] = temp[l - 1 + i][r - 1] != null ? temp[l - 1 + i][r - 1] + ','+ context : context;
                }
            }
        }
        return temp;
    }



    public static  String encode1(String className, String classPlace, String teacherName,String mainLecturer, String startWeek, String endWeek, String classNum,int student, int schoolDistrictId) {
        String schoolDistrictName = "兴庆校区";
        if (schoolDistrictId == 2) schoolDistrictName = "雁塔校区";
        else if (schoolDistrictId == 3) schoolDistrictName = "曲江校区";
        else if (schoolDistrictId == 4) schoolDistrictName = "苏州校区";
        else if (schoolDistrictId == 5) schoolDistrictName = "创新港校区";
        return "★课程：" + className + ',' + "教室：" + schoolDistrictName + ":" + classPlace + ',' + "授课教师：" + teacherName + ','+ (student==1?"":("主讲教师：" + mainLecturer + ',')) + "周次：" + startWeek + "-" + endWeek + ',' + "班次：" + classNum;
    }


    public static String[][] makeTable(List<Map<String, Object>> lis) {
        String temp[][] = new String[13][7];
//        String temp[][] = new String[24][7];
//        System.out.println("=============================lis========================");
//        System.out.println(lis);
//        System.out.println("=============================lis========================");
        if (!lis.isEmpty()) {
            for (Map<String, Object> li : lis) {
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
                //r表示周几，l表示第几节课
                Integer r = ints[0].toCharArray()[0] - '0';
                Integer l = ints[1].toCharArray()[0] - '0';

                String context = "★课程：" + className + ',' + "教室：" + classPlace + ',' + "教师：" + teaName + ',' + "周次：" + startWeek + "-" + endWeek + ',' + "班次：" + classNum;
                temp[(l - 1) * 2][r - 1] = context;
                temp[(l - 1) * 2 + 1][r - 1] = context;
            }
        }
//        System.out.println(temp);
//        for(int i = 0 ;i< 24; i++){
//            for (int j = 0; j<7; j++){
//                System.out.print(temp[i][j] + "\t");
//            }
//            System.out.println();
//        }
        return temp;
    }

    public static void main(String[] args) {
        List<HashMap<String, Object>> ls = new ArrayList<>();
        HashMap<String, Object> m = new HashMap<>();
        m.put("startWeek", 4);
        m.put("teaName", "Amy");
        m.put("stuId", "03118105316");
        m.put("classPlace", "外文楼A502");
        m.put("className", "英语实用口语实践");
        m.put("classNum", 9);
        m.put("endWeek", 12);
        m.put("classDateDescription", "2:11:2");
        ls.add(m);
//        ls.add()
//                [{startWeek=4, teaName=Amy, stuId=3118105316, classPlace=外文楼A502,
//                className=英语实用口语实践, classNum=9, endWeek=11, classDateDescription=2:5}]
        String[][] res = makeBigTable(ls,1);
        System.out.println(res);
    }
}
