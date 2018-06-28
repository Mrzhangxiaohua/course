package com.spc.service.student.impl;

import com.spc.controller.StudentController;
import com.spc.dao.StudentDao;
import com.spc.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service(value = "studentService")
public class StudentServiceImpl  implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<HashMap<String,String>> findClasses(int stuId) {
        return studentDao.findClasses(stuId);
    }
}
