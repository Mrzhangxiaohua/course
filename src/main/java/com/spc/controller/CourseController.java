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

/**
 * 这个类提供课程管理的路由。
 *
 * @author yuhongchao
 * @version 1.0
 */
@RequestMapping("/select")
@RestController
public class CourseController {
    @Autowired
    private ClassService classService;

    @Autowired
    private CourseDateTrans courseDateTrans;

    /**
     * 根据院系以及课程名称，老师名称查询课程
     *
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @param departId 院系id
     * @param classname 课程名称
     * @param teaId 教师id
     * @param model 课程所属模块
     * @return Map<String, Object>
     */
    @RequestMapping("/classes")
    @ResponseBody
    public Map<String, Object> selectClasses(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false, defaultValue = "88888888") int departId,
            @RequestParam(required = false, defaultValue = "") String classname,
            @RequestParam(required = false, defaultValue = "88888888") int teaId,
            Model model) {

        PageHelper.startPage(currentPage, pageSize);
        List<ClassDomain> classes = classService.findAllClass(departId, classname, teaId, 88888888, 88888888);
        System.out.println(classes);
        if(classes !=null){
            for (ClassDomain l : classes) {
                System.out.println(l.getClassDateDescription());

                String[] d = l.getClassDateDescription().split(":");
                int a = Integer.parseInt(d[0]);
                int b = Integer.parseInt(d[1]);
                l.setClassDateDescription(new String(courseDateTrans.dateToString(a, b)));
            }
        }
        Map<String, Object> res = new HashMap<>();
        res.put("status", "SUCCESS");

        Map<String, Object> data = new HashMap<>();
        data.put("total", ((Page) classes).getTotal());
        System.out.printf("total = %s\n", ((Page) classes).getTotal());
        data.put("pageSize", pageSize);
        data.put("currentPage", currentPage);
        data.put("list", classes);
        res.put("data", data);
        return res;
    }


}
