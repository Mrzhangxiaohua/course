DROP TABLE IF EXISTS ClassApplication;
-- auto-generated definition
create Table ClassApplication
(
  id      int auto_increment
    primary key,
  stuId   int          not null,
  classId int          not null,
  states  int          not null,
  reason  varchar(200) not null,
  mydate  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  checked int          not null,
  constraint StudentApplication_id_uindex
  unique (id)
)
  comment '存储学生的申请修改课程的情况';

