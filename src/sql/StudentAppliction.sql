create table StudentApplication
(
  id      int auto_increment primary key,
  stuId   int                                 not null,
  classId int                                 not null,
  states  int                                 not null,
  reason  varchar(200)                        not null,
  mydate  timestamp default CURRENT_TIMESTAMP not null,
  checked int                                 not null,
  constraint StudentApplication_id_uindex
  unique (id)
)
  comment '存储学生的申请修改课程的情况';

