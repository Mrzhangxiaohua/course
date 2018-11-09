DROP TABLE IF EXISTS TeaComment;

CREATE TABLE TeaComment(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  stuId INT(11) NOT NULL ,
  teaId INT(11) NOT NULL ,
  teaEvaluate varchar(11),
  teaSuggestion varchar(100)
)
comment '存储教师评教内容'