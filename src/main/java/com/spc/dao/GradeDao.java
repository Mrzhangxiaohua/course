package com.spc.dao;

import com.spc.model.GradeDomain;
import com.spc.model.GradePercent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GradeDao {
    public int insert(GradeDomain gradeDomain);

    public List<GradeDomain> selectGrade(@Param("classId") Integer classId, @Param("stuId") String stuId);

    Integer addScore(@Param("stuId") String stuId, @Param("classId") Integer classId, @Param("score") Integer score);

    List selectGetTitle();

    int updateGrade(@Param("classId")int classId,@Param("stuId") String stuId,@Param("grade") float grade);

    List<Map<String, Object>> getModelGrade(@Param("stuId") String stuId);
}
