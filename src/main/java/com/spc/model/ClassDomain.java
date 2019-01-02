package com.spc.model;


import com.spc.util.CourseDateTrans;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("ClassDomain")
public class ClassDomain implements Serializable {

    private String teacherInfo;
    private String courseInfo;
    private Integer classId; //课程编号
    private String className;
    private Integer classNum; //课程的班次
    private String teaId; //老师的工号
    private String teaName;
    private Integer classChooseNum;
    private Integer classUpperLimit;
    private String classDateDescription;
    private String classDateDescriptionA;
    private String classDateDescriptionB;
    private String classPlace;
    private Integer classLength;
    private String modelsName;
    private Integer departId;
    private Integer classModuleNum;
    private String classSemester;
    private Integer classGradePoint;
    private Integer startWeek;
    private Integer endWeek;
    private Integer classTime;
    private boolean notShowAddButton;
    private boolean showDeleteButton;
    private String buttonGroup;
    private String mainLecturer;
    private String classEncode;
    private String shenQingRenId;
    private String classStr;
    private String departName;
    private Integer schoolDistrictId;
    private Integer classAllId;

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

    public String getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(String buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    public String getMainLecturer() {
        return mainLecturer;
    }

    public void setMainLecturer(String mainLecturer) {
        this.mainLecturer = mainLecturer;
    }

    public String getClassDateDescriptionA() {
        return classDateDescriptionA;
    }

    public void setClassDateDescriptionA(String classDateDescriptionA) {
        this.classDateDescriptionA = classDateDescriptionA;
    }

    public String getClassDateDescriptionB() {
        return classDateDescriptionB;
    }

    public void setClassDateDescriptionB(String classDateDescriptionB) {
        this.classDateDescriptionB = classDateDescriptionB;
    }

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    public String getClassEncode() {
        return classEncode;
    }

    public void setClassEncode(String classEncode) {
        this.classEncode = classEncode;
    }

    public String getClassSemester() {
        return classSemester;
    }

    public void setClassSemester(String classSemester) {
        this.classSemester = classSemester;
    }

    public String getShenQingRenId() {
        return shenQingRenId;
    }

    public void setShenQingRenId(String shenQingRenId) {
        this.shenQingRenId = shenQingRenId;
    }

    public String getClassStr() {
        return classStr;
    }

    public void setClassStr(String classStr) {
        this.classStr = classStr;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public Integer getSchoolDistrictId() {
        return schoolDistrictId;
    }

    public void setSchoolDistrictId(Integer schoolDistrictId) {
        this.schoolDistrictId = schoolDistrictId;
    }

    public Integer getClassAllId() {
        return classAllId;
    }

    public void setClassAllId(Integer classAllId) {
        this.classAllId = classAllId;
    }
}
