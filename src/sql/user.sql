CREATE DATABASE mytest;

CREATE TABLE t_user(
  userId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userName VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  phone VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

lock tables t_user write;

insert into t_user values (1,'张三','fsfsf','2342423525'),(2,'李四','fsfsfsfsf','2342425325');

unlock tables;
