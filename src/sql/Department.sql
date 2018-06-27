
DROP TABLE IF EXISTS Department;

CREATE TABLE  Department(
  `departId`        INT(11)      NOT NULL AUTO_INCREMENT, # 学院id
  `departName`      VARCHAR(200) NOT NULL,                # 学院名称
  PRIMARY KEY (`departId`)
)
 ENGINE = InnoDB
 DEFAULT CHARSET = utf8;


  lock tables course write;
  insert into Department values
  (1,"机械工程学院"),
  (2,"材料科学与工程学院"),
  (3,"能源与动力工程学院"),
  (4,"电气工程学院"),
  (5,"电子与信息工程学院"),
  (6,"航天航空学院"),
  (7,"数学与统计学院"),
  (8,"管理学院"),
  (9,"理学院"),
  (10,"人文社会科学学院"),
  (11,"软件学院"),
  (12,"外国语学院"),
  (13,"生命科学与技术学院"),
  (14,"马克思主义学院"),
  (15,"国际教育学院"),
  (16,"医学部"),
  (17,"化学工程与技术学院"),
  (18,"公共政策与管理学院"),
  (19,"经济与金融学院"),
  (20,"金禾经济研究中心"),
  (21,"人居环境与建筑工程学院"),
  (22,"继续教育学院"),
  (23,"法学院"),
  (24,"研究生院（苏州）"),
  (25,"MBA中心"),
  (26,"体育中心"),
  (27,"前沿科学技术研究院"),
  (28,"工程博士中心"),
  (29,"可持续发展学院"),

  unlock tables;



