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

 Date: 20/03/2019 15:06:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for v_t_xk_by_yjsyxkb
-- ----------------------------
DROP TABLE IF EXISTS `v_t_xk_by_yjsyxkb`;
CREATE TABLE `v_t_xk_by_yjsyxkb`  (
  `WID` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'WID',
  `XNXQDM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学年学期代码',
  `XH` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `KCH` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程号',
  `SKJS` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上课教师',
  `YPSJDD` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '已排时间地点',
  `SKZC` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上课周次',
  `SKXQ` int(11) NULL DEFAULT NULL COMMENT '上课星期',
  `KSJC` int(11) NULL DEFAULT NULL COMMENT '开始节次',
  `JSJC` int(11) NULL DEFAULT NULL COMMENT '结束节次',
  `BZ` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `KXH` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课序号',
  `JXBID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教学班Id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '研究生已选课表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
