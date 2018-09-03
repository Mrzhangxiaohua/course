package com.spc.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spc.model.ClassApplicationDomain;
import com.spc.model.ClassDomain;
import com.spc.model.StudentApplicationDomain;
import com.spc.service.classes.ClassService;
import com.spc.service.manage.ManageService;
import com.spc.util.RequestPayload;
import com.spc.view.ManageScorePdfView;
import com.spc.view.StudentTablePdfView;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 这个类提供管理端的路由。
 *
 * @author yuhongchao
 * @version 1.0
 */
@RequestMapping("/manage")
@Controller
public class ManageController {


    @Autowired
    private ClassService classService;

    @Autowired
    private ManageService manageService;

    @Autowired
    private RequestPayload requestPayload;

    /**
     * 学生端：根据学生id查询课表
     *
     * @param stuId 学生id
     * @return String[][] 类型的课表
     */
    @RequestMapping("/select/classes")
    @ResponseBody
    public String[][] manageFindClasses(
            @RequestParam(required = false, defaultValue = "") String stuId
    ) {
        String[][] res = manageService.findClasses(stuId);
        return res;
    }

    /**
     * 查询学生提交的改课申请
     *
     * @param tabKey：所要查询的申请的状态
     * @param currentPage ：当前页码
     * @param pageSize ： 页面大小
     * @return Map<String, Object>
     */
    @RequestMapping("/checked/message")
    @ResponseBody
    public Map<String, Object> checkedMessage(
            @RequestParam(required = false, defaultValue = "88888888") int tabKey,
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false, defaultValue = "") String stuId,
            @RequestParam(required = false, defaultValue = "") String mydate
    ) {
        PageHelper.startPage(currentPage, pageSize);
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        List<StudentApplicationDomain> result = new ArrayList<>();
        if (!mydate.equals("")) {
            try {
                Date date = new Date();
                date = fmt.parse(mydate);
                result = manageService.checkedMessageAndDate(tabKey, stuId, date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            result = manageService.checkedMessage(tabKey, stuId);
        }
        Map<String, Object> res = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        map.put(Integer.toString(tabKey), result);
        map.put("total", ((Page) result).getTotal());
        map.put("pageSize", pageSize);
        map.put("currentPage", currentPage);
        res.put("data", map);
        return res;
    }

    /**
     * 教师端：审核开课申请的信息。
     *
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @param mydate      日期
     * @param className   课程名称
     * @return 查询结果
     */
    @RequestMapping("/checked/classAppMessage")
    @ResponseBody
    public Map<String, Object> checkedClassAppMessage(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false, defaultValue = "") String mydate,
            @RequestParam(required = false, defaultValue = "") String className,
            @RequestParam(required = false, defaultValue = "") String shenQingRenId,
            @RequestParam(required = false, defaultValue = "88888888") Integer tabKey
    ) {
        PageHelper.startPage(currentPage, pageSize);
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        List<ClassApplicationDomain> result = new ArrayList<>();
        if (!mydate.equals("")) {
            try {
                Date date = new Date();
                date = fmt.parse(mydate);
                result = manageService.checkedClassMessageAndDate(shenQingRenId, className, date, tabKey);
            } catch (ParseException e) {
                System.out.println(e);
            }
        } else {
            result = manageService.checkedClassMessage(shenQingRenId, className, tabKey);
        }
        System.out.println(result);
        Map<String, Object> res = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        if (tabKey == 88888888) {
            map.put("list", result);
        } else {
            map.put(Integer.toString(tabKey), result);
        }
        map.put("total", ((Page) result).getTotal());
        map.put("pageSize", pageSize);
        map.put("currentPage", currentPage);

        res.put("data", map);
        return res;
    }


    /**
     * 管理端：审核通过学生的改课申请
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/makeSure/application", method = RequestMethod.POST)
    @ResponseBody
    public int convertStatus(HttpServletRequest request) {
        String json = requestPayload.getRequestPayload(request);
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
            Integer id = obj.getInt("id");
            String className = obj.getString("className");
            return manageService.makeSure(id, className);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @RequestMapping(value = "/makeSure/classApplication", method = RequestMethod.POST)
    @ResponseBody
    public int convertClassStatus(HttpServletRequest request) {
        String json = requestPayload.getRequestPayload(request);
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
            Integer id = obj.getInt("id");
            return manageService.makeSureClassApplication(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @RequestMapping(value = "/reject/application", method = RequestMethod.POST)
    @ResponseBody
    public int rejectStatus(HttpServletRequest request) {
        String json = requestPayload.getRequestPayload(request);
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
            Integer id = obj.getInt("id");
            return manageService.reject(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @RequestMapping(value = "/reject/classApplication", method = RequestMethod.POST)
    @ResponseBody
    public int rejectClassStatus(HttpServletRequest request) {
        String json = requestPayload.getRequestPayload(request);
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
            Integer id = obj.getInt("id");
            return manageService.rejectClassApplication(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @RequestMapping("/find/classes")
    @ResponseBody
    public List<Map> getAllCourse() {
        List<ClassDomain> classes = classService.findAllClass(88888888, "", "", 88888888, 88888888);
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
    public ModelAndView downloadTable(HttpServletResponse response,HttpServletRequest request,
                                      @RequestParam(required = false, defaultValue = "") String classStr
    ) {
        System.out.println(classStr);
        Map<String, Object> model = new HashMap<>();
        try {
            String newStr = classStr.replace("(",",").replace(")","");
            String[] strs = newStr.substring(0,newStr.length()-1).split(",");

            System.out.println(newStr);
            String className = strs[0];
            Integer classNum = Integer.parseInt(strs[1]);

            int classId = manageService.getClassId(className,classNum);

            System.out.printf("classId %d", classId);
            List students = classService.findStudent(classId);
            Map<String, Object> res = new HashMap<String, Object>();

            res.put("data", students);
            model.put("res", res);
            model.put("style", "wider");

        }catch (Exception e){
            System.out.println(e);
        }
        return new ModelAndView(new ManageScorePdfView(), model);
    }

    @RequestMapping("/download/bigTable")
    public ModelAndView downloadTable() {
        String[][] strs = manageService.bigTable();
        Map<String, Object> res = new HashMap<String, Object>();

        res.put("data", strs);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style", "wider");
        return new ModelAndView(new StudentTablePdfView(), model);
    }

    @RequestMapping(value = "/add/course", method = RequestMethod.POST)
    @ResponseBody
    public int addCourse(@RequestBody ClassDomain cd) {
        cd.setClassDateDescription(cd.getClassDateDescriptionA() + ":" + cd.getClassDateDescriptionB());
        cd.setClassChooseNum(0);
        System.out.println(cd.getClassDateDescription());
        System.out.println(cd.getMainLecturer());
        manageService.addCourse(cd);
        return 0;
    }

    @RequestMapping(value = "/delete/course", method = RequestMethod.POST)
    @ResponseBody
    public int deleteCourse(@RequestBody ClassDomain cd) {
        manageService.deleteCourseRecord(cd.getClassId());
        return 0;
    }

    @RequestMapping("/update/course")
    @ResponseBody
    public int updateCourse(@RequestBody ClassDomain cd) {
        System.out.println(cd.getClassDateDescriptionA());
        System.out.println(cd.getClassDateDescriptionB());
        cd.setClassDateDescription(cd.getClassDateDescriptionA() + ":" + cd.getClassDateDescriptionB());
        manageService.deleteCourseRecord(cd.getClassId());
        System.out.println(cd.getClassId());
        manageService.addCourse(cd);
        return 0;
    }

    @RequestMapping("/get/bigTable")
    @ResponseBody
    public String[][] getBigTable() {
        return manageService.bigTable();
    }

    /**
     * 管理端：给相应的接口添加学生
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/add/courseStudent", method = RequestMethod.POST)
    @ResponseBody
    public int addCourseStudent(HttpServletRequest request) {
        System.out.println("run addCourseStudent");
        String json = requestPayload.getRequestPayload(request);
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
            System.out.println(obj);
            String stuId = obj.getString("stuId");
//            String stuName = obj.getString("stuName");
            String classStr = obj.getString("classStr");
            manageService.addCourseStudent(stuId, classStr);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @RequestMapping(value = "/delete/courseStudent", method = RequestMethod.POST)
    @ResponseBody
    public int deleteCourseStudent(HttpServletRequest request) {
        String json = requestPayload.getRequestPayload(request);
        JSONObject obj = null;
        try {
            System.out.println("==================");
            obj = new JSONObject(json);
            System.out.println(obj);
            String stuId = obj.getString("stuId");
            String classStr = obj.getString("classStr");
            manageService.deleteCourseStudent(stuId, classStr);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @RequestMapping("/find/student")
    @ResponseBody
    public Map<String, Object> findStudentByClassnameAndNum(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false, defaultValue = "") String classStr
    ) {
        List students = new ArrayList();
        System.out.println(classStr);
        if (!classStr.equals("") && !classStr.isEmpty()) {
            String newStr = classStr.replace("(", ",").replace(")", "");
            String[] strs = newStr.substring(0, newStr.length() - 1).split(",");

            System.out.println(strs);
            String className = strs[0];
            Integer classNum = Integer.parseInt(strs[1]);

            students = manageService.findStudentByClassnameAndNum(className, classNum, pageSize, currentPage);

            List newStus = zhuanhuan(students);
            System.out.printf("find student result:%s", newStus);
            Map<String, Object> res = new HashMap<>();
            res.put("status", "SUCCESS");

            Map<String, Object> data = new HashMap<>();
            data.put("total", ((Page) students).getTotal());
            data.put("pageSize", pageSize);
            data.put("currentPage", currentPage);
            data.put("list", newStus);
            res.put("data", data);
            return res;
        } else {
            Map<String, Object> res = new HashMap<>();
            res.put("status", "SUCCESS");
            Map<String, Object> data = new HashMap<>();
            data.put("total", 0);
            data.put("pageSize", pageSize);
            data.put("currentPage", currentPage);
            data.put("list", students);
            res.put("data", data);
            return res;
        }
    }

    List zhuanhuan(List<Map<String,Object>> students){
        for (Map li :students){
            li.put("classStr",li.get("className")+"("+li.get("classNum")+"班)");
        }
        return students;
    }
}
