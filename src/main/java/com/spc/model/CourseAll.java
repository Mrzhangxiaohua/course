package com.spc.model;

/**
 * 选课
 *
 * @author yzk
 */
public class CourseAll {
    // 主键，自增
    private Integer id;
    // 学院ID
    private Integer departId;
    // 所属模块ID
    private Integer modelId;
    // 课程ID
    private Integer courseId;
    // 课程名称（中文）
    private String courseNameCHS;
    // 课程名称（英文）
    private String courseNameEN;
    // 课程信息
    private String courseInfo;
    // 主讲教师工号
    private String teacherId;
    // 主讲教师名字
    private String teacherName;
    // 授课老师，当不是外教时，和主讲教师一致
    private String instructorName;
    // 授课老师信息
    private String instructorInfo;
    // 教学团队人员工号（多个）
    private String teachingTeamIds;
    // 教学团队人员（多个）
    private String teachingTeamNames;
    // 申请人ID
    private String applicantId;
    // 申请人Name
    private String applicantName;
    // 班级号
    private Integer classId;
    // 开课季节
    private String classSemester;
    // 学时
    private Integer classHours;
    // 学分
    private Integer classGradePoint;
    // 课程已选人数
    private Integer classChooseNum;
    // 上限人数
    private Integer classUpperBound;
    // 起始周次
    private Integer startWeek;
    // 结束周次
    private Integer endWeek;
    // 上课时间
    private String classDateDesc;
    // 上课地点
    private String classPlace;
    // 冲突状态，id-t(时间冲突)，id-p(点冲突)，多个冲突以分号间隔
    private String conflictDesc;

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

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
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

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
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

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorInfo() {
        return instructorInfo;
    }

    public void setInstructorInfo(String instructorInfo) {
        this.instructorInfo = instructorInfo;
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

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassSemester() {
        return classSemester;
    }

    public void setClassSemester(String classSemester) {
        this.classSemester = classSemester;
    }

    public Integer getClassHours() {
        return classHours;
    }

    public void setClassHours(Integer classHours) {
        this.classHours = classHours;
    }

    public Integer getClassGradePoint() {
        return classGradePoint;
    }

    public void setClassGradePoint(Integer classGradePoint) {
        this.classGradePoint = classGradePoint;
    }

    public Integer getClassChooseNum() {
        return classChooseNum;
    }

    public void setClassChooseNum(Integer classChooseNum) {
        this.classChooseNum = classChooseNum;
    }

    public Integer getClassUpperBound() {
        return classUpperBound;
    }

    public void setClassUpperBound(Integer classUpperBound) {
        this.classUpperBound = classUpperBound;
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
        this.classDateDesc = classDateDesc;
    }

    public String getClassPlace() {
        return classPlace;
    }

    public void setClassPlace(String classPlace) {
        this.classPlace = classPlace;
    }

    public String getConflictDesc() {
        return conflictDesc;
    }

    public void setConflictDesc(String conflictDesc) {
        this.conflictDesc = conflictDesc;
    }
}
