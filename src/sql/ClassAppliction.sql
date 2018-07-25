DROP TABLE IF EXISTS ClassApplication;
-- auto-generated definition
-- auto-generated definition

create table ClassApplication
(
  id           int auto_increment
    primary key,
  className    varchar(200)                        not null,
  mainLecturer varchar(200)                        not null,
  teacherInfo  varchar(200)                        not null,
  courseInfo   varchar(200)                        not null,
  classTime    int                                 not null,
  teaName      varchar(200)       not null default  "",
  teaId        int                not null default  0,
  checked      int                                 not null,
  mydate       timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP
)
  comment '申请添加课程的表';



