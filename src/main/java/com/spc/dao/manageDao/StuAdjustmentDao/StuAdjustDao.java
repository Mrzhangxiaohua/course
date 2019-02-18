package com.spc.dao.manageDao.StuAdjustmentDao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StuAdjustDao {

    List<Map<String, Object>> getAllCourse(@Param("CURRENTSEMESTER") String CURRENTSEMESTER, @Param("departId") String departId);

    int moveStudent(@Param("stuId") String stuId, @Param("oldClassId") Integer oldClassId,
                    @Param("newClassId") Integer newClassId);

    Map<String, Object> findCapacity(@Param("newClassId") Integer newClassId);
}
