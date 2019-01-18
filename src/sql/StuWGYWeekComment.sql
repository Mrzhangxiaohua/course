DROP TABLE IF EXISTS StuWGYWeekComment;

CREATE TABLE StuWGYWeekComment(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  stuId varchar(11) NOT NULL ,
  teaId varchar(11) NOT NULL ,
  stuEvaluate varchar(11),
  stuSuggestion varchar(100),
  commentFlag varchar (2),
  classId varchar (11)
)
comment '存储学生周评教信息'