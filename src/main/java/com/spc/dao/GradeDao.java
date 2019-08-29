package com.spc.dao;

import com.spc.model.GradeDomain;
import com.spc.model.GradePercent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Repository
public interface GradeDao {
    public int insert(GradeDomain gradeDomain);

    public List<GradeDomain> selectGrade(@Param("classId") Integer classId, @Param("stuId") String stuId);

    Integer addScore(@Param("stuId") String stuId, @Param("classId") Integer classId, @Param("score") Integer score);

    List selectGetTitle();

    int updateGrade(@Param("classId")int classId,@Param("stuId") String stuId,@Param("grade") float grade);

    List<Map<String, Object>> getModelGrade(@Param("stuId") String stuId);

    int updateKnskGrade(@Param("JXBID")String JXBID,@Param("stuId") String stuId,@Param("grade") float grade);

    List<Map<String, Object>> findAllStudent(@Param("academicYear") String academicYear,@Param("depId") int depId,@Param("stuId") String stuId);

    List<Map<String, Object>> findStuById(@Param("stuId") String stuId);

    void updateWlzzScore(@Param("stuId") String stuId,@Param("grade") Float grade,@Param("status") int status);

    void updateDektScore(@Param("stuId") String stuId,@Param("grade") Float grade,@Param("status") int status);

    void updateNlcsScore(@Param("stuId") String stuId,@Param("grade") Float grade,@Param("status") int status);

    void insertStu(@Param("stuId") String stuId,@Param("academicYear") String academicYear);

    List<Map<String, Object>> findWlzzIsGrade(@Param("academicYear") String academicYear);

    List<Map<String, Object>> findDektIsGrade(@Param("academicYear") String academicYear);

    List<Map<String, Object>> findNlcsIsGrade(@Param("academicYear") String academicYear);

    List<Map<String, Object>> findXbsjStudents(@Param("classId") int classId);

    List<Map<String, Object>> findKnskStudents(@Param("classId") String classId);

    void updateXbsjChecked(@Param("classId") int classId,@Param("stuId") String stuId,@Param("isChecked")int isChecked);

    void updateKnskChecked(@Param("classId") String classId,@Param("stuId") String stuId,@Param("isChecked")int isChecked);

   void  updateXbsjSubmit(@Param("classId") int classId);

    void updateKnskSubmit(@Param("classId") String classId);

    List<Map<String, Object>> findAllScore(@Param("academicYear") String academicYear,@Param("departId") int departId, @Param("stuId") String stuId);

    void uploadAllGradeKnsk(@Param("stuId") String stuId,@Param("grade") float grade);

    void uploadAllGradeXbsj(@Param("stuId") String stuId,@Param("grade") float grade);

    void uploadAllGradeOther1(@Param("stuId") String stuId,@Param("grade") Float grade);

    void uploadAllGradeOther2(@Param("stuId") String stuId,@Param("grade") Float grade);

    void uploadAllGradeOther3(@Param("stuId") String stuId,@Param("grade") Float grade);

    Map<String, Object> findGradePercent(@Param("stuType") int stuType);

    void updateWlzzIsSubmit();

    void updateDektIsSubmit();

    void updateNlcsIsSubmit();

    int findStuType(@Param("stuId") String stuId);

    void updateSumGrade(@Param("stuId") String stuId,@Param("grade") Float grade);
}
