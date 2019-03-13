create view v_kb_xskb as
  select
         a.classEncode as kcbh,    -- 课程编号
         a.className as kcmc,      -- 课程名称
         a.classNum as bjid,       -- 班级id
         a.classSemester as xnxqdm,-- 学年学期
         concat(a.startWeek,'-',a.endWeek) as zc, -- 周次
         a.classDateDescription as skxq_ksjc_jsjc, -- 上课星期_开始节次_结束节次
         a.teaId as jsbh,          -- 教师编号
         a.teaName as jsxm,        -- 教师姓名
         c.JASDM as jasdm,         -- 教室编号
         b.stuId as xh
  from Course a left join Course_choose b on a.classId=b.classId left join ClassroomInfo c on c.JASMC=a.classPlace;