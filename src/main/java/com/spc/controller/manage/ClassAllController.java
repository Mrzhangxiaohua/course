package com.spc.controller.manage;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spc.controller.Base;
import com.spc.model.ClassAll;
import com.spc.model.ClassroomInfo;
import com.spc.model.IceSelectDataSource;
import com.spc.model.TeacherInfo;
import com.spc.service.manage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    private SchoolDistrictService schoolDistrictService;

    @Autowired
    private TeacherInfoService teacherInfoService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ClassroomInfoService classroomInfoService;

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
                                           @RequestParam(required = false) String courseName,
                                           @RequestParam(required = false) String teacherId,
                                           @RequestParam(required = false) String teacherName,
                                           @RequestParam(required = false) String classPlaceId,
                                           HttpServletRequest request) {
        // get user's departId
        HttpSession httpSession = request.getSession();
        Object departIdObject = httpSession.getAttribute("departId");
        if (null == departIdObject) {
            return null;
        }
        int departId = Integer.parseInt(departIdObject.toString());


        PageHelper.startPage(currentPage, pageSize);
        List<ClassAll> courses = classAllService.getClassAll(departId, academicYear, classSemester, courseName,
                teacherId, teacherName, classPlaceId);

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
     * @param classSemester 春、秋
     * @return
     */
    @RequestMapping("/getDepartTimeTable")
    @ResponseBody
    public String[][] getDepartTimeTable(@RequestParam int departId, @RequestParam String academicYear, @RequestParam String classSemester) {
        return classAllService.getDepartTimeTable(departId, academicYear, classSemester);
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
}
