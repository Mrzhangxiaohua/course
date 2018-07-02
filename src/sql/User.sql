DROP TABLE IF EXISTS user;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

CREATE TABLE user(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userId VARCHAR(255)  NOT NULL ,
  userName VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

lock tables user write;

insert into user values (2,'0000000001','张三','fsfsf'),(23,'0000000002','李四','fsfsfsfsf');

unlock tables;
