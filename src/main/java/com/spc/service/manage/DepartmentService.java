package com.spc.service.manage;

import com.spc.model.IceSelectDataSource;

import java.util.List;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2018-12-30 19:26
 **/
public interface DepartmentService {
    List<IceSelectDataSource> getDepartments();
}
