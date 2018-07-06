package com.spc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.spc.model.GradeDomain;
import com.spc.service.grade.GradeService;
import com.spc.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;



    @RequestMapping("/select/classes")
    @ResponseBody
    public String[][] selectClasses(){


//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String name =  authentication.getName();
//        System.out.printf("name%s",name);

//        Integer stuId = studentService.findNum(name);

        Integer stuId = 2018000001;
//        String[][] lis = studentService.findClasses(stuId);
//
//        System.out.println("run here");
//        StringBuilder str = new StringBuilder("[");
//        for(String[] sli : lis) {
//            try {
//                StringBuilder jsons =new StringBuilder(new ObjectMapper().writeValueAsString(sli));
//                str.append(jsons);
//                str.append(",");
//            } catch (Exception exception) {
//            }
//        }
//        str.deleteCharAt(str.length()-1);
//        str.append("]");
//        System.out.println(str);
        return studentService.findClasses(stuId);
    }



    @RequestMapping("/select/grade")
    @ResponseBody
    public List<GradeDomain> selectGrade(
            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize,
            @RequestParam(required = false,defaultValue = "88888888") Integer stuId,
            @RequestParam(required = false,defaultValue = "88888888") Integer classId){

        PageHelper.startPage(pageNum,pageSize);
        return gradeService.selectGrade(classId,stuId);

    }

}
