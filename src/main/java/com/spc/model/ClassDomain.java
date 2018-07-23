package com.spc.model;


import org.apache.ibatis.type.Alias;

@Alias("ClassDomain")
public class ClassDomain {

    private String teacherInfo;
    private String courseInfo;
    private Integer classId; //课程编号
    private String className;
    private Integer classNum; //课程的班次
    private Integer teaId; //老师的工号
    private String teaName;
    private Integer classChooseNum;
    private Integer classUpperLimit;
    private String classDateDescription;
    private String classPlace;
    private Integer classLength;
    private String modelsName;
    private Integer departId;
    private Integer classModuleNum;
    private Integer classSemester;
    private Integer classGradePoint;
    private Integer startWeek;
    private Integer endWeek;
    private Integer classTime;
    private boolean notShowAddButton;
    private boolean showDeleteButton;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public Integer getClassChooseNum() {
        return classChooseNum;
    }

    public void setClassChooseNum(Integer classChooseNum) {
        this.classChooseNum = classChooseNum;
    }

    public Integer getClassUpperLimit() {
        return classUpperLimit;
    }

    public void setClassUpperLimit(Integer classUpperLimit) {
        this.classUpperLimit = classUpperLimit;
    }

    public String getClassDateDescription() {

        return classDateDescription;
    }

    public void setClassDateDescription(String classDateDescription) {
        this.classDateDescription = classDateDescription;
    }

    public String getClassPlace() {
        return classPlace;
    }

    public void setClassPlace(String classPlace) {
        this.classPlace = classPlace;
    }

    public Integer getClassLength() {
        return classLength;
    }

    public void setClassLength(Integer classLength) {
        this.classLength = classLength;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public Integer getClassModuleNum() {
        return classModuleNum;
    }

    public void setClassModuleNum(Integer classModuleNum) {
        this.classModuleNum = classModuleNum;
    }

    public Integer getClassSemester() {
        return classSemester;
    }

    public void setClassSemester(Integer classSemester) {
        this.classSemester = classSemester;
    }

    public String getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(String teacherInfo) {
        this.teacherInfo = teacherInfo;
    }

    public String getModelsName() {
        return modelsName;
    }

    public void setModelsName(String modelsName) {
        this.modelsName = modelsName;
    }

    public Integer getClassGradePoint() {
        return classGradePoint;
    }

    public void setClassGradePoint(Integer classGradePoint) {
        this.classGradePoint = classGradePoint;
    }

    public Integer getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(Integer startWeek) {
        this.startWeek = startWeek;
    }

    public Integer getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(Integer endWeek) {
        this.endWeek = endWeek;
    }

    public Integer getClassTime() {
        return classTime;
    }

    public void setClassTime(Integer classTime) {
        this.classTime = classTime;
    }

    public boolean isNotShowAddButton() {
        return notShowAddButton;
    }

    public void setNotShowAddButton(boolean notShowAddButton) {
        this.notShowAddButton = notShowAddButton;
    }

    public boolean isShowDeleteButton() {
        return showDeleteButton;
    }

    public void setShowDeleteButton(boolean showDeleteButton) {
        this.showDeleteButton = showDeleteButton;
    }
}
