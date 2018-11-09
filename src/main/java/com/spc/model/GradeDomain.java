package com.spc.model;

import java.io.Serializable;

public class GradeDomain  implements Serializable {
    private Integer chooseId;
    private String stuId;
    private String className;
    private Integer classId;
    private Integer wlzzxxGrade;
    private Integer knskGrade;
    private Integer xbsjGrade;
    private Integer zzGrade;
    private String classSemester;
    private Integer classGradePoint;

    public Integer getWlzzxxGrade() {
        return wlzzxxGrade;
    }

    public void setWlzzxxGrade(Integer wlzzxxGrade) {
        this.wlzzxxGrade = wlzzxxGrade;
    }

    public Integer getKnskGrade() {
        return knskGrade;
    }

    public void setKnskGrade(Integer knskGrade) {
        this.knskGrade = knskGrade;
    }

    public Integer getXbsjGrade() {
        return xbsjGrade;
    }

    public void setXbsjGrade(Integer xbsjGrade) {
        this.xbsjGrade = xbsjGrade;
    }

    public Integer getZzGrade() {
        return zzGrade;
    }

    public void setZzGrade(Integer zzGrade) {
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


//    public Integer getScore() {
//        return score;
//    }
//
//    public void setScore(Integer score) {
//        this.score = score;
//    }

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
}

