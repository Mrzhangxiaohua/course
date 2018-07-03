DROP TABLE IF EXISTS Role;
DROP TABLE IF EXISTS Role;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

CREATE TABLE Role(
  roleId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  roleName VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

lock tables Role write;

insert into Role values (1,'学生'),(2,'教师'),(3,'管理员');

unlock tables;