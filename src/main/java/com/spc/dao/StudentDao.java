package com.spc.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface StudentDao {

    public List<HashMap<String,String>> findClasses(@Param("stuId")Integer stuId);

    public int findNum(@Param("name") String name);

    //添加该学生选择的课程
    @Insert("insert into Course_choose(stuId, classId,score) values(#{stuId}, #{classId},0)")
    public int addChooseCourse(@Param("stuId") Integer stuId, @Param("classId") Integer classId);
}
