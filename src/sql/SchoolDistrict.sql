/*
Navicat MySQL Data Transfer

Source Server         : 202.117.16.167
Source Server Version : 50718
Source Host           : 202.117.16.167:3306
Source Database       : course

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-12-28 20:41:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for SchoolDistrict
-- ----------------------------
DROP TABLE IF EXISTS `SchoolDistrict`;
CREATE TABLE `SchoolDistrict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `name` varchar(64) DEFAULT NULL COMMENT '校区名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='校区';

-- ----------------------------
-- Records of SchoolDistrict
-- ----------------------------
INSERT INTO `SchoolDistrict` VALUES ('1', '兴庆校区');
INSERT INTO `SchoolDistrict` VALUES ('2', '雁塔校区');
INSERT INTO `SchoolDistrict` VALUES ('3', '曲江校区');
INSERT INTO `SchoolDistrict` VALUES ('4', '苏州校区');
INSERT INTO `SchoolDistrict` VALUES ('5', '创新港校区');
