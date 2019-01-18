package com.spc.service.manage.impl;

import com.spc.dao.SchoolDistrictDao;
import com.spc.model.IceSelectDataSource;
import com.spc.model.SchoolDistrict;
import com.spc.service.manage.SchoolDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2018-12-29 20:48
 **/
@Service
public class SchoolDistrictServiceImpl implements SchoolDistrictService {

    @Autowired
    private SchoolDistrictDao schoolDistrictDao;

    @Override
    public List<IceSelectDataSource> getAllSchoolDistricts() {
        List<SchoolDistrict> schoolDistricts = schoolDistrictDao.selectAll();
        List<IceSelectDataSource> dataSource = new ArrayList<>();
        if (!schoolDistricts.isEmpty()) {
            for (SchoolDistrict schoolDistrict: schoolDistricts) {
                dataSource.add(new IceSelectDataSource(schoolDistrict.getId().toString(), schoolDistrict.getName()));
            }
        }

        return dataSource;
    }
}
