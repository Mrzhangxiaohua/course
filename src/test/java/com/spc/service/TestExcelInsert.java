package com.spc.service;

import com.spc.dao.FileInfoDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestExcelInsert {
    @Autowired
    FileInfoDao fileInfoDao;

    @Test
    public void testExcel(){
    Map<String, Object> info= (Map<String, Object>) fileInfoDao.selectGradeExcel(18).get(0);
        System.out.println( info.get("fileName"));
    }

}
