package com.spc.model;

public class GradeDomain {
    private Integer chooseId;
    private Integer stuId;
    private String className;
    private Integer classId;
    private Integer score;
    private String classSemester;
    private Integer classGradePoint;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
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


    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
}

