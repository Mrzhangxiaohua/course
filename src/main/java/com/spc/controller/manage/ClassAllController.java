package com.spc.controller.manage;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spc.controller.Base;
import com.spc.model.*;
import com.spc.service.manage.*;
import com.spc.service.wsdl.GetUndergradFreeClassrooms.GetUndergradFreeClassroomInfo;
import com.spc.service.wsdl.TeachersOccupyTimeWebservice.TeacherCurriculumInfo;
import com.spc.util.ResponseWrap;
import com.spc.view.ManageTablePdfView;
import com.spc.view.StudentTablePdfView;
import com.sun.xml.rpc.processor.model.soap.SOAPUnorderedStructureType;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description 排课Controller
 * @create 2018-12-25 16:24
 **/
@RequestMapping("/manage")
@Controller
public class ClassAllController extends Base {

    @Autowired
    private ClassAllService classAllService;

    @Autowired
    private CourseAllService courseAllService;

    @Autowired
    private SchoolDistrictService schoolDistrictService;

    @Autowired
    private TeacherInfoService teacherInfoService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ClassroomInfoService classroomInfoService;

    @Autowired
    private TeacherCurriculumInfo teacherCurriculumInfoService;

    @Autowired
    private GetUndergradFreeClassroomInfo freeClassroomService;

    /**
     * 获取课程列表
     *
     * @param currentPage
     * @param pageSize
     * @param courseName
     * @param teacherId
     * @param teacherName
     * @param classSemester
     * @return
     */
    @RequestMapping("/getClassAll")
    @ResponseBody
    public Map<String, Object> getClassAll(@RequestParam(required = false, defaultValue = "1") int currentPage,
                                           @RequestParam(required = false, defaultValue = "10") int pageSize,
                                           @RequestParam(required = false) String academicYear,
                                           @RequestParam(required = false) String classSemester,
                                           @RequestParam(required = false) String courseId,
                                           @RequestParam(required = false) String courseName,
                                           @RequestParam(required = false) String teacherId,
                                           @RequestParam(required = false) String teacherName,
                                           @RequestParam(required = false) String classPlaceId,
                                           @RequestParam(required = false) String selectDepartId,
                                           HttpServletRequest request) {
        // get user's departId
        HttpSession httpSession = request.getSession();
        Object departIdObject = httpSession.getAttribute("departId");
        if (null == departIdObject) {
            return null;
        }

        int departId = Integer.parseInt(departIdObject.toString());
//        int departId = 8;
        if (departId == 99){

        }

        PageHelper.startPage(currentPage, pageSize);
        List<ClassAll> courses = classAllService.getClassAll(departId, academicYear, classSemester, courseId,
                courseName, teacherId, teacherName, classPlaceId, selectDepartId);

        Map<String, Object> res = new HashMap<>();
        res.put("status", "SUCCESS");

        Map<String, Object> data = new HashMap<>();
        data.put("total", ((Page) courses).getTotal());
        data.put("pageSize", pageSize);
        data.put("currentPage", currentPage);
        data.put("list", courses);
        res.put("data", data);
        return res;
    }

    /**
     * 获取某个老师的上课课表
     *
     * @param teacherId
     * @return
     */
    @RequestMapping("/getTeacherTimetable")
    @ResponseBody
    public String[][] getTeacherTimetable(@RequestParam String teacherId, @RequestParam String academicYear, @RequestParam String classSemester) {
        return classAllService.getTeacherTimetable(teacherId, academicYear, classSemester);
    }

    /**
     * 获取所有校区
     *
     * @return
     */
    @RequestMapping("/getSchoolDistricts")
    @ResponseBody
    public List<IceSelectDataSource> getSchoolDistricts() {
        return schoolDistrictService.getAllSchoolDistricts();
    }


    /**
     * 获取某门课程的授课老师
     *
     * @param courseId
     * @param academicYear
     * @param classSemester
     * @return
     */
    @RequestMapping("/getTeachersByCourse")
    @ResponseBody
    public List<TeacherInfo> getTeachersByCourse(String courseId, String academicYear, String classSemester) {
        return courseAllService.getTeachersByCourse(courseId, academicYear, classSemester);
    }

    /**
     * 获取所有老师
     *
     * @return
     */
    @RequestMapping("/getTeachers")
    @ResponseBody
    public Map<String, Object> getTeachers(@RequestParam(required = false, defaultValue = "1") int currentPage,
                                           @RequestParam(required = false, defaultValue = "10") int pageSize,
                                           @RequestParam(required = false) Integer departId,
                                           @RequestParam(required = false) String teacherName) {
        PageHelper.startPage(currentPage, pageSize);
        List<TeacherInfo> teachers = teacherInfoService.getAllTeachers(departId, teacherName);

        Map<String, Object> res = new HashMap<>();
        res.put("status", "SUCCESS");

        Map<String, Object> data = new HashMap<>();
        data.put("total", ((Page) teachers).getTotal());
        data.put("pageSize", pageSize);
        data.put("currentPage", currentPage);
        data.put("list", teachers);
        res.put("data", data);
        return res;
    }

    /**
     * 获取所有教室（可排课）
     *
     * @return
     */
    @RequestMapping("/getClassrooms")
    @ResponseBody
    public Map<String, Object> getClassrooms(@RequestParam(required = false, defaultValue = "1") int currentPage,
                                             @RequestParam(required = false, defaultValue = "10") int pageSize,
                                             @RequestParam(required = false) String schoolDistrictId,
                                             @RequestParam(required = false) String classroomName) {
        PageHelper.startPage(currentPage, pageSize);
        List<ClassroomInfo> classrooms = classroomInfoService.getClassrooms(schoolDistrictId, classroomName);

        Map<String, Object> res = new HashMap<>();
        res.put("status", "SUCCESS");

        Map<String, Object> data = new HashMap<>();
        data.put("total", ((Page) classrooms).getTotal());
        data.put("pageSize", pageSize);
        data.put("currentPage", currentPage);
        data.put("list", classrooms);
        res.put("data", data);
        return res;
    }

    /**
     * 获取所有学院
     *
     * @return
     */
    @RequestMapping("/getDepartments")
    @ResponseBody
    public List<IceSelectDataSource> getDepartments() {
        return departmentService.getDepartments();
    }

    /**
     * 对某门课程进行排课处理
     * <p>
     * id    如果有，表示修改，如果没有，表示新增
     * force 是否在有冲突时仍强制排课
     *
     * @return
     */
    @PostMapping(value = "/scheduleClass")
    @ResponseBody
    public Map<String, String> scheduleClass(@RequestBody ClassAll classAll, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        String operatorId = httpSession.getAttribute("userId").toString();
        String operatorName = httpSession.getAttribute("username").toString();

        classAll.setOperatorId(operatorId);
        classAll.setOperatorName(operatorName);
        logger.info("scheduleClass: " + classAll.toString());

        return classAllService.scheduleClass(classAll);
    }

    /**
     * 删除班级
     *
     * @param id
     * @return
     */
    @GetMapping("/delClass")
    @ResponseBody
    public Map<String, String> delClass(@RequestParam int id, HttpServletRequest request) {
        logger.info("delClass, id: " + id);
        HttpSession httpSession = request.getSession();
        String operatorId = httpSession.getAttribute("userId").toString();
        String operatorName = httpSession.getAttribute("username").toString();

        return classAllService.delClass(id, operatorId, operatorName);
    }

    /**
     * 获取某个学院的上课课表
     *
     * @param classSemester 春、秋、departId
     *
     * @return
     */
    @RequestMapping("/getDepartTimeTable")
    @ResponseBody
    public String[][] getDepartTimeTable(@RequestParam String academicYear, @RequestParam String classSemester,@RequestParam("departmentId") String depId,HttpSession session) {
       if (depId==null|| depId.equals("")){
           depId = session.getAttribute("departId").toString();
       }
        int departId = Integer.parseInt(depId);
        return classAllService.getDepartTimeTable(departId, academicYear, classSemester);
    }

    /**
     * 获取某个学院的上课课表 pdf格式
     *
     * @param classSemester 春、秋、departId
     * @return
     */
    @RequestMapping("/getDepartTimeTablePdf")
    @ResponseBody
    public ModelAndView getDepartTimeTablePdf(@RequestParam String academicYear, @RequestParam String classSemester,
                                              @RequestParam(required = false, defaultValue = "8888") int depId,
                                              @RequestParam(required = false, defaultValue = "88888888") String depName,
                                              HttpSession session, HttpServletResponse response) {
        if(depId==8888){
            depId= (int) session.getAttribute("departId");
            depName= (String) session.getAttribute("dep");
        }

        //根据学生的名称设置pdf的文件名
        response = ResponseWrap.setName(response, depName + "课表", "pdf");

        String[][] tableData = classAllService.getDepartTimeTable(depId, academicYear, classSemester);
        Map res = new HashMap();
        res.put("data", tableData);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style", "higher");
        model.put("student", 1);
        return new ModelAndView(new StudentTablePdfView(), model);
    }

    /**
     * 获取某个学院的上课课表 excel格式
     *
     * @param classSemester 春、秋、departId
     * @return
     */
    @RequestMapping("/getDepartTimeTableExcel")
    @ResponseBody
    public void getDepartTimeTableExcel(@RequestParam String academicYear, @RequestParam String classSemester,
                                        @RequestParam(required = false, defaultValue = "8888") int depId,
                                        @RequestParam(required = false, defaultValue = "88888888") String depName,
                                        HttpSession session, HttpServletResponse response) {

        if(depId==8888){
            depId= (int) session.getAttribute("departId");
            depName= (String) session.getAttribute("dep");
        }
        String[][] tables = classAllService.getDepartTimeTable(depId, academicYear, classSemester);
        List<CourseTableExcelDomain> liC = new ArrayList<>();
        for (int i = 0; i < tables.length; i = i + 1) {
            liC.add(new CourseTableExcelDomain(i, tables[i][0], tables[i][1], tables[i][2], tables[i][3]
                    , tables[i][4], tables[i][5], tables[i][6]));
        }

        //设置课表的名称
        response = ResponseWrap.setName(response, depName + "课表", "xls");

        ExportParams params = new ExportParams();
        params.setTitle("课表");
        System.out.println("before");
        Workbook workbook = ExcelExportUtil.exportExcel(params, CourseTableExcelDomain.class, liC);
        System.out.println("after");
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一键获取所有学院的上课课表 excel格式
     *
     * @param classSemester 春、秋、departId
     * @return
     */
    @RequestMapping("/getAllDepartTimeTableExcel")
    @ResponseBody
    public void getAllDepartTimeTableExcel(@RequestParam String academicYear,
                                        @RequestParam String classSemester,HttpServletResponse response){
        List<Map<String,Object>> departList=classAllService.findDepartList(academicYear,classSemester);
        List<Map<String,Object>> list=new ArrayList<>();
        System.out.println(departList);
        for(Map<String,Object> depart:departList){
            int departId= (int) depart.get("departId");
            String departName= (String) depart.get("departName");
            String[][] tables = classAllService.getDepartTimeTable(departId, academicYear, classSemester);
            List<CourseTableExcelDomain> liC = new ArrayList<>();
            for (int i = 0; i < tables.length; i = i + 1) {
                liC.add(new CourseTableExcelDomain(i, tables[i][0], tables[i][1], tables[i][2], tables[i][3]
                        , tables[i][4], tables[i][5], tables[i][6]));
            }
            Map<String,Object> map=new HashMap<>();
            ExportParams params = new ExportParams();
            params.setTitle(departName+"总课表");
            params.setSheetName(departName);
            map.put("title",params);
            map.put("data",liC);
            map.put("entity",CourseTableExcelDomain.class);
            list.add(map);
        }


        //设置课表的名称
        response = ResponseWrap.setName(response,  "全学院总课表", "xls");

//        ExportParams params = new ExportParams();
//        params.setTitle("课表");
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(classSemester);
    }

    /**
     * 一键获取某个学院的上课课表 pdf格式
     *
     * @param classSemester 春、秋、departId
     * @return
     */
    @RequestMapping("/getAllDepartTimeTablePdf")
    @ResponseBody
    public ModelAndView getAllDepartTimeTablePdf(@RequestParam String academicYear, @RequestParam String classSemester,
                                                  HttpSession session, HttpServletResponse response) {


        response = ResponseWrap.setName(response, "全学院总课表", "pdf");
        List<Map<String,Object>> departList=classAllService.findDepartList(academicYear,classSemester);
        List<Map<String,Object>> tableList=new ArrayList<>();
        for(Map<String,Object> depart:departList){
            int departId= (int) depart.get("departId");
            String departName= (String) depart.get("departName");
            String[][] tableData = classAllService.getDepartTimeTable(departId, academicYear, classSemester);
            Map<String,Object> map = new HashMap<>();
            map.put("departName",departName);
            map.put("table",tableData);
            tableList.add(map);
        }


        Map res = new HashMap();
        res.put("data", tableList);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style", "higher");
        System.out.println("after");
        return new ModelAndView(new ManageTablePdfView(), model);
    }

    /**
     * 获取departId
     *
     * @param request
     * @return
     */
    @RequestMapping("/getDepartId")
    @ResponseBody
    public Integer getDepartId(HttpServletRequest request) {
        Object departIdObject = request.getSession().getAttribute("departId");
        if (null == departIdObject) {
            return null;
        }
        return Integer.parseInt(departIdObject.toString());
    }

    @RequestMapping("/getTeacherOccupyTime")
    @ResponseBody
//    classWeeks是0101的串
    public boolean[][] getTeacherOccupyTime(String teacherId, String academicYear, String classSemester, int startWeek, int endWeek, String classWeeks, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        String operatorId = httpSession.getAttribute("userId").toString();
        String operatorName = httpSession.getAttribute("username").toString();
        return teacherCurriculumInfoService.getTeacherOccupyTime(teacherId, academicYear, classSemester, startWeek, endWeek, classWeeks, operatorId, operatorName);
    }

    @RequestMapping("/getFreeClassrooms")
    @ResponseBody
    public String[] getFreeClassrooms(String academicYear, String classSemester, int startWeek, int endWeek, String classDateDesc, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        String operatorId = httpSession.getAttribute("userId").toString();
        String operatorName = httpSession.getAttribute("username").toString();

        return freeClassroomService.getAllFreeClassrooms(academicYear, classSemester, startWeek, endWeek, classDateDesc, operatorId, operatorName);
    }
}
