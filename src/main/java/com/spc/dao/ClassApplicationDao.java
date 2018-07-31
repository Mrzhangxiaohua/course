package com.spc.dao;

import com.spc.model.ClassApplicationDomain;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ClassApplicationDao {
    //添加开课申请
    int add(ClassApplicationDomain cas);

    // 找到所有满足要求的开课申请
    List<ClassApplicationDomain> findall(@Param("shenQingRenId") int shenQingRenId, @Param("className") String className, @Param("tabKey") int tabKey);

    List<ClassApplicationDomain> findallWithDate(@Param("shenQingRenId") int shenQingRenId, @Param("className") String className, @Param("date") Date date, @Param("tabKey") int tabKey);

    int checkedClass(@Param("id") int id, @Param("checked") int checked);

    List<Map<String,Object>> findByTeaId(@Param("teaId") int teaId);

}
