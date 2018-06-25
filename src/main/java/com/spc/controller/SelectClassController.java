package com.spc.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.spc.model.ClassDomain;
import com.spc.service.classes.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/select")
public class SelectClassController {
    @Autowired
    private ClassService classService;



    @RequestMapping("/classes")
    public List<ClassDomain> selectClassed(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize,
            @RequestParam(name = "depart", required = false, defaultValue = "")
                    String depart,
            @RequestParam(name = "classname", required = false, defaultValue = "")
                    String classname,
            Model model){
        //开始分页
        PageHelper.startPage(pageNum,pageSize);
        List<ClassDomain> classes = classService.findAllClass(pageNum,pageSize,depart,classname);
        System.out.println(classes);
        model.addAttribute("classes",classes);
//        String str = "[";
//        for(ClassDomain sli : classes) {
//            try {
//                String jsons = new ObjectMapper().writeValueAsString(sli);
//                str += jsons;
//                str += ",";
//            } catch (Exception exception) {
//            }
//        }
//        str = str.substring(0,str.length()-1);
//        str +="]";
//        System.out.println(str);

        return classes;

    }

}
