create view v_kb_jskb as
  select
         a.classEncode as kcbh,    -- 课程编号
         a.className as kcmc,      -- 课程名称
         a.classNum as bjid,       -- 班级id
         a.classSemester as xnxqdm,-- 学年学期
         concat(a.startWeek,'-',a.endWeek) as zc, -- 周次
         a.classDateDescription as skxq_ksjc_jsjc, -- 上课星期_开始节次_结束节次
         a.teaId as jsbh,          -- 教师编号
         a.teaName as jsxm,        -- 教师姓名
         c.JASDM as jasdm,        -- 教室编号
         a.classId as ID
  from Course a left join TeacherInfo b on a.teaId = b.JSBH left join ClassroomInfo c on c.JASMC=a.classPlace;