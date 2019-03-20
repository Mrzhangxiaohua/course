/*
 Navicat Premium Data Transfer

 Source Server         : 202.117.16.167
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 202.117.16.167:3306
 Source Schema         : course

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 20/03/2019 15:16:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for studentComment
-- ----------------------------
DROP TABLE IF EXISTS `studentComment`;
CREATE TABLE `studentComment`  (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `classId` int(50) NULL DEFAULT NULL,
  `isComment` int(5) NULL DEFAULT NULL ,
  `stuId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
