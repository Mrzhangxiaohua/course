DROP TABLE IF EXISTS v_t_xk_by_yjsrw;
create table v_t_xk_by_yjsrw
(
  WID      varchar(40)   null,
  JXBID    varchar(60)   null
  comment '教学班ID',
  XNXQDM   varchar(20)   null
  comment '学年学期',
  KCH      varchar(20)   null
  comment '课程号',
  KXH      varchar(20)   null
  comment '课序号',
  JXBMC    varchar(100)  null
  comment '教学班名称',
  LRDWDM   varchar(20)   null
  comment '录入单位',
  XS       int           null
  comment '学时',
  SKXS     int           null
  comment '授课学时',
  KNZXS    int           null
  comment '周学时',
  TSKH     varchar(40)   null
  comment '同时课号',
  KSLXDM   varchar(10)   null
  comment '考试类型',
  KRL      int           null
  comment '课容量',
  SFXZXB   varchar(2)    null
  comment '是否限制性别',
  NSRS     int           null
  comment '男生人数',
  NVSRS    int           null
  comment '女生人数',
  RWZTDM   varchar(6)    null
  comment '任务状态',
  TYXMDM   varchar(20)   null
  comment '体育项目',
  SKJS     varchar(2000) null
  comment '授课教师',
  JXFSDM   varchar(200)  null
  comment '教学方式',
  CZR      varchar(20)   null
  comment '操作人',
  CZSJ     date          null
  comment '操作日期',
  CZIP     varchar(200)  null
  comment '操作IP',
  BZ       varchar(500)  null
  comment '备注',
  SKBJ     varchar(4000) null
  comment '上课班级',
  SFCXB    varchar(2)    null
  comment '是否重修班',
  CZRXM    varchar(100)  null
  comment '操作人姓名',
  PX       int           null
  comment '排序',
  PKDWDM   varchar(20)   null
  comment '排课单位',
  XXXQDM   varchar(10)   null
  comment '学校校区代码',
  SFXYPK   varchar(2)    null
  comment '是否需要排课',
  SJZDFSDM varchar(4)    null
  comment '时间指定方式',
  PKPCDM   varchar(40)   null
  comment '排课批次',
  PKCTBJDM varchar(10)   null
  comment '排课冲突标记',
  PKSXDM   varchar(10)   null
  comment '排课属性',
  JASXQDM  varchar(10)   null
  comment '教室需求',
  PKZTDM   varchar(6)    null
  comment '排课状态',
  PKCTSM   varchar(2000) null
  comment '排课冲突说明',
  ZDPKYY   varchar(4000) null
  comment '自动排课原因',
  XKKZH    varchar(40)   null
  comment '选课课组号',
  XKCLDM   varchar(10)   null
  comment '选课策略',
  XKXZSM   varchar(2000) null
  comment '选课限制说明',
  XKWZSM   varchar(2000) null
  comment '选课文字说明',
  XKZRS    int           null
  comment '选课总人数',
  NSXKRS   int           null
  comment '男生选课人数',
  NVSXKRS  int           null
  comment '女生选课人数',
  KYL      int           null
  comment '课余量',
  SFXZXK   varchar(2)    null
  comment '是否限制选课',
  SFKFXK   varchar(2)    null
  comment '是否开放选课',
  YPXS     int           null
  comment '已排学时',
  YPSJDD   varchar(4000) null
  comment '已排时间地点',
  JCJG     varchar(20)   null
  comment '检查结果',
  SKZC     varchar(2000) null
  comment '上课周次',
  TZDID    varchar(10)   null
  comment '通知单ID',
  KCLBDM   varchar(10)   null
  comment '课程类别代码',
  KCXZDM   varchar(10)   null
  comment '课程性质代码',
  SFSDPK   varchar(10)   null
  comment '是否锁定排课',
  ZKPL     int           null
  comment '主选容量',
  FZKRL    int           null
  comment '非主选容量',
  SFXYKS   varchar(10)   null
  comment '是否需要考试',
  SFLRCJ   varchar(10)   null
  comment '是否录入成绩',
  SLDM     varchar(40)   null
  comment '流程代码',
  SHYJ     varchar(4000) null
  comment '审核意见',
  SQZTDM   varchar(10)   null
  comment '申请状态代码',
  PKYQMS   varchar(2000) null
  comment '排课要求描述',
  SFTBXKXZ varchar(10)   null
  comment '是否同步选课限制',
  SKJSSJ   varchar(2000) null
  comment '上课教师时间',
  TJNJ     varchar(2000) null
  comment '推荐年级',
  YPSJ     varchar(4000) null
  comment '已排时间',
  TKKRL    int           null
  comment '停开课容量',
  XSZL     varchar(40)   null
  comment '学生助理',
  JXBLXDM  varchar(10)   null,
  JSDWDM   varchar(20)   null,
  PYKRL    int           null
  comment '平移课容量',
  KXKRL    int           null
  comment '跨选课容量'
)
  comment '研究生任务';

