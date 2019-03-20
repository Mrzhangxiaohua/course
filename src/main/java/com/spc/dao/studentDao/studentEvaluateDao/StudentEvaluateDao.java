package com.spc.dao.studentDao.studentEvaluateDao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentEvaluateDao {
    List<Map<String, Object>> selectList(@Param("stuId") String stuId);

    int stuEvaluate(@Param("classId") Integer classId, @Param("stuId") String stuId, @Param("strScore1") String strScore1,
                    @Param("strScore2") String strScore2,@Param("strScore3") String strScore3);
}
