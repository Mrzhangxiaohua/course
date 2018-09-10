package com.spc.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.spc.model.ClassApplicationDomain;
import com.spc.model.ClassDomain;
import com.spc.model.CourseTableExcelDomain;
import com.spc.model.UserDomain;
import com.spc.service.classes.ClassService;
import com.spc.service.grade.GradeService;
import com.spc.service.teacher.TeacherService;

import com.spc.util.CourseDateTrans;
import com.spc.view.StudentTablePdfView;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.spc.util.RequestPayload;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
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
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false, defaultValue = "88888888") Integer classId) {
        List students = new ArrayList();
        if (classId != 88888888) {
            PageHelper.startPage(currentPage, pageSize);

            students = classService.findStudent(classId);


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
            scoreMap = (Map) session.getAttribute("updatescore1");
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
        Map tempM = new HashMap();
        tempM.put("wlzzxxGrade", wlzzxxGrade);
        tempM.put("knskGrade", knskGrade);
        scoreMap.put(className + ":" + classNum + ":" + stuId, tempM);
        System.out.println(request.getSession().getAttribute("updatescore1"));

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
            scoreMap = (Map) session.getAttribute("updatescore2");
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
        Map tempM = new HashMap();
        tempM.put("xbsjGrade", xbsjGrade);
        scoreMap.put(className + ":" + classNum + ":" + stuId, tempM);
        System.out.println(request.getSession().getAttribute("updatescore2"));
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
            scoreMap = (Map) session.getAttribute("updatescore3");
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
        Map tempM = new HashMap();
        tempM.put("xbsjGrade", xbsjGrade);
        tempM.put("wlzzxxGrade", wlzzxxGrade);
        tempM.put("knskGrade", knskGrade);
        scoreMap.put(className + ":" + classNum + ":" + stuId, tempM);
        System.out.println(request.getSession().getAttribute("updatescore3"));
        return 0;
    }

    @RequestMapping("/download/courseTable")
    public ModelAndView downloadCourseTable(HttpSession session) {
        String teaId = (String) session.getAttribute("userId");
        String[][] tables = teacherService.findCourseTable(teaId);
        System.out.println(tables);

        Map res = new HashMap();

        res.put("data", tables);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style", "wider");

        return new ModelAndView(new StudentTablePdfView(), model);
    }

    @RequestMapping("/download/courseTableExcel")
    public void downloadCourseTableExcel(HttpServletResponse response, HttpSession session) {
        String teaId = (String) session.getAttribute("userId");
        String[][] tables = teacherService.findCourseTable(teaId);

        List<CourseTableExcelDomain> liC = new ArrayList<>();
        for (int i = 0; i < tables.length; i = i + 2) {
            liC.add(new CourseTableExcelDomain(i / 2, tables[i][0], tables[i][1], tables[i][2], tables[i][3]
                    , tables[i][4], tables[i][5], tables[i][6]));
        }
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=Table.xls");

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
//        cad.setTeaId("");
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

    @RequestMapping(value = "/store/score1", method = RequestMethod.POST)
    @ResponseBody
    public int storeGrade1(HttpServletRequest request) {
        tianjiaMap(request);
        Map map = (Map) request.getSession(false).getAttribute("updatescore1");
        for (Object i : map.keySet()) {
            if (!i.toString().equals("operator")) {
                String[] strs = i.toString().split(":");
                String className = strs[0];
                String classNum = strs[1];
                String stuId = strs[2];
                Map scoreMap = (Map) map.get(i);
                int wlzzxxGrade = (int) scoreMap.get("wlzzxxGrade");
                int knskGrade = (int) scoreMap.get("knskGrade");
                classService.updateScore1(className, Integer.parseInt(classNum), stuId, wlzzxxGrade, knskGrade);
            }
        }
        return 0;
    }

    @RequestMapping(value = "/store/score2", method = RequestMethod.POST)
    @ResponseBody
    public int storeGrade2(HttpServletRequest request) {
        tianjiaMap(request);
        Map map = (Map) request.getSession(false).getAttribute("updatescore2");
        for (Object i : map.keySet()) {
            if (!i.toString().equals("operator")) {
                String[] strs = i.toString().split(":");
                String className = strs[0];
                String classNum = strs[1];
                String stuId = strs[2];
                Map scoreMap = (Map) map.get(i);
                int xbsjGrade = (int) scoreMap.get("xbsjGrade");

                classService.updateScore2(className, Integer.parseInt(classNum), stuId, xbsjGrade);
            }
        }
        return 0;
    }

    @RequestMapping(value = "/store/score3", method = RequestMethod.POST)
    @ResponseBody
    public int storeGrade3(HttpServletRequest request) {
        tianjiaMap(request);
        Map map = (Map) request.getSession(false).getAttribute("updatescore3");
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

    @RequestMapping(value = "/issue/grade1", method = RequestMethod.POST)
    @ResponseBody
    public int issueGrade1(HttpServletRequest request) {
        Map map = (Map) request.getSession(false).getAttribute("updatescore1");
        for (Object i : map.keySet()) {
            if (!i.toString().equals("operator")) {
                String[] strs = i.toString().split(":");
                String className = strs[0];
                String classNum = strs[1];
                String stuId = strs[2];
                Map scoreMap = (Map) map.get(i);
                int wlzzxxGrade = (int) scoreMap.get("wlzzxxGrade");
                int knskGrade = (int) scoreMap.get("knskGrade");
                classService.updateScore1(className, Integer.parseInt(classNum), stuId, wlzzxxGrade, knskGrade);
            }
        }
        String json = RequestPayload.getRequestPayload(request);
        System.out.println(json);
        try {
            JSONObject obj = new JSONObject(json);
            int classId = obj.getInt("classId");
            return teacherService.issueGrade(classId);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }


    @RequestMapping(value = "/issue/grade2", method = RequestMethod.POST)
    @ResponseBody
    public int issueGrade2(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);

        Map map = (Map) request.getSession(false).getAttribute("updatescore2");
        for (Object i : map.keySet()) {
            if (!i.toString().equals("operator")) {
                String[] strs = i.toString().split(":");
                String className = strs[0];
                String classNum = strs[1];
                String stuId = strs[2];
                Map scoreMap = (Map) map.get(i);
                int xbsjGrade = (int) scoreMap.get("xbsjGrade");

                classService.updateScore2(className, Integer.parseInt(classNum), stuId, xbsjGrade);
            }
        }

        System.out.println(json);
        try {
            JSONObject obj = new JSONObject(json);
            int classId = obj.getInt("classId");
            return teacherService.issueGrade(classId);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    @RequestMapping(value = "/issue/grade3", method = RequestMethod.POST)
    @ResponseBody
    public int issueGrade3(HttpServletRequest request) {
        Map map = (Map) request.getSession(false).getAttribute("updatescore3");
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

        String json = RequestPayload.getRequestPayload(request);
        System.out.println(json);
        try {
            JSONObject obj = new JSONObject(json);
            int classId = obj.getInt("classId");
            return teacherService.issueGrade(classId);
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
}
