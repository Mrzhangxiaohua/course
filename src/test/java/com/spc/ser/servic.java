package com.spc.ser;

import com.spc.service.classes.ClassService;
import com.spc.service.teacher.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

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

    @Autowired
    public ClassService classService;

    @Test
    public void testTable(){
        teacherService.findCourseTable("0002017115");
    }

    @Test
    public void testFindStudent(){
        classService.findStudent(Integer.parseInt("247"));
        Map m = classService.findClassInfo("247");

        String className = (String) m.get("className");
        Integer classNum = (Integer) m.get("classNum");
        System.out.println(String.valueOf(classNum));
    }

}
