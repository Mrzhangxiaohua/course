-- auto-generated definition
create table courseApplication
(
  id                int auto_increment
    primary key,
  departId          int                                 null,
  departName        varchar(255)                        null,
  courseId          varchar(255)                        null,
  courseNameCHS     varchar(255)                        null,
  courseNameEN      varchar(255)                        null,
  moduleId          int                                 null,
  academicYear      varchar(255)                        null,
  classSemester     varchar(255)                        null,
  classHour         int                                 null,
  stuNumUpperLimit  int                                 null,
  fileInfoId        int                                 null,
  teacherId         varchar(255)                        null,
  teacherName       varchar(255)                        null,
  teachingTeamNames varchar(500)                        null,
  courseInfo        text                                null,
  teacherInfo       text                                null,
  operatorId        varchar(255)                        null,
  operatorName      varchar(255)                        null,
  operatorDate      timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP,
  isChecked         int                                 null
  comment '0表示未审核，1表示审核通过，2表示拒绝，3表示由管理员直接添加课程目录',
  teachingTeamIds   varchar(500)                        null
);

