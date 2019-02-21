package com.spc.ser;

import com.spc.service.teacher.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/2/19 21:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class servic {
    @Autowired
    public TeacherService teacherService;

    @Test
    public void testTable(){
        teacherService.findCourseTable("0002017115");
    }
}
