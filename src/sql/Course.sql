-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: Course_Selection_System
-- ------------------------------------------------------
-- Server version	5.7.18-1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS Course;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE  Course (
  `classId`        INT(11)      NOT NULL AUTO_INCREMENT, # 课程id
  `className`      VARCHAR(200) NOT NULL,                # 课程名称
  `classNum`       INT(11)      NOT NULL,                # 班次
  `teaId`          INT(11)      NOT NULL,                # 教师id （多个教师扩展？）
  `teaName`        VARCHAR(200) NOT NULL,                # 教师姓名
  `classChooseNum` INT(11)      NOT NULL,                # 当前选课人数
  `classUpperLimit`INT(11)      NOT NULL,                # 选课人数上限
  `classDateDescription`      VARCHAR(200) NOT NULL,     # 课程时间
  `classPlace`     VARCHAR(200) NOT NULL,                # 课程地点
  `classLength`    INT(11)      NOT NULL,                # 课程时长
  `classModuleNum` INT(11)      NOT NULL,                # 课程所属模块编号
  `departId`       INT(11)      NOT NULL,                # 学院id
  `classSemester`    VARCHAR(200)      NOT NULL,          # 所属学期
  PRIMARY KEY (`classId`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1009
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES Course WRITE;
/*!40000 ALTER TABLE `Course`
  DISABLE KEYS */;
INSERT INTO Course VALUES (1001, 'c语言程序设计',1, 2018100001,'王五', 2,20,'周二上午三四节','B座701',2,1,2,'2018春'),
(1002, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,2,'2018秋'),
(2, 'c++程序设计',2, 2018122001,'张发', 3,2,'周二上午一二节','B座703',2,1,5,'2018秋'),
(34, '哲学',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,2,'2018秋'),
(3333333, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'2:1','B座703',2,1,4,'2018秋'),
(245324, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,4,'2018秋'),
(45, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,4,'2018秋'),
(23443, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,4,'2018春'),
(2234, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,4,'2018春'),
(345, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,4,'2018春'),
(222, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,4,'2018秋'),
(3333, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,4,'2018秋'),
(444, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,4,'2018春'),
(535, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,4,'2018春'),
(5559, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,4,'2018春'),
(5558, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,4,'2018春'),
(5557, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,4,'2018春'),
(5556, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,4,'2018春'),
(5554, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,4,'2018春'),
(6663, 'JAVA程序设计',2, 2018122001,'李四', 3,2,'周二上午一二节','B座703',2,1,4,'2018春');
/*!40000 ALTER TABLE `Course`
  ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2018-06-01 16:59:26
