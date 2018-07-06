
DROP TABLE IF EXISTS Grade;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

CREATE TABLE Grade(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  stuId INT(11) NOT NULL,
  classId INT(11) NOT NULL,
  score INT NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

lock tables Grade write;

insert into Grade values (1,234234,222,65),
  (2,2018000001,222,65),
  (3,2018000001,222,65),
  (4,2018000001,222,65),
  (5,2018000001,222,65),
  (6,2018000001,222,65)
;

unlock tables;