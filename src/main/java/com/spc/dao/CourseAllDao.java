package com.spc.dao;

import com.spc.model.CourseAll;
import com.spc.model.CourseApplication;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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

    int findCourseAppCount(@Param("twoYear")String twoYear);

    List<Map<String, Object>> findAppByTeaId(@Param("userId") String teaId);

    List<CourseApplication> findAllApp();
}
