package com.spc.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.spc.model.ClassApplicationDomain;
import com.spc.model.ClassDomain;
import com.spc.model.CourseApplication;
import com.spc.model.CourseTableExcelDomain;
import com.spc.service.classes.ClassService;
import com.spc.service.grade.GradeService;
import com.spc.service.manage.CourseAllService;
import com.spc.service.teacher.TeacherService;

import com.spc.util.CalculateWeekth;
import com.spc.util.CourseDateTrans;
import com.spc.util.ResponseWrap;
import com.spc.view.StudentTablePdfView;
import com.spc.view.StudentsListPdfView;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.spc.util.RequestPayload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.multi.MultiMenuItemUI;
import javax.wsdl.Output;

import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 这个类提供教师端的路由。
 *
 * @author yuhongchao
 * @version 1.0
 */
@RequestMapping("/teacher")
@Controller
public class TeacherController extends Base {

    @Autowired
    ClassService classService;

    @Autowired
    GradeService gradeService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    CourseAllService courseAllService;

    /**
     * 教师端：录入分数
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/grade/add", method = RequestMethod.POST)
    @ResponseBody
    public int addGrade(HttpServletRequest request) {
        try {
            String json = RequestPayload.getRequestPayload(request);
            System.out.println(json);
            JSONObject obj = new JSONObject(json);

            Integer classId = obj.getInt("classId");
            String stuId = obj.getString("stuId");
            Integer score = obj.getInt("score");

            return gradeService.addScore(classId, stuId, score);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    /**
     * 教师端：根据老师teaId 查询所教的课程
     *
     * @return
     */
    @RequestMapping("teach/course")
    @ResponseBody
    public List<Map> getTeachCourse(HttpSession session) {
        String teacherId = (String) session.getAttribute("userId");

        List<ClassDomain> classes = classService.findAllClass(88888888, "", teacherId, 88888888, 88888888);

        List<Map> resList = new ArrayList<Map>();

        for (int i = 0; i < classes.size(); i++) {
            Map<String, Object> res = new HashMap<>();
            res.put("className", classes.get(i).getClassName());
            res.put("classId", classes.get(i).getClassId());
            res.put("classStr", classes.get(i).getClassName() + "(" + classes.get(i).getClassNum() + ")");
            resList.add(res);
        }
        return resList;
    }

    /**
     * 主要用于教师端的教授课程显示
     * @param currentPage
     * @param pageSize
     * @param session
     * @return
     */
    @RequestMapping("teach/course2")
    @ResponseBody
    public Map getTeachCourse2(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            HttpSession session
    ) {
        String teacherId = (String) session.getAttribute("userId");
        PageHelper.startPage(currentPage, pageSize);
        List<ClassDomain> classes = classService.findAllClass(88888888, "", teacherId, 88888888, 88888888);

        for (ClassDomain li : classes) {
            String[] is = li.getClassDateDescription().split(":");
            System.out.println(is[0] + ":::::::" + is[1]);
            li.setClassDateDescription(String.valueOf(CourseDateTrans.dateToString(Integer.parseInt(is[0]), Integer.parseInt(is[1]), Integer.parseInt(is[2]))));
            li.setClassStr(li.getClassName() + "(" + li.getClassNum() + "班)");
        }

        Map<String, Object> res = new HashMap<>();
        res.put("status", "SUCCESS");
        Map<String, Object> data = new HashMap<>();
        data.put("total", ((Page) classes).getTotal());
        data.put("pageSize", pageSize);
        data.put("currentPage", currentPage);
        data.put("list", classes);

        res.put("data", data);
        return res;
    }

    /**
     * 教师端：根据课程信息查询选课的学生
     *
     * @param currentPage
     * @param pageSize
     * @param classId     课程id
     * @return
     */
    @RequestMapping("/find/student")
    @ResponseBody
    public Map<String, Object> getStudent(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "20") int pageSize,
            @RequestParam(required = false, defaultValue = "88888888") Integer classId,
            HttpSession session) {
        List students = new ArrayList();
        if (classId != 88888888) {
            PageHelper.startPage(currentPage, pageSize);

            students = classService.findStudent(classId);

            //将学生的信息放到session里面
            putSession(session,students);


            System.out.printf("find student result:%s", students);
            Map<String, Object> res = new HashMap<>();
            res.put("status", "SUCCESS");

            Map<String, Object> data = new HashMap<>();
            data.put("total", ((Page) students).getTotal());
            System.out.printf("total = %s\n", ((Page) students).getTotal());
            data.put("pageSize", pageSize);
            data.put("currentPage", currentPage);
            data.put("list", students);
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
            int wlzzxxGrade = (int) li.get("wlzzxxGrade");
            int xbsjGrade = (int) li.get("xbsjGrade");
            int knskGrade = (int) li.get("knskGrade");

            Map tempM = new HashMap();
            tempM.put("wlzzxxGrade", wlzzxxGrade);
            tempM.put("knskGrade", knskGrade);
            tempM.put("xbsjGrade", xbsjGrade);

            scoreMap.put(className + ":" + classNum + ":" + stuId, tempM);
        }
        return 0;
    }
    /**
     * 教师端：查询老师课表
     *
     * @return 返回的是课表信息的多维数组
     */
    @RequestMapping(value = "/course/table")
    @ResponseBody
    public String[][] findCourseTable(HttpSession session) {
        String teaId = (String) session.getAttribute("userId");
        return teacherService.findCourseTable(teaId);
    }

    /**
     * 教师端：添加课程
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/course/add", method = RequestMethod.POST)
    @ResponseBody
    public int addCourse(HttpServletRequest request) {
        try {
            String json = RequestPayload.getRequestPayload(request);
            System.out.println(json);
            JSONObject obj = new JSONObject(json);

            ClassDomain classDomain = new ClassDomain();
            classDomain.setTeacherInfo(obj.getString("teacherInfo"));
            classDomain.setCourseInfo(obj.getString("courseInfo"));
//            classDomain.setClassId(obj.getInt("classId"));
            classDomain.setTeaName(obj.getString("teaName"));
            classDomain.setTeaId(obj.getString("teaId"));
            classDomain.setClassUpperLimit(obj.getInt("classUpperLimit"));
            classDomain.setClassNum(obj.getInt("classNum"));
            classDomain.setClassName(obj.getString("className"));
            classDomain.setClassChooseNum(0);
            classDomain.setClassLength(obj.getInt("classLength"));

            Integer daseA = obj.getInt("classDateDescriptionA");
            Integer daseB = obj.getInt("classDateDescriptionB");

            System.out.printf("a%s,b%s", daseA, daseB);

            classDomain.setClassDateDescription(Integer.toString(daseA) + Integer.toString(daseB));
            classDomain.setClassPlace(obj.getString("classPlace"));
            classDomain.setDepartId(obj.getInt("departId"));
            classDomain.setClassModuleNum(obj.getInt("classModuleNum"));
            classDomain.setClassSemester(obj.getString("classSemester"));
            classDomain.setModelsName(" ");

            try {
                classService.addClass(classDomain);
            } catch (Exception e) {
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    /**
     * 教师端 更新模块一的分数
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/update/score1", method = RequestMethod.POST)
    @ResponseBody
    public int updateScore(HttpServletRequest request) {

        //首先获得session 里面的map
        Map scoreMap = new HashMap();
        HttpSession session = request.getSession(false);
        if (session != null) {
            scoreMap = (Map) session.getAttribute("updatescore");
        }
        //解析post 请求，得到请求的信息
        String className = null;
        String stuId = null;
        int classNum = 0;
        int wlzzxxGrade = 0;
        int knskGrade = 0;

        JSONObject obj = null;

        String json = RequestPayload.getRequestPayload(request);

        try {
            obj = new JSONObject(json);
            className = obj.getString("className");
            stuId = obj.getString("stuId");
            classNum = obj.getInt("classNum");
            wlzzxxGrade = obj.getInt("wlzzxxGrade");
            knskGrade = obj.getInt("knskGrade");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //存储请求的信息
        Map map= (Map) scoreMap.get(className + ":" + classNum + ":" + stuId);
        map.put("wlzzxxGrade", wlzzxxGrade);
        map.put("knskGrade", knskGrade);
//        System.out.println(request.getSession().getAttribute("updatescore1"));

        return 0;
    }

    /**
     * 教师端 更新模块2的分数
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/update/score2", method = RequestMethod.POST)
    @ResponseBody
    public int updateScore2(HttpServletRequest request) {

        //首先获得session 里面的map
        Map scoreMap = new HashMap();
        HttpSession session = request.getSession(false);
        if (session != null) {
            scoreMap = (Map) session.getAttribute("updatescore");
        }
        //解析post 请求，得到请求的信息
        String className = null;
        String stuId = null;
        int classNum = 0;
        int xbsjGrade = 0;


        JSONObject obj = null;

        String json = RequestPayload.getRequestPayload(request);

        try {
            obj = new JSONObject(json);
            className = obj.getString("className");
            stuId = obj.getString("stuId");
            classNum = obj.getInt("classNum");
            xbsjGrade = obj.getInt("xbsjGrade");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //存储请求的信息
        Map map= (Map) scoreMap.get(className + ":" + classNum + ":" + stuId);
        map.put("xbsjGrade", xbsjGrade);
        return 0;
    }

    /**
     * 这个主要是供管理端使用的
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/update/score3", method = RequestMethod.POST)
    @ResponseBody
    public int updateScore3(HttpServletRequest request) {
        //首先获得session 里面的map
        Map scoreMap = new HashMap();
        HttpSession session = request.getSession(false);
        if (session != null) {
            scoreMap = (Map) session.getAttribute("updatescore");
        }
        //解析post 请求，得到请求的信息
        String className = null;
        String stuId = null;
        int classNum = 0;
        int xbsjGrade = 0;
        int wlzzxxGrade = 0;
        int knskGrade = 0;

        JSONObject obj = null;

        String json = RequestPayload.getRequestPayload(request);

        try {
            obj = new JSONObject(json);
            className = obj.getString("className");
            stuId = obj.getString("stuId");
            classNum = obj.getInt("classNum");
            xbsjGrade = obj.getInt("xbsjGrade");
            wlzzxxGrade = obj.getInt("wlzzxxGrade");
            knskGrade = obj.getInt("knskGrade");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //存储请求的信息
        //存储请求的信息
        Map map= (Map) scoreMap.get(className + ":" + classNum + ":" + stuId);
        map.put("xbsjGrade", xbsjGrade);
        map.put("wlzzxxGrade", wlzzxxGrade);
        map.put("knskGrade", knskGrade);
        return 0;
    }

    /**
     * 教师端：根据教师工号下载课表
     * @param session
     * @param response
     * @return
     */
    @RequestMapping("/download/courseTable")
    public ModelAndView downloadCourseTable(HttpSession session,HttpServletResponse response) {
        String teaId = (String) session.getAttribute("userId");
        String[][] tables = teacherService.findCourseTable(teaId);

        Map res = new HashMap();

        res.put("data", tables);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style", "wider");
        model.put("student",0);

        //根据学生的名称设置pdf的文件名
        response = ResponseWrap.setName(response, (String) session.getAttribute("username")+"的课表","pdf");

        return new ModelAndView(new StudentTablePdfView(), model);
    }

    /**
     * 根据教师id下载课表
     * @param response
     * @param session
     */
    @RequestMapping("/download/courseTableExcel")
    public void downloadCourseTableExcel(HttpServletResponse response, HttpSession session) {
        String teaId = (String) session.getAttribute("userId");
        String[][] tables = teacherService.findCourseTable(teaId);
        List<CourseTableExcelDomain> liC = new ArrayList<>();
        for (int i = 0; i < tables.length; i = i + 1) {
            liC.add(new CourseTableExcelDomain(i, tables[i][0], tables[i][1], tables[i][2], tables[i][3]
                    , tables[i][4], tables[i][5], tables[i][6]));
        }

        response = ResponseWrap.setName(response, (String) session.getAttribute("username")+"的课表","xls");

        ExportParams params = new ExportParams();
        params.setTitle("课表");

        Workbook workbook = ExcelExportUtil.exportExcel(params, CourseTableExcelDomain.class, liC);

        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/add/classApplication", method = RequestMethod.POST)
    @ResponseBody
    public int addClassApplication(HttpServletRequest request) throws JSONException  {
        String userId= (String) request.getSession().getAttribute("userId");
        String username= (String) request.getSession().getAttribute("username");
        int departId= (int) request.getSession().getAttribute("departId");
        String departName=(String) request.getSession().getAttribute("dep");
        String json = RequestPayload.getRequestPayload(request);
        JSONObject obj = new JSONObject(json);
        String courseNameCHS=obj.getString("className");
        String courseNameEN=obj.getString("classNameEN");
        int moduleId=obj.getInt("classModuleNum");
        String academicYear=obj.getString("classYear");
        int classSemesterInt=obj.getInt("classSemester");
        int classHour=obj.getInt("classTime");
        int stuNumUpperLimit=obj.getInt("limitPerson");
        String teacherName=obj.getString("mainLecturer");
        String teacherId=obj.getString("mainLecturerId");
        JSONArray teacherArray= (JSONArray) obj.get("teacherList");

        String courseInfo=obj.getString("courseInfo");
        String teacherInfo=obj.getString("teacherInfo");
        int fileInfoId=obj.getInt("fileInfoId");

        CourseApplication courseApp=new CourseApplication();
        courseApp.setDepartId(departId);
        courseApp.setDepartName(departName);
        courseApp.setCourseNameEN(courseNameEN);
        courseApp.setCourseNameCHS(courseNameCHS);
        courseApp.setModuleId(moduleId);
        courseApp.setAcademicYear(academicYear);
        if(classSemesterInt==1){
            courseApp.setClassSemester("春季");
        }else if(classSemesterInt==2){
            courseApp.setClassSemester("秋季");
        }else if(classSemesterInt==3){
            courseApp.setClassSemester("春秋季");
        }
        courseApp.setClassHour(classHour);
        courseApp.setStuNumUpperLimit(stuNumUpperLimit);
        courseApp.setTeacherId(teacherId);
        courseApp.setTeacherName(teacherName);
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
        courseApp.setTeachingTeamIds(teachingTeamIds.toString());
        courseApp.setTeachingTeamNames(teachingTeamNames.toString());
        courseApp.setCourseInfo(courseInfo);
        courseApp.setTeacherInfo(teacherInfo);
        courseApp.setFileInfoId(fileInfoId);
        courseApp.setOperatorId(userId);
        courseApp.setOperatorName(username);
        courseApp.setOperateDate(new Date());
        return courseAllService.addCourseApp(courseApp);
    }

    @RequestMapping("/find/application")
    @ResponseBody
    public Map<String, Object> findApplication(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            HttpSession session
    ) {
        PageHelper.startPage(currentPage, pageSize);

        List<Map<String, Object>> list = teacherService.findApplication((String) session.getAttribute("userId"));

        Map<String, Object> res = new HashMap<>();
        res.put("status", "SUCCESS");

        Map<String, Object> data = new HashMap<>();
        data.put("total", ((Page) list).getTotal());
        System.out.printf("total = %s\n", ((Page) list).getTotal());
        data.put("pageSize", pageSize);
        data.put("currentPage", currentPage);
        data.put("list", list);
        res.put("data", data);
        return res;
    }

//存储分数
    @RequestMapping(value = "/store/score1", method = RequestMethod.POST)
    @ResponseBody
    public int storeGrade1(HttpServletRequest request) {
        tianjiaMap(request);
        Map map = (Map) request.getSession(false).getAttribute("updatescore");
        for (Object i : map.keySet()) {
            if (!i.toString().equals("operator")) {
                String[] strs = i.toString().split(":");
                String className = strs[0];
                String classNum = strs[1];
                String stuId = strs[2];
                Map scoreMap = (Map) map.get(i);
                int wlzzxxGrade = (int) scoreMap.get("wlzzxxGrade");
                int knskGrade = (int) scoreMap.get("knskGrade");

                classService.updateScore3(className, Integer.parseInt(classNum), stuId,88888888, wlzzxxGrade, knskGrade);
            }
        }
        return 0;
    }

    @RequestMapping(value = "/store/score2", method = RequestMethod.POST)
    @ResponseBody
    public int storeGrade2(HttpServletRequest request) {
        tianjiaMap(request);
        Map map = (Map) request.getSession(false).getAttribute("updatescore");
        for (Object i : map.keySet()) {
            if (!i.toString().equals("operator")) {
                String[] strs = i.toString().split(":");
                String className = strs[0];
                String classNum = strs[1];
                String stuId = strs[2];
                Map scoreMap = (Map) map.get(i);
                int xbsjGrade = (int) scoreMap.get("xbsjGrade");

                classService.updateScore3(className, Integer.parseInt(classNum), stuId, xbsjGrade,88888888,88888888);
            }
        }
        return 0;
    }

    @RequestMapping(value = "/store/score3", method = RequestMethod.POST)
    @ResponseBody
    public int storeGrade3(HttpServletRequest request) {
        tianjiaMap(request);
        Map map = (Map) request.getSession(false).getAttribute("updatescore");
        for (Object i : map.keySet()) {
            if (!i.toString().equals("operator")) {
                String[] strs = i.toString().split(":");
                String className = strs[0];
                String classNum = strs[1];
                String stuId = strs[2];
                Map scoreMap = (Map) map.get(i);
                int xbsjGrade = (int) scoreMap.get("xbsjGrade");
                int wlzzxxGrade = (int) scoreMap.get("wlzzxxGrade");
                int knskGrade = (int) scoreMap.get("knskGrade");
                classService.updateScore3(className, Integer.parseInt(classNum), stuId, xbsjGrade,wlzzxxGrade,knskGrade);
            }
        }
        return 0;
    }

    //发布模块一的成绩
    @RequestMapping(value = "/issue/grade1", method = RequestMethod.POST)
    @ResponseBody
    public int issueGrade1(HttpServletRequest request) {
        Map map = (Map) request.getSession(false).getAttribute("updatescore");

        //读取设置的成绩设置的百分比，并转化成小数
        Map<String, Object> m = teacherService.findGradePercent();
        float KNSKPercent = Float.valueOf(String.valueOf(m.get("KNSK"))) / 100;     //课内授课百分比
        float XBSJercent = Float.valueOf(String.valueOf(m.get("XBSJ"))) / 100;      //小班实践百分比
        float ZZXXPercent = Float.valueOf(String.valueOf(m.get("ZZXX"))) / 100;     //在线学习百分比
        System.out.println(KNSKPercent + "---" + XBSJercent + "---" + ZZXXPercent);

        // 不能出现空的分数
        for (Object i : map.keySet()) {
            if (!i.toString().equals("operator")) {
                //获取到学生的班级名称，班级号，学生学号
                String[] strs = i.toString().split(":");
                String className = strs[0];
                String classNum = strs[1];
                String stuId = strs[2];
                Map scoreMap = (Map) map.get(i);        // 获得每一条数据
                int wlzzxxGrade = (int) scoreMap.get("wlzzxxGrade");
                int knskGrade = (int) scoreMap.get("knskGrade");
                int xbsjGrade = (int) scoreMap.get("xbsjGrade");

                // 获取选修的该门课程，判断对应的学时，并进行填写成绩，若为16学时，小班实践成绩百分比为50%*XBSJercent，若为32学时，为XBSJercent
                Map<String, Object> l = teacherService.findCourseClassTime(classNum, stuId);
                int xueshi = (int) l.get("classTime");
                int flag = 0;
                zuizhongchengji(xueshi,XBSJercent,ZZXXPercent,KNSKPercent,wlzzxxGrade, knskGrade,xbsjGrade,className,
                        classNum,stuId,flag);
            }
        }
        //保存模块一的成绩
        storeGrade1(request);
        String json = RequestPayload.getRequestPayload(request);
        System.out.println(json);
        try {
            JSONObject obj = new JSONObject(json);
            int classId = obj.getInt("classId");
            return teacherService.issueGrade(classId,1,0);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public void zuizhongchengji(int xueshi,float XBSJercent, float ZZXXPercent, float KNSKPercent, int wlzzxxGrade,
                                int knskGrade, int xbsjGrade, String className, String classNum, String stuId, int flag){
        if (xueshi == 16) {
            // 小班实践比例减半
            float pe = (float) (XBSJercent / 2.0);
            //计算总成绩
            System.out.println("-------------------------------" + pe + " ------------" + xbsjGrade * pe);
            int zzGrade = (int) ((wlzzxxGrade * ZZXXPercent) + (knskGrade * KNSKPercent) + (xbsjGrade * pe));
            classService.zzGrade(className, Integer.parseInt(classNum), stuId, zzGrade, flag);
        }else if(xueshi == 32){
            float pe = (float) (XBSJercent / 2.0);
            flag = 1;
            int zzGrade = (int) ((wlzzxxGrade * ZZXXPercent) + (knskGrade * KNSKPercent) + (xbsjGrade * pe));
            classService.zzGrade(className, Integer.parseInt(classNum), stuId, zzGrade, flag);
        }
    }

    @RequestMapping(value = "/issue/grade2", method = RequestMethod.POST)
    @ResponseBody
    public int issueGrade2(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);

        Map map = (Map) request.getSession(false).getAttribute("updatescore");
        //读取设置的成绩设置的百分比，并转化成小数
        Map<String, Object> m = teacherService.findGradePercent();
        float KNSKPercent = Float.valueOf(String.valueOf(m.get("KNSK"))) / 100;     //课内授课百分比
        float XBSJercent = Float.valueOf(String.valueOf(m.get("XBSJ"))) / 100;      //小班实践百分比
        float ZZXXPercent = Float.valueOf(String.valueOf(m.get("ZZXX"))) / 100;     //在线学习百分比
        for (Object i : map.keySet()) {
            if (!i.toString().equals("operator")) {
                String[] strs = i.toString().split(":");
                String className = strs[0];
                String classNum = strs[1];
                String stuId = strs[2];
                Map scoreMap = (Map) map.get(i);
                int wlzzxxGrade = (int) scoreMap.get("wlzzxxGrade");
                int knskGrade = (int) scoreMap.get("knskGrade");
                int xbsjGrade = (int) scoreMap.get("xbsjGrade");
                Map<String, Object> l = teacherService.findCourseClassTime(classNum, stuId);
                int xueshi = (int) l.get("classTime");
                int flag = 0;
                zuizhongchengji(xueshi,XBSJercent,ZZXXPercent,KNSKPercent,wlzzxxGrade, knskGrade,xbsjGrade,className,
                        classNum,stuId,flag);
                classService.updateScore3(className, Integer.parseInt(classNum), stuId, xbsjGrade,88888888,88888888);
            }
        }

        System.out.println(json);
        try {
            JSONObject obj = new JSONObject(json);
            int classId = obj.getInt("classId");
            return teacherService.issueGrade(classId,0,1);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    @RequestMapping(value = "/issue/grade3", method = RequestMethod.POST)
    @ResponseBody
    public int issueGrade3(HttpServletRequest request) {
        Map map = (Map) request.getSession(false).getAttribute("updatescore");
        //读取设置的成绩设置的百分比，并转化成小数
        Map<String, Object> m = teacherService.findGradePercent();
        float KNSKPercent = Float.valueOf(String.valueOf(m.get("KNSK"))) / 100;     //课内授课百分比
        float XBSJercent = Float.valueOf(String.valueOf(m.get("XBSJ"))) / 100;      //小班实践百分比
        float ZZXXPercent = Float.valueOf(String.valueOf(m.get("ZZXX"))) / 100;     //在线学习百分比

        for (Object i : map.keySet()) {
            if (!i.toString().equals("operator")) {
                String[] strs = i.toString().split(":");
                String className = strs[0];
                String classNum = strs[1];
                String stuId = strs[2];
                Map scoreMap = (Map) map.get(i);
                int wlzzxxGrade = (int) scoreMap.get("wlzzxxGrade");
                int knskGrade = (int) scoreMap.get("knskGrade");
                int xbsjGrade = (int) scoreMap.get("xbsjGrade");
                Map<String, Object> l = teacherService.findCourseClassTime(classNum, stuId);
                int xueshi = (int) l.get("classTime");
                int flag = 0;
                zuizhongchengji(xueshi,XBSJercent,ZZXXPercent,KNSKPercent,wlzzxxGrade, knskGrade,xbsjGrade,className,
                        classNum,stuId,flag);
                classService.updateScore3(className, Integer.parseInt(classNum), stuId, xbsjGrade, wlzzxxGrade, knskGrade);
            }
        }

        String json = RequestPayload.getRequestPayload(request);
        System.out.println(json);
        try {
            JSONObject obj = new JSONObject(json);
            int classId = obj.getInt("classId");
            return teacherService.issueGrade(classId,1,1);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    void tianjiaMap(HttpServletRequest request) {
        if (request.getSession().getAttribute("updatescore1") == null ||
                request.getSession().getAttribute("updatescore2") == null) {
            Map updateScore = new HashMap<>();
            updateScore.put("operator", request.getSession().getAttribute("username"));
            HttpSession httpSession = request.getSession();

            httpSession.setAttribute("updatescore1", updateScore);
            httpSession.setAttribute("updatescore2", updateScore);
        }
    }
    /*
    * 教师端对某学生添加评价
    * */
    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    @ResponseBody
    public int addComment(HttpServletRequest request) {
        String teaId = (String) request.getSession().getAttribute("userId");
        String jsonString = RequestPayload.getRequestPayload(request);
        try {
            JSONObject json=new JSONObject(jsonString);
            System.out.println("json"+json);
            JSONObject valuejson = json.getJSONObject("value");
            String stuId=valuejson.getString("stuId");
            String classId=valuejson.getString("classId");
            String suggestion=valuejson.getString("evaluation");
            List<String> scores=new ArrayList<>();
            for(int i=0;i<5;i++){
                scores.add(valuejson.getString("value"+Integer.toString(i+1)));
            }


           return teacherService.addComment(classId,suggestion,teaId,scores,stuId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
  /*
  * 教师开课课程
  * */
    @RequestMapping("/courses")
    @ResponseBody
    public Map<String, Object> courseList(HttpSession session){
        String teaId = (String)session.getAttribute("userId");
        teaId="0002017115";
        System.out.println(teaId);
        Map<String, Object> res = new HashMap<>();
        List<Map<String,Object>> courses = classService.findClass(88888888, "", "0002017115", 88888888, 88888888);
        String[] weekDays={"周一","周二","周三","周四","周五","周六","周日"};
       for(Map<String,Object> course:courses){
           String classInfo="";
           String[] classDate = ((String) course.get("classDateDescription")).split(":");
           classInfo+=weekDays[Integer.parseInt(classDate[0])-1]+"第"+classDate[1]+"-"+(Integer.parseInt(classDate[1])+Integer.parseInt(classDate[2])-1)+"节";
           course.put("classInfo",classInfo);
           int evaluationStatus= classService.CommentStatus(Integer.toString((int) course.get("classId")));
           course.put("evaluationStatus",evaluationStatus);
       }
        if(courses.size()==0){
            res.put("status","success");
            res.put("msg","0");
            return res;
        }
        res.put("courses",courses);
        res.put("msg",1);
        res.put("courseSize",courses.size());
        res.put("status", "success");

        return res;
    }

    /*
    * 课程学生翻页
    * */
    @RequestMapping(value="/comment/pageStudent")
    @ResponseBody
    public Map<String, Object> pageStudent(HttpServletRequest request,
                                           @RequestParam(required = false, defaultValue = "1") int currentPage,
                                           @RequestParam(required = false, defaultValue = "10") int pageSize,
                                           @RequestParam(required = false, defaultValue = "88888888") int classId){

        String teaId = (String) request.getSession().getAttribute("userId");
      /*  String jsonString = RequestPayload.getRequestPayload(request);
        System.out.println(jsonString);*/
        System.out.println(currentPage+"\n"+classId);
       if(classId==88888888){
           List<Map<String,Object>> courses = classService.findClass(88888888, "", teaId, 88888888, 88888888);
           classId= (int) courses.get(0).get("classId");
       }
        Map<String,Object> res=new HashMap<>();
        Page page=PageHelper.startPage(currentPage, pageSize);
        List students = teacherService.findStudentAndStatus(classId,teaId);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(students);
        res.put("total",page.getTotal());
        List<Map<String,Object>> pageList=pageInfo.getList();
        Map<String, Object> data = new HashMap<>();
        data.put("students",pageList);
        res.put("currentPage",currentPage);
        res.put("data", data);
        res.put("status", "SUCCESS");
        return res;

    }
/*
* 查看某个学生已评价的信息
* */
    @RequestMapping("/comment/info")
    @ResponseBody
    public Map<String, Object> commentInfo(HttpSession session,
                                           @RequestParam(required = true) int classId,
                                           @RequestParam(required = true) int stuId
    ){
       // String teaId = (String)session.getAttribute("userId");
        Map<String, Object> res = new HashMap<>();
        Map<String, Object> comment = teacherService.findCommentByClassIdAndStuId(classId, stuId);
        res.put("comment",comment);
        return res;
    }
    /*currentWeek*/
    @RequestMapping("/currentWeek")
    @ResponseBody
    public Map<String,Object> currentWeek(HttpServletRequest request){
        String firstWeek= (String) teacherService.findCurrentCalendar().get("firstWeek");
        int weekth= CalculateWeekth.weekth(firstWeek);
        Map<String,Object> res=new HashMap<>();
        res.put("weekth",weekth);
        return res;
    }
    /*weekCourse*/
    @RequestMapping("/weekCourses")
    @ResponseBody
    public Map<String, Object> weekCourse(HttpServletRequest request,
                                          @RequestParam(required = true) int weekth){
        String teaId = (String)request.getSession().getAttribute("userId");
//        teaId="0002017115";
        String jsonString = RequestPayload.getRequestPayload(request);
        System.out.println(jsonString);
        System.out.println("weekth："+weekth);
        String semester=(String) teacherService.findCurrentCalendar().get("semester");
        List<Map<String,Object>> courses = classService.findWeekCourses(teaId,semester,weekth);
        String[] weekDays={"周一","周二","周三","周四","周五","周六","周日"};
        for(Map<String,Object> course:courses){
            String classInfo="";
            String[] classDate = ((String) course.get("classDateDescription")).split(":");
            classInfo+=weekDays[Integer.parseInt(classDate[0])-1]+"第"+classDate[1]+"-"+(Integer.parseInt(classDate[1])+Integer.parseInt(classDate[2])-1)+"节";
            course.put("classInfo",classInfo);
        }
        Map<String, Object> res = new HashMap<>();
        res.put("courses",courses);
        res.put("courseSize",courses.size());
        res.put("weekth",weekth);
        res.put("status", "success");
        return res;
    }

    @RequestMapping("/weekCourseStudent")
    @ResponseBody
    public Map<String, Object> weekCourseStudent(HttpSession session,
                                                 @RequestParam(required = true) String classId,
                                                 @RequestParam(required = true) int week){
        String teaId = (String)session.getAttribute("userId");
        List<Map<String,Object>> students=classService.findStudent(Integer.parseInt(classId));

        for(Map<String,Object>student:students){
           List comments=classService.findWeekComment((String) student.get("stuId"),week,classId);
           if(comments.size()==0){
               for(int i=0;i<4;i++){
                   student.put("score"+(i+1),0);
               }
               student.put("comment","0");
           }else if(comments.size()>0){
               Map<String,Object> comment= (Map<String, Object>) comments.get(0);
               for(int i=0;i<4;i++){
                   student.put("score"+(i+1),comment.get("score"+(i+1)));
               }
               student.put("comment",comment.get("suggestion"));

           }
        }
        System.out.println(students);
        Map<String, Object> res = new HashMap<>();
        res.put("students",students);
        res.put("status", "success");
        return res;
    }
    @RequestMapping(value="/addWeekComment",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addWeekComment(HttpServletRequest request) throws JSONException {
        String jsonString= RequestPayload.getRequestPayload(request);
        JSONArray jsonArray=new JSONArray(jsonString);
        JSONObject json=jsonArray.getJSONObject(0);
        int weekth = (int) json.get("weekth");
        int classId = Integer.parseInt((String) json.get("classId"));
        JSONArray studentjsonArray=json.getJSONArray("students");
        List<Map<String,Object>> commentList =new ArrayList<>();
        for (int i=0; i<studentjsonArray.length(); i++){
            JSONObject studentJson=studentjsonArray.getJSONObject(i);
            Map<String,Object> studentMap=new HashMap<>();
            studentMap.put("stuId",studentJson.getString("stuId"));
            for(int j=0;j<4;j++){
                studentMap.put("score"+(j+1),studentJson.getString("score"+(j+1)));
            }
            studentMap.put("suggestion",studentJson.getString("comment"));
            commentList.add(studentMap);
        }

        String teaId= (String) request.getSession().getAttribute("userId");
        String firstWeek= (String) teacherService.findCurrentCalendar().get("firstWeek");
        int currentWeekth= CalculateWeekth.weekth(firstWeek);
        Map<String,Object> res=new HashMap<>();
        String status="";
        if((currentWeekth-weekth)>1){
            res.put("status","超过评价时间");
            return res;
        }
        if(currentWeekth<weekth){
            res.put("status","未到评价时间");
            return res;
        }
        int  flag=teacherService.addWeekComment(classId,teaId,weekth,commentList);

        if(flag==1){
           status="success";
        }
        res.put("status",status);
        return res;

    }

    @RequestMapping("/downloadTemplate")
    @ResponseBody
    public String downloadTemplate(HttpServletRequest request,HttpServletResponse response) {
        Map<String, Object> fileInfo=teacherService.findTemplateFile();
        String fileName=(String)fileInfo.get("fileName");
        String path=(String)fileInfo.get("path");
        File file=new File(path+fileName);
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

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, Object> uploadPlan(@RequestParam("file") MultipartFile file,HttpServletRequest request){
        String teaId=(String)request.getSession().getAttribute("userId");
        String dep=(String) request.getSession().getAttribute("dep");
        Map<String,Object> res=new HashMap<>();
        try {
            if (file.isEmpty()) {
                res.put("status","文件为空");
                return res;
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            logger.info("上传的文件名为：" + fileName);

            // 设置文件存储路径
            String filePath=request.getSession().getServletContext().getRealPath(File.separator)+"/file/";
            String path = filePath + fileName;
            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date=sdf.format(new Date());
            int fileInfoId=teacherService.addFileInfo(teaId,fileName,path,2,dep,date,1);
            res.put("status","上传成功");
            res.put("fileInfoId",fileInfoId);
            return res;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;

    }
    /**
     * 教师端：根据教师Id查询教师课程
     * @param session
     * @param
     * @return
     */
    @RequestMapping("teach/findCourse")
    @ResponseBody
    public Map findTeachCourse(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            HttpSession session
    ) {
        String teacherId = (String) session.getAttribute("userId");
//        String teacherId = "0000096131";
        Map<String,Object> res=new HashMap<>();
//        PageHelper.startPage(currentPage, pageSize);
        Page page=PageHelper.startPage(currentPage, pageSize);
        List classes = classService.findTeachCourse(teacherId);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(classes);
//        res.put("total",page.getTotal());
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
     * 教师端：根据班级Id导出选课学生名单Excel
     * @param
     * @param
     * @return
     */

    @RequestMapping("/downloadStudentsExcel")
    @ResponseBody
    public void downloadStudentsExcel(HttpServletResponse response,@RequestParam("classId") int classId ,
                                      @RequestParam("className") String className,
                                      @RequestParam("classNum") String classNum) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(className+classNum+"选课学生名单");
        List<Map<String,Object>> students = classService.findStudent(classId);
        String fileName =className+classNum+ "选课学生名单"  + ".xls";//设置要导出的文件的名字
        String[] headers={"姓名","学号"};
        HSSFRow headerRow=sheet.createRow(0);
        //添加表头
        for(int i=0;i<headers.length;i++){
            HSSFCell cell=headerRow.createCell(i);
            HSSFRichTextString text=new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        int rowNum=1;
        System.out.print(students);
        for(Map<String,Object> stu:students){
            HSSFRow row=sheet.createRow(rowNum);
            row.createCell(0).setCellValue((String) stu.get("name"));
            row.createCell(1).setCellValue((String) stu.get("stuId"));
//            row.createCell(2).setCellValue((String) stu.get("className")+stu.get("classNum")+"班");
            rowNum++;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName,"utf-8"));
        response.flushBuffer();
        workbook.write(response.getOutputStream());

    }

    /**
     * 教师端：根据班级Id导出选课学生名单PDF
     * @param
     * @param
     * @return
     */
    @RequestMapping("/downloadStudentsPdf")
    @ResponseBody
    public ModelAndView downloadStudentsPdf(@RequestParam("classId") int classId ,
            @RequestParam("className") String className ,@RequestParam("classNum") int classNum ,
                                            HttpSession session, HttpServletResponse response) {
//        int classId=501;
//        String className="英语";
//        int classNum=1;
        System.out.print(classId);
        System.out.print(className);
        System.out.print(classNum);

        response = ResponseWrap.setName(response, className+classNum + "班选课名单", "pdf");
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
     * 教师端：根据班级Id查看学生名单
     * @param
     * @param
     * @return
     */
    @RequestMapping("teach/findStudents")
    @ResponseBody
    public Map findStudents(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam("classId") int classId
    ) {

        Map<String,Object> res=new HashMap<>();
        Page page=PageHelper.startPage(currentPage, pageSize);
        List<Map<String,Object>> students = classService.findStudent(classId);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(students);
        res.put("total",page.getTotal());
        List<Map<String,Object>> pageList=pageInfo.getList();
        Map<String, Object> data = new HashMap<>();
        data.put("students",pageList);
        res.put("currentPage",currentPage);
        res.put("data", data);
        res.put("status", "SUCCESS");
        return res;
    }
    @RequestMapping("/downloadExcel")
    @ResponseBody
    public void downloadExcel(HttpServletResponse response,@RequestParam("classId") int classId) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("成绩表");
        List<Map<String,Object>> students = classService.findStudent(classId);
        String fileName = "学生名单"  + ".xls";//设置要导出的文件的名字

        String[] headers={"姓名","学号","班级","成绩"};
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
            row.createCell(2).setCellValue((String) stu.get("className")+stu.get("classNum")+"班");
            rowNum++;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName,"utf-8"));
        response.flushBuffer();
        workbook.write(response.getOutputStream());

    }
    @RequestMapping("/uploadGradeExcel")
    @ResponseBody
    public Map<String, Object> uploadGradeExcel(@RequestParam("file") MultipartFile file,HttpServletRequest request){
        Map<String,Object> res=new HashMap<>();
        String userId= (String) request.getSession().getAttribute("userId");
        String dep= (String) request.getSession().getAttribute("dep");
        String filePath=request.getSession().getServletContext().getRealPath(File.separator)+"/file/";
        int type=3;
        int fileInfoId= teacherService.uploadFile(file,userId,dep,type,filePath);
        if (fileInfoId==0){
            res.put("status","error");
        }else{
            res.put("status","success");
            res.put("fileInfoId",fileInfoId);
        }
        return res;
    }
    @RequestMapping("insertGradeExcel")
    @ResponseBody
    public Map<String,Object> insertGradeExcel(@RequestParam("classId") int classId,@RequestParam("fileInfoId") int fileInfoId){
        Map<String,Object> res=new HashMap<>();
        int flag=teacherService.insertGradeExcel(classId,fileInfoId);
        if(flag==0){
            res.put("status","上传成绩失败！");
        }else{
            res.put("status","上传成绩成功！");
        }
        return res;
    }


}
