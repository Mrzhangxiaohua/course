DROP TABLE IF EXISTS StuWGYComment;

CREATE TABLE StuWGYComment(
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  stuId varchar(11) NOT NULL ,
  teaId varchar(11) NOT NULL ,
  stuEvaluate varchar(11),
  stuSuggestion varchar(100)
)
comment '存储学生评外国语学院小班实践内容'