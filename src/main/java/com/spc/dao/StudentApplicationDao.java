package com.spc.dao;

import org.apache.ibatis.annotations.Param;

public interface StudentApplicationDao {

    int add(@Param("stuId")Integer stuId,@Param("classId")Integer classId,@Param("states")Integer  states);

}
