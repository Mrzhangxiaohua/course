package com.spc.model;

import java.util.Date;

public class ClassAll {
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

    private Integer schoolDistrictId;

    private String className;

    private String instructorId;

    private String instructorName;

    private Integer startWeek;

    private Integer endWeek;

    private String classDateDesc;

    private String classPlaceId;

    private String classPlaceName;

    private String conflictDesc;

    private Integer scheduled;

    private String operatorId;

    private String operatorName;

    private Date operateDate;

    private Integer stuChooseNum;

    private boolean force;

    public ClassAll() {
    }

    public ClassAll(Integer id, Integer departId, String courseId, String courseNameCHS, String courseNameEN, String moduleId, String academicYear, String classSemester, Integer classHour, Integer stuNumUpperLimit, String teacherId, String teacherName, String teachingTeamIds, String teachingTeamNames, Integer schoolDistrictId, String className, String instructorId, String instructorName, Integer startWeek, Integer endWeek, String classDateDesc, String classPlaceId, String classPlaceName, String conflictDesc, Integer scheduled, String operatorId, String operatorName) {
        this.id = id;
        this.departId = departId;
        this.courseId = courseId;
        this.courseNameCHS = courseNameCHS;
        this.courseNameEN = courseNameEN;
        this.moduleId = moduleId;
        this.academicYear = academicYear;
        this.classSemester = classSemester;
        this.classHour = classHour;
        this.stuNumUpperLimit = stuNumUpperLimit;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teachingTeamIds = teachingTeamIds;
        this.teachingTeamNames = teachingTeamNames;
        this.schoolDistrictId = schoolDistrictId;
        this.className = className;
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.classDateDesc = classDateDesc;
        this.classPlaceId = classPlaceId;
        this.classPlaceName = classPlaceName;
        this.conflictDesc = conflictDesc;
        this.scheduled = scheduled;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
    }

    public ClassAll(Integer id, Integer departId, String courseId, String courseNameCHS, String courseNameEN, String moduleId, String academicYear, String classSemester, Integer classHour, Integer stuNumUpperLimit, String teacherId, String teacherName, String teachingTeamIds, String teachingTeamNames, Integer schoolDistrictId, String className, String instructorId, String instructorName, Integer startWeek, Integer endWeek, String classDateDesc, String classPlaceId, String classPlaceName, String conflictDesc, Integer scheduled, String operatorId, String operatorName, Date operateDate) {
        this.id = id;
        this.departId = departId;
        this.courseId = courseId;
        this.courseNameCHS = courseNameCHS;
        this.courseNameEN = courseNameEN;
        this.moduleId = moduleId;
        this.academicYear = academicYear;
        this.classSemester = classSemester;
        this.classHour = classHour;
        this.stuNumUpperLimit = stuNumUpperLimit;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teachingTeamIds = teachingTeamIds;
        this.teachingTeamNames = teachingTeamNames;
        this.schoolDistrictId = schoolDistrictId;
        this.className = className;
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.classDateDesc = classDateDesc;
        this.classPlaceId = classPlaceId;
        this.classPlaceName = classPlaceName;
        this.conflictDesc = conflictDesc;
        this.scheduled = scheduled;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.operateDate = operateDate;
    }

    public Integer getScheduled() {
        return scheduled;
    }

    public void setScheduled(Integer scheduled) {
        this.scheduled = scheduled;
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

    public Integer getSchoolDistrictId() {
        return schoolDistrictId;
    }

    public void setSchoolDistrictId(Integer schoolDistrictId) {
        this.schoolDistrictId = schoolDistrictId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId == null ? null : instructorId.trim();
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName == null ? null : instructorName.trim();
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

    public String getClassDateDesc() {
        return classDateDesc;
    }

    public void setClassDateDesc(String classDateDesc) {
        this.classDateDesc = classDateDesc == null ? null : classDateDesc.trim();
    }

    public String getClassPlaceId() {
        return classPlaceId;
    }

    public void setClassPlaceId(String classPlaceId) {
        this.classPlaceId = classPlaceId == null ? null : classPlaceId.trim();
    }

    public String getClassPlaceName() {
        return classPlaceName;
    }

    public void setClassPlaceName(String classPlaceName) {
        this.classPlaceName = classPlaceName == null ? null : classPlaceName.trim();
    }

    public String getConflictDesc() {
        return conflictDesc;
    }

    public void setConflictDesc(String conflictDesc) {
        this.conflictDesc = conflictDesc == null ? null : conflictDesc.trim();
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

    public boolean getForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    @Override
    public String toString() {
        return "ClassAll{" +
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
                ", schoolDistrictId=" + schoolDistrictId +
                ", className='" + className + '\'' +
                ", instructorId='" + instructorId + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", startWeek=" + startWeek +
                ", endWeek=" + endWeek +
                ", classDateDesc='" + classDateDesc + '\'' +
                ", classPlaceId='" + classPlaceId + '\'' +
                ", classPlaceName='" + classPlaceName + '\'' +
                ", conflictDesc='" + conflictDesc + '\'' +
                ", scheduled=" + scheduled +
                ", operatorId='" + operatorId + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", operateDate=" + operateDate +
                ", force=" + force +
                '}';
    }

    public Integer getStuChooseNum() {
        return stuChooseNum;
    }

    public void setStuChooseNum(Integer stuChooseNum) {
        this.stuChooseNum = stuChooseNum;
    }
}