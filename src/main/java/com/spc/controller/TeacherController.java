package com.spc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.spc.model.ClassDomain;
import com.spc.service.classes.ClassService;
import com.spc.service.grade.GradeService;
import com.spc.util.AuthMess;

import com.spc.view.MyTablePdfView;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spc.util.RequestPayload;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/teacher")
@Controller
public class TeacherController {
    @Autowired
    RequestPayload requestPayload;

    @Autowired
    ClassService classService;

    @Autowired
    GradeService gradeService;

    @Autowired
    AuthMess authMess;

    /**
     * 教师端：录入分数
     * @param request
     * @return
     */
    @RequestMapping(value ="/grade/add" ,method = RequestMethod.POST)
    @ResponseBody
    public int addGrade(HttpServletRequest request){
        try {
            String json = requestPayload.getRequestPayload(request);
            System.out.println(json);
            JSONObject obj = new JSONObject(json);

            Integer classId= obj.getInt("classId");
            Integer stuId = obj.getInt("stuId");
            Integer score = obj.getInt("score");

            return gradeService.addScore(classId,stuId,score);
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }

    /**
     * 教师端：根据老师teaId 查询所教的课程
     * @return
     */
    @RequestMapping("teach/course")
    @ResponseBody
    public List<Map> getTeachCourse(){
        Integer teacherId = authMess.teacherId();

        List<ClassDomain> classes =classService.findAllClass(88888888,"",teacherId);

        List<Map> resList = new ArrayList<Map>();

        for(int i=0;i<classes.size();i++){
            Map<String, Object> res = new HashMap<>();
            res.put("className",classes.get(i).getClassName());
            res.put("classId",classes.get(i).getClassId());
            resList.add(res);
        }
        return resList;
    }

    /**
     * 教师端：根据课程信息查询选课的学生
     * @param currentPage
     * @param pageSize
     * @param className 课程名称
     * @param classId 课程id
     * @return
     */
    @RequestMapping("/find/student")
    @ResponseBody
    public Map<String, Object>  getStudent(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false,defaultValue = "") String className,
            @RequestParam(required = false,defaultValue = "88888888") Integer classId){
        PageHelper.startPage(currentPage,pageSize);

        List students = classService.findStudent(className,classId);
        System.out.printf("find student result:%s",students);
        Map<String, Object> res = new HashMap<>();
        res.put("status","SUCCESS");

        Map<String, Object> data = new HashMap<>();
        data.put("total", ((Page)students).getTotal());
        System.out.printf("total = %s\n",((Page)students).getTotal());
        data.put("pageSize", pageSize);
        data.put("currentPage", currentPage);
        data.put("list", students);
        res.put("data", data);
        return res;
    }

    /**
     * 教师端：查询老师课表
     * @return 返回的是课表信息的多维数组
     */
    @RequestMapping(value = "/course/table")
    @ResponseBody
    public String[][]  findCourseTable(){
        int teaId = authMess.teacherId();
        return classService.findCourseTable(teaId);
    }

    /**
     * 教师端：添加课程
     * @param request
     * @return
     */
    @RequestMapping(value = "/course/add",method = RequestMethod.POST)
    @ResponseBody
    public int addCourse(HttpServletRequest request){
        try {
            String json = requestPayload.getRequestPayload(request);
            System.out.println(json);
            JSONObject obj = new JSONObject(json);

            ClassDomain classDomain = new ClassDomain();
            classDomain.setTeacherInfo(obj.getString("teacherInfo"));
            classDomain.setCourseInfo(obj.getString("courseInfo"));
//            classDomain.setClassId(obj.getInt("classId"));
            classDomain.setTeaName(obj.getString("teaName"));
            classDomain.setTeaId(obj.getInt("teaId"));
            classDomain.setClassUpperLimit(obj.getInt("classUpperLimit"));
            classDomain.setClassNum(obj.getInt("classNum"));
            classDomain.setClassName(obj.getString("className"));
            classDomain.setClassChooseNum(0);
            classDomain.setClassLength(obj.getInt("classLength"));

            Integer daseA = obj.getInt("classDateDescriptionA");
            Integer daseB = obj.getInt("classDateDescriptionB");

            System.out.printf("a%s,b%s",daseA,daseB);

            classDomain.setClassDateDescription(Integer.toString(daseA) + Integer.toString(daseB) );
            classDomain.setClassPlace(obj.getString("classPlace"));
            classDomain.setDepartId(obj.getInt("departId"));
            classDomain.setClassModuleNum(obj.getInt("classModuleNum"));
            classDomain.setClassSemester(obj.getInt("classSemester"));
            classDomain.setModelsName(" ");

            try{
                classService.addClass(classDomain);
            }catch (Exception e){
                System.out.println(e);
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }

    /**
     * 教师端 更新分数
     * @param request
     * @return
     */
    @RequestMapping(value = "/update/score",method = RequestMethod.POST)
    @ResponseBody
    public int updateScore(HttpServletRequest request){
        String json = requestPayload.getRequestPayload(request);
        System.out.println(json);

        try {
            JSONObject obj = new JSONObject(json);
            String className = obj.getString("className");
            int stuId = obj.getInt("stuId");
            int score = obj.getInt("score");
            return classService.updateScore(className,stuId,score);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @RequestMapping("/download/courseTable")
    public ModelAndView  downloadCourseTable(HttpServletResponse response){
        int teaId = authMess.teacherId();
        String[][] tables = classService.findCourseTable(teaId);

        Map res = new HashMap();

        res.put("tables", tables);
        Map<String, Object> model = new HashMap<>();
        model.put("res",res);

        return new ModelAndView(new MyTablePdfView(), model);
    }
}
