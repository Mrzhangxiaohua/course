DROP TABLE IF EXISTS CourseOthers;
CREATE TABLE CourseOthers(
  `classId`       INT (10) NOT NULL AUTO_INCREMENT,
  `className`     VARCHAR (200),
  `classEngName`  VARCHAR (200),
  `classNum`      INT (10),
  `teaId`         VARCHAR (200),
  `teaName`       VARCHAR (200),
  `classDateDescription` VARCHAR (200),
  `classPlace`    VARCHAR (200),
  `classModuleNum`INT (11),
  `departId`      INT (11),
  `startWeek`     INT (11),
  `endWeek`       INT (11),
  `classSemester` VARCHAR (200),
  `mainTeaName`   VARCHAR (200),
  `TeaTeam`       VARCHAR (200),
  `TeaTeamNum`    VARCHAR (200),
  `classEncode`   VARCHAR (200),
  PRIMARY KEY (`classId`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

LOCK TABLES Student WRITE;
INSERT INTO CourseOthers VALUES
(NULL, '英语专项实践', 'Engprac', 1, '0000008742', '郑庆华', NULL, NULL, 2, 5, 4, 11, '2018-2019-2', '冯广宜', NULL, NULL, '323232'),
(NULL, '英语专项实践2', 'Engprac2', 1, '0002009029', '龙建纲', NULL, NULL, 1, 13, 12, 19, '2018-2019-2', '龙建纲', NULL, NULL, '111222');
UNLOCK TABLES;