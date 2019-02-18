DROP TABLE IF EXISTS models;

CREATE TABLE  models(
  `modelsId`        INT(11)      NOT NULL AUTO_INCREMENT, # 模块id
  `modelsName`      VARCHAR(200) NOT NULL,                # 模块名称
  PRIMARY KEY (`modelsId`)
)
 ENGINE = InnoDB
 DEFAULT CHARSET = utf8;


  lock tables models write;
  insert into models values
  (1,'核心素养'),
  (2,'英文博雅'),
  (3,'学术英语'),
  (4,'专业英语');

  unlock tables;


