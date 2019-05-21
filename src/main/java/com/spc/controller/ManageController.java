package com.spc.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spc.model.*;
import com.spc.service.classes.ClassService;
import com.spc.service.grade.GradeService;
import com.spc.service.manage.ClassAllService;
import com.spc.service.manage.CourseAllService;
import com.spc.service.manage.ManageService;
import com.spc.service.teacher.TeacherService;
import com.spc.util.RequestPayload;
import com.spc.util.ResponseWrap;
import com.spc.view.*;
//import com.sun.org.apache.xpath.internal.operations.Lt;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.net.URLEncoder;

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
    private GradeService gradeService;

    @Autowired
    private TeacherService teacherService;

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
     * 超级管理员端：审核开课申请的信息。
     *
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @param mydate      日期
     * @return 查询结果
     */
    @RequestMapping("/checked/classAppMessage")
    @ResponseBody
    public Map<String, Object> checkedClassAppMessage(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false, defaultValue = "") String mydate,
            @RequestParam(required = false, defaultValue = "") String operatorId,
            @RequestParam(required = false, defaultValue = "") String operatorName,
            @RequestParam(required = false, defaultValue = "") String departId,
            @RequestParam(required = false, defaultValue = "0") int type,
            @RequestParam(required = false, defaultValue = "0") int tabKey
    ) throws ParseException {
        PageHelper.startPage(currentPage, pageSize);
        List<CourseApplication> result=null;
        if (!mydate.equals("")) {
            result = courseAllService.findAllCourseApp(operatorId, operatorName, mydate,tabKey,departId,type);
        }else{
            result= courseAllService.findAllCourseApp(operatorId, operatorName,tabKey,departId, type);
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
     * 超级管理员端：审核开课申请。
     * post:
     *  ids  idList
     * result   审核结果，1代表通过，2代表拒绝
     * @return 更改结果
     */
    @RequestMapping("/checkCourseApp")
    @ResponseBody
    public String checkCourseApp( HttpServletRequest request){
        String username= (String) request.getSession().getAttribute("username");
        String userId= (String) request.getSession().getAttribute("userId");
        String json = RequestPayload.getRequestPayload(request);
        try {
            JSONObject obj = new JSONObject(json);
            int result=obj.getInt("result");
            JSONArray idArray=obj.getJSONArray("ids");
            List<Integer> idList=new ArrayList();
            for(int i=0;i<idArray.length();i++){
                idList.add((Integer) idArray.get(i));
            }
            courseAllService.checkCourseApp(idList,result,username,userId);
        } catch (Exception e) {
            e.printStackTrace();
            return "审核失败！";
        }

        return "审核成功！";
    }

//    @RequestMapping("/checked/classAppMessage2")
//    @ResponseBody
//    public Map<String, Object> checkedClassAppMessage2(
//            @RequestParam(required = false, defaultValue = "1") int currentPage,
//            @RequestParam(required = false, defaultValue = "10") int pageSize,
//            @RequestParam(required = false, defaultValue = "") String mydate,
//            @RequestParam(required = false, defaultValue = "") String className,
//            @RequestParam(required = false, defaultValue = "") String shenQingRenId,
//            @RequestParam(required = false, defaultValue = "") String shenQingRenName
//    ) {
//        PageHelper.startPage(currentPage, pageSize);
//
//        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
//        List<ClassApplicationDomain> result = new ArrayList<>();
//        if (!mydate.equals("")) {
//            try {
//                Date date = new Date();
//                date = fmt.parse(mydate);
//                result = manageService.checkedClassMessageAndDate(shenQingRenId, className, date, 1, shenQingRenName);
//            } catch (ParseException e) {
//                System.out.println(e);
//            }
//        } else {
//            result = manageService.checkedClassMessage(shenQingRenId, className, 1, shenQingRenName);
//        }
//        System.out.println(result);
//        Map<String, Object> res = new HashMap<>();
//        Map<String, Object> map = new HashMap<>();
//
//        map.put("list", result);
//        map.put("total", ((Page) result).getTotal());
//        map.put("pageSize", pageSize);
//        map.put("currentPage", currentPage);
//
//        res.put("data", map);
//        return res;
//    }

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

//    /**
//     * 确认了老师开课申请
//     *
//     * @param request
//     * @return
//     */
//    @RequestMapping(value = "/makeSure/classApplication", method = RequestMethod.POST)
//    @ResponseBody
//    public int convertClassStatus(HttpServletRequest request) {
//        String json = RequestPayload.getRequestPayload(request);
//        System.out.println(json);
//        System.out.println(request.getSession().getAttribute("departId"));
//        int departId= (int) request.getSession().getAttribute("departId");
//        System.out.println(departId);
//        JSONObject obj = null;
//        try {
//            obj = new JSONObject(json);
//            Integer id = obj.getInt("id");
//            String courseId=obj.getString("classId");
//            manageService.makeSureClassApplication(id,courseId,departId);
//            return 1;
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return 0;
//    }

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
//    @RequestMapping(value = "/reject/classApplication", method = RequestMethod.POST)
//    @ResponseBody
//    public int rejectClassStatus(HttpServletRequest request) {
//        String json = RequestPayload.getRequestPayload(request);
//        JSONObject obj = null;
//        try {
//            obj = new JSONObject(json);
//            Integer id = obj.getInt("id");
//            return manageService.rejectClassApplication(id);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return 0;
//    }

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
//    @RequestMapping(value = "/add/course", method = RequestMethod.POST)
//    @ResponseBody
//    public int addCourse(@RequestBody ClassDomainWithId cdwi) {
//        cdwi.setClassDateDescription(cdwi.getClassDateDescriptionA() + ":" + cdwi.getClassDateDescriptionB());
//        cdwi.setClassChooseNum(0);
//        int id = cdwi.getId();
//        if (id != 0) {
//            manageService.deleteApplication(id);
//        }
//        manageService.addCourse(cdwi);
//        return 0;
//    }

    @RequestMapping(value = "/delete/course", method = RequestMethod.POST)
    @ResponseBody
    public int deleteCourse(@RequestBody CourseAll courseAll) {
        manageService.deleteCourseAll(courseAll.getId());
        return 0;
    }

    @RequestMapping(value ="/delete/courseApp",method = RequestMethod.POST)
    @ResponseBody
    public int deleteCourseApp(@RequestBody CourseApplication courseApp){
        manageService.deleteCourseApp(courseApp.getId());
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
                data.put("total", 10);
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

            double xbsjGrade = Double.valueOf(String.valueOf(li.get("xbsjGrade")));
            double knskGrade = Double.valueOf(String.valueOf(li.get("knskGrade")));
            double wlzzxxGrade = Double.valueOf(String.valueOf(li.get("wlzzxxGrade")));

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
            SimpleDateFormat sdf2=new SimpleDateFormat("yyMMddHHmmss");
            String str=sdf2.format(new Date());
            //文件路径+原文件名+时间戳+随机数防止重名文件覆盖，下载文件时按照该路径下载;
            String pathName = filePath+fileName+str+(new Random().nextInt(100));
            File dest = new File(pathName);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date=sdf.format(new Date());
            manageService.addTemplateFileInfo(teaId,fileName,pathName,1,dep,date,1);
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
    @RequestMapping(value="/downloadAppFile")
    @ResponseBody
    public String downloadAppFile(HttpServletResponse response, @RequestParam("fileInfoId") int fileInfoId){
        FileInfo fileInfo=manageService.findAppFile(fileInfoId);
        String fileName=fileInfo.getFileName();
        String path=fileInfo.getPath();
        File file=new File(path);
        if(file.exists()){
            response.setContentType("application/force-download");
            try {
                response.addHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(fileName,"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            byte[] buffer=new byte[1024];
            FileInputStream fis=null;
            BufferedInputStream bis=null;
            try{
                fis=new FileInputStream(file);
                bis=new BufferedInputStream(fis);
                OutputStream os=response.getOutputStream();
                int i=bis.read(buffer);
                while(i!=-1){
                    os.write(buffer,0,i);
                    i=bis.read(buffer);
                }
                return "下载成功";
            }catch(Exception e){
                e.printStackTrace();
                System.out.println(e);
            }finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }

    /**
     * 查看成绩模快比例
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/getGradePercent")
    public Map getGradePercent(){
        return manageService.getGradePercent();
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
//            JSONObject valuejson = json.getJSONObject("value");
            int XBSJ= (int) json.get("XBSJ");
            int ZZXX= (int) json.get("ZZXX");
            int KNSK= (int) json.get("KNSK");
            int DEKT = (int) json.get("DEKT");
            int QMNL = (int) json.get("QMNL");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date=sdf.format(new Date());
            manageService.addGradePercent(KNSK,XBSJ,ZZXX,DEKT,QMNL,userId,date);
        return "设置成功";
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "设置失败";
    }

    /**
     * 超级管理员端：查看往年课程目录
     *
     *
     * @return
     */
    @RequestMapping("/findCourseAll")
    @ResponseBody
    public Map<String,Object> findCourseAll(  @RequestParam(required = false, defaultValue = "1") int currentPage,
                                              @RequestParam(required = false, defaultValue = "10") int pageSize,
                                              @RequestParam(required = false, defaultValue="8888") String academicYear,
                                              @RequestParam(required = false, defaultValue = "8888") String courseId,
                                              @RequestParam(required = false,defaultValue = "8888") String courseName,
                                              @RequestParam(required = false,defaultValue = "8888") int departId
    ){
        Map<String,Object> res=new HashMap<>();
        PageHelper.startPage(currentPage, pageSize);
        List courseAllList=courseAllService.findCourseAll(academicYear,courseId,courseName,departId);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(courseAllList);
        res.put("total", pageInfo.getTotal());
        List<Map<String,Object>> pageList=pageInfo.getList();
        res.put("pageSize", pageSize);
        res.put("currentPage", currentPage);
        res.put("list", pageList);
        return res;

    }

    @RequestMapping(value="/courseApp")
    @ResponseBody
    public Map<String, Object> courseApp(HttpServletRequest request,
                                                    @RequestParam(required = false, defaultValue = "1") int currentPage,
                                                    @RequestParam(required = false, defaultValue = "10") int pageSize,
                                                    @RequestParam(required = false, defaultValue="8888") String academicYear,
                                                    @RequestParam(required = false, defaultValue = "8888") String courseId,
                                                    @RequestParam(required = false,defaultValue = "8888") String courseName
    ){
        if(academicYear.equals("8888")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

            Date date = new Date();
            int year = Integer.parseInt(sdf.format(date));
            academicYear = year + "-" + (year + 1);
        }
        int departId=  (int)request.getSession().getAttribute("departId");
        PageHelper.startPage(currentPage, pageSize);
        List courseAllList=courseAllService.findDepartCourseApp(departId,academicYear,courseId,courseName);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(courseAllList);
        Map<String, Object> res = new HashMap<>();
        res.put("total", pageInfo.getTotal());
        List<Map<String,Object>> pageList=pageInfo.getList();
        res.put("pageSize", pageSize);
        res.put("currentPage", currentPage);
        res.put("list", pageList);
        return res;
    }

    /**
     * 学院管理员端：查看往年课程目录
     *
     */
    @RequestMapping("/findCourseAllDepart")
    @ResponseBody
    public Map<String,Object> findCourseAll(  @RequestParam(required = false, defaultValue = "1") int currentPage,
                                              @RequestParam(required = false, defaultValue = "10") int pageSize,
                                              @RequestParam(required = false, defaultValue="8888") String academicYear,
                                              @RequestParam(required = false, defaultValue = "8888") String courseId,
                                              @RequestParam(required = false,defaultValue = "8888") String courseName,
                                              HttpSession session
    ){
        int departId = (int) session.getAttribute("departId");
        Map<String,Object> res=new HashMap<>();
        PageHelper.startPage(currentPage, pageSize);
        List courseAllList=courseAllService.findCourseAll(academicYear,courseId,courseName,departId);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(courseAllList);
        res.put("total", pageInfo.getTotal());
        List<Map<String,Object>> pageList=pageInfo.getList();
        res.put("pageSize", pageSize);
        res.put("currentPage", currentPage);
        res.put("list", pageList);
        return res;

    }
    /**
     * 学院管理员端:导入往年课程
     *
     */
    @RequestMapping("/departAddFormerCourse")
    @ResponseBody
    public int departAddFormerCourseAll(HttpServletRequest request) throws JSONException {
        String username= (String) request.getSession().getAttribute("username");
        String userId= (String) request.getSession().getAttribute("userId");
        String json = RequestPayload.getRequestPayload(request);
        JSONArray obj = new JSONArray(json);
        for(int i=0;i<obj.length();i++){
            int id= (int) obj.get(i);
            courseAllService.addDepartFormer(id,username,userId);
        }
        return 0;
    }

    /**
     * 学院管理员新增课程
     * @param request
     * @return
     * @throws JSONException
     */
    @RequestMapping(value="/addCourseApp",method=RequestMethod.POST)
    @ResponseBody
    public int addCourseApp(HttpServletRequest request) throws JSONException {
        String userId= (String) request.getSession().getAttribute("userId");
        String username= (String) request.getSession().getAttribute("username");
        String json = RequestPayload.getRequestPayload(request);
        JSONObject obj = new JSONObject(json);
        int departId=obj.optInt("departId");
        if(departId==0){
            departId= (int) request.getSession().getAttribute("departId");
        }
        System.out.println(departId);
        String courseNameCHS=obj.getString("className");
        String courseNameEN=obj.getString("classNameEN");
        int moduleId=obj.getInt("classModuleNum");
        String academicYear=obj.getString("classYear");
        int classSemesterInt=obj.getInt("classSemester");

        int classHour=obj.getInt("classHour");
        int stuNumUpperLimit=obj.getInt("stuNumUpperLimit");
        String teacherName=obj.getString("mainLecturer");
        String teacherId=obj.getString("mainLecturerId");
        JSONArray teacherArray= (JSONArray) obj.get("teacherList");
        String courseInfo=obj.getString("courseInfo");
        String teacherInfo=obj.getString("teacherInfo");
        CourseApplication ca=new CourseApplication();
        ca.setDepartId(departId);
        ca.setCourseNameEN(courseNameEN);
        ca.setCourseNameCHS(courseNameCHS);
        ca.setModuleId(moduleId);
        ca.setAcademicYear(academicYear);
        if(classSemesterInt==1){
            ca.setClassSemester("春季");
        }else if(classSemesterInt==2){
            ca.setClassSemester("秋季");
        }else if(classSemesterInt==3){
            ca.setClassSemester("春秋季");
        }
        ca.setClassHour(classHour);
        ca.setStuNumUpperLimit(stuNumUpperLimit);
        ca.setTeacherId(teacherId);
        ca.setTeacherName(teacherName);
        StringBuilder teachingTeamIds=new StringBuilder();
        StringBuilder teachingTeamNames=new StringBuilder();
        for(int i=0;i<teacherArray.length();i++){
            JSONObject jsonObject= (JSONObject) teacherArray.get(i);
            teachingTeamIds.append(jsonObject.getString("teaId"));
            teachingTeamIds.append(",");
            teachingTeamNames.append(jsonObject.getString("teaName"));
            teachingTeamNames.append(",");
        }
        teachingTeamIds.deleteCharAt(teachingTeamIds.length()-1);
        teachingTeamNames.deleteCharAt(teachingTeamNames.length()-1);
        ca.setTeachingTeamIds(teachingTeamIds.toString());
        ca.setTeachingTeamNames(teachingTeamNames.toString());
        ca.setCourseInfo(courseInfo);
        ca.setTeacherInfo(teacherInfo);
        ca.setOperatorId(userId);
        ca.setOperateDate(new Date());
        ca.setIsChecked(3);
        ca.setCategory(2);
        courseAllService.addCourseApp(ca);
        return 1;
    }

    /**
     * 学院管理员提交课程目录审核
     * @param request
     * @return
     * @throws JSONException
     */
    @RequestMapping("/commitApp")
    @ResponseBody
    public int commitApp(HttpServletRequest request,@RequestParam("academicYear") String academicYear){
        int departId= (int) request.getSession().getAttribute("departId");
        return courseAllService.commitApp(academicYear,departId);
    }

    /**
     * 学院管理员修改未经审核的课程目录
     * @param ca
     * @param request
     * @return
     */
    @RequestMapping("/modifyCourseApp")
    @ResponseBody
    public int modifyCourseApp(@RequestBody CourseApplication ca, HttpServletRequest request){
        String username= (String) request.getSession().getAttribute("username");
        String userId= (String) request.getSession().getAttribute("userId");
        if(ca.getIsChecked()!=3){
            return 0;
        }
        //测试的时候看下
        courseAllService.modifyCourseApp(ca,username,userId);
        return 1;
    }

    /**
     * 超级管理员修改课程目录
     * @param courseAll
     * @param request
     * @return
     */
    @RequestMapping("/modifyCourseAll")
    @ResponseBody
    public  String modifyCourseAll(@RequestBody CourseAll courseAll,HttpServletRequest request){
        String userId= (String) request.getSession().getAttribute("userId");
        String username= (String) request.getSession().getAttribute("username");
        int flag=courseAllService.modifyCourseAll(courseAll,userId,username);
        if(flag!=0){
            return "修改成功!";
        }
        return "修改失败！";
    }

    /**
     * 超级管理员：查看课程目录
     * @param request
     * @param currentPage
     * @param pageSize
     * @param academicYear
     * @param courseId
     * @param courseName
     * @param departId
     * @return
     */
    @RequestMapping(value="/findCourseApplication")
    @ResponseBody
    public Map<String, Object> findCurrentCourseAll(HttpServletRequest request,
                                                    @RequestParam(required = false, defaultValue = "1") int currentPage,
                                                    @RequestParam(required = false, defaultValue = "10") int pageSize,
                                                    @RequestParam(required = false, defaultValue="8888",value="academicYear") String academicYear,
                                                    @RequestParam(required = false, defaultValue = "8888") String courseId,
                                                    @RequestParam(required = false,defaultValue = "8888") String courseName,
                                                    @RequestParam(required = false,defaultValue = "8888") int departId
    ){
        if(academicYear.equals("8888")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

            Date date = new Date();
            int year = Integer.parseInt(sdf.format(date));
            academicYear = year + "-" + (year + 1);
        }
        PageHelper.startPage(currentPage, pageSize);
        List courseAllList=courseAllService.findCourseAll(academicYear,courseId,courseName,departId);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(courseAllList);
        Map<String, Object> res = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        res.put("total", pageInfo.getTotal());
        List<Map<String,Object>> pageList=pageInfo.getList();
        res.put("pageSize", pageSize);
        res.put("currentPage", currentPage);
        res.put("list", pageList);
        return res;
    }

    /**
     * 超级管理员直接新增课程
     * @param request
     * @return
     * @throws JSONException
     */
    @RequestMapping(value = "/addCourseAll", method = RequestMethod.POST)
    @ResponseBody
    public int addClassApplication(HttpServletRequest request) throws JSONException  {
        String userId= (String) request.getSession().getAttribute("userId");
        String username= (String) request.getSession().getAttribute("username");
        String json = RequestPayload.getRequestPayload(request);
        JSONObject obj = new JSONObject(json);
        int departId=obj.getInt("departId");
        String courseNameCHS=obj.getString("className");
        String courseNameEN=obj.getString("classNameEN");
        int moduleId=obj.getInt("classModuleNum");
        String academicYear=obj.getString("classYear");
        int classSemesterInt=obj.getInt("classSemester");
        int classHour=obj.getInt("classHour");
        int stuNumUpperLimit=obj.getInt("stuNumUpperLimit");
        String teacherName=obj.getString("mainLecturer");
        String teacherId=obj.getString("mainLecturerId");
        JSONArray teacherArray= (JSONArray) obj.get("teacherList");
        CourseAll courseAll=new CourseAll();
        courseAll.setDepartId(departId);
        courseAll.setCourseNameEN(courseNameEN);
        courseAll.setCourseNameCHS(courseNameCHS);
        courseAll.setModuleId(Integer.toString(moduleId));
        courseAll.setAcademicYear(academicYear);
        if(classSemesterInt==1){
            courseAll.setClassSemester("春季");
        }else if(classSemesterInt==2){
            courseAll.setClassSemester("秋季");
        }else if(classSemesterInt==3){
            courseAll.setClassSemester("春秋季");
        }
        courseAll.setClassHour(classHour);
        courseAll.setStuNumUpperLimit(stuNumUpperLimit);
        courseAll.setTeacherId(teacherId);
        courseAll.setTeacherName(teacherName);
        StringBuilder teachingTeamIds=new StringBuilder();
        StringBuilder teachingTeamNames=new StringBuilder();
        for(int i=0;i<teacherArray.length();i++){
            JSONObject jsonObject= (JSONObject) teacherArray.get(i);
            teachingTeamIds.append(jsonObject.getString("teaId"));
            teachingTeamIds.append(",");
            teachingTeamNames.append(jsonObject.getString("teaName"));
            teachingTeamNames.append(",");
        }
        teachingTeamIds.deleteCharAt(teachingTeamIds.length()-1);
        teachingTeamNames.deleteCharAt(teachingTeamNames.length()-1);
        courseAll.setTeachingTeamIds(teachingTeamIds.toString());
        courseAll.setTeachingTeamNames(teachingTeamNames.toString());
        courseAll.setOperatorId(userId);
        courseAll.setOperatorName(username);
        courseAll.setOperateDate(new Date());
        courseAllService.addCourseAll(courseAll);
        return 1;
    }

    /**
     * 超级管理员修订当年课程目录时导入往年课程
     * @param request
     * @return
     * @throws JSONException
     */

    @RequestMapping(value = "addFormerCourseAll")
    @ResponseBody
    public int addFormerCourseAll(HttpServletRequest request) throws JSONException {
        String json = RequestPayload.getRequestPayload(request);
        JSONArray obj = new JSONArray(json);
        for(int i=0;i<obj.length();i++){
            int id= (int) obj.get(i);
            CourseAll courseAll=courseAllService.findCourseAll(id);
            courseAll.setId(null);
            Calendar now = Calendar.getInstance();
            int currentYear=now.get(Calendar.YEAR);
            courseAll.setAcademicYear(currentYear+"-"+(currentYear+1));
            courseAllService.addCourseAll(courseAll);
        }
        return 0;
    }

    @RequestMapping(value = "/makeSureCourseAll")
    @ResponseBody
    public String findCourseYear(HttpServletRequest request,@RequestParam("academicYear") String academicYear){

        System.out.println("academicYear："+academicYear);
        int flag=courseAllService.makeSureCourseAll(academicYear);
        if(flag==0){
            return "修订失败！";
        }
        return "修订成功！";
    }
    /**
     * 教师端：根据课程编码和班级号导出学生列表PDF
     * @param
     * @param
     * @return
     */
    @RequestMapping("/downloadStudentsPdf")
    @ResponseBody
    public ModelAndView downloadStudentsPdf(@RequestParam("courseId")String courseId,@RequestParam("classNum")int classNum,
                                            HttpSession session, HttpServletResponse response) {
//        int classId=480;
//        String className="英语";
//        int classNum=1;
        Map classIdAndFlag=classService.findClassId(courseId,classNum);
//        System.out.print(classId);
        int classId=(int)classIdAndFlag.get("classId");
        ClassDomain classes =  classService.findClassById(classId);
        String className=classes.getClassName();
        response = ResponseWrap.setName(response, className+classNum + "班选课学生名单", "pdf");
        List<Map<String,Object>> students = classService.findStudent(classId);
        Map res = new HashMap();
        res.put("data", students);
        res.put("className",className);
        res.put("classNum",classNum);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style", "higher");

        return new ModelAndView(new StudentsListPdfView(), model);
    }


    /**
     * 管理员端通过学院和班级下载成绩单
     *
     * @return
     */
    @RequestMapping("/find/department")
    @ResponseBody
    public List<Map> getAllDepartment() {
        List department = classService.findAllDepartment();
        return department;
    }

    @RequestMapping("/find/departmentCourse")
    @ResponseBody
    public List<Map<String,Object>> getDepartmentCourse(@RequestParam String academicYear, @RequestParam String classSemester,@RequestParam("departId")int departId) {
        List<Map<String,Object>> depCourse = classAllService.getOneDimDepartTimeTable(departId, academicYear, classSemester);
        return depCourse;
    }

    @RequestMapping("/find/KnskCourse")
    @ResponseBody
    public List<Map<String,Object>> getKnskCourse(@RequestParam String academicYear) {
        List<Map<String,Object>> KnskCourse = classAllService.getKnskCourse( academicYear);
        return KnskCourse;
    }


    @RequestMapping("/downloadStudentsScorePdf")
    @ResponseBody
    public ModelAndView downloadStudentsScorePdf(@RequestParam("courseId")String courseId,@RequestParam("classNum")int classNum,
                                                 HttpSession session, HttpServletResponse response) {

        Map classIdAndFlag=classService.findClassId(courseId,classNum);
        int classId=(int)classIdAndFlag.get("classId");
        int isGrade=(int)classIdAndFlag.get("isGrade");
        if(isGrade==0)//成绩未提交无法下载成绩
        {
            return null;
        }
        ClassDomain classes =  classService.findClassById(classId);
        String className=classes.getClassName();
        response = ResponseWrap.setName(response, className+classNum + "班学生成绩单", "pdf");
        List<Map<String,Object>> students = classService.findStudent(classId);
        Map res = new HashMap();
        res.put("data", students);
        res.put("className",className);
        res.put("classNum",classNum);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style", "higher");

        return new ModelAndView(new StudentsScoreListPdfView(), model);
    }
    /**
     * 超级管理员：查看所有学院
     * @param
     * @param
     * @return
     */
    @RequestMapping("/findAlldepartment")
    @ResponseBody
    public List<Map<String, Object>> findAlldepartment(){
        List<Map<String,Object>> res = manageService.findAlldepartment();
        return res;
    }



    /**
     * 超级管理员：查看所有学生其它模块成绩
     * @param
     * @param
     * @return
     */
    @RequestMapping("/findStudentsScore")
    @ResponseBody
    public Map findStudentsScore(@RequestParam("moduleId") int moduleId,
                                 @RequestParam("academicYear") String academicYear,
                                 @RequestParam(required = false, defaultValue = "88888888") int depId,
                                 @RequestParam(required = false, defaultValue = "88888888") String stuId,
                                 @RequestParam(required = false, defaultValue = "1") int currentPage,
                                 @RequestParam(required = false, defaultValue = "10") int pageSize,
                                 HttpSession session) {
        Map<String,Object> res=new HashMap<>();
        Page page=PageHelper.startPage(currentPage, pageSize);
        int submit=0;
        List<Map<String,Object>> students = manageService.findAllStudent(moduleId,academicYear,submit,depId,stuId);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(students);
        List<Map<String,Object>> pageList=pageInfo.getList();
        Map<String, Object> data = new HashMap<>();
        int isGrade=manageService.findIsGrade(moduleId,academicYear);
        data.put("total",page.getTotal());
        data.put("list",pageList);
        data.put("currentPage",currentPage);
        data.put("pageSize",pageSize);
        res.put("data", data);
        res.put("isGrade",isGrade);
        res.put("status", "SUCCESS");
        return res;
    }

    /**
     * 超级管理员：下载所有学生其它模块成绩Excel
     * @param
     * @param
     * @return
     */
    @RequestMapping("/downloadStudentsScore")
    @ResponseBody
    public void downloadStudentsScore(@RequestParam("moduleId") int moduleId,
                                      @RequestParam("academicYear") String academicYear,
                                      @RequestParam(required = false, defaultValue = "88888888") int depId,
                                      @RequestParam(required = false, defaultValue = "88888888") String stuId, HttpServletResponse response,
                                      HttpSession session) throws IOException{
        Map<String,Object> res=new HashMap<>();
        int submit=0;
        String moduleName=null;
        if(moduleId==1) {
            moduleName="网络自主学习";
        }
        if(moduleId==2){
            moduleName="第二课堂活动";
        }
        if(moduleId==3){
            moduleName="期末能力水平测试";
        }
        List<Map<String,Object>> students = manageService.findAllStudent(moduleId,academicYear,submit,depId,stuId);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(academicYear+moduleName+"成绩表");
        String fileName = academicYear+moduleName+"成绩表"  + ".xls";//设置要导出的文件的名字

        String[] headers={"姓名","学号","所属学院","所属专业","成绩"};
        HSSFRow headerRow=sheet.createRow(0);
        //添加表头
        for(int i=0;i<headers.length;i++){
            HSSFCell cell=headerRow.createCell(i);
            HSSFRichTextString text=new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        int rowNum=1;
        for(Map<String,Object> stu:students){
            HSSFRow row=sheet.createRow(rowNum);
            row.createCell(0).setCellValue((String) stu.get("stuName"));
            row.createCell(1).setCellValue((String) stu.get("stuId"));
            row.createCell(2).setCellValue((String) stu.get("departName"));
            row.createCell(3).setCellValue((String) stu.get("speciality"));
            rowNum++;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
    /**
     * 超级管理员：上传其它模块成绩Excel
     * @param
     * @param
     * @return
     */
    @RequestMapping("/uploadGradeExcel")
    @ResponseBody
    public Map<String, Object> uploadGradeExcel(@RequestParam("file") MultipartFile file,
                                                HttpServletRequest request){
        Map<String,Object> res=new HashMap<>();
        String userId= (String) request.getSession().getAttribute("userId");
        String dep= (String) request.getSession().getAttribute("dep");
        String filePath=request.getSession().getServletContext().getRealPath(File.separator)+"/file/";
        int type=3;
        int fileInfoId= teacherService.uploadFile(file,userId,dep,type,filePath);
        if (fileInfoId==0){
            res.put("status","上传失败");
        }else{
            res.put("status","上传成功");
            res.put("fileInfoId",fileInfoId);
        }
        return res;
    }

    @RequestMapping("/insertGradeExcel")
    @ResponseBody
    public Map<String,Object> insertGradeExcel(@RequestParam("moduleId") int moduleId,
                                               @RequestParam("academicYear") String academicYear,
                                               @RequestParam("fileInfoId") int fileInfoId){
        Map<String,Object> res=manageService.insertGradeExcel(moduleId,fileInfoId,academicYear);
        if((int)res.get("flag") == 0){
            res.put("status","上传成绩失败！");
        }else{
            res.put("status","上传成绩成功！");
        }
        return res;
    }


    /**
     * 管理员端：保存或提交学生成绩
     * @param
     * @param
     * @return
     */
    @RequestMapping("/updateScore")
    @ResponseBody
    public Map updateScore(HttpServletRequest request,
                           HttpSession session) {
        Map<String,Object> res=new HashMap<>();
        String json = RequestPayload.getRequestPayload(request);
        try {
            List<Map<String,Object>> li=new ArrayList<>();
            JSONObject obj = new JSONObject(json);
            int moduleId=obj.getInt("moduleId");
            int status= obj.getInt("status");
            if(status==1)
            {
                manageService.updateIsSubmit(moduleId);
            }
            String academicYear= obj.getString("academicYear");
            JSONArray stuList=  obj.getJSONArray("stuList");
            for(int i=0;i<stuList.length();i++){
                JSONObject stu=stuList.getJSONObject(i);
                String stuId= (String) stu.get("stuId");
                String stuName= (String) stu.get("stuName");
                List<Map<String,Object>> stuInfo=manageService.findStuById(stuId,moduleId);
                if(stuInfo.size()==0) {
                    Map<String, Object> limap = new HashMap<>();
                    limap.put("stuId", stuId);
                    limap.put("stuName", stuName);
                    li.add(limap);
                }
            }
            if(li.size()!=0)
            {
                res.put("list",li);
                return res;
            }
            for(int i=0;i<stuList.length();i++){
                JSONObject stu=stuList.getJSONObject(i);
                String stuId= (String) stu.get("stuId");
                String grade= String.valueOf(stu.get("grade"));
                List<Map<String,Object>> stuInfo=manageService.findStuById(stuId,moduleId);
                if(stuInfo.size()==0)
                    manageService.insertStu(stuId,academicYear);
                if(stuInfo.size() !=0 &&(int) stuInfo.get(0).get("isSubmit")==1)
                    continue;
                manageService.updateScore(stuId,Float.parseFloat(grade),moduleId,status);
                manageService.uploadAllGradeOther(stuId,Float.parseFloat(grade),moduleId);
            }
            if(status==1){
                res.put("status","成绩提交成功");
                return res;
            }
            else{
                res.put("status","成绩保存成功");
                return res;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 管理员端：根据模块id下载已提交的学生成绩PDF
     * @param
     * @param
     * @return
     */
    @RequestMapping("/downloadOtherScorePdf")
    @ResponseBody
    public ModelAndView downloadOtherScore(@RequestParam("moduleId") int moduleId,
                                           @RequestParam("academicYear") String academicYear,
                                           @RequestParam(required = false, defaultValue = "88888888") int departId,
                                           @RequestParam(required = false, defaultValue = "88888888") String stuId,
                                           HttpSession session, HttpServletResponse response) {
        String moduleName=null;
        if(moduleId==1) {
            moduleName="网络自主学习";
        }
        if(moduleId==2){
            moduleName="第二课堂活动";
        }
        if(moduleId==3){
            moduleName="期末能力水平测试";
        }
        response = ResponseWrap.setName(response, academicYear + moduleName + "班学生成绩单", "pdf");
        int submit=1;
        List<Map<String,Object>> students = manageService.findAllStudent(moduleId,academicYear,submit,departId,stuId);
        Map res = new HashMap();
        res.put("data", students);
        res.put("academicYear",academicYear);
        res.put("moduleName",moduleName);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style", "higher");
        logger.info(String.valueOf(model));
        return new ModelAndView(new StudentsOtherScoreListPdfView(), model);
    }

    /**
     * 学院管理员审核成绩
     * 学院管理员端：获取本学院课程
     * @param
     * @param
     * @return
     */
    @RequestMapping("/findAllCourse")
    @ResponseBody
    public Map findAllCourse(@RequestParam(required = false, defaultValue = "3") int moduleId,
                           @RequestParam(required = false, defaultValue = "2018-2019春季") String academicYear,
                           @RequestParam(required = false, defaultValue = "3") int curentTab,
                           @RequestParam(required = false, defaultValue = "88888888") String courseId,
                           @RequestParam(required = false, defaultValue = "88888888") String className,
                           @RequestParam(required = false, defaultValue = "88888888") String classNum,
                           @RequestParam(required = false, defaultValue = "88888888") String teaName,
                           @RequestParam(required = false, defaultValue = "88888888") int  departId,
                           @RequestParam(required = false, defaultValue = "1") int currentPage,
                           @RequestParam(required = false, defaultValue = "10") int pageSize,
                           HttpSession session){
        Map<String,Object> res=new HashMap<>();
        Page page=PageHelper.startPage(currentPage, pageSize);
        List<Map<String,Object>> courses=new ArrayList<>();
        if (departId == 88888888) {
            departId = (Integer) session.getAttribute("departId");
        }
        if (moduleId == 0) {
            courses=classService.findAllXbsjCourse(departId,academicYear,courseId,className,classNum,teaName,curentTab);
        }
        else if (moduleId==1)
        {
            if(departId!=12){ }
            else if(academicYear.indexOf("春季")!=-1) {
                academicYear = academicYear.substring(0, 9) + "-2";
                courses=classService.findAllKnskCourse(academicYear,courseId,className,classNum,teaName,curentTab);
            }
            else {
                academicYear=academicYear.substring(0,9)+"-1";
                courses=classService.findAllKnskCourse(academicYear,courseId,className,classNum,teaName,curentTab);
            }
        }
        else
            {
                List<Map<String,Object>> courses1=classService.findAllXbsjCourse(departId,academicYear,courseId,className,classNum,teaName,curentTab);
                if(departId!=12){
                    courses=courses1;}
                else if(academicYear.indexOf("春季")!=-1) {
                    academicYear = academicYear.substring(0, 9) + "-2";
                    List<Map<String, Object>> courses2=classService.findAllKnskCourse(academicYear,courseId,className,classNum,teaName,curentTab);
                    courses1.addAll(courses2);
                    courses=courses1;
                }
                else {
                    academicYear = academicYear.substring(0, 9) + "-1";
                    List<Map<String, Object>> courses2 = classService.findAllKnskCourse(academicYear, courseId, className, classNum, teaName, curentTab);
                    courses1.addAll(courses2);
                    courses=courses1;
                }
            }
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(courses);
        List<Map<String,Object>> pageList=pageInfo.getList();
        Map<String, Object> data = new HashMap<>();
        data.put("total",page.getTotal());
        data.put("list",pageList);
        data.put("currentPage",currentPage);
        data.put("pageSize",pageSize);
        res.put("data", data);
        res.put("status", "SUCCESS");
        return res;
    }

    /**
     * 学院管理员端：审核成绩
     * 获取班级学生审核情况
     * @param
     * @param
     * @return
     */
    @RequestMapping("/findStudentStatus")
    @ResponseBody
    public Map findStudentStatus(@RequestParam("moduleId") int moduleId,
                                 @RequestParam("classId") String id,
                                 HttpSession session){

        Map<String,Object> res=new HashMap<>();
        List<Map<String,Object>> students=new ArrayList<>();
        if(moduleId==0) {
            int classId=Integer.parseInt(id);
            students=manageService.findXbsjStudents(classId);

        }
        else
            students= manageService.findKnskStudents(id);
        Map<String, Object> data = new HashMap<>();
        data.put("list",students);
        res.put("data", data);
        res.put("status", "SUCCESS");
        return res;
    }
    /**
     * 学院管理员端：审核成绩
     * 返回班级学生审核情况
     * @param
     * @param
     * @return
     */
    @RequestMapping("/checkGrade")
    @ResponseBody
    public void checkGrade(HttpServletRequest request,
                           HttpSession session){
        String json = RequestPayload.getRequestPayload(request);
        try {
            JSONObject obj = new JSONObject(json);
            int classId1 = 0;
            String classId2="";
            int moduleId=obj.getInt("moduleId");
            int isChecked=obj.getInt("status");
            if(moduleId==0) {
                classId1=obj.getInt("classId");
            }
            if(moduleId==1) {
                classId2=obj.getString("classId");
            }
            JSONArray stuList=  obj.getJSONArray("stuList");
            for(int i=0;i<stuList.length();i++){
                String stuId= (String) stuList.get(i);
                System.out.println("学生学号:"+stuId);
                if(moduleId==0) {
                    manageService.updateXbsjChecked(classId1, stuId, isChecked);
                    if(isChecked==2)
                        manageService.updateXbsjSubmit(classId1);
                }
                else {
                    manageService.updateKnskChecked(classId2, stuId, isChecked);
                    if(isChecked==2)
                        manageService.updateKnskSubmit(classId2);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /**
     * 学院管理员端：审核成绩
     * 一键审核整个班级
     * @param
     * @param
     * @return
     */
    @RequestMapping("/checkClassGrade")
    @ResponseBody
    public void checkClassGrade(@RequestParam("moduleId") int moduleId,
                                @RequestParam("classId") String classId,
                                @RequestParam("isChecked") int isChecked ){
        List<Map<String,Object>> stuList=new ArrayList<>();
        if(moduleId==0){
            stuList=classService.findStudent(Integer.parseInt(classId));
        }
        else
            stuList=classService.findKnskStudents(classId);
        for(Map stu:stuList)
        {
            String stuId= (String) stu.get("stuId");
            if(moduleId==0) {
                manageService.updateXbsjChecked(Integer.parseInt(classId), stuId, isChecked);
                if(isChecked==2)
                    manageService.updateXbsjSubmit(Integer.parseInt(classId));
            }
            else {
                manageService.updateKnskChecked(classId, stuId, isChecked);
                if(isChecked==2)
                    manageService.updateKnskSubmit(classId);
            }
        }
    }
    /**
     * 查看学院学生所有成绩
     * @param
     * @param
     * @return
     */
    @RequestMapping("/findAllScore")
    @ResponseBody
    public Map  findAllScore(@RequestParam(required = false, defaultValue = "88888888") int departId,
                              @RequestParam(required = false, defaultValue = "88888888") String stuId,
                              @RequestParam(required = false, defaultValue = "1") int currentPage,
                              @RequestParam(required = false, defaultValue = "10") int pageSize,
                              HttpSession session){
        Map<String,Object> res=new HashMap<>();
        Page page = PageHelper.startPage(currentPage, pageSize);
        List<Map<String,Object>> students = manageService.findAllScore(departId,stuId);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(students);
        List<Map<String,Object>> pageList=pageInfo.getList();
        Map<String, Object> data = new HashMap<>();
        data.put("total",page.getTotal());
        data.put("list",pageList);
        data.put("currentPage",currentPage);
        data.put("pageSize",pageSize);
        res.put("data", data);
        res.put("status", "SUCCESS");
        return res;
    }

    /**
     * 强制录入单个学生成绩
     * @param
     * @param
     * @return
     */
    @RequestMapping("/forcedEntryScore")
    @ResponseBody
    public void  ForcedEntryScore(@RequestParam("stuId") String stuId,
                             @RequestParam("moduleId") int moduleId,
                             @RequestParam("classId") String classId,
                             @RequestParam("grade") float grade,
                             HttpSession session){
        if(moduleId==0){
            List<Map<String,Object>> stuXbsjClass=new ArrayList<>();
            classService.updateXbsjScore(Integer.parseInt(classId),stuId,grade);
            stuXbsjClass=classService.findStuXbsjClass(stuId);
            float xbsjGrade=0;
            int classTime=0;
            for(Map course:stuXbsjClass){
                classTime=classTime+(int)course.get("classTime");

            }
            if(classTime==32) {
                for (Map course : stuXbsjClass) {
                    if((float)course.get("xbsjGrade")!=0)
                    xbsjGrade=xbsjGrade+(float)course.get("xbsjGrade")*((int)course.get("classTime")/(float)32);
                else{
                    xbsjGrade=0;
                    break;
                    }
                }
            }
            if(xbsjGrade!=0){
                gradeService.uploadAllGradeXbsj(stuId,xbsjGrade);
            }
        }
        else {
            teacherService.updateKnskScore(classId,stuId,grade);
            gradeService.uploadAllGradeKnsk(stuId,grade);
        }
    }

    /**
     * 超级管理员端：导出所有学生总成绩PDF
     * @param
     * @param
     * @return
     */
    @RequestMapping("/downloadScorePdf")
    @ResponseBody
    public ModelAndView downloadScorePdf(@RequestParam(required = false, defaultValue = "88888888") int departId,
                                         @RequestParam(required = false, defaultValue = "88888888") String stuId,
                                         HttpSession session,HttpServletResponse response){
        List<Map<String,Object>> students = manageService.findAllScore(departId,stuId);
        response = ResponseWrap.setName(response, "2018-2019学年英语总成绩单", "pdf");
        Map res = new HashMap();
        res.put("data", students);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style", "higher");
        return new ModelAndView(new StudentsAllScoreListPdfView(), model);
    }


}


