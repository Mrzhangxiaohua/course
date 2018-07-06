package com.spc.dao;

import com.spc.model.GradeDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeDao {
    public int insert(GradeDomain gradeDomain);
    public List<GradeDomain> selectGrade (@Param("classId") Integer classId,@Param("stuId") Integer stuId);
}
