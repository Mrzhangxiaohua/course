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

    List<ClassAll> selectClassAllExcludeId(@Param("academicYear") String academicYear,
                                           @Param("classSemester") String classSemester,
                                           @Param("instructorId") String instructorId,
                                           @Param("classPlaceId") String classPlaceId,
                                           @Param("id") Integer id);

    int insertFirstClass(@Param("departId") int departId, @Param("courseNameCHS") String courseNameCHS,
                         @Param("classModuleNum") int classModuleNum, @Param("classTime") int classTime,
                         @Param("teaId") String teaId, @Param("teaName") String teaName,
                         @Param("courseId") String courseId, @Param("className") String className);


    int countClassAllByClassName(@Param("academicYear") String academicYear,
                                 @Param("classSemester") String classSemester,
                                 @Param("courseId") String courseId,
                                 @Param("schoolDistrictId") Integer schoolDistrictId,
                                 @Param("className") String className);

    int updateClass(@Param("classAll") ClassAll classAll);

    int insertClass(@Param("classAll") ClassAll classAll);

    ClassAll selectClassAllById(@Param("id") int id);

    int delClassAllById(@Param("id") int id);

    int clearClassAllById(@Param("id") int id, @Param("operatorId") String operatorId, @Param("operatorName") String operatorName);
}
