package com.spc.dao;

import com.spc.model.ClassDomain;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface ClassDao {

    void insert(ClassDomain record);

    void delete(@Param("classId") int classId);

    List<ClassDomain> selectClasses(@Param("departId") Integer departId, @Param("className") String className,
                                    @Param("teaName") String teaName, @Param("teaId") int teaId, @Param("startWeek") int startWeek,
                                    @Param("endWeek") int endWeek, @Param("hasWaiGuoYu") int hasWaiGuoYu);

    int updateScore(@Param("className") String className, @Param("stuId") int stuId,
                    @Param("score") int score);

    List<HashMap<String, Object>> findCourseTable(@Param("teaId") Integer teaId);

    List<HashMap<String, Object>> findAllClasseSimpleMess();

    int updateChooseNum(@Param("classId") int classId, @Param("num") int num);


}