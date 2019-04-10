package com.spc.model;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class CourseTableExcelDomain {

    @Excel(name = "节次", orderNum = "0")
    private int jieci;
    @Excel(name = "星期一", orderNum = "1")
    private String mon;
    @Excel(name = "星期二", orderNum = "2")
    private String tue;
    @Excel(name = "星期三", orderNum = "3")
    private String wed;
    @Excel(name = "星期四", orderNum = "4")
    private String thu;
    @Excel(name = "星期五", orderNum = "5")
    private String fri;
    @Excel(name = "星期六", orderNum = "6")
    private String sat;
    @Excel(name = "星期天", orderNum = "7")
    private String sun;

    public CourseTableExcelDomain() {
    }

    public CourseTableExcelDomain(int jieci, String mon, String tue, String wed, String thu, String fri, String sat, String sun) {
        this.jieci = jieci;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
    }


    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getTue() {
        return tue;
    }

    public void setTue(String tue) {
        this.tue = tue;
    }

    public String getWed() {
        return wed;
    }

    public void setWed(String wed) {
        this.wed = wed;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getFri() {
        return fri;
    }

    public void setFri(String fri) {
        this.fri = fri;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public String getJieci() {
        StringBuilder res = new StringBuilder();
        switch (jieci) {
            case 0:
                res.append("一节");
                break;
            case 1:
                res.append("二节");
                break;
            case 2:
                res.append("三节");
                break;
            case 3:
                res.append("四节");
                break;
//            case 4:
//                res.append("N1节");
//                break;
//            case 5:
//                res.append("N2节");
//                break;
            case 4:
                res.append("五节");
                break;
            case 5:
                res.append("六节");
                break;
            case 6:
                res.append("七节");
                break;
            case 7:
                res.append("八节");
                break;
            case 8:
                res.append("九节");
                break;
            case 9:
                res.append("十节");
                break;
            case 10:
                res.append("十一节");
                break;
            default:
                // do nothing
        }
        return res.toString();
    }

    public void setJieci(int jieci) {
        this.jieci = jieci;
    }
}
