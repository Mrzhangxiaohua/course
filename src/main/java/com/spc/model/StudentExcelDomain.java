package com.spc.model;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class StudentExcelDomain {
    @Excel(name = "姓名", orderNum = "0")
    private String name;
    @Excel(name = "学号", orderNum = "1")
    private String userno;
    @Excel(name = "所属学院", orderNum = "2")
    private String departname;
    @Excel(name = "所属专业", orderNum = "3")
    private String speclity;
    @Excel(name = "导师", orderNum = "4")
    private String tea;
    @Excel(name = "网络自主学习", orderNum = "5")
    private String wlzz;
    @Excel(name = "课内授课", orderNum = "6")
    private String knsk;
    @Excel(name = "小班实践", orderNum = "7")
    private String xbsj;

    public StudentExcelDomain(Object stuName, Object stuId, Object departName, Object speciality, Object tutoremployeeid, Object wlzzxxGrade, Object knskGrade, Object xbsjGrade){

    };

    public StudentExcelDomain(String name, String userno, String departname, String speclity, String tea, String wlzz, String knsk, String xbsj) {
        this.name = name;
        this.userno = userno;
        this.departname = departname;
        this.speclity = speclity;
        this.tea = tea;
        this.wlzz = wlzz;
        this.knsk = knsk;
        this.xbsj = xbsj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    public String getSpeclity() {
        return speclity;
    }

    public void setSpeclity(String speclity) {
        this.speclity = speclity;
    }

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public String getWlzz() {
        return wlzz;
    }

    public void setWlzz(String wlzz) {
        this.wlzz = wlzz;
    }

    public String getKnsk() {
        return knsk;
    }

    public void setKnsk(String knsk) {
        this.knsk = knsk;
    }

    public String getXbsj() {
        return xbsj;
    }

    public void setXbsj(String xbsj) {
        this.xbsj = xbsj;
    }
}
