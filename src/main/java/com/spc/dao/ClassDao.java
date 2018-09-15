package com.spc.dao;

import com.spc.model.ClassDomain;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ClassDao {

    void insert(ClassDomain record);

    void delete(@Param("classId") int classId);

    List<Map> findStudentClassTime(@Param("stuId") String stuId);

    Map findClassTimeById(@Param("classId") int classId);

    List<ClassDomain> selectClasses(@Param("departId") Integer departId, @Param("className") String className,
                                    @Param("teaName") String teaName, @Param("teaId") String teaId, @Param("startWeek") int startWeek,
                                    @Param("endWeek") int endWeek, @Param("hasWaiGuoYu") int hasWaiGuoYu,
                                    @Param("modelsId") int modelsId);

    int updateScore1(@Param("className") String className, @Param("classNum") int classNum,@Param("stuId") String stuId,
                    @Param("wlzzxxGrade") int wlzzxxGrade, @Param("knskGrade") int knskGrade);
    int updateScore2(@Param("className") String className,@Param("classNum") int classNum, @Param("stuId") String stuId,
                    @Param("xbsjGrade") int xbsjGrade);
    int updateScore3(@Param("className") String className,@Param("classNum") int classNum, @Param("stuId") String stuId,
                    @Param("xbsjGrade") int xbsjGrade ,@Param("wlzzxxGrade") int wlzzxxGrade, @Param("knskGrade") int knskGrade);

    List<HashMap<String, Object>> findCourseTable(@Param("teaId") String teaId);

    List<HashMap<String, Object>> findAllClasseSimpleMess(@Param("shenQingRenId") String shenQingRenId,@Param("shenQingRenName") String shenQingRenName,@Param("teaName")String teaName);

    int updateChooseNum(@Param("classId") int classId, @Param("num") int num);

    ClassDomain findClassById(@Param("classId") int classId);

    List haveStuInClass(@Param("classId")int  classId,@Param("stuId")String stuId);

}