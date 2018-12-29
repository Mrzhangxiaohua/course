DROP TABLE IF EXISTS ClassroomInfo;

CREATE TABLE  ClassroomInfo(
  `JASDM`     VARCHAR (50) NOT NULL COMMENT '教室代码',
  `WID`       VARCHAR (50)  COMMENT 'WID',
  `JASMC`     VARCHAR (200) COMMENT'教室名称',
  `JASLXDM`   VARCHAR (20)    COMMENT'教室类型代码',
  `JXLDM`     VARCHAR (20)  COMMENT'教学楼代码',
  `LC`        VARCHAR (20)  COMMENT'楼层',
  `XXXQDM`    VARCHAR (20)  COMMENT'学校校区代码',
  `ZT`        VARCHAR (20)  COMMENT'状态',
  `PKYXJ`     VARCHAR (20)  COMMENT'排课优先级',
  `KSYXJ`     VARCHAR (20)  COMMENT'考试优先级',
  `SKZWS`     VARCHAR (50)  COMMENT'上课座位数',
  `KSZWS`     VARCHAR (50)  COMMENT'试座位数',
  `DWDM`      VARCHAR (50)  COMMENT'单位代码',
  `PX`        VARCHAR (50)  COMMENT'排序',
  `BZ`        VARCHAR (50)  COMMENT'备注',
  `SFYXPK`    VARCHAR (50)  COMMENT'是否允许排课',
  `SFYXKS`    VARCHAR (50)  COMMENT'是否允许考试',
  `SFYXJY`    VARCHAR (50)  COMMENT'是否允许借用',
  `SFYXCX`    VARCHAR (50)  COMMENT'是否允许查询',
  `ZWSXDM`    VARCHAR (50)  COMMENT'座位属性代码',
  `XGDD`      VARCHAR (50)  COMMENT'相关地点',
  `JSYT`      VARCHAR (50)  COMMENT'教室用途',
  `SXLB`      VARCHAR (50)  COMMENT'实习类别',
  `ZP`        VARCHAR (50)  COMMENT'照片',
  `CZR`       VARCHAR (50)  COMMENT'操作人',
  `CZRXM`     VARCHAR (50)  COMMENT'操作人姓名',
  `CZSJ`      VARCHAR (50)  COMMENT'操作时间',
  `SFSY`      VARCHAR (50)  COMMENT'是否使用',
  `MC`        VARCHAR (50)  COMMENT'校区名称',
  `JASLXMC`   VARCHAR (50)  COMMENT'教室类型',
  `JXLMC`     VARCHAR (50)  COMMENT'教学楼名称',
  `SFKSWH`    VARCHAR (50)  COMMENT'是否考试维护',
  `XLSXH`     VARCHAR (50)  COMMENT'相邻顺序号',
  PRIMARY KEY (`JASDM`)
)
 ENGINE = InnoDB
 DEFAULT CHARSET = utf8;
 COMMENT'存储教室信息'