package com.spc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spc.model.ClassDomain;
import com.spc.service.classes.ClassService;
import com.spc.util.CourseDateTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/select")
@RestController
public class CourseController {
    @Autowired
    private ClassService classService;

    @Autowired
    private CourseDateTrans courseDateTrans;

    /**
     * 根据院系以及课程名称，老师名称查询课程
     * @param currentPage
     * @param pageSize
     * @param departId
     * @param classname
     * @param teaId
     * @param model
     * @return
     */
    @RequestMapping("/classes")
    @ResponseBody
    public Map<String, Object> selectClassed(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false, defaultValue = "88888888") int departId,
            @RequestParam(required = false, defaultValue = "") String classname,
            @RequestParam(required = false, defaultValue = "88888888") int teaId,
            Model model) {

        PageHelper.startPage(currentPage,pageSize);
        List<ClassDomain> classes = classService.findAllClass(departId, classname , teaId);


        for(ClassDomain l:classes){
            String[] d = l.getClassDateDescription().split(":");
            int a = Integer.parseInt(d[0]);
            int b = Integer.parseInt(d[1]);
            l.setClassDateDescription(new String(courseDateTrans.dateToString(a,b)));
        }
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
