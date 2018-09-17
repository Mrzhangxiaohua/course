package com.spc.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DataDao {

    List<Map<String, Object>> getDepart();

    int selectXuanKeStu(@Param("stuId") String stuId);
}
