package com.spc.model;

import java.io.Serializable;

public class GradeDomain  implements Serializable {
    private Integer chooseId;
    private String stuId;
    private String className;
    private Integer classId;
    private Float wlzzxxGrade;
    private Float knskGrade;
    private Float xbsjGrade;
    // 预留两个model模块和百分比使用
    private Float kthdGrade;
    private Float qmcsGrade;
    private String percent;
    private String gradeAll;

    private Float zzGrade;
    private String classSemester;
    private Integer classGradePoint;
    private Integer flag;


    public Float getWlzzxxGrade() {
        return wlzzxxGrade;
    }

    public void setWlzzxxGrade(Float wlzzxxGrade) {
        this.wlzzxxGrade = wlzzxxGrade;
    }

    public Float getKnskGrade() {
        return knskGrade;
    }

    public void setKnskGrade(Float knskGrade) {
        this.knskGrade = knskGrade;
    }

    public Float getXbsjGrade() {
        return xbsjGrade;
    }

    public void setXbsjGrade(Float xbsjGrade) {
        this.xbsjGrade = xbsjGrade;
    }

    public Float getZzGrade() {
        return zzGrade;
    }

    public void setZzGrade(Float zzGrade) {
        this.zzGrade = zzGrade;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }


    public Integer getChooseId() {
        return chooseId;
    }

    public void setChooseId(Integer chooseId) {
        this.chooseId = chooseId;
    }

    public String getClassSemester() {
        return classSemester;
    }

    public void setClassSemester(String classSemester) {
        this.classSemester = classSemester;
    }

    public Integer getClassGradePoint() {
        return classGradePoint;
    }

    public void setClassGradePoint(Integer classGradePoint) {
        this.classGradePoint = classGradePoint;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getGradeAll() {
        return gradeAll;
    }

    public void setGradeAll(String gradeAll) {
        this.gradeAll = gradeAll;
    }

    public Float getKthdGrade() {
        return kthdGrade;
    }

    public void setKthdGrade(Float kthdGrade) {
        this.kthdGrade = kthdGrade;
    }

    public Float getQmcsGrade() {
        return qmcsGrade;
    }

    public void setQmcsGrade(Float qmcsGrade) {
        this.qmcsGrade = qmcsGrade;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}

