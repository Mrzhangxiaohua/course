package com.spc.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.spc.model.ClassApplicationDomain;
import com.spc.model.ClassDomain;
import com.spc.model.CourseTableExcelDomain;
import com.spc.service.classes.ClassService;
import com.spc.service.grade.GradeService;
import com.spc.service.teacher.TeacherService;

import com.spc.util.CalculateWeekth;
import com.spc.util.CourseDateTrans;
import com.spc.util.ResponseWrap;
import com.spc.view.StudentTablePdfView;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.spc.util.RequestPayload;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            li.setClassDateDescription(String.valueOf(CourseDateTrans.dateToString(Integer.parseInt(is[0]), Integer.parseInt(is[1]))));
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
        for (int i = 0; i < tables.length; i = i + 2) {
            liC.add(new CourseTableExcelDomain(i / 2, tables[i][0], tables[i][1], tables[i][2], tables[i][3]
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
    public int addClassApplication(@RequestBody ClassApplicationDomain cad,
                                   HttpSession session) {
        cad.setChecked(2);
        boolean urlTou = cad.getHomepage().contains("http://");
        String homePage = cad.getHomepage();
        if(urlTou) {
            homePage = cad.getHomepage().replace("http://", "");
        }
        cad.setTeacherInfo(cad.getTeacherInfo()+":"+homePage);
        cad.setShenQingRenName((String) session.getAttribute("username"));
        cad.setShenQingRenId((String) session.getAttribute("userId"));
        return teacherService.addClassApplication(cad);
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
        //不能出现空的分数
        for (Object i : map.keySet()) {
            if (!i.toString().equals("operator")) {
                String[] strs = i.toString().split(":");
                Map scoreMap = (Map) map.get(i);
                int wlzzxxGrade = (int) scoreMap.get("wlzzxxGrade");
                int knskGrade = (int) scoreMap.get("knskGrade");
                if(wlzzxxGrade==0||knskGrade==0){
                    return 3;
                }
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


    @RequestMapping(value = "/issue/grade2", method = RequestMethod.POST)
    @ResponseBody
    public int issueGrade2(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);

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
    /*weekCourse*/
    @RequestMapping("/weekCourses")
    @ResponseBody
    public Map<String, Object> weekCourse(HttpSession session){
        String teaId = (String)session.getAttribute("userId");
        teaId="0002017115";
        System.out.println(teaId);
        String firstWeek= (String) teacherService.findCurrentCalendar().get("firstWeek");
        int weekth= CalculateWeekth.weekth(firstWeek);
        System.out.println(weekth);
        String semester=(String) teacherService.findCurrentCalendar().get("semester");
        List<Map<String,Object>> courses = classService.findWeekCourses(teaId,semester,weekth);
        System.out.println(courses.size());
        Map<String, Object> res = new HashMap<>();
        res.put("courses",courses);
        res.put("courseSize",courses.size());
        res.put("status", "success");
        return res;
    }

    @RequestMapping("/weekCourseStudent")
    @ResponseBody
    public Map<String, Object> weekCourseStudent(HttpSession session,
                                                 @RequestParam(required = true) int classId){
        String teaId = (String)session.getAttribute("userId");
        List<Map<String,Object>> students=classService.findStudent(classId);
        Map<String, Object> res = new HashMap<>();
        res.put("students",students);
        res.put("status", "success");
        return res;
    }
    @RequestMapping("/addWeekComment")
    @ResponseBody
    public Map<String,Object> addWeekComment(HttpServletRequest request,
                              @RequestParam(required = true) int classId,
                              @RequestParam(required = true) int weekth,
                              @RequestParam(required = true) List<Map<String,Object>> commentList
                              ){
        String teaId= (String) request.getSession().getAttribute("userId");
        int courseSize=classService.findClassById(classId).getClassChooseNum();
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


   /* @RequestMapping("/weekComment")
    @ResponseBody
    public Map<String, Object> weekCourseStudent(HttpSession session){
        //int week=;第几周
        String teaId = (String)session.getAttribute("userId");
        Map<String, Object> res = new HashMap<>();
        List<Map<String,Object>> courses = classService.findClass(88888888, "", "0002017115", 88888888, 88888888);
        res.put("courses",courses);
        if(courses.size()==0){
            res.put("status","success");
            res.put("msg","0");
            return res;
        }
        res.put("status", "success");
        res.put("msg",1);
        res.put("courseSize",courses.size());
        return res;
    *//*    String teaId = (String)session.getAttribute("userId");
        Map<String, Object> res = new HashMap<>();
        List<Map<String,Object>> courses = classService.findClass(88888888, "", "0002017115", 88888888, 88888888);
        res.put("courses",courses);
        if(courses.size()==0){
            res.put("status","success");
            res.put("msg","0");
            return res;
        }
        res.put("status", "success");
        res.put("msg",1);
        res.put("courseSize",courses.size());

        Map<String, Object> data = new HashMap<>();
        for(int i=0;i<courses.size();i++){
            int classId= (int) courses.get(i).get("classId");
            PageHelper.startPage(1, 10);
            List students = teacherService.findStudentAndStatus(classId,teaId);
            PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(students);
            List<Map<String,Object>> pageList=pageInfo.getList();
            data.put("class"+Integer.toString(i),pageList);
        }
        res.put("data", data);
        return res;*//*
    }*/







}
