package com.spc.dao;

import com.spc.model.StudentApplicationDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentApplicationDao {

    int add(@Param("stuId")Integer stuId,@Param("classId")Integer classId,  @Param("states")Integer  states,@Param("reason")String  reason,@Param("checked")int checked);

    List<StudentApplicationDomain> findall();
}
