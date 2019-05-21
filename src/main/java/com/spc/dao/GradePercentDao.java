package com.spc.dao;

import com.spc.model.GradePercent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GradePercentDao {
   int insertGradePercent(@Param("knsk") int knsk,@Param("xbsj") int xbsj,@Param("zzxx") int zzxx,@Param("dekt") int dekt,@Param("qmnl") int qmnl,@Param("userId") String userId,@Param("date") String date);

   int updateFlagZero();

   List<Map<String,Object>> getGradePercent();
}
