DROP TABLE IF EXISTS XjtuUserInfo;

-- auto-generated definition
create table XjtuUserInfo
(
  birthday        varchar(255) null,
  classId         varchar(255) null,
  dep             varchar(255) null,
  depid           varchar(255) null,
  email           varchar(255) null,
  gender          varchar(255) null,
  idcardname      varchar(255) null,
  idcardno        varchar(255) null,
  marriage        varchar(255) null,
  mobile          varchar(255) null,
  nation          varchar(255) null,
  nationplace     varchar(255) null,
  polity          varchar(255) null,
  roomnumber      varchar(255) null,
  speciality      varchar(255) null,
  studenttype     varchar(255) null,
  tutoremployeeid varchar(255) null,
  userid          varchar(255) null,
  username        varchar(255) null,
  userno          varchar(255) not null
    primary key,
  usertype        varchar(255) null,
  roomphone       varchar(255) null
)ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;



