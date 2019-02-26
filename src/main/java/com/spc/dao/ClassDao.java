package com.spc.dao;

import com.spc.model.ClassDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface ClassDao {


    ClassDomain findCourseByIdForUpdate(@Param("classId") Integer courseId);

    List<Map> kaiKe(@Param("departId") Integer departId, @Param("classSemester") String classSemester);

    int insert(ClassDomain record);

    void delete(@Param("classId") int classId);

    void deleteByClassAllId(@Param("classAllId") int id);

    Map getClassId(@Param("classAllId") int id);

    List<Map> findStudentClassTime(@Param("stuId") String stuId, @Param("classSemester") String classSemester);

    Map findClassTimeById(@Param("classId") int classId);

    List<ClassDomain> selectClasses(@Param("departId") Integer departId, @Param("className") String className,
                                    @Param("teaName") String teaName, @Param("teaId") String teaId, @Param("startWeek") int startWeek,
                                    @Param("endWeek") int endWeek, @Param("hasWaiGuoYu") int hasWaiGuoYu,
                                    @Param("modelsId") int modelsId, @Param("classNum") int classNum
            , @Param("classChooseNum") int classChooseNum);

    int updateScore1(@Param("className") String className, @Param("classNum") int classNum, @Param("stuId") String stuId,
                     @Param("wlzzxxGrade") int wlzzxxGrade, @Param("knskGrade") int knskGrade);

    int updateScore2(@Param("className") String className, @Param("classNum") int classNum, @Param("stuId") String stuId,
                     @Param("xbsjGrade") int xbsjGrade);

    int updateScore3(@Param("className") String className, @Param("classNum") int classNum, @Param("stuId") String stuId,
                     @Param("xbsjGrade") int xbsjGrade, @Param("wlzzxxGrade") int wlzzxxGrade, @Param("knskGrade") int knskGrade);

    List<HashMap<String, Object>> findCourseTable(@Param("teaId") String teaId, @Param("semester") String semester);

    List<HashMap<String, Object>> findAllClasseSimpleMess(@Param("shenQingRenId") String shenQingRenId, @Param("shenQingRenName") String shenQingRenName, @Param("teaName") String teaName, @Param("departId") Integer departId);

    int updateChooseNum(@Param("classId") int classId, @Param("num") int num);

    ClassDomain findClassById(@Param("classId") int classId);

    List haveStuInClass(@Param("classId") int classId, @Param("stuId") String stuId);

    List<Map<String, Object>> findClasses(@Param("departId") Integer departId, @Param("className") String className,
                                          @Param("teaName") String teaName, @Param("teaId") String teaId, @Param("startWeek") int startWeek,
                                          @Param("endWeek") int endWeek, @Param("hasWaiGuoYu") int hasWaiGuoYu,
                                          @Param("modelsId") int modelsId, @Param("classNum") int classNum
            , @Param("classChooseNum") int classChooseNum);


    List<Map<String, Object>> findWeekCourses(@Param("teaId") String teaId, @Param("semester") String semester, @Param("weekth") String weekth);

    Map<String, Object> currentCalendar();

    int weekCourseStatus(Object classId);

    int findCommentNumber(String classId);

    List<Map<String, Object>> findWeekComment(@Param("stuId") String stuId, @Param("weekth") int weekth, @Param("classId") String classId);

    int zzGrade(@Param("className") String className, @Param("classNum") int classNum, @Param("stuId") String stuId,
                @Param("zzGrade") int zzGrade, @Param("flag") int flag);

    List<Map<String, Object>> findTeachCourse(@Param("teacherId") String teacherId);

    Map findClassInfo(@Param("classStr") String classStr);
}