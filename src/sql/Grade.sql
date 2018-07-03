DROP TABLE IF EXISTS Grade;
DROP TABLE IF EXISTS Grade;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

CREATE TABLE Grade(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userId VARCHAR(255) NOT NULL,
  score INT NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

lock tables Grade write;

insert into Grade values (1,'2342342',65);

unlock tables;