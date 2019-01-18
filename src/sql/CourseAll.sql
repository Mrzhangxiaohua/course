/*
Navicat MySQL Data Transfer

Source Server         : 202.117.16.167
Source Server Version : 50718
Source Host           : 202.117.16.167:3306
Source Database       : course

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-12-28 20:40:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for CourseAll
-- ----------------------------
DROP TABLE IF EXISTS `CourseAll`;
CREATE TABLE `CourseAll` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `departId` int(11) DEFAULT NULL COMMENT '学院ID',
  `courseId` varchar(255) NOT NULL COMMENT '课程ID',
  `courseNameCHS` varchar(255) DEFAULT NULL COMMENT '课程名称（中文）',
  `courseNameEN` varchar(255) DEFAULT NULL COMMENT '课程名称（英文）',
  `moduleId` int(11) DEFAULT NULL COMMENT '所属模块ID',
  `academicYear` varchar(255) DEFAULT NULL COMMENT '学年',
  `classSemester` varchar(255) DEFAULT NULL COMMENT '开课季节',
  `classHour` int(11) DEFAULT NULL COMMENT '学时',
  `stuNumUpperLimit` int(11) DEFAULT NULL COMMENT '课程上限人数',
  `teacherId` varchar(255) DEFAULT NULL COMMENT '主讲教师工号',
  `teacherName` varchar(255) DEFAULT NULL COMMENT '主讲教师名字',
  `teachingTeamIds` varchar(255) DEFAULT NULL COMMENT '教学团队人员工号（多个）',
  `teachingTeamNames` varchar(255) DEFAULT NULL COMMENT '教学团队人员（多个）',
  `courseInfo` varchar(255) DEFAULT NULL COMMENT '课程内容简介',
  `teacherInfo` varchar(255) DEFAULT NULL COMMENT '主讲教师简介',
  `operatorId` varchar(255) DEFAULT NULL COMMENT '操作员ID',
  `operatorName` varchar(255) DEFAULT NULL COMMENT '操作员Name',
  `operateDate` varchar(255) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程目录';
