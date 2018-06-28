package com.spc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spc.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/data/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/select")
    public StringBuilder selectClasses(
            @RequestParam(name = "stuId", required = false) int stuId){
        System.out.println(stuId);

        List<HashMap<String,String>> lis = studentService.findClasses(stuId);

        System.out.println("run heree");
        StringBuilder str = new StringBuilder("[");
        for(HashMap sli : lis) {
            try {
                StringBuilder jsons =new StringBuilder(new ObjectMapper().writeValueAsString(sli));
                str.append(jsons);
                str.append(",");
            } catch (Exception exception) {
            }
        }
        str.deleteCharAt(str.length()-1);
        str.append("]");
        System.out.println(str);
        return str;

    }
}
