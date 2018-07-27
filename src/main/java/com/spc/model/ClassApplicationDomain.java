package com.spc.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ClassApplicationDomain {

    private int id;
    private int teaId;
    private int checked;
    private String checkStr;
    private int classTime;
    private String mydate;
    private String teaName;
    private String mainLecturer;
    private String className;
    private String teacherInfo;
    private String courseInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }



    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public int getClassTime() {
        return classTime;
    }

    public void setClassTime(int classTime) {
        this.classTime = classTime;
    }

    public String getMydate() {
        return mydate;
    }

    public void setMydate(java.sql.Timestamp mydate) {
        String s = new SimpleDateFormat("yyyy-MM-dd").format(mydate);
        this.mydate = s;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getMainLecturer() {
        return mainLecturer;
    }

    public void setMainLecturer(String mainLecturer) {
        this.mainLecturer = mainLecturer;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(String teacherInfo) {
        this.teacherInfo = teacherInfo;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }
}
