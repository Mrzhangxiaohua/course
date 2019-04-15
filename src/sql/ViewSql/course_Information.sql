create view t_kc_byhx as
       select a.classEncode  as KCBH,
              a.className    as KCMC,
              b.courseNameEN as KCYWMC,
              c.departCode   as YXSH,
              null           as KCXF,
              a.classTime    as KCZXS,
              a.teaId        as JSBH,
              null           as KKJJ,
              a.classId      as ID,
              null           as XDND
       from Course a
              left join
              mid as b
              on a.className = b.courseNameCHS
              left join Department as c on c.departId = a.departId;

