package com.spc.dao;

import com.spc.model.StudentApplicationDomain;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StudentApplicationDao {

    int add(@Param("stuId")Integer stuId,@Param("classId")Integer classId,  @Param("states")Integer  states,@Param("reason")String  reason,@Param("checked")int checked);

    List<StudentApplicationDomain> findall(@Param("key")Integer key,@Param("stuId")Integer  stuId);
    List<StudentApplicationDomain> findallWithDate(@Param("key")Integer key,@Param("stuId")Integer  stuId,@Param("date")Date  date);

    int checked(@Param("id")int id,@Param("checked")int checked);
}
