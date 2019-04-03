package com.spc.model;

import java.util.Date;

/**
 * @author Milingyun
 * @date 2019-03-12 14:10
 */
public class Oral {
    private int id;
    private String teaId;
    private String teaName;
    private String time;
    private String place;
    private int stuLimit;
    private int curChoose;
    private int flag;
    private String yearSemester;
    private String operatorId;
    private String operatorName;
    private String examRoom;

    public Oral( String teaId, String teaName, String time, String place, int stuLimit, int curChoose,
                int flag, String yearSemester, String operatorId, String operatorName, String examRoom) {

        this.teaId = teaId;
        this.teaName = teaName;
        this.time = time;
        this.place = place;
        this.stuLimit = stuLimit;
        this.curChoose = curChoose;
        this.flag = flag;
        this.yearSemester = yearSemester;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.examRoom = examRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getYearSemester() { return yearSemester; }

    public void setYearSemester(String yearSemester) { this.yearSemester = yearSemester; }

    public String getOperatorName() {  return operatorName; }

    public void setOperatorName(String operatorName) { this.operatorName = operatorName; }

    public int getStuLimit() { return stuLimit; }

    public void setStuLimit(int stuLimit) { this.stuLimit = stuLimit; }

    public int getCurChoose() { return curChoose; }

    public void setCurChoose(int curChoose) { this.curChoose = curChoose; }

    public String getExamRoom() { return examRoom; }

    public void setExamRoom(String examRoom) { this.examRoom = examRoom; }
}
