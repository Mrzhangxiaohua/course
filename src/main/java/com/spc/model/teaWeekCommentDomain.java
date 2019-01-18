package com.spc.model;

import org.joda.time.DateTime;

import java.util.Date;

public class teaWeekCommentDomain {
    private int teaWeekCommentId;
    private String stuId;
    private String teaId;
    private String classId;
    private String listen;
    private String speak;
    private String read;
    private String write;
    private String week;
    private Date dateTime;


    public int getTeaWeekCommentId() {
        return teaWeekCommentId;
    }

    public void setTeaWeekCommentId(int teaWeekCommentId) {
        this.teaWeekCommentId = teaWeekCommentId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getListen() {
        return listen;
    }

    public void setListen(String listen) {
        this.listen = listen;
    }

    public String getSpeak() {
        return speak;
    }

    public void setSpeak(String speak) {
        this.speak = speak;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getWrite() {
        return write;
    }

    public void setWrite(String write) {
        this.write = write;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
