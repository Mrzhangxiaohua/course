package com.spc.dao;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentDao {

    public List<HashMap<String, Object>> findClasses(@Param("stuId") Integer stuId);

    public List<Map<String,Object>> findAllClassName();


    //添加该学生选择的课程
    public int addChooseCourse(@Param("stuId") Integer stuId, @Param("classId") Integer classId);

    public int deleteChooseCourse(@Param("stuId") Integer stuId, @Param("classId") Integer classId);

    public List findStudent( @Param("classId") Integer classId);

    public List<Map<String, Object>> getWaiStudyTime(@Param("stuId") int stuId);

    public List<Map<String, Object>> getNotWaiStudyTime(@Param("stuId") int stuId);

    public List<Map<String, Object>> findTimeChongTu(@Param("stuId") int stuId, @Param("classId") int classId);

    int addClassNum(@Param("stuId")int  stuId,@Param("classNum")int  classNum,@Param("className") String className);

    int deleteCourse(String className,int stuId);

    int findClassNewId(int  oldClassId,int classNum);

    Map<String,Object> findClassesByNameAndNum(@Param("className")String className,@Param("classNum") int classNum);

}
