package com.spc.dao;

import com.spc.model.ClassroomInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomInfoDao {

    List<ClassroomInfo> selectAll(@Param("schoolDistrictId") String schoolDistrictId,
                                  @Param("classroomName") String classroomName);
}
