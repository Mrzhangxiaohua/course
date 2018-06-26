package com.spc.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spc.model.ClassDomain;
import com.spc.service.classes.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/select")
public class SelectClassController {
    @Autowired
    private ClassService classService;

    @ResponseBody
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
//        Page<ClassDomain> page =PageHelper.startPage(pageNum,pageSize);

        List<ClassDomain> classes = classService.findAllClass(pageNum,pageSize,depart,classname);
        System.out.println(classes.size());
//        System.out.println(page.getStartRow());
//        System.out.println(page.getPageSize());
//        System.out.println(page.getEndRow());
//        System.out.println(page.getPageNum());

        return classes;

    }

}
