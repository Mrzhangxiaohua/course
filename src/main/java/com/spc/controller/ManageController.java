package com.spc.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spc.model.*;
import com.spc.service.classes.ClassService;
import com.spc.service.manage.ClassAllService;
import com.spc.service.manage.CourseAllService;
import com.spc.service.manage.ManageService;
import com.spc.util.RequestPayload;
import com.spc.util.ResponseWrap;
import com.spc.view.ManageScorePdfView;
import com.spc.view.StudentTablePdfView;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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
public class ManageController extends Base {

    @Autowired
    private ClassService classService;

    @Autowired
    private ManageService manageService;

    @Autowired
    ClassAllService classAllService;

    @Autowired
    CourseAllService courseAllService;
    /**
     * 学生端：根据学生id查询课表
     *
     * @param stuId 学生id
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
     * @param currentPage       ：当前页码
     * @param pageSize          ： 页面大小
     * @return Map<String   ,       Object>
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
            @RequestParam(required = false, defaultValue = "") String shenQingRenName,
            @RequestParam(required = false, defaultValue = "88888888") Integer tabKey
    ) {
        PageHelper.startPage(currentPage, pageSize);

        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        List<ClassApplicationDomain> result = new ArrayList<>();
        if (!mydate.equals("")) {
            try {
                Date date = new Date();
                date = fmt.parse(mydate);
                result = manageService.checkedClassMessageAndDate(shenQingRenId, className, date, tabKey, shenQingRenName);
            } catch (ParseException e) {
                System.out.println(e);
            }
        } else {
            result = manageService.checkedClassMessage(shenQingRenId, className, tabKey, shenQingRenName);
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

    @RequestMapping("/checked/classAppMessage2")
    @ResponseBody
    public Map<String, Object> checkedClassAppMessage2(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false, defaultValue = "") String mydate,
            @RequestParam(required = false, defaultValue = "") String className,
            @RequestParam(required = false, defaultValue = "") String shenQingRenId,
            @RequestParam(required = false, defaultValue = "") String shenQingRenName
    ) {
        PageHelper.startPage(currentPage, pageSize);

        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        List<ClassApplicationDomain> result = new ArrayList<>();
        if (!mydate.equals("")) {
            try {
                Date date = new Date();
                date = fmt.parse(mydate);
                result = manageService.checkedClassMessageAndDate(shenQingRenId, className, date, 1, shenQingRenName);
            } catch (ParseException e) {
                System.out.println(e);
            }
        } else {
            result = manageService.checkedClassMessage(shenQingRenId, className, 1, shenQingRenName);
        }
        System.out.println(result);
        Map<String, Object> res = new HashMap<>();
        Map<String, Object> map = new HashMap<>();

        map.put("list", result);
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
        String json = RequestPayload.getRequestPayload(request);
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

    /**
     * 确认了老师开课申请
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/makeSure/classApplication", method = RequestMethod.POST)
    @ResponseBody
    public int convertClassStatus(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);
        System.out.println(json);
        System.out.println(request.getSession().getAttribute("departId"));
        int departId= (int) request.getSession().getAttribute("departId");
        System.out.println(departId);
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
            Integer id = obj.getInt("id");
            String courseId=obj.getString("classId");
            manageService.makeSureClassApplication(id,courseId,departId);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @RequestMapping(value = "/makeSure/applications", method = RequestMethod.POST)
    @ResponseBody
    public int convertS(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);
        JSONObject obj = null;
        try {
            JSONArray Jarray = new JSONArray(json);
            for (int i = 0; i < Jarray.length(); i++) {
                obj = Jarray.getJSONObject(i);
                Integer id = obj.getInt("id");
                String className = obj.getString("className");
                manageService.makeSure(id, className);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    /*一键审核*/
    @RequestMapping(value = "/makeSure/classApplications", method = RequestMethod.POST)
    @ResponseBody
    public int convertClassApplications(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);
        int departId= Integer.parseInt((String) request.getSession().getAttribute("departId"));
        JSONObject obj = null;
        try {
            JSONArray Jarray = new JSONArray(json);
            for (int i = 0; i < Jarray.length(); i++) {
                obj = Jarray.getJSONObject(i);
                System.out.println("提交的实体是" + obj);
                Integer id = obj.getInt("id");
                String courseId=obj.getString("courseId");
                manageService.makeSureClassApplication(id,courseId,departId);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    /**
     * 拒绝学生改课申请
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/reject/application", method = RequestMethod.POST)
    @ResponseBody
    public int rejectStatus(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);
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

    /**
     * 拒绝老师开课申请
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/reject/classApplication", method = RequestMethod.POST)
    @ResponseBody
    public int rejectClassStatus(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);
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

    @RequestMapping(value = "/reject/classApplications", method = RequestMethod.POST)
    @ResponseBody
    public int rejectClasses(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);
        JSONObject obj = null;
        try {
            JSONArray Jarray = new JSONArray(json);
            for (int i = 0; i < Jarray.length(); i++) {
                obj = Jarray.getJSONObject(i);
                System.out.println("提交的实体是" + obj);
                Integer id = obj.getInt("id");
                manageService.rejectClassApplication(id);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    /**
     * 管理员端查询课程
     *
     * @return
     */
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

    /**
     * 根据课程classStr下载学生名单
     *
     * @param classStr
     * @return
     */
    @RequestMapping("/download/tableExcel")
    public void downloadTableExcel(
            @RequestParam(required = false, defaultValue = "") String classStr,
            HttpServletResponse response,
            HttpSession session
    ) {
        Map<String, Object> model = new HashMap<>();

//        String newStr = classStr.replace("(", ",").replace(")", "");
//        String[] strs = newStr.substring(0, newStr.length() - 1).split(",");

        if(classStr!=""){
//            String className = strs[0];
//            Integer classNum = Integer.parseInt(strs[1]);

//            int classId = manageService.getClassId(className, classNum);

//            List students = classService.findStudent(classId);
            List students = classService.findStudent(Integer.parseInt(classStr));
            Map m = classService.findClassInfo(classStr);
            String className = (String) m.get("className");
            Integer classNum = (Integer) m.get("classNum");

            List<StudentExcelDomain> liC = new ArrayList<>();

            for (int i = 0; i < students.size(); i = i + 1) {
                Map<String, String> t = (Map<String, String>) students.get(i);
                liC.add(new StudentExcelDomain(t.get("stuName"), t.get("stuId"), t.get("departName"), t.get("speciality"), t.get("tutoremployeeid"),t.get("wlzzxxGrade")==null?"":String.valueOf(t.get("wlzzxxGrade")), t.get("knskGrade")==null?"":String.valueOf(t.get("knskGrade")), t.get("xbsjGrade")==null?"":String.valueOf(t.get("xbsjGrade")) ));
            }


            response = ResponseWrap.setName(response, className + String.valueOf(classNum) + "班人名单", "xls");

            ExportParams params = new ExportParams();
            params.setTitle(className + String.valueOf(classNum) + "班人名单");

            Workbook workbook = ExcelExportUtil.exportExcel(params, StudentExcelDomain.class, liC);

            try {
                workbook.write(response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 根据课程classStr下载学生名单
     *
     * @param classStr
     * @return
     */
    @RequestMapping("/download/table")
    public ModelAndView downloadTable(
            @RequestParam(required = true, defaultValue = "") String classStr,
            HttpServletResponse response,
            HttpSession session
    ) {
        Map<String, Object> model = new HashMap<>();
        try {
//                String newStr = classStr.replace("(", ",").replace(")", "");
//                String[] strs = newStr.substring(0, newStr.length() - 1).split(",");
//
//                String className = strs[0];
//                Integer classNum = Integer.parseInt(strs[1]);
//
//                int classId = manageService.getClassId(className, classNum);

//                List students = classService.findStudent(classId);
            List students = classService.findStudent(Integer.parseInt(classStr));
            Map m = classService.findClassInfo(classStr);
            String className = (String) m.get("className");
            Integer classNum = (Integer) m.get("classNum");

            Map<String, Object> res = new HashMap<String, Object>();

            res.put("data", students);
            model.put("res", res);
            model.put("style", "wider");
            model.put("name", classStr);
            response = ResponseWrap.setName(response, className + String.valueOf(classNum) + "班人名单", "pdf");

        } catch (Exception e) {
            System.out.println(e);
        }
        return new ModelAndView(new ManageScorePdfView(), model);
    }


    /**
     * 管理端：下载大课表
     *
     * @return
     */
    @RequestMapping("/download/bigTable")
    public ModelAndView downloadTable(
            @RequestParam(required = false, defaultValue = "") String shenQingRenId,
            @RequestParam(required = false, defaultValue = "") String shenQingRenName,
            @RequestParam(required = false, defaultValue = "") String teaName,
            HttpServletResponse response,
            HttpSession session
    ) {
        Integer departId = (Integer) session.getAttribute("departId");
//        Integer departId = 5;
        String role = (String) session.getAttribute("userRole");
        if (role.equals("超级管理员")){
            departId = 88888888;
        }
        String[][] strs = manageService.bigTable(shenQingRenId, shenQingRenName, teaName, departId);
        Map<String, Object> res = new HashMap<String, Object>();

        res.put("data", strs);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style", "wider");
        model.put("student", 0);
        String fileName = teaName == "" ? "all" : teaName;

        response = ResponseWrap.setName(response, fileName + "的课表", "pdf");
        return new ModelAndView(new StudentTablePdfView(), model);
    }

    /**
     * 管理端：下载大课表.excel 格式
     *
     * @return
     */
    @RequestMapping("/download/bigTableExcel")
    public void downloadTableExcel(
            @RequestParam(required = false, defaultValue = "") String shenQingRenId,
            @RequestParam(required = false, defaultValue = "") String shenQingRenName,
            @RequestParam(required = false, defaultValue = "") String teaName,
            HttpServletResponse response,
            HttpSession session
    ){

        Integer departId = (Integer) session.getAttribute("departId");

        String role = (String) session.getAttribute("userRole");
        if (role.equals("超级管理员")){
            departId = 88888888;
        }
        String[][] tables = manageService.bigTable(shenQingRenId, shenQingRenName, teaName, departId);
        List<CourseTableExcelDomain> liC = new ArrayList<>();
        for (int i = 0; i < tables.length; i = i + 2) {
            liC.add(new CourseTableExcelDomain(i / 2, tables[i][0], tables[i][1], tables[i][2], tables[i][3]
                    , tables[i][4], tables[i][5], tables[i][6]));
        }

        response = ResponseWrap.setName(response, (teaName==""?"所有老师":teaName)+"的课表","xls");

        ExportParams params = new ExportParams();
        params.setTitle("课表");

        Workbook workbook = ExcelExportUtil.exportExcel(params, CourseTableExcelDomain.class, liC);

        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 添加课程
     *
     * @return
     */
//    @RequestMapping(value = "/add/course", method = RequestMethod.POST)
//    @ResponseBody
//    public int addCourse(@RequestBody ClassDomain cd ) {
//        cd.setClassDateDescription(cd.getClassDateDescriptionA() + ":" + cd.getClassDateDescriptionB());
//        cd.setClassChooseNum(0);
//        manageService.addCourse(cd);
//        return 0;
//    }
    @RequestMapping(value = "/add/course", method = RequestMethod.POST)
    @ResponseBody
    public int addCourse(@RequestBody ClassDomainWithId cdwi) {
        cdwi.setClassDateDescription(cdwi.getClassDateDescriptionA() + ":" + cdwi.getClassDateDescriptionB());
        cdwi.setClassChooseNum(0);
        int id = cdwi.getId();
        if (id != 0) {
            manageService.deleteApplication(id);
        }
        manageService.addCourse(cdwi);
        return 0;
    }

    @RequestMapping(value = "/delete/course", method = RequestMethod.POST)
    @ResponseBody
    public int deleteCourse(@RequestBody ClassDomain cd) {
        manageService.deleteCourseRecord(cd.getClassId());
        return 0;
    }

    @Transactional
    @RequestMapping("/update/course")
    @ResponseBody
    public int updateCourse(@RequestBody ClassDomain cd) {
//        System.out.println(cd.getClassDateDescriptionA());
//        System.out.println(cd.getClassDateDescriptionB());
        cd.setClassDateDescription(cd.getClassDateDescriptionA() + ":" + cd.getClassDateDescriptionB());
        manageService.deleteCourseRecord(cd.getClassId());
//        System.out.println(cd.getClassId());
        manageService.addCourse(cd);
        return 0;
    }

    @RequestMapping("/get/bigTable")
    @ResponseBody
    public String[][] getBigTable(
            @RequestParam(required = false, defaultValue = "") String shenQingRenId,
            @RequestParam(required = false, defaultValue = "") String shenQingRenName,
            @RequestParam(required = false, defaultValue = "") String teaName,
            HttpSession session) {
        Integer departId = (Integer) session.getAttribute("departId");

        String role = (String) session.getAttribute("userRole");
        if (role.equals("超级管理员")){
            departId = 88888888;
        }
        String[][] strs = manageService.bigTable(shenQingRenId, shenQingRenName, teaName, departId);
        return strs;
    }

    /**
     * 管理端：给相应的班级添加学生
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/add/courseStudent", method = RequestMethod.POST)
    @ResponseBody
    public int addCourseStudent(HttpServletRequest request) {
        logger.info("==============runinhere=============");
        String json = RequestPayload.getRequestPayload(request);
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
            String stuId = obj.getString("stuId");
            logger.info("==============runinhere=============" + stuId);
            logger.info(json);
            String classId = obj.getString("classId");
            logger.info("==============runinhere=============" + classId);

//            System.out.println("===============" + stuId + "===============" + classId);
//            String classStr = obj.getString("classStr");
            manageService.addCourseStudent(stuId, classId);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @RequestMapping(value = "/delete/courseStudent", method = RequestMethod.POST)
    @ResponseBody
    public int deleteCourseStudent(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
            String stuId = obj.getString("stuId");
            String classStr = obj.getString("classStr");
            String classId = obj.getString("classId");
            System.out.println(stuId + classStr + classId);
            manageService.deleteCourseStudent(stuId, classId);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }


    /**
     * 通过班级名称以及班次查询学生
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/find/student")
    @ResponseBody
    public Map<String, Object> findStudentByClassnameAndNum(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false, defaultValue = "") String classId,
            @RequestParam(required = false, defaultValue = "") String stuId,
            HttpSession session
    ) {
        List students = new ArrayList();
        if (stuId.equals("")){
            if (!classId.equals("") && !classId.isEmpty()) {
//                String newStr = classStr.replace("(", ",").replace(")", "");
//                String[] strs = newStr.substring(0, newStr.length() - 1).split(",");
//
//                String className = strs[0];
//                Integer classNum = Integer.parseInt(strs[1]);

//                students = manageService.findStudentByClassnameAndNum(className, classNum, pageSize, currentPage);
                students = manageService.findStudentByClassnameAndNum(classId, pageSize, currentPage);

                List newStus = zhuanhuan(students);

                putSession(session,students);

                logger.info("find student result:%s", newStus);
                Map<String, Object> res = new HashMap<>();
                res.put("status", "SUCCESS");

                Map<String, Object> data = new HashMap<>();
                data.put("total", ((Page) students).getTotal());
                data.put("pageSize", pageSize);
                data.put("currentPage", currentPage);
                data.put("list", newStus);
                res.put("data", data);
                return res;
            }
        }else if (!stuId.equals("")){
                String studentId = stuId;
                students = manageService.findStudentByStudentId(pageSize, currentPage, stuId);
                List newStus = zhuanhuan(students);/////
                putSession(session,students);

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
        return null;
    }

    private int putSession(HttpSession session,List<HashMap> students){
        Map scoreMap = (Map) session.getAttribute("updatescore");
        scoreMap.clear();
        for(HashMap li:students){
            String className = (String) li.get("className");

            String stuId = (String) li.get("stuId");
            int classNum = (int) li.get("classNum");

            int xbsjGrade = (int) li.get("xbsjGrade");
            int knskGrade = (int) li.get("knskGrade");
            int wlzzxxGrade = (int) li.get("wlzzxxGrade");

            Map tempM = new HashMap();
            tempM.put("wlzzxxGrade", wlzzxxGrade);
            tempM.put("knskGrade", knskGrade);
            tempM.put("xbsjGrade", xbsjGrade);

            scoreMap.put(className + ":" + classNum + ":" + stuId, tempM);
        }
        return 0;
    }

    List zhuanhuan(List<Map<String, Object>> students) {
        for (Map li : students) {
            li.put("classStr", li.get("className") + "(" + li.get("classNum") + "班)");
        }
        return students;
    }

    @RequestMapping(value = "/time/switch", method = RequestMethod.POST)
    @ResponseBody
    public int timeSwitch(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);
        System.out.println(json);
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
            JSONObject sts = obj.getJSONObject("params").getJSONObject("values");
            Integer timeSwitch = sts.getInt("timeSwitch");

            manageService.updateTimeSwitch(timeSwitch);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @RequestMapping(value = "/time/switch2", method = RequestMethod.POST)
    @ResponseBody
    public int timeSwitch2(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);
        System.out.println(json);
        try {
            JSONArray Jarray = new JSONArray(json);

            for (int i = 0; i < Jarray.length(); i++) {
                String startDate = (String) Jarray.get(0);
                String endDate = (String) Jarray.get(1);
                manageService.updateTimeSwitch2(startDate,endDate);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @RequestMapping(value="/time/switch3",method=RequestMethod.POST)
    @ResponseBody
    public int timeSwithch3(HttpServletRequest request){
        String json= RequestPayload.getRequestPayload(request);
        System.out.println(json);
        try {
            JSONObject jsonObject=new JSONObject(json);
            String firstWeek=jsonObject.getString("time");
            String year=firstWeek.split("-")[0];
            Map<String,String> semesterMap=new HashMap<>();
            semesterMap.put("spring","春");
            semesterMap.put("autumn","秋");
            String semester=year+semesterMap.get(jsonObject.getString("semester"));
            System.out.println(year);
            System.out.println(firstWeek);
            System.out.println(semester);
            manageService.addSchoolCalendar(year,firstWeek,semester);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @RequestMapping("/jilian/select")
    @ResponseBody
    public List<Map> jilianSelect() {
        return manageService.jilianSelect();
    }

    @RequestMapping(value="/uploadTemplate")
    @ResponseBody
    public String uploadTemplate(HttpServletRequest request, @RequestParam("file") MultipartFile file){
        String teaId=(String)request.getSession().getAttribute("userId");
        String dep=(String)request.getSession().getAttribute("dep");
        System.out.println(file);

        try {
            if (file.isEmpty()) {
                return "文件为空";
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            logger.info("上传的文件名为：" + fileName);
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            logger.info("文件的后缀名为：" + suffixName);
            // 设置文件存储路径
            String filePath=request.getSession().getServletContext().getRealPath(File.separator)+"/file/";
            String path = filePath+fileName;
            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date=sdf.format(new Date());
            manageService.addTemplateFileInfo(teaId,fileName,filePath,1,dep,date,1);
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    /*
    * 超级管理员设置成绩比例
    * */
    @RequestMapping("/setGradePercent")
    @ResponseBody
    public String setGradePercent(HttpServletRequest request){
        String userId= (String) request.getSession().getAttribute("userId");
        String jsonString = RequestPayload.getRequestPayload(request);
        try {
            JSONObject json=new JSONObject(jsonString);
            System.out.println("json"+json);
            JSONObject valuejson = json.getJSONObject("value");
            int XBSJ= (int) valuejson.get("XBSJ");
            int ZZXX= (int) valuejson.get("ZZXX");
            int KNSK= (int) valuejson.get("KNSK");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date=sdf.format(new Date());
            manageService.addGradePercent(KNSK,XBSJ,ZZXX,userId,date);
        return "设置成功";
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "设置失败";
    }

    /*
     *超级管理员查看往年课程目录
     *
     */
    @RequestMapping("/findCourseAll")
    @ResponseBody
    public Map<String,Object> findCourseAll(@RequestParam("year")String year,@RequestParam("depId")int depId){
        Map<String,Object> res=new HashMap<>();
        List<CourseAll> courseAllList=courseAllService.getCourseAllByYearAndDep(year,depId);
        res.put("year",year);
        res.put("depId",depId);
        res.put("courseAllList",courseAllList);
        return res;
    }


    /*
     *超级管理员修改往年课程目录
     */
    @RequestMapping("/modifyCourseAll")
    @ResponseBody
    public  String modifyCourseAll(@RequestBody CourseAll courseAll,HttpServletRequest request){
        String userId= (String) request.getSession().getAttribute("userId");
        String username= (String) request.getSession().getAttribute("username");
        int flag=courseAllService.ModifyCourseAll(courseAll,userId,username);
        if(flag!=0){
            return "修改成功!";
        }
        return "修改失败！";
    }
    /*
     *超级管理员修订学年课程目录
     */
    @RequestMapping("/addYearCourseAll")
    @ResponseBody
    public String addYearCourseAll(HttpServletRequest request){
        String userId= (String) request.getSession().getAttribute("userId");
        String username= (String) request.getSession().getAttribute("username");
        String jsonString = RequestPayload.getRequestPayload(request);
        JSONObject json= null;
        try {
            json = new JSONObject(jsonString);
            System.out.println("json"+json);
            List<CourseAll> courseList= (List<CourseAll>) json.get("courseList");
            String year= (String) json.get("year");
            int flag=courseAllService.addYearCourseAll(courseList,userId,username,year);
            if(flag!=0){
                return "新增成功！";
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "新增失败！";
    }
    /*
     *超级管理员新增学年课程目录时，从courseApplication表中导入申请开课和直接新增的课程
     */
    @RequestMapping("/findCourseApplication")
    @ResponseBody
    public List<CourseApplication> findCourseApp(HttpServletRequest request){

        List<CourseApplication> courseAppList=courseAllService.findAllCourseApp();
        return courseAppList;
    }

}


