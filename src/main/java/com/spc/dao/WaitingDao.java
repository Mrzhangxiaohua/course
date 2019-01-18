package com.spc.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface WaitingDao {
    int insert(@Param("stuId") String stuId,@Param("classId") int classId,
               @Param("flag") int flag,@Param("time") String time);

    List<Map<String, Object>> selectWaitings(@Param("classId") Integer classId);

    int updateFlag(@Param("id") int id);

    int delete(@Param("id") int id);

    List<Map<String,Object>> findByStuId(@Param("stuId") String stuId);

    List<Map<String, Object>> findByStuAndClass(@Param("stuId")String stuId, @Param("classId")int classId);

    List<Map<String, Object>> findOrder(@Param("time")String time,@Param("classId")int classId);

    List<Map<String, Object>> findById(@Param("id")int id);
}
