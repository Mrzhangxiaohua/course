DROP TABLE IF EXISTS Role_user;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

CREATE TABLE Role_user(
  Id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  roleId INT NOT NULL ,
  userId VARCHAR(255)  NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

lock tables Role_user write;

insert into Role_user values (1,1,'0000000001'),(2,2,'0000000002');

unlock tables;