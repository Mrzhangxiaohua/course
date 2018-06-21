package com.spc.controller;

import com.github.pagehelper.PageHelper;
import com.spc.model.ClassDomain;
import com.spc.service.classes.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @RequestMapping("/all")
    public String findAllClassed(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize,
            Model model){
        //开始分页
        PageHelper.startPage(pageNum,pageSize);
        List<ClassDomain> classes = classService.findAllClass(pageNum,pageSize);

        model.addAttribute("classes",classes);
        System.out.println(classes);
        return "class/showAll";
    }

}
