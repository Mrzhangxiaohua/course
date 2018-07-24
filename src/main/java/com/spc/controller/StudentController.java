package com.spc.controller;

import com.github.pagehelper.Page;
import com.spc.model.ClassDomain;
import com.spc.model.GradeDomain;
import com.spc.service.grade.GradeService;
import com.spc.service.student.StudentService;
import com.spc.util.AuthMess;
import com.spc.util.RequestPayload;
import com.spc.view.StudentScorePdfView;
import com.spc.view.StudentTablePdfView;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这个是用户端的控制层
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;


    @Autowired
    private RequestPayload requestPayload;

    @Autowired
    private AuthMess authMess;


    /**
     * 根据学号查询学生选择的课程
     * @return
     */
    @RequestMapping("/select/classes")
    @ResponseBody
    public String[][] selectClasses(){

        Integer stuId = authMess.userId();

        return studentService.findClasses(stuId);
    }

    @RequestMapping("/all/className")
    @ResponseBody
    public List<Map> allClassName(){
        return studentService.allClassName();
    }

    /**
     * 学生端 ：添加申请的函数
     * @return
     */
    @RequestMapping(value = "/add/application",method = RequestMethod.POST)
    public int addApplcation(HttpServletRequest request){
        System.out.println("run here");
        String json = requestPayload.getRequestPayload(request);
        System.out.printf("添加申请的json = %s",json);
        try {
            JSONObject obj = new JSONObject(json);
            Integer classId = obj.getInt("classId");
            Integer state = obj.getInt("state");
            String reason = obj.getString("reason");

            return studentService.addApplication(classId,state,reason);
        }catch (Exception e){
            System.out.println(e);
        }
        return 0;
    }

    /**
     * 学生端：可以根据课程id 添加课程
     * @param request
     * @return
     */
    @RequestMapping(value = "/choose/course",method = RequestMethod.POST)
    @ResponseBody
    public int chooseCourse(HttpServletRequest request){
        String json = requestPayload.getRequestPayload(request);
        System.out.printf("添加课程的json = %s",json);
        try {
            JSONObject obj = new JSONObject(json);
            Integer classId = obj.getInt("classId");

            int stuId =authMess.userId();

            if(gradeService.selectGrade(classId,stuId).isEmpty()!=true){
                return 0;
            }else{
                return studentService.addCourse(stuId,classId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 学生端：可以根据课程id 取消课程
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete/course",method = RequestMethod.POST)
    @ResponseBody
    public int deleteCourse(HttpServletRequest request){
        String json = requestPayload.getRequestPayload(request);
        System.out.printf("添加课程的json = %s",json);
        try {
            JSONObject obj = new JSONObject(json);
            Integer classId = obj.getInt("classId");

            int stuId =authMess.userId();

            if(gradeService.selectGrade(classId,stuId).isEmpty()!=true & classId!=null){
                return studentService.deleteCourse(stuId,classId);
            }else{
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @RequestMapping("/select/grade")
    @ResponseBody
    public List<GradeDomain> selectGrade(
            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize,
            @RequestParam(required = false,defaultValue = "88888888") Integer stuId,
            @RequestParam(required = false,defaultValue = "88888888") Integer classId){

//        PageHelper.startPage(pageNum,pageSize);
//        stuId = authMess.UserId();
        stuId = 2018000006;
        return gradeService.selectGrade(classId,stuId);
    }

    /**
     * 学生端：根据验证的学生id下载课表
     * @param response
     * @return
     */
    @RequestMapping("/download/table")
    public ModelAndView downloadCourseTable(HttpServletResponse response) {

        int teaId = authMess.userId();

        String[][] tables = studentService.findClasses(teaId);
        Map res = new HashMap();

        res.put("tables", tables);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style","higher");
        return new ModelAndView(new StudentTablePdfView(), model);
    };

    /**
     * 学生端：根据验证的学生id下载成绩单
     * @param response
     * @param stuId
     * @param classId
     * @return
     */
    @RequestMapping("/download/score")
    public ModelAndView downloadScore(HttpServletResponse response,
                              @RequestParam(required = false,defaultValue = "88888888") Integer stuId,
                              @RequestParam(required = false,defaultValue = "88888888") Integer classId) {
        stuId = authMess.userId();
        stuId = 2018000006;

        List<GradeDomain> scores = gradeService.selectGrade(classId,stuId);
        System.out.println("tun here");
        Map res = new HashMap();

        res.put("scores", scores);
        res.put("stuId",Integer.toString(stuId));
        res.put("stuName",authMess.userName());
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style","wider");
        return new ModelAndView(new StudentScorePdfView(), model);
    }

    /**
     * 学生端的选择课程，可以根据当前学生id来判断是否已选课程
     * @param currentPage
     * @param pageSize
     * @param departId
     * @param classname
     * @param teaId
     * @return 查询出的课程
     */
    @RequestMapping("/classes/find")
    @ResponseBody
    public Map<String, Object> selectClassed(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false, defaultValue = "88888888") int departId,
            @RequestParam(required = false, defaultValue = "") String classname,
            @RequestParam(required = false, defaultValue = "") String teaName,
            @RequestParam(required = false, defaultValue = "88888888") int teaId,
            @RequestParam(required = false, defaultValue = "88888888") int startWeek,
            @RequestParam(required = false, defaultValue = "88888888") int endWeek) {

        Map map = new HashMap<String,Object>();
        map.put("currentPage",currentPage);
        map.put("pageSize",pageSize);
        map.put("departId",departId);
        map.put("classname",classname);
        map.put("teaname",teaName);
        map.put("teaId",teaId);
        map.put("startWeek",startWeek);
        map.put("endWeek",endWeek);
        Integer stuId = authMess.userId();
        map.put("stuId",stuId);

        List<ClassDomain> classes = studentService.selectClassed(map);

        Map<String, Object> res = new HashMap<>();
        res.put("status","SUCCESS");

        Map<String, Object> data = new HashMap<>();
        data.put("total", ((Page)classes).getTotal());
        data.put("pageSize", pageSize);
        data.put("currentPage", currentPage);
        data.put("list", classes);
        res.put("data", data);
        return res;
    }

}
