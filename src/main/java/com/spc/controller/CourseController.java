package com.spc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spc.model.ClassDomain;
import com.spc.service.classes.ClassService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/select")
@RestController
public class CourseController {
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
        PageHelper.startPage(currentPage,pageSize);
        List<ClassDomain> classes = classService.findAllClass(depart, classname);

        Map<String, Object> res = new HashMap<>();
        res.put("status","SUCCESS");

        Map<String, Object> data = new HashMap<>();
        data.put("total", ((Page)classes).getTotal());
        System.out.printf("total = %s\n",((Page)classes).getTotal());
        data.put("pageSize", pageSize);
        data.put("currentPage", currentPage);
        data.put("list", classes);
        res.put("data", data);
        return res;
    }


}
