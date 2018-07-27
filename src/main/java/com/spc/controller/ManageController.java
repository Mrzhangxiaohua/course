package com.spc.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spc.model.ClassDomain;
import com.spc.model.StudentApplicationDomain;
import com.spc.service.classes.ClassService;
import com.spc.service.manage.ManageService;
import com.spc.service.student.StudentService;
import com.spc.util.AuthMess;
import com.spc.util.RequestPayload;
import com.spc.view.ManageScorePdfView;
import com.spc.view.StudentTablePdfView;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Autowired
    private RequestPayload requestPayload;

    @Autowired
    private AuthMess authMess;


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
            @RequestParam(required = false, defaultValue = "") String mydate
            ){

        PageHelper.startPage(currentPage,pageSize);
        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
        List<StudentApplicationDomain> result = new ArrayList<>();
        if(!mydate.equals("")){
            try {
                Date date =new Date();
                date = fmt.parse(mydate);
                result = manageService.checkedMessageAndDate(tabKey,stuId,date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else {
            result = manageService.checkedMessage(tabKey,stuId);
        }
        System.out.println("==========-----------============");
        System.out.println(result.get(0).getMydate());

        Map<String,Object> res = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        map.put(Integer.toString(tabKey),result);
        map.put("total",((Page)result).getTotal());
        map.put("pageSize",pageSize);
        map.put("currentPage",currentPage);
        res.put("data",map);
        return res;
    }

    @RequestMapping(value = "/makeSure/application",method = RequestMethod.POST)
    @ResponseBody
    public int convertStatus(HttpServletRequest request){
        String json = requestPayload.getRequestPayload(request);
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
            Integer id = obj.getInt("id");
            return manageService.makeSure(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }
    @RequestMapping(value = "/reject/application",method = RequestMethod.POST)
    @ResponseBody
    public int rejectStatus(HttpServletRequest request){
        String json = requestPayload.getRequestPayload(request);
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
            Integer id = obj.getInt("id");
            return manageService.reject(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
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
