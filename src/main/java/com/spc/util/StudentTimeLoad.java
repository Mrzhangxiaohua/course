package com.spc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//用来判断一个人的课程时间是否存在冲突
public class StudentTimeLoad {

    private static String CHUSHISHIJIAN = "2018-09-02 00:00:00";//每一个学期的第一周的星期一



    public  static List<long[]> StudentTimeLoad( List<Map>  maps) {
        List<long[]> lis = new ArrayList<>();
        if(!maps.isEmpty()){
            for(Map map:maps){
                lis.addAll(TimeLoad(map));
            }
        }
        return lis;
    }
    public static List<long[]> TimeLoad( Map  map) {
        int sW = (int) map.get("startWeek");
        int eW = (int) map.get("endWeek");
        String description = (String) map.get("classDateDescription");

        String[] des = description.split(":");
        //取索引用来制作所选课程的信息表
        int firstIndex = Integer.parseInt(des[0]);
        int secondIndex = Integer.parseInt(des[1]);
        int thirdIndex = Integer.parseInt(des[2]); //课程时长

        List<long[]> lis = new ArrayList<>();//用来存储课程信息

        if (firstIndex != 0) {
            int xingqiji = firstIndex;
            int begin = switchSecondTime(secondIndex);//转换课程的时间为几点开始
            int chixu = thirdIndex;                            //课程持续时间几节课
            lis.addAll(toHours(sW, eW, xingqiji, begin, chixu));//将选择的课程放入lis中
        } else {/////////////////////////////////
            for (int i = 1; i <= 5; i++) {
                int xingqiji = i;
                int begin = switchSecondTime(secondIndex);
                int chixu = 2;
                lis.addAll(toHours(sW, eW, xingqiji, begin, chixu));
            }
        }
        return lis;
    }

    private  static int switchSecondTime(int secondIndex) {
        int res = 0;        //res表示开课时间是几点
        switch (secondIndex) {
//            case 1:
//                res = 8;
//                break;
//            case 2:
//                res = 10;
//                break;
//            case 3:
//                res = 12;
//                break;
//            case 4:
//                res = 14;
//                break;
//            case 5:
//                res = 16;
//                break;
//            case 6:
//                res = 19;
//                break;
            case 1:
                res = 8;
                break;
            case 2:
                res = 9;
                break;
            case 3:
                res = 10;
                break;
            case 4:
                res = 11;
                break;
            case 5:
                res = 12;
                break;
            case 6:
                res = 13;
                break;
            case 7:
                res = 14;
                break;
            case 8:
                res = 15;
                break;
            case 9:
                res = 16;
                break;
            case 10:
                res = 17;
                break;
            case 11:
                res = 18;
                break;
            case 12:
                res = 19;
                break;
            case 13:
                res = 20;
                break;
            default:
                break;
        }
        return res;
    }

    private static List<long[]> toHours(int sW, int eW, int xingqiji, int begin, int chixu) {
        List<long[]> res = new ArrayList<>();
        for (int i = sW; i <= eW; i++) {
            res.add(zhouCiToHours(i, xingqiji, begin, chixu));
        }
        return res;
    }

    //将（第几周，周几，开始时间，结束时间）时间格式转化为[hours,hours]
    private  static long[] zhouCiToHours(int weekNo, int xingqiji, int begin, int chixu) {
        int resDay = (weekNo - 1) * 7 + xingqiji - 1;   //为形成时间格式yyyy-MM-dd HH:mm:ss做准备

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long[] res = new long[2];
        try {
            Date date = df.parse(CHUSHISHIJIAN);//拿到初始选课时间
            Calendar cal = Calendar.getInstance();//用来获取当前时间或者指定时间
            cal.setTime(date);                    //拿到系统初始时间
            cal.add(Calendar.DATE, resDay);       //对初始时间DATE加上resDay
            cal.add(Calendar.HOUR, begin);
            long b = cal.getTime().getTime() / (1000 * 3600);
            res[0] = b;
            cal.add(Calendar.HOUR, chixu);
            long e = cal.getTime().getTime() / (1000 * 3600);
            res[1] = e;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return res;
    }

    //将这种格式的时间"2018-09-02 00:00:00"转化为hours
    private long changeTimeToHours(String timeString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(timeString);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("run here");
        }
        long hours = date.getTime() / (1000 * 3600);
        return hours;
    }

    private long changeStartTimeToHours() {
        long hours = changeTimeToHours(CHUSHISHIJIAN);
        return hours;
    }


    public static void main(String[] args) {
//        String CHUSHISHIJIAN = "2018-09-02 00:00:00";//每一个学期的第一周的星期一
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = df.parse(CHUSHISHIJIAN);//拿到初始选课时间
//            System.out.println(date);
            Date beg = df.parse("2018-11-20 00:00:00");
            Date end = df.parse("2018-11-19 23:59:59");
            Date now = df.parse(df.format(new Date()));
            System.out.println(beg);
            System.out.println(end);
            System.out.println(now);
            Calendar dat = Calendar.getInstance();
            dat.setTime(now);
//            dat2.add(Calendar.DATE, 6);
//            System.out.println(df.format(dat2.getTime()));
            for (int i = 1; i <= 3; i++){
                Calendar dat1 = Calendar.getInstance();
                Calendar dat2 = Calendar.getInstance();
                dat1.setTime(beg);
                dat2.setTime(end);

                dat1.add(Calendar.DATE, 7 * (i-1));
                dat2.add(Calendar.DATE, 7 * i);

                if(dat.after(dat1) && dat.before(dat2)){
                    System.out.println(df.format(dat.getTime()) + "---------"+ "\n" + df.format(dat1.getTime()) + "---------"+ "\n"+ df.format(dat2.getTime()) +  "\n");
                    System.out.println(i);
                }else {
                    System.out.println(df.format(dat.getTime()) + "---------"+ "\n" + df.format(dat1.getTime()) + "---------"+ "\n"+ df.format(dat2.getTime()) +  "\n");
                    System.out.println("第" + i + "次不在评价周内");
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
