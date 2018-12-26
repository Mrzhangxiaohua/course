# 数据库建表语句

## 1. 排课

```sql
DROP TABLE IF EXISTS CourseAll;
CREATE TABLE
IF NOT EXISTS `CourseAll` (
  `id`                INT NOT NULL PRIMARY KEY AUTO_INCREMENT
  COMMENT '主键，自增',
  `departId`          INT COMMENT '学院ID',
  `moduleId`          INT COMMENT '所属模块ID',
  `courseId`          VARCHAR(255) NOT NULL
  COMMENT '课程ID',
  `courseNameCHS`     VARCHAR(255) COMMENT '课程名称（中文）',
  `courseNameEN`      VARCHAR(255) COMMENT '课程名称（英文）',
  `courseInfo`        VARCHAR(255) COMMENT '课程信息',
  `teacherId`         VARCHAR(255) COMMENT '主讲教师工号',
  `teacherName`       VARCHAR(255) COMMENT '主讲教师名字',
  `instructorName`    VARCHAR(255) COMMENT '授课老师，当不是外教时，和主讲教师一致',
  `instructorInfo`    VARCHAR(255) COMMENT '授课老师信息',
  `teachingTeamIds`   VARCHAR(255) COMMENT '教学团队人员工号（多个）',
  `teachingTeamNames` VARCHAR(255) COMMENT '教学团队人员（多个）',
  `applicantId`       VARCHAR(255) COMMENT '申请人ID',
  `applicantName`     VARCHAR(255) COMMENT '申请人Name',
  `classId`           INT COMMENT '班级号',
  `classSemester`     VARCHAR(255) COMMENT '开课季节',
  `classHours`        INT COMMENT '学时',
  `classGradePoint`   INT COMMENT '学分',
  `classChooseNum`    INT COMMENT '课程已选人数',
  `classUpperLimit`   INT COMMENT '课程上限人数',
  `startWeek`         INT COMMENT '起始周次',
  `endWeek`           INT COMMENT '结束周次',
  `classDateDesc`     VARCHAR(255) COMMENT '上课时间',
  `classPlace`        VARCHAR(255) COMMENT '上课地点',
  `conflictDesc`      VARCHAR(255) COMMENT '冲突状态，id-t(时间冲突)，id-p(点冲突)，多个冲突以分号间隔'
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  COMMENT = '排课';
```