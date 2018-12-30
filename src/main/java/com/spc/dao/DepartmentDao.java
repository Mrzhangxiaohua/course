package com.spc.dao;

import com.spc.model.Department;

import java.util.List;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2018-12-30 19:25
 **/
public interface DepartmentDao {
    List<Department> selectAll();
}
