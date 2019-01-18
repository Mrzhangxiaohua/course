package com.spc.dao;

import com.spc.model.StudentApplicationDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentApplicationDao {

    int add(@Param("stuId") String stuId, @Param("classId") Integer classId, @Param("states") Integer states, @Param("reason") String reason, @Param("checked") int checked
    ,@Param("classNum") int classNum);

    List<StudentApplicationDomain> findall(@Param("key") Integer key, @Param("stuId") String stuId);

    List<StudentApplicationDomain> findallWithDate(@Param("key") Integer key, @Param("stuId") String stuId, @Param("date") Date date);

    int checked(@Param("id") int id, @Param("checked") int checked);

    StudentApplicationDomain selectById(@Param("id") int id);

}
