/*
Navicat MySQL Data Transfer

Source Server         : 202.117.16.167
Source Server Version : 50718
Source Host           : 202.117.16.167:3306
Source Database       : course

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-12-28 20:40:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ClassAll
-- ----------------------------
DROP TABLE IF EXISTS `ClassAll`;
CREATE TABLE `ClassAll` (
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
  `schoolDistrictId` int(11) DEFAULT NULL COMMENT '校区ID',
  `className` varchar(255) DEFAULT NULL COMMENT '班级名称',
  `instructorId` varchar(255) DEFAULT NULL COMMENT '授课老师ID',
  `instructorName` varchar(255) DEFAULT NULL COMMENT '授课老师Name',
  `startWeek` int(11) DEFAULT NULL COMMENT '起始周次',
  `endWeek` int(11) DEFAULT NULL COMMENT '结束周次',
  `classDateDesc` varchar(255) DEFAULT NULL COMMENT '上课时间',
  `classPlaceId` varchar(255) DEFAULT NULL COMMENT '上课地点ID',
  `classPlaceName` varchar(255) DEFAULT NULL COMMENT '上课地点Name',
  `conflictDesc` varchar(255) DEFAULT NULL COMMENT '冲突状态，id-t(时间冲突)，id-p(点冲突)，多个冲突以分号间隔',
  `operatorId` varchar(255) DEFAULT NULL COMMENT '操作员ID',
  `operatorName` varchar(255) DEFAULT NULL COMMENT '操作员Name',
  `operateDate` varchar(255) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='排课';
