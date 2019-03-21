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

 Date: 20/03/2019 15:06:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for v_t_xk_by_yjsrwsjdd
-- ----------------------------
DROP TABLE IF EXISTS `v_t_xk_by_yjsrwsjdd`;
CREATE TABLE `v_t_xk_by_yjsrwsjdd`  (
  `WID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'WID',
  `KBID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课表ID',
  `XNXQDM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学年学期代码',
  `KCH` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程号',
  `KXH` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课序号',
  `JXBID` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教学班ID',
  `SKZC` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上课周次',
  `SKXQ` int(11) NULL DEFAULT NULL COMMENT '上课星期',
  `KSJC` int(11) NULL DEFAULT NULL COMMENT '开始节次',
  `JSJC` int(11) NULL DEFAULT NULL COMMENT '结束周次',
  `JASDM` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教室代码',
  `CZR` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `CZSJ` date NULL DEFAULT NULL COMMENT '操作时间',
  `CZIP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作IP',
  `BZ` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `SJSM` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间说明',
  `CZRXM` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人姓名',
  `XSLXDM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学时类型代码'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '研究生排课结果' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
