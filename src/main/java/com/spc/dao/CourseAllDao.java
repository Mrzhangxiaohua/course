package com.spc.dao;

import com.spc.model.CourseAll;
import com.spc.model.CourseApplication;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface CourseAllDao {

    int insertCourse(@Param("departId") int departId, @Param("className") String className,
                     @Param("classModuleNum") int classModuleNum, @Param("classTime") int classTime,
                     @Param("teaId") String teaId, @Param("teaName") String teaName,
                     @Param("courseInfo") String courseInfo, @Param("teacherInfo") String teacherInfo,
                     @Param("courseId") String courseId);

    CourseAll selectCourseAll(@Param("courseId") String courseId);

    CourseAll selectCourseAllWithParams(@Param("courseId") String courseId,
                                        @Param("academicYear") String academicYear,
                                        @Param("classSemester") String classSemester);

    List<CourseAll> selectCourseAllByYearAndDep(@Param("year") String year, @Param("depId")int depId);

    int updateCourseAll(CourseAll courseAll);

    int insertYearCourse(CourseAll courseAll);

    int insertCourseApp(CourseApplication courseApp);

    List<Map<String,Object>> selectCourseApp(@Param("date") String date, @Param("operatorId") String operatorId,
                                             @Param("operatorName") String operatorName, @Param("departId") int departId);

    int updateCourseAppflag(@Param("courseAppId")int courseAppId,@Param("result") int result,@Param("courseId")String courseId);

    int findCourseCount(@Param("yearDepart")String yearDepart);

    List<Map<String, Object>> findAppByTeaId(@Param("userId") String teaId);

    List<CourseApplication> findAllAppByDate(@Param("operatorName")String operatorName,
                                       @Param("operatorId")String operatorId,@Param("operateDate") String operateDate,@Param("tabKey") int tabKey,
                                             @Param("departId") String departId,@Param("type") int type);

    List<CourseApplication> findAllApp(@Param("operatorName")String operatorName,
                                       @Param("operatorId")String operatorId,@Param("tabKey")int tabKey,
                                       @Param("departId") String departId,@Param("type") int type);

    List<CourseApplication> findById(@Param("id")Integer id);

    int insertPassApp(CourseAll courseApp);

    List<Map<String,Object>> findCourseAll(@Param("academicYear")String academicYear,
                                           @Param("courseId") String courseId,
                                           @Param("courseName") String courseName,
                                           @Param("departId") int departId);

    List selectCourseYear();

    int delete(@Param("id") Integer id);

    List<CourseAll> findCourseAllById(@Param("id") int id);

    int updateFlag(@Param("academicYear")String academicYear);

    List<CourseAll> findNotSure(@Param("academicYear")String academicYear);

    List<CourseApplication> selectDepartCourseApp(@Param("departId") int departId,
                                                  @Param("academicYear") String academicYear,@Param("courseId") String courseId,@Param("courseName") String courseName);

    int deleteCourseApp(@Param("id")int id);

    int updateCourseApp(CourseApplication ca);

    List<CourseApplication> findAppByYear(@Param("academicYear")String academicYear,@Param("departId")int departId);

    int selectFlag();

    int updateCourseAllFlag(@Param("flag")int flag);

    int updateAppCheck(CourseApplication ca);

    List<Map<String, Object>> selectAllDepart(@Param("academicYear")String academicYear);

    List<Map<String, Object>> findByYearAndDepart(@Param("academicYear")String academicYear,@Param("departId") int departId);

    int deleteCourseAllByAppId(@Param("id") Integer id);
}
