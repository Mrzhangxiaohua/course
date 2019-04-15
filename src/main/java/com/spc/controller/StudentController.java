package com.spc.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.github.pagehelper.Page;
import com.spc.model.ClassDomain;
import com.spc.model.CourseTableExcelDomain;
import com.spc.model.GradeDomain;
import com.spc.service.grade.GradeService;
import com.spc.service.manage.ManageService;
import com.spc.service.student.StudentService;
import com.spc.service.user.UserService;
import com.spc.util.CalculateWeekth;
import com.spc.util.RequestPayload;
import com.spc.util.ResponseWrap;
import com.spc.view.StudentScorePdfView;
import com.spc.view.StudentTablePdfView;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 这个类提供学生端的路由。
 *
 * @author yuhongchao
 * @version 1.0
 */
@RestController
@RequestMapping("/student")
public class StudentController extends Base{

    @Autowired
    private StudentService studentService;
    @Autowired
    private ManageService manageService;

    @Autowired
    private GradeService gradeService;
    @Autowired
    UserService userService;

    /**
     * 学生端：根据学号查询学生选择的课程,用做课表显示
     *
     * @return
     */
    @RequestMapping("/select/classes")
    @ResponseBody
    public String[][] selectClasses(HttpSession session) {
        String stuId = (String) session.getAttribute("userId");
        return studentService.findClasses(stuId);
    }

    /**
     * 学生端：查询所有的课程名称
     *
     * @return
     */
    @RequestMapping(value = "/find/allClassName")
    public List<HashMap<String,Object>> findAllClassName(
            @RequestParam(required = false, defaultValue = "88888888") int student,
            HttpSession session
    ) {
        String stuId = (String) session.getAttribute("userId");
        return studentService.findAllClassName(student,stuId);
    }

    /**
     * 学生端：添加课程申请
     *
     * @return
     */
    @RequestMapping(value = "/add/application", method = RequestMethod.POST)
    public int addApplcation(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);
        logger.info("添加课程的json = %s", json);
        try {
            JSONObject obj = new JSONObject(json);
            Integer classId = obj.getInt("classId");
            //states 为1 是增加课程
            //states 为2 是调整班级
            //states 为3 是重修班级
            //states 为4 是退选计划
            Integer state = obj.getInt("states");
            String reason = obj.getString("reason");
            String className = obj.getString("className");
            System.out.println(obj.getString("classNum"));
            Integer classNum = obj.getString("classNum").equals("")? 0: Integer.parseInt(obj.getString("classNum")); //专门为调整班级使用的“班次”字段
            String stuId = (String) request.getSession().getAttribute("userId");
            return studentService.addApplication(classId, state, reason, classNum,stuId);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    /**
     * 学生端：获取学生所选择的课程列表
     *
     */
    @RequestMapping("/select/list")
    public List<Map<String, Object>> selectList(HttpSession session){
            String stuId = (String) session.getAttribute("userId");
            return studentService.selectList(stuId);
    }

    /**
     *此段代码暂时不用
     * @param session
     * @return
     */
    @RequestMapping("/select/list1")
    public List<Map<String, Object>> selectList1(HttpSession session){
        String stuId = (String) session.getAttribute("userId");
        return studentService.selectList1(stuId);
    }

    @RequestMapping(value = "/chakanpingjiaqingkuang", method = RequestMethod.POST)
    public List<Map<String, Object>> showCommentList(HttpServletRequest request){
        String stuId = (String)request.getSession().getAttribute("userId");
        String json = RequestPayload.getRequestPayload(request);
        System.out.println(json);
        try {
            JSONObject obj = new JSONObject(json);
//            String classId = obj.getString("classId");

            String classId = "4";
            System.out.println(classId);

            return studentService.showCommentList(stuId, classId);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    /**
     * 学生端:进行教师评价总评
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/stutotea/addComment", method = RequestMethod.POST)
    public int addComment(HttpServletRequest request){
        String json = RequestPayload.getRequestPayload(request);
        logger.info("增加=================================== %s", json);
        try {
            JSONObject obj = new JSONObject(json);
            String classType = obj.getString("classType");
            String className = obj.getString("className");
            String words = obj.getString("comment");
            String teaId = obj.getString("teaId");
            JSONArray scoreJS = obj.getJSONArray("score");
            String stuId = (String) request.getSession().getAttribute("userId");
            List<String> li = new ArrayList<>();
            for (int i=0; i<scoreJS.length(); i++) {
                li.add( scoreJS.getString(i));
            }
            String[] score = li.toArray(new String[li.size()]);
            return studentService.addComment(stuId, teaId, score, words);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(json);
        return 0;
    }
    /**
     * 学生端：显示老师的打分及其评语
     */
    @RequestMapping(value = "/show/teacomment")
    public List<Map<String, Object>> showTeacomment(HttpSession session){
        String stuId = (String) session.getAttribute("userId");
        return studentService.showTeacomment(stuId);
    }

    /**
     * 学生按照课时评论老师
     * @param request
     * @return
     */
    @RequestMapping(value = "/evaluateTeacherWeekly", method = RequestMethod.POST)
    @ResponseBody
    public int  addCommentWeekly(HttpServletRequest request){
        String json = RequestPayload.getRequestPayload(request);
        String stuId = (String)request.getSession().getAttribute("userId");
        System.out.println(json);
        boolean flag = false;
        try {
            int theWeeks = CalculateWeekth.weekth("2018-10-03");//时间控件，最终需要调整
            System.out.println("看看周次zzzzzzzzzzz" + theWeeks);//当前为第九周
            if(theWeeks != 0){ //如果周次不为0说明可以对第n周进行评价
                JSONObject obj = new JSONObject(json);
                /**
                 * 此处拿到学生评教老师的各种字段
                 */
                String classId = obj.getString("classId");
                String comment = obj.getString("comment");
                String currWeek = obj.getString("currWeek");
                Integer score1 = obj.getInt("score1");
                Integer score2 = obj.getInt("score2");
                Integer score3 = obj.getInt("score3");
                Integer score4 = obj.getInt("score4");
                String teaId = obj.getString("teaId");
                System.out.println(classId + "===" + comment + "===" + currWeek + "===" + teaId +  "===" + score1 + "===" + score2 + "===" + score3 + "===" + score4 + "===" + stuId);
                List<Map<String, Object>> add = studentService.addCommentWeeklyTrue(stuId);//获取上面参数并进行数据库插入操作
                int startWeek = 0;
                int endWeek = 0;
                List<Map<String, Object>> li= studentService.selectList(stuId);
                for (Map map : li){
                    for (Object k : map.keySet()){
                        startWeek = (int) map.get("startWeek");
                        endWeek = (int) map.get("endWeek");
                    }
                }
                System.out.println("add------------" + add);

                if(add.size() != 0) {//当有过评论
                    for (Map<String, Object> m : add) {
                        int week = (int) m.get("classWeek");
                        System.out.println("week=========" + week);
                        System.out.println(week+ "----------------");
                        if (theWeeks == week) {
                            flag = false;
                            break;
                        }else if (theWeeks!= week && theWeeks>=startWeek && theWeeks<=endWeek && theWeeks==Integer.parseInt(currWeek)){
                            flag = true;
                            continue;
                        }
                    }
                    //调用插入
                    if (flag == true){
                        return studentService.addCommentWeeklyFinal(stuId, classId, comment, currWeek, teaId, score1, score2, score3, score4);
                    }else {
                        System.out.println("添加不成功，因为周次不对");
                    }
                }else {//当一次都没有添加过评论
                    if (theWeeks>=startWeek && theWeeks<=endWeek && theWeeks==Integer.parseInt(currWeek)){
                        System.out.println("添加成功");
                        return studentService.addCommentWeeklyFinal(stuId, classId, comment, currWeek, teaId, score1, score2, score3, score4);
                    }else {
                        return 0;
                    }
                }
            }
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 学生端：可以根据课程id 添加课程
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/choose/course", method = RequestMethod.POST)
    @ResponseBody
    public int chooseCourse(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
            Integer classId = obj.getInt("classId");
            Integer departId = (Integer) request.getSession().getAttribute("departId");
            return studentService.addCourse(classId, (String) request.getSession().getAttribute("userId"),departId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 学生端：可以根据课程id 取消课程
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete/course", method = RequestMethod.POST)
    @ResponseBody
    public int deleteCourse(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);
        try {
            JSONObject obj = new JSONObject(json);
            Integer classId = obj.getInt("classId");
            studentService.deleteCourse(classId, (String) request.getSession().getAttribute("userId"));
//            List<Map<String,Object>> waitingList=studentService.findWaiting(classId);
//            if(waitingList.size()!=0) {
//                String stuId= (String) waitingList.get(0).get("stuId");
//                int id= (int) waitingList.get(0).get("id");
//                studentService.addyuanzi(classId,stuId);
//                studentService.updateWaitingFlag(id);
                return 1;
            }
         catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 学生端：查询学生的学分
     * @param pageNum
     * @param pageSize
     * @param stuId
     * @param classId
     * @param session
     * @return
     */
    @RequestMapping("/select/grade")
    @ResponseBody
    public List<Map<String, Object>> selectGrade(
            @RequestParam(required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(required = false, defaultValue = "") String stuId,
            @RequestParam(required = false, defaultValue = "88888888") Integer classId, HttpSession session) {
        stuId = (String) session.getAttribute("userId");

        return gradeService.selectGrade(classId, stuId);
    }

    @RequestMapping("/select/getTitle")
    @ResponseBody
    public List<Map<String, Object>> selectGetTitle(){
        return gradeService.selectGetTitle();
    }




    /**@author zf
     * 返回学生的已选学分
     *
     * @return所有的模块标题
     */
    @RequestMapping("get/classTime")
    public Map getGradePoint(HttpSession session) {
        return studentService.getClassTime((String) session.getAttribute("userId"));
    }

    /**
     * 学生端：根据验证的学生id下载课表到pdf
     *
     * @return
     */
    @RequestMapping("/download/table")
    public ModelAndView downloadCourseTable(HttpSession session, HttpServletResponse response) {


        String[][] tables = studentService.findClasses((String) session.getAttribute("userId"));

        Map res = new HashMap();
        res.put("data", tables);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style", "higher");
        model.put("student",1);

        //根据学生的名称设置pdf的文件名
        response = ResponseWrap.setName(response, (String) session.getAttribute("username")+"的课表","pdf");

        return new ModelAndView(new StudentTablePdfView(), model);
    };

    /**
     * 学生端：根据验证的学生id下载课表到excel
     *
     * @return
     */
    @RequestMapping("/download/excelTable")
    public void downloadCourseTableExcel(HttpSession session,HttpServletResponse response) {


        String[][] tables = studentService.findClasses((String) session.getAttribute("userId"));

        List<CourseTableExcelDomain> liC = new ArrayList<>();
        for (int i = 0; i < tables.length; i = i + 1) {
            liC.add(new CourseTableExcelDomain(i , tables[i][0], tables[i][1], tables[i][2], tables[i][3]
                    , tables[i][4], tables[i][5], tables[i][6]));
        }

        //设置课表的名称
        response =  ResponseWrap.setName(response, (String) session.getAttribute("username")+"的课表","xls");

        ExportParams params = new ExportParams();
        params.setTitle("课表");

        Workbook workbook = ExcelExportUtil.exportExcel(params, CourseTableExcelDomain.class, liC);

        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

//    /**
//     * 学生端：根据验证的学生id下载成绩单
//
//     * @return
//     */
//    @RequestMapping("/download/score")
//    public ModelAndView downloadScore(@RequestParam(required = false, defaultValue = "88888888") Integer classId,
//                                      HttpSession session) {
//        String stuId = (String) session.getAttribute("userId");
//        List<GradeDomain> scores = gradeService.selectGrade(classId, stuId);
//        System.out.println("tun here");
//        Map res = new HashMap();
//        res.put("data", scores);
//        res.put("stuId", stuId);
//        res.put("stuName", session.getAttribute("authentication"));
//        Map<String, Object> model = new HashMap<>();
//        model.put("res", res);
//        model.put("style", "wider");
//        return new ModelAndView(new StudentScorePdfView(), model);
//    }

    /**
     * 学生端的选择课程，可以根据当前学生id来判断是否已选课程
     *
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
            HttpSession session,
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false, defaultValue = "88888888") int departId,
            @RequestParam(required = false, defaultValue = "88888888") int modelsId,
            @RequestParam(required = false, defaultValue = "") String classname,
            @RequestParam(required = false, defaultValue = "") String teaName,
            @RequestParam(required = false, defaultValue = "") String teaId,
            @RequestParam(required = false, defaultValue = "88888888") int startWeek,
            @RequestParam(required = false, defaultValue = "88888888") int endWeek,
            @RequestParam(required = false, defaultValue = "88888888") int hasWaiGuoYu,
            @RequestParam(required = false, defaultValue = "88888888") int courseSorting) {
        System.out.println("courseSorting = "+ courseSorting);
        Map map = new HashMap<String, Object>();
        map.put("currentPage", currentPage);
        map.put("pageSize", pageSize);
        map.put("departId", departId);
        map.put("classname", classname);
        map.put("teaname", teaName);
        map.put("teaId", teaId);
        map.put("modelsId", modelsId);
        map.put("startWeek", startWeek);
        map.put("endWeek", endWeek);
        String stuId = (String) session.getAttribute("userId");

        map.put("stuId", stuId);
        map.put("hasWaiGuoYu", hasWaiGuoYu);
        map.put("classChooseNum", courseSorting);
        map.put("classNum",courseSorting==2?1:0 );

        List<ClassDomain> classes = studentService.selectClassed(map);

        Map<String, Object> res = new HashMap<>();
        // 查询出stuId并返回前端学生校区
        stuId = (String) session.getAttribute("userId");
        int schoolDistrict = studentService.finSchoolDistrict(stuId);
        res.put("status", "SUCCESS");

        Map<String, Object> data = new HashMap<>();
        data.put("total", ((Page) classes).getTotal());
        data.put("pageSize", pageSize);
        data.put("currentPage", currentPage);
        data.put("list", classes);
        data.put("personalSchoolId",schoolDistrict);
        res.put("data", data);
        return res;
    }

    /**
     * 学生端查询开关信息，主要用于显示开关
     * @return
     */
    @RequestMapping("/get/timeswitch")
    @ResponseBody
    public Map getTimeSwitch(){
        Map res = new HashMap();
        res.put("timeSwitch",studentService.getTimeSwtich());
        return res;
    }

/*    @RequestMapping("waiting/apply")
    @ResponseBody
    public int waitingApply( HttpSession session, @RequestParam int classId){
        String stuId= (String) session.getAttribute("userId");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=sdf.format(new Date());
        return studentService.addWaiting(stuId,classId,1,date);
    }*/

/*    @RequestMapping("waiting/delete")
    @ResponseBody
    public int waitingDelete( HttpSession session, @RequestParam int id){

        return studentService.deleteWaiting(id);
    }*/

/*
    @RequestMapping("waiting/lookUp")
    @ResponseBody
    public Map<String,Object> waitingFind( HttpSession session,@RequestParam int classId){
        String stuId= (String) session.getAttribute("userId");
        return studentService.lookUpWaitingOrder(stuId,classId);
    }
*/

  /*  @RequestMapping("waiting/findStatus")
    @ResponseBody
    public Map<String,Object>  findStatus( HttpSession session,@RequestParam int id){
        String stuId= (String) session.getAttribute("userId");
        return studentService.findWaitStatus(id);
    }

    /**
     * 学生查询总成绩
     */
    @RequestMapping("/stuFindScore")
    @ResponseBody
    public List<Map<String,Object>>  findScore( HttpSession session){
        String stuId= (String) session.getAttribute("userId");
        List<Map<String,Object>> stu=manageService.findAllScore(88888888,stuId);
        return stu;
    }
}

