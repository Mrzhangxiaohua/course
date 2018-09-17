package com.spc.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spc.model.*;
import com.spc.service.classes.ClassService;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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


    /**
     * 学生端：根据学生id查询课表
     *
     * @param stuId 学生id
     * @return String[][]
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

    @RequestMapping(value = "/makeSure/classApplications", method = RequestMethod.POST)
    @ResponseBody
    public int convertClassApplications(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);
        JSONObject obj = null;
        try {
            JSONArray Jarray = new JSONArray(json);
            for (int i = 0; i < Jarray.length(); i++) {
                obj = Jarray.getJSONObject(i);
                System.out.println("提交的实体是" + obj);
                Integer id = obj.getInt("id");
                manageService.makeSureClassApplication(id);
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

        String newStr = classStr.replace("(", ",").replace(")", "");
        String[] strs = newStr.substring(0, newStr.length() - 1).split(",");

        String className = strs[0];
        Integer classNum = Integer.parseInt(strs[1]);

        int classId = manageService.getClassId(className, classNum);

        List students = classService.findStudent(classId);


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

    /**
     * 根据课程classStr下载学生名单
     *
     * @param classStr
     * @return
     */
    @RequestMapping("/download/table")
    public ModelAndView downloadTable(
            @RequestParam(required = false, defaultValue = "") String classStr,
            HttpServletResponse response,
            HttpSession session
    ) {
        Map<String, Object> model = new HashMap<>();
        try {

            String newStr = classStr.replace("(", ",").replace(")", "");
            String[] strs = newStr.substring(0, newStr.length() - 1).split(",");

            String className = strs[0];
            Integer classNum = Integer.parseInt(strs[1]);

            int classId = manageService.getClassId(className, classNum);

//            System.out.printf("classId %d", classId);
            List students = classService.findStudent(classId);
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
        String[][] strs = manageService.bigTable(shenQingRenId, shenQingRenName, teaName);
        Map<String, Object> res = new HashMap<String, Object>();

        res.put("data", strs);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style", "wider");
        model.put("student", 1);
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
        String[][] tables = manageService.bigTable(shenQingRenId, shenQingRenName, teaName);
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
            @RequestParam(required = false, defaultValue = "") String teaName) {
        return manageService.bigTable(shenQingRenId, shenQingRenName, teaName);
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
//        System.out.println("run addCourseStudent");
        String json = RequestPayload.getRequestPayload(request);
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
            String stuId = obj.getString("stuId");
            System.out.println("===============" + stuId);
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
        String json = RequestPayload.getRequestPayload(request);
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
            String stuId = obj.getString("stuId");
            String classStr = obj.getString("classStr");
            manageService.deleteCourseStudent(stuId, classStr);
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
     * @param classStr
     * @return
     */
    @RequestMapping("/find/student")
    @ResponseBody
    public Map<String, Object> findStudentByClassnameAndNum(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false, defaultValue = "") String classStr,
            HttpSession session
    ) {
        List students = new ArrayList();
        if (!classStr.equals("") && !classStr.isEmpty()) {
            String newStr = classStr.replace("(", ",").replace(")", "");
            String[] strs = newStr.substring(0, newStr.length() - 1).split(",");

            String className = strs[0];
            Integer classNum = Integer.parseInt(strs[1]);

            students = manageService.findStudentByClassnameAndNum(className, classNum, pageSize, currentPage);

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
//        JSONObject obj = null;
        try {
//            obj = new JSONObject(json);
//            JSONObject sts = obj.getJSONObject("params").getJSONObject("values");
//            JSONObject timeSwitchArray = sts.getJSONObject("timeSwitch2");
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


    @RequestMapping("/jilian/select")
    @ResponseBody
    public List<Map> jilianSelect() {
        return manageService.jilianSelect();
    }

}
