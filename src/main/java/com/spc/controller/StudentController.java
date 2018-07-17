package com.spc.controller;

import com.github.pagehelper.PageHelper;
import com.spc.model.GradeDomain;
import com.spc.service.grade.GradeService;
import com.spc.service.student.StudentService;
import com.spc.util.AuthMess;
import com.spc.util.RequestPayload;
import com.spc.view.MyScorePdfView;
import com.spc.view.MyTablePdfView;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @RequestMapping("/select/classes")
    @ResponseBody
    public String[][] selectClasses(){


//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String name =  authentication.getName();
//        System.out.printf("name%s",name);

//        Integer stuId = studentService.findNum(name);

        Integer stuId = 2018000001;
//        String[][] lis = studentService.findClasses(stuId);
//
//        System.out.println("run here");
//        StringBuilder str = new StringBuilder("[");
//        for(String[] sli : lis) {
//            try {
//                StringBuilder jsons =new StringBuilder(new ObjectMapper().writeValueAsString(sli));
//                str.append(jsons);
//                str.append(",");
//            } catch (Exception exception) {
//            }
//        }
//        str.deleteCharAt(str.length()-1);
//        str.append("]");
//        System.out.println(str);
        return studentService.findClasses(stuId);
    }

    @RequestMapping(value = "/choose/course",method = RequestMethod.POST)
    @ResponseBody
    public int chooseCourse(HttpServletRequest request){
        String json = requestPayload.getRequestPayload(request);
        System.out.printf("添加课程的json = %s",json);

        try {
            JSONObject obj = new JSONObject(json);

            Integer classId = obj.getInt("classId");

            int stuId =authMess.UserId();

            return studentService.addCourse(stuId,classId);



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
     * 学生端：下载课表
     * @param response
     * @return
     */
    @RequestMapping("/download/table")
    public ModelAndView downloadCourseTable(HttpServletResponse response) {

        int teaId = authMess.UserId();

        String[][] tables = studentService.findClasses(teaId);

        Map res = new HashMap();

        res.put("tables", tables);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        return new ModelAndView(new MyTablePdfView(), model);
    };

    @RequestMapping("/download/score")
    public ModelAndView downloadScore(HttpServletResponse response,
                              @RequestParam(required = false,defaultValue = "88888888") Integer stuId,
                              @RequestParam(required = false,defaultValue = "88888888") Integer classId) {
        stuId = authMess.UserId();
        List scores = gradeService.selectGrade(classId,stuId);
        Map res = new HashMap();

        res.put("scores", scores);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        return new ModelAndView(new MyScorePdfView(), model);
    }


}
