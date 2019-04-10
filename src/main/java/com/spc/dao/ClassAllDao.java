package com.spc.dao;

import com.spc.model.ClassAll;
import com.spc.model.CourseAll;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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
                                  @Param("courseId") String courseId,
                                  @Param("courseName") String courseName,
                                  @Param("teacherId") String teacherId,
                                  @Param("teacherName") String teacherName,
                                  @Param("classPlaceId") String classPlaceId,
                                  @Param("selectDepartId") String selectDepartId);

    List<ClassAll> selectClassAllExcludeId(@Param("academicYear") String academicYear,
                                           @Param("classSemester") String classSemester,
                                           @Param("instructorId") String instructorId,
                                           @Param("classPlaceId") String classPlaceId,
                                           @Param("scheduled") Integer scheduled,
                                           @Param("id") Integer id);

    int insertFirstClass(@Param("departId") int departId, @Param("courseNameCHS") String courseNameCHS,
                         @Param("classModuleNum") int classModuleNum, @Param("classTime") int classTime,
                         @Param("teaId") String teaId, @Param("teaName") String teaName,
                         @Param("courseId") String courseId, @Param("className") String className);


    int countClassAllByClassNameExcludeId(@Param("academicYear") String academicYear,
                                          @Param("classSemester") String classSemester,
                                          @Param("courseId") String courseId,
                                          @Param("schoolDistrictId") Integer schoolDistrictId,
                                          @Param("className") String className,
                                          @Param("id") Integer id);

    int updateClass(@Param("classAll") ClassAll classAll);

    int insertClass(ClassAll classAll);

    ClassAll selectClassAllById(@Param("id") int id);

    int delClassAllById(@Param("id") int id);

    int clearClassAllById(@Param("id") int id, @Param("operatorId") String operatorId, @Param("operatorName") String operatorName);

    List<Map<String, Object>> selectAllDepart(@Param("academicYear")String academicYear,@Param("classSemester") String classSemester);

    List<Map<String,Object>> selectOneDimClassAll(@Param("departId") int departId,@Param("academicYear")String academicYear,@Param("classSemester") String classSemester);

    List<Map<String,Object>> selectOneDimRoomClassAll(@Param("roomName") String roomName,@Param("academicYear")String academicYear,@Param("classSemester") String classSemester);

    List<Map<String, Object>> selectAllRoom(@Param("academicYear")String academicYear,@Param("classSemester") String classSemester);

    List<ClassAll> selectRoomClassAll(@Param("roomName") String roomName,
                                  @Param("academicYear") String academicYear,
                                  @Param("classSemester") String classSemester,
                                  @Param("courseId") String courseId,
                                  @Param("courseName") String courseName,
                                  @Param("teacherId") String teacherId,
                                  @Param("teacherName") String teacherName,
                                  @Param("classPlaceId") String classPlaceId,
                                  @Param("selectDepartId") String selectDepartId);

    void updateStuNumUpperLimit(@Param("classAllId") int classAllId, @Param("stuNumUpperLimit") int stuNumUpperLimit);

    int addFirstClass(CourseAll courseAll);

    List<Map<String, Object>> getKnskCourse(@Param("academicYear") String academicYear);
}
