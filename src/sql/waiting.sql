-- auto-generated definition
create table waiting
(
  id          int auto_increment
    primary key,
  stuId       varchar(20) null,
  classId     int         null,
  flag        int         null
  comment '1表示排队中，0表示补位成功，2表示撤销申请',
  operateTime varchar(20) null
);

