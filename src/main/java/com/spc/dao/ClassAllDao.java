package com.spc.dao;

import com.spc.model.ClassAll;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description ClassAllDao
 * @create 2018-12-28 20:32
 **/
@Repository
public interface ClassAllDao {
    List<ClassAll> selectClassAll(@Param("departId") Integer departId,
                                  @Param("academicYear") String academicYear,
                                  @Param("classSemester") String classSemester,
                                  @Param("courseName") String courseName,
                                  @Param("teacherId") String teacherId,
                                  @Param("teacherName") String teacherName,
                                  @Param("classPlaceId") String classPlaceId);
}
