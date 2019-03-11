package com.spc.model;

import java.util.Date;

/**
 *
 * @author Milingyun
 * @date 2019-01-21 17:21
 */
public class CourseApplication {
    private int id;
    private int departId;
    private String departName;
    private String courseId;
    private String courseNameCHS;
    private String courseNameEN;
    private int moduleId;
    private String academicYear;
    private String classSemester;
    private int classHour;
    private int stuNumUpperLimit;
    private String teacherId;
    private String teacherName;
    private String teachingTeamIds;
    private String teachingTeamNames;
    private String courseInfo;
    private String teacherInfo;
    private int fileInfoId;
    private String operatorId;
    private String operatorName;
    private Date operateDate;
    private int isChecked;
    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

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

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseNameCHS() {
        return courseNameCHS;
    }

    public void setCourseNameCHS(String courseNameCHS) {
        this.courseNameCHS = courseNameCHS;
    }

    public String getCourseNameEN() {
        return courseNameEN;
    }

    public void setCourseNameEN(String courseNameEN) {
        this.courseNameEN = courseNameEN;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getClassSemester() {
        return classSemester;
    }

    public void setClassSemester(String classSemester) {
        this.classSemester = classSemester;
    }

    public int getClassHour() {
        return classHour;
    }

    public void setClassHour(int classHour) {
        this.classHour = classHour;
    }

    public int getStuNumUpperLimit() {
        return stuNumUpperLimit;
    }

    public void setStuNumUpperLimit(int stuNumUpperLimit) {
        this.stuNumUpperLimit = stuNumUpperLimit;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeachingTeamIds() {
        return teachingTeamIds;
    }

    public void setTeachingTeamIds(String teachingTeamIds) {
        this.teachingTeamIds = teachingTeamIds;
    }

    public String getTeachingTeamNames() {
        return teachingTeamNames;
    }

    public void setTeachingTeamNames(String teachingTeamNames) {
        this.teachingTeamNames = teachingTeamNames;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    public String getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(String teacherInfo) {
        this.teacherInfo = teacherInfo;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }
}
