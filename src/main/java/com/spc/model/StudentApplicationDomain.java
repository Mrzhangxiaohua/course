package com.spc.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentApplicationDomain {

    private int id;
    private int stuId;
    private int classId;
    private int states;
    private String reason;
    private String mydate;
    private int checked;
    private String checkStr;
    private String category;
    private String stuName;
    private String className;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getStates() {
        return states;
    }

    public void setStates(int states) {
        this.states = states;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMydate() {
        return mydate;
    }

    public void setMydate(java.sql.Timestamp mydate) {
        String s = new SimpleDateFormat("yyyy-MM-dd").format(mydate);
        this.mydate = s;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public String getCheckStr() {
        return checkStr;
    }

    public void setCheckStr(String checkStr) {
        this.checkStr = checkStr;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
