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
DROP TABLE IF EXISTS `KnskGrade`;
CREATE TABLE `KnskGrade`  (
  `XH` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `KCH` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程号',
  `KXH` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课序号',
  `grade` int(11) NULL DEFAULT NULL COMMENT '成绩'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '研究生任务' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
