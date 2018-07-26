package com.spc.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spc.model.ClassDomain;
import com.spc.model.StudentApplicationDomain;
import com.spc.service.classes.ClassService;
import com.spc.service.manage.ManageService;
import com.spc.service.student.StudentService;
import com.spc.view.ManageScorePdfView;
import com.spc.view.StudentTablePdfView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RequestMapping("/manage")
@Controller
public class ManageController {

    @Autowired
    private StudentService studentService;


    @Autowired
    private ClassService classService;

    @Autowired
    private ManageService manageService;




    @RequestMapping("/select/classes")
    @ResponseBody
    public String[][] manageFindClasses(
            @RequestParam(required = false, defaultValue = "88888888") Integer stuId
    ) {
        String[][] res = manageService.findClasses(stuId);

        return res;
    }

    /**
     * 查询所有的审核情况
     * @param tabKey
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/checked/message")
    @ResponseBody
    public Map<String,Object> checkedMessage(
            @RequestParam(required = false,defaultValue = "88888888") int tabKey,
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false, defaultValue = "88888888") int stuId,
            @RequestParam(required = false, defaultValue = "") Date date
            ){

        PageHelper.startPage(currentPage,pageSize);

        List<StudentApplicationDomain> result = manageService.checkedMessage(tabKey,stuId,date);

        Map<String,Object> res = new HashMap<>();

        Map<String,Object> map = new HashMap<>();
        map.put(Integer.toString(tabKey),result);
        map.put("total",((Page)result).getTotal());
        map.put("pageSize",pageSize);
        map.put("currentPage",currentPage);
        res.put("data",map);
        return res;
    }

    @RequestMapping("/find/classes")
    @ResponseBody
    public List<Map> getAllCourse() {
        List<ClassDomain> classes = classService.findAllClass(88888888, "", 88888888,88888888,88888888);
        List<Map> resList = new ArrayList<Map>();
        for (int i = 0; i < classes.size(); i++) {
            Map<String, Object> res = new HashMap<>();
            res.put("className", classes.get(i).getClassName());
            res.put("classId", classes.get(i).getClassId());
            resList.add(res);
        }
        return resList;
    }

    @RequestMapping("/download/table")
    public ModelAndView downloadTable(HttpServletResponse response,
                                      @RequestParam(required = false,defaultValue = "") String className,
                                      @RequestParam(required = false,defaultValue = "88888888") Integer classId
    ){
        System.out.printf("classId %d",classId);
        List students = classService.findStudent(className,classId);
        Map<String,Object> res = new HashMap<String, Object>();

        res.put("data", students);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style","wider");
        return new ModelAndView(new ManageScorePdfView(), model);
    }

    @RequestMapping("/download/bigTable")
    public ModelAndView downloadTable(){
        String[][] strs = manageService.bigTable();
        Map<String,Object> res = new HashMap<String, Object>();

        res.put("data", strs);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style","wider");
        return new ModelAndView(new StudentTablePdfView(), model);

    }
}
