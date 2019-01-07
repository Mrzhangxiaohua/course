package com.spc.dao;

import com.spc.model.GradeDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeDao {
    public int insert(GradeDomain gradeDomain);

    public List<GradeDomain> selectGrade(@Param("classId") Integer classId, @Param("stuId") String stuId);

    Integer addScore(@Param("stuId") String stuId, @Param("classId") Integer classId, @Param("score") Integer score);
}
