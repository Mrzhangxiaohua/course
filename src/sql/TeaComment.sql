DROP TABLE IF EXISTS TeaComment;

CREATE TABLE TeaComment(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  stuId VARCHAR(11) NOT NULL ,
  classId VARCHAR(11) NOT NULL ,
  teaId VARCHAR(11) NOT NULL ,
  teaEvaluate varchar(11),
  teaSuggestion varchar(100)
)
comment '存储教师评教内容'