package com.spc.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class ClassApplicationDomain  implements Serializable {

    private int id;
    private String teaId;
    private int checked;
    private String checkStr;
    private int classTime;
    private String mydate;
    private String teaName;
    private String mainLecturer;
    private String className;
    private String teacherInfo;
    private String courseInfo;
    private String shenQingRenId;
    private String shenQingRenName;
    private int classModuleNum;
    private String modelsName;
    private String homepage;
    private int fileInfoId;

    public int getFileInfoId() {
        return fileInfoId;
    }

    public void setFileInfoId(int fileInfoId) {
        this.fileInfoId = fileInfoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCheckStr() {
        return checkStr;
    }

    public void setCheckStr(String checkStr) {
        this.checkStr = checkStr;
    }


    public String getShenQingRenName() {
        return shenQingRenName;
    }

    public void setShenQingRenName(String shenQingRenName) {
        this.shenQingRenName = shenQingRenName;
    }

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    public String getShenQingRenId() {
        return shenQingRenId;
    }

    public void setShenQingRenId(String shenQingRenId) {
        this.shenQingRenId = shenQingRenId;
    }

    public int getClassModuleNum() {
        return classModuleNum;
    }

    public void setClassModuleNum(int classModuleNum) {
        this.classModuleNum = classModuleNum;
    }

    public String getModelsName() {
        return modelsName;
    }

    public void setModelsName(String modelsName) {
        this.modelsName = modelsName;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
}
