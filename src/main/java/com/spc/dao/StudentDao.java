package com.spc.dao;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface StudentDao {

    public List<HashMap<String,String>> findClasses(@Param("stuId")Integer stuId);

    public int findNum(@Param("name") String name);

}
