package com.spc.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

public interface IssueGradeDao {

    public int insert(@Param("classId") int classId,@Param("model1") int model1,@Param("model2") int model2);
    public int update(@Param("classId") int classId,@Param("model1") int model1,@Param("model2") int model2);
    public Map select(@Param("classId") int classId);

}
