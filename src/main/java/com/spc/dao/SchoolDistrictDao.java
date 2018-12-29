package com.spc.dao;

import com.spc.model.SchoolDistrict;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description SchoolDistrictDao
 * @create 2018-12-29 20:42
 **/
@Repository
public interface SchoolDistrictDao {
    List<SchoolDistrict> selectAll();
}
