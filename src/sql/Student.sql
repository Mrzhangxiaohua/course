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
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS Student;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE Student (
  `stuId`   INT(11)      NOT NULL,
  `stuName` VARCHAR(200) NOT NULL,
  `stuPass` VARCHAR(200) NOT NULL,
  `insId`   INT(11)      DEFAULT NULL,
  `insName` VARCHAR(200) DEFAULT NULL,
  `classId` INT(11)      DEFAULT NULL,
  PRIMARY KEY (`stuId`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES Student WRITE;
/*!40000 ALTER TABLE `Student`
  DISABLE KEYS */;
INSERT INTO Student
VALUES (2018000001, '张三', '2018000001', 1005, '经济学院', 1), (2018000002, '李四', '2018000002', 1001, '信息科学技术学院', 2),
  (2018000003, '王五', '2018000003', 1005, '经济学院', 3), (2018000004, '赵六', '2018000004', 1005, '经济学院', 4),
  (2018000005, '孙七', '2018000005', 1004, '管理学院', 5), (2018000006, '周八', '2018000006', 1001, '信息科学技术学院',6),
  (2018000007, '吴九', '2018000007', 1004, '管理学院',6), (2018000008, '郑十', '2018000008', 1001, '信息科学技术学院',8),
  (2018000009, '刘备', '2018000009', 1004, '管理学院',8), (2018000010, '关羽', '2018000010', 1002, '医学院',9),
  (2018000011, '张飞', '2018000011', 1002, '医学院',9);
/*!40000 ALTER TABLE `Student`
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

-- Dump completed on 2018-02-19 16:59:26
