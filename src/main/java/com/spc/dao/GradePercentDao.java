package com.spc.dao;

import com.spc.model.GradePercent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GradePercentDao {
   int updateGradePercent(@Param("knsk") int knsk,@Param("xbsj") int xbsj,@Param("wlzz") int wlzz,@Param("dekt") int dekt,@Param("nlcs") int nlcs,@Param("userId") String userId,@Param("date") String date ,@Param("typeId") int typeId);

   int updateFlagZero();

   List<Map<String,Object>> getGradePercent();
}
