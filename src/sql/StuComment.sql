DROP TABLE IF EXISTS StuComment;

CREATE TABLE StuComment(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  stuId varchar(11) NOT NULL ,
  teaId varchar(11) NOT NULL ,
  stuEvaluate varchar(11),
  stuSuggestion varchar(100)
)
comment '存储学生评教内容'