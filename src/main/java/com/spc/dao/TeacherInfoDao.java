package com.spc.dao;

import com.spc.model.TeacherInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2018-12-30 14:36
 **/
@Repository
public interface TeacherInfoDao {
    List<TeacherInfo> selectAll(@Param("departId") Integer departId, @Param("teacherName") String teacherName);

    List<TeacherInfo> selectByTeacherIds(List<String> teacherIds);

    String selectTeaName(@Param("teaId")String teaId);
}
