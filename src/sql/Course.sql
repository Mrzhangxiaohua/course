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
  `teaId`          INT(11)      NOT NULL,                # 教师id
  `teaName`        VARCHAR(200) NOT NULL,                # 教师姓名
  `classGradePoint` INT(11)      NOT NULL,                # 学分
  `classChooseNum` INT(11)      NOT NULL,                # 当前选课人数
  `classUpperLimit`INT(11)      NOT NULL,                # 选课人数上限
  `classDateDescription`      VARCHAR(200) NOT NULL,     # 课程时间
  `classPlace`     VARCHAR(200) NOT NULL,                # 课程地点
  `classLength`    INT(11)      NOT NULL,                # 每节课时长
  `classModuleNum` INT(11)      NOT NULL,                # 课程所属模块编号
  `departId`       INT(11)      NOT NULL,                # 学院id
  `startWeek`       INT(11)      NOT NULL,                # 开始周次
  `endWeek`       INT(11)      NOT NULL,                # 结束周次
  `classSemester`    VARCHAR(200)      NOT NULL,          # 所属学期
  `courseInfo`    VARCHAR(200)      NOT NULL,          # 课程信息
  `teacherInfo`    VARCHAR(200)      NOT NULL,          # 老师信息
  `classTime`      INT(11)      NOT NULL,                # 课时
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
INSERT INTO Course VALUES (1001, 'c语言程序设计',1, 2018100001,'张发',1, 2,20,'1:1','B座201',2,1,5,2,17,'2018春','这是一门计算机基础课程','教学经验丰富',16),
  (1003, 'c语言程序设计',2, 2018100001,'张发',1, 2,20,'1:1','B座201',2,1,5,2,17,'2018春','这是一门计算机基础课程','教学经验丰富',16),
(1002, 'JAVA程序设计',2, 2018122002,'张发二',2, 50,50,'1:2','B座203',2,1,12,2,17,'2018秋','这是一门计算机基础课程','教学经验丰富',16),
(2, 'c++程序设计',2, 2018122003,'张发三', 1,3,50,'1:3','B座202',2,1,5,2,17,'2018秋','这是一门计算机基础课程','教学经验丰富',16),
(34, '哲学',2, 2018122004,'张发四',1, 3,50,'1:4','B座303',2,1,14,2,17,'2018秋','这是一门计算机基础课程','教学经验丰富',16),
(3333333, '计算机网络',2, 2018122005,'张发五',2, 3,50,'2:1','B座301',2,1,5,2,17,'2018秋','这是一门计算机基础课程','教学经验丰富',16),
(245324, '线性代数',2, 2018122006,'张发六', 2,3,50,'2:2','B座302',2,1,9,2,17,'2018秋','这是一门计算机基础课程','教学经验丰富',16),
(45, '离散数学',2, 2018122007,'张发七', 1,3,50,'2:3','B座304',2,1,9,2,17,'2018秋','这是一门计算机基础课程','教学经验丰富',16),
(23443, '英语写作',2, 2018122008,'张发八', 2,3,50,'2:4','B座403',2,3,26,2,17,'2018春','这是一门计算机基础课程','教学经验丰富',16),
(2234, '高级英语口语',2, 2018122009,'张发九',1, 3,50,'3:1','B座401',2,3,26,2,17,'2018春','这是一门计算机基础课程','教学经验丰富',16),
(345, '自然辩证法',2, 2018122010,'张发十',1, 3,50,'3:2','B座402',2,1,14,2,17,'2018春','这是一门计算机基础课程','教学经验丰富',16),
(222, '概率与数理统计',2, 2018123001,'李一',2, 3,50,'3:3','B座404',2,1,9,2,17,'2018秋','这是一门计算机基础课程','教学经验丰富',16),
(3333, '马克思原理',2, 2018123002,'李二', 2,3,50,'3:4','B座503',2,1,14,2,17,'2018秋','这是一门计算机基础课程','教学经验丰富',16),
(444, '数据库',2, 2018123003,'李三', 2,3,50,'4:1','B座501',2,1,5,2,17,'2018春','这是一门计算机基础课程','教学经验丰富',16),
(535, '计算机导论',2, 2018123004,'李五',1, 3,50,'4:2','B座502',2,1,5,2,17,'2018春','这是一门计算机基础课程','教学经验丰富',16),
(5559, '随机过程',2, 2018123005,'李六',2, 3,50,'4:3','B座504',2,1,9,2,17,'2018春','这是一门计算机基础课程','教学经验丰富',16),
(5558, '电子技术基础',2, 2018123006,'李七',2, 3,50,'4:4','A座103',2,1,5,2,17,'2018春','这是一门计算机基础课程','教学经验丰富',16),
(5557, 'VC++程序设计',2, 2018123007,'李八', 2,3,50,'5:1','A座203',2,1,5,2,17,'2018春','这是一门计算机基础课程','教学经验丰富',16),
(5556, '高等数学',2, 2018123008,'李九',1 ,3,50,'5:2','A座303',2,1,9,2,17,'2018春','这是一门计算机基础课程','教学经验丰富',16),
(5554, '物理',2, 2018123009,'李十', 1,3,50,'5:3','A座401',2,1,6,2,17,'2018春','这是一门计算机基础课程','教学经验丰富',16),
(6663, '有机化学',2, 2018124001,'赵一',1, 3,50,'5:4','A座403',2,1,17,2,17,'2018春','这是一门计算机基础课程','教学经验丰富',16);
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
