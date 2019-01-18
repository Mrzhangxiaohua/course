package com.spc.dao;

import com.spc.model.GradePercent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradePercentDao {
   int insertGradePercent(@Param("knsk") int knsk,@Param("xbsj") int xbsj,@Param("zzxx") int zzxx,@Param("userId") String userId,@Param("date") String date);

   int updateFlagZero();

   List<GradePercent> getGradePercent();
}
