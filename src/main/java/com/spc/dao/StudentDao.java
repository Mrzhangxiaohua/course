package com.spc.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.annotation.Repeatable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentDao {


    public List<HashMap<String, Object>> findClasses(@Param("stuId") String stuId);

    public List<HashMap<String,Object>> findAllClassName();


    //添加该学生选择的课程
    public int addChooseCourse(@Param("stuId") String stuId, @Param("classId") int classId);

    public int deleteChooseCourse(@Param("stuId") String stuId, @Param("classId") int classId);

    public List findStudent( @Param("classId") int classId);

    public List<Map<String, Object>> getWaiStudyTime(@Param("stuId") String stuId);

    public List<Map<String, Object>> getNotWaiStudyTime(@Param("stuId") String stuId);

    public List<Map<String, Object>> findTimeChongTu(@Param("stuId") String stuId, @Param("classId") int classId);

    int addClassNum(@Param("stuId")String  stuId,@Param("classNum")int  classNum,@Param("className") String className);

    int deleteCourse(String className,String stuId);

    int findClassNewId(int  oldClassId,int classNum);

    Map<String,Object> findClassesByNameAndNum(@Param("className")String className,@Param("classNum") int classNum);

    int addComment(@Param("stuId") String stuId,@Param("teaId") String teaId, @Param("scores") String scores, @Param("words") String words);

    public List<Map<String, Object>> selectList(@Param("stuId") String stuId);

    Map<String,Object> findIsComment(@Param("stuId") String stuId);

    public List<Map<String, Object>> showTeacomment(@Param("stuId") String stuId);

    public List<Map<String, Object>> addCommentWeeklyTrue(@Param("stuId") String stuId);

    public int addCommentWeeklyFinal();

    public Map selectList1(@Param("stuId") String stuId);


}
