package com.spc.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.spc.model.ClassApplicationDomain;
import com.spc.model.ClassDomain;
import com.spc.model.CourseTableExcelDomain;
import com.spc.service.classes.ClassService;
import com.spc.service.grade.GradeService;
import com.spc.service.teacher.TeacherService;
import com.spc.util.AuthMess;

import com.spc.view.StudentTablePdfView;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.spc.util.RequestPayload;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class TeacherController  extends Base{

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
    public List<Map> getTeachCourse() {
        String teacherId = userId;

        List<ClassDomain> classes = classService.findAllClass(88888888, "", teacherId, 88888888, 88888888);

        List<Map> resList = new ArrayList<Map>();

        for (int i = 0; i < classes.size(); i++) {
            Map<String, Object> res = new HashMap<>();
            res.put("className", classes.get(i).getClassName());
            res.put("classId", classes.get(i).getClassId());
            res.put("classStr", classes.get(i).getClassName() +"("+ classes.get(i).getClassNum()+")");
            resList.add(res);
        }
        return resList;
    }

    @RequestMapping("teach/course2")
    @ResponseBody
    public Map getTeachCourse2(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize
    ) {
        String teacherId = userId;
        PageHelper.startPage(currentPage, pageSize);
        List<ClassDomain> classes = classService.findAllClass(88888888, "", teacherId, 88888888, 88888888);


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
        if(classId!=88888888){
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
        }else{
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
    public String[][] findCourseTable() {
        String teaId = AuthMess.userId(authentication);
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
        String json = RequestPayload.getRequestPayload(request);
        System.out.println(json);

        try {
            JSONObject obj = new JSONObject(json);
            String className = obj.getString("className");
            String stuId = obj.getString("stuId");
            int wlzzxxGrade = obj.getInt("wlzzxxGrade");
            int knskGrade = obj.getInt("knskGrade");
            return classService.updateScore1(className, stuId, wlzzxxGrade,knskGrade);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
    /**
     * 教师端 更新分数
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/update/score2", method = RequestMethod.POST)
    @ResponseBody
    public int updateScore2(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);
        System.out.println(json);

        try {
            JSONObject obj = new JSONObject(json);
            String className = obj.getString("className");
            String stuId = obj.getString("stuId");
            int xbsjGrade = obj.getInt("xbsjGrade");
            return classService.updateScore2(className, stuId, xbsjGrade);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @RequestMapping(value = "/update/score3", method = RequestMethod.POST)
    @ResponseBody
    public int updateScore3(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);
        System.out.println(json);

        try {
            JSONObject obj = new JSONObject(json);
            String className = obj.getString("className");
            String stuId = obj.getString("stuId");
            int xbsjGrade = obj.getInt("xbsjGrade");
            int wlzzxxGrade = obj.getInt("wlzzxxGrade");
            int knskGrade = obj.getInt("knskGrade");

            return classService.updateScore3(className, stuId, xbsjGrade,wlzzxxGrade,knskGrade);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @RequestMapping("/download/courseTable")
    public ModelAndView downloadCourseTable() {
        String teaId = AuthMess.userId(authentication);
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
    public void downloadCourseTableExcel(HttpServletResponse response) {
        String teaId = AuthMess.userId(authentication);
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
    public int addClassApplication(@RequestBody ClassApplicationDomain cad) {
        cad.setChecked(2);
//        cad.setTeaId("");
        cad.setShenQingRenName(username);
        cad.setShenQingRenId(userId);
        return teacherService.addClassApplication(cad);
    }

    @RequestMapping("/find/application")
    @ResponseBody
    public  Map<String, Object>  findApplication(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize
    ){
        PageHelper.startPage(currentPage, pageSize);

        List<Map<String,Object>> list= teacherService.findApplication(AuthMess.userId(authentication));

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

    @RequestMapping(value = "/issue/grade",method = RequestMethod.POST)
    @ResponseBody
    public int issueGrade(HttpServletRequest request){
        String json = RequestPayload.getRequestPayload(request);
        System.out.println(json);
        try {
            JSONObject obj = new JSONObject(json);
            int classId = obj.getInt("classId");
            return teacherService.issueGrade(classId);
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }

}
