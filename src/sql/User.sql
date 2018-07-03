DROP TABLE IF EXISTS User;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

CREATE TABLE User(
  uid INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userName VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL,
  num INT(11)      NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

lock tables User write;

insert into User values (1,'张三','fsfsf',2018000001),(2,'李四','fsfsfsfsf',2018000004);

unlock tables;
