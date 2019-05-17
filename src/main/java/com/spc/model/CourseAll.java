package com.spc.model;

import java.util.Date;

public class CourseAll {
    private Integer id;

    private Integer departId;

    private String courseId;

    private String courseNameCHS;

    private String courseNameEN;

    private String moduleId;

    private String academicYear;

    private String classSemester;

    private Integer classHour;

    private Integer stuNumUpperLimit;

    private String teacherId;

    private String teacherName;

    private String teachingTeamIds;

    private String teachingTeamNames;

    private String courseInfo;

    private String teacherInfo;

    private String operatorId;

    private String operatorName;

    private Date operateDate;

    private int flag;

    private Integer courseAppId;

    public Integer getCourseAppId() {
        return courseAppId;
    }

    public void setCourseAppId(Integer courseAppId) {
        this.courseAppId = courseAppId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getCourseNameCHS() {
        return courseNameCHS;
    }

    public void setCourseNameCHS(String courseNameCHS) {
        this.courseNameCHS = courseNameCHS == null ? null : courseNameCHS.trim();
    }

    public String getCourseNameEN() {
        return courseNameEN;
    }

    public void setCourseNameEN(String courseNameEN) {
        this.courseNameEN = courseNameEN == null ? null : courseNameEN.trim();
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear == null ? null : academicYear.trim();
    }

    public String getClassSemester() {
        return classSemester;
    }

    public void setClassSemester(String classSemester) {
        this.classSemester = classSemester == null ? null : classSemester.trim();
    }

    public Integer getClassHour() {
        return classHour;
    }

    public void setClassHour(Integer classHour) {
        this.classHour = classHour;
    }

    public Integer getStuNumUpperLimit() {
        return stuNumUpperLimit;
    }

    public void setStuNumUpperLimit(Integer stuNumUpperLimit) {
        this.stuNumUpperLimit = stuNumUpperLimit;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeachingTeamIds() {
        return teachingTeamIds;
    }

    public void setTeachingTeamIds(String teachingTeamIds) {
        this.teachingTeamIds = teachingTeamIds == null ? null : teachingTeamIds.trim();
    }

    public String getTeachingTeamNames() {
        return teachingTeamNames;
    }

    public void setTeachingTeamNames(String teachingTeamNames) {
        this.teachingTeamNames = teachingTeamNames == null ? null : teachingTeamNames.trim();
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo == null ? null : courseInfo.trim();
    }

    public String getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(String teacherInfo) {
        this.teacherInfo = teacherInfo == null ? null : teacherInfo.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    @Override
    public String toString() {
        return "CourseAll{" +
                "id=" + id +
                ", departId=" + departId +
                ", courseId='" + courseId + '\'' +
                ", courseNameCHS='" + courseNameCHS + '\'' +
                ", courseNameEN='" + courseNameEN + '\'' +
                ", moduleId='" + moduleId + '\'' +
                ", academicYear='" + academicYear + '\'' +
                ", classSemester='" + classSemester + '\'' +
                ", classHour=" + classHour +
                ", stuNumUpperLimit=" + stuNumUpperLimit +
                ", teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teachingTeamIds='" + teachingTeamIds + '\'' +
                ", teachingTeamNames='" + teachingTeamNames + '\'' +
                ", courseInfo='" + courseInfo + '\'' +
                ", teacherInfo='" + teacherInfo + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", operateDate=" + operateDate +
                '}';
    }
}