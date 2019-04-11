/*
 Navicat Premium Data Transfer

 Source Server         : 58.206.125.53
 Source Server Type    : MySQL
 Source Server Version : 50641
 Source Host           : 58.206.125.53:3306
 Source Schema         : course

 Target Server Type    : MySQL
 Target Server Version : 50641
 File Encoding         : 65001

 Date: 20/03/2019 15:06:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for v_t_xk_by_yjsrw
-- ----------------------------
DROP TABLE IF EXISTS `v_t_xk_by_yjsrw`;
CREATE TABLE `v_t_xk_by_yjsrw`  (
  `WID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JXBID` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教学班ID',
  `XNXQDM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学年学期',
  `KCH` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程号',
  `KXH` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课序号',
  `JXBMC` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教学班名称',
  `LRDWDM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '录入单位',
  `XS` int(11) NULL DEFAULT NULL COMMENT '学时',
  `SKXS` int(11) NULL DEFAULT NULL COMMENT '授课学时',
  `KNZXS` int(11) NULL DEFAULT NULL COMMENT '周学时',
  `TSKH` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '同时课号',
  `KSLXDM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考试类型',
  `KRL` int(11) NULL DEFAULT NULL COMMENT '课容量',
  `SFXZXB` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否限制性别',
  `NSRS` int(11) NULL DEFAULT NULL COMMENT '男生人数',
  `NVSRS` int(11) NULL DEFAULT NULL COMMENT '女生人数',
  `RWZTDM` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务状态',
  `TYXMDM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '体育项目',
  `SKJS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授课教师',
  `JXFSDM` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教学方式',
  `CZR` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `CZSJ` date NULL DEFAULT NULL COMMENT '操作日期',
  `CZIP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作IP',
  `BZ` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `SKBJ` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上课班级',
  `SFCXB` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否重修班',
  `CZRXM` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人姓名',
  `PX` int(11) NULL DEFAULT NULL COMMENT '排序',
  `PKDWDM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排课单位',
  `XXXQDM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校校区代码',
  `SFXYPK` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否需要排课',
  `SJZDFSDM` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间指定方式',
  `PKPCDM` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排课批次',
  `PKCTBJDM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排课冲突标记',
  `PKSXDM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排课属性',
  `JASXQDM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教室需求',
  `PKZTDM` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排课状态',
  `PKCTSM` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排课冲突说明',
  `ZDPKYY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自动排课原因',
  `XKKZH` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选课课组号',
  `XKCLDM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选课策略',
  `XKXZSM` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选课限制说明',
  `XKWZSM` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选课文字说明',
  `XKZRS` int(11) NULL DEFAULT NULL COMMENT '选课总人数',
  `NSXKRS` int(11) NULL DEFAULT NULL COMMENT '男生选课人数',
  `NVSXKRS` int(11) NULL DEFAULT NULL COMMENT '女生选课人数',
  `KYL` int(11) NULL DEFAULT NULL COMMENT '课余量',
  `SFXZXK` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否限制选课',
  `SFKFXK` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否开放选课',
  `YPXS` int(11) NULL DEFAULT NULL COMMENT '已排学时',
  `YPSJDD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '已排时间地点',
  `JCJG` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '检查结果',
  `SKZC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上课周次',
  `TZDID` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知单ID',
  `KCLBDM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程类别代码',
  `KCXZDM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程性质代码',
  `SFSDPK` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否锁定排课',
  `ZKPL` int(11) NULL DEFAULT NULL COMMENT '主选容量',
  `FZKRL` int(11) NULL DEFAULT NULL COMMENT '非主选容量',
  `SFXYKS` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否需要考试',
  `SFLRCJ` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否录入成绩',
  `SLDM` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '流程代码',
  `SHYJ` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核意见',
  `SQZTDM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请状态代码',
  `PKYQMS` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排课要求描述',
  `SFTBXKXZ` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否同步选课限制',
  `SKJSSJ` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上课教师时间',
  `TJNJ` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推荐年级',
  `YPSJ` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '已排时间',
  `TKKRL` int(11) NULL DEFAULT NULL COMMENT '停开课容量',
  `XSZL` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生助理',
  `JXBLXDM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JSDWDM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PYKRL` int(11) NULL DEFAULT NULL COMMENT '平移课容量',
  `KXKRL` int(11) NULL DEFAULT NULL COMMENT '跨选课容量'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '研究生任务' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
