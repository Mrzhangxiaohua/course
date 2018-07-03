package com.spc.controller;

import com.spc.model.ClassDomain;
import com.spc.service.classes.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/select")
public class ClassController {
    @Autowired
    private ClassService classService;

    @RequestMapping("/classes")
    @ResponseBody
    public Map<String, Object> selectClassed(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false, defaultValue = "") String depart,
            @RequestParam(required = false, defaultValue = "") String classname,
            Model model) {
        List<ClassDomain> classes = classService.findAllClass(currentPage, pageSize, depart, classname);

        Map<String, Object> res = new HashMap<>();
        res.put("status","SUCCESS");

        Map<String, Object> data = new HashMap<>();
        data.put("total", classes.size());
        data.put("pageSize", pageSize);
        data.put("currentPage", currentPage);

        if (currentPage == 1) {
            data.put("list", classes.subList(0, Math.min(10, classes.size())));
        } else {
            data.put("list", classes.subList(10,20));
        }

        res.put("data", data);

        return res;
    }


}
