create
  view t_xkjg_byhx as
  select
         b.chooseId as ID,-- 学号
         b.stuId as XH, -- 姓名
         c.username as XM,-- 学年学期
         null as JXBID,-- 教学班ID
         a.classSemester as XNXQDM, -- 采用2018-1019春季|秋季
         concat(a.classNum,'班','(', (select name from SchoolDistrict where SchoolDistrict.id=a.schoolDistrictId),')') as KXH,
         a.classEncode as KCH, -- 课程号
         a.className as KCM, -- 课程名称
         null as XKZT,  -- 选课状态
         null as CZR,   -- 操作人
         null as CZSJ,  -- 操作时间
         null as CZIP,  -- 操作IP
         null as CZRXM, -- 操作人姓名
         null as BZ -- 备注
  from
       Course a,course.Course_choose b,XjtuUserInfo c
  where a.classId = b.classId and b.stuId = c.userno;