package com.spc.dao;


import org.apache.ibatis.annotations.Param;

public interface ClassAllDao {

    int insertFirstClass(@Param("departId") int departId, @Param("courseNameCHS") String courseNameCHS,
                         @Param("classModuleNum") int classModuleNum, @Param("classTime") int classTime,
                         @Param("teaId") String teaId, @Param("teaName") String teaName,
                         @Param("courseId") String courseId, @Param("className") String className);


}