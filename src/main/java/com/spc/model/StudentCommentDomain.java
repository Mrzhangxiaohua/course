package com.spc.model;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("StudentCommentDomain")
public class StudentCommentDomain implements Serializable {
    private String stuId; //学生的Id
    private Integer classId; //课程的Id
    private String className;
    private Integer classNum;
    private String teaId;
    private String teaName;
    private String stuEvaluate; //学生细则评分
    private String stuSuggestion; //学生评价

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
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

    public String getStuEvaluate() {
        return stuEvaluate;
    }

    public void setStuEvaluate(String stuEvaluate) {
        this.stuEvaluate = stuEvaluate;
    }

    public String getStuSuggestion() {
        return stuSuggestion;
    }

    public void setStuSuggestion(String stuSuggestion) {
        this.stuSuggestion = stuSuggestion;
    }


}
