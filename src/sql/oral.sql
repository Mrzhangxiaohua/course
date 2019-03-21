create table oral
(
  idq          int auto_increment
    primary key,
  teaId        varchar(20)     null,
  teaName      varchar(20)     null,
  time         varchar(20)     null,
  examRoom     varchar(20)     null,
  flag         int             null,
  yearSemester varchar(30)     null,
  operatorId   varchar(20)     null,
  operatorName varchar(20)     null,
  stuLimit     int             null,
  curChoose    int default '0' null,
  place        varchar(20)     null
);

