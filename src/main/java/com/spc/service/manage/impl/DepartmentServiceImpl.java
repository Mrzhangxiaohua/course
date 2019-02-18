package com.spc.service.manage.impl;

import com.spc.dao.DepartmentDao;
import com.spc.model.Department;
import com.spc.model.IceSelectDataSource;
import com.spc.service.manage.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2018-12-30 19:27
 **/
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<IceSelectDataSource> getDepartments() {
        List<Department> departments = departmentDao.selectAll();
        List<IceSelectDataSource> dataSource = new ArrayList<>();
        if (!departments.isEmpty()) {
            for (Department department: departments) {
                dataSource.add(new IceSelectDataSource(department.getDepartId().toString(), department.getDepartName()));
            }
        }
        return dataSource;
    }
}
