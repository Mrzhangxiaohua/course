package com.spc.dao;

import org.apache.ibatis.annotations.Param;

public interface GradePercentDao {
   int insertGradePercent(@Param("knsk") int knsk,@Param("xbsj") int xbsj,@Param("zzxx") int zzxx,@Param("userId") String userId,@Param("date") String date);

   int updateFlagZero();
}
