create
  view t_kc_byhx as
select a.classEncode  as KCBH, -- 课程编号
       a.className    as KCMC,  -- 课程名称
       b.courseNameEN as KCYWMC,-- 课程英文名称
       c.departCode   as YXSH,-- 院系
       null           as KCXF,-- 课程学分
       a.classTime    as KCZXS,-- 课程学时
       a.teaId        as JSBH,-- 教师编号
       null           as KKJJ,-- 开课季节
       a.classId      as ID,-- ID
       null           as XDND  -- 学年年度
from Course a
       left join
       mid as b
       on a.className = b.courseNameCHS
       left join Department as c on c.departId = a.departId;

