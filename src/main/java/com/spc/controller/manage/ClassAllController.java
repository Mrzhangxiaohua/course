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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping("/getCourseAll")
    @ResponseBody
    public Map<String, Object> getCourseAll(@RequestParam(required = false, defaultValue = "1") int currentPage,
                                            @RequestParam(required = false, defaultValue = "10") int pageSize,
                                            @RequestParam(required = false) String academicYear,
                                            @RequestParam(required = false) String classSemester,
                                            @RequestParam(required = false) String courseName,
                                            @RequestParam(required = false) String teacherId,
                                            @RequestParam(required = false) String teacherName,
                                            @RequestParam(required = false) String classPlaceId) {
        PageHelper.startPage(currentPage, pageSize);
        // departId = 8. test
        int departId = 8;
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
    public String[][] getTeacherTimetable(String teacherId, String academicYear, String classSemester) {
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
    public Map<String, Object> getTeachers(@RequestParam(required = false, defaultValue = "1") int currentPage,
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
     *
     * @param id    如果有，表示修改，如果没有，表示新增
     * @param force 是否在有冲突时仍强制排课
     * @return
     */
    @RequestMapping(value = "/scheduleCourse", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> scheduleCourse(Integer id, Integer departId, String courseId,
                                              String courseNameCHS, String courseNameEN, String moduleId,
                                              String academicYear, String classSemester, Integer classHour,
                                              Integer stuNumUpperLimit, String teacherId, String teacherName,
                                              String teachingTeamIds, String teachingTeamNames,
                                              Integer schoolDistrictId, String className,
                                              String instructorId, String instructorName,
                                              int startWeek, int endWeek, String classDateDesc,
                                              String classPlaceId, String classPlaceName,
                                              boolean force, HttpServletRequest request) {

//        return courseAllService.scheduleCourse(id, rowIndex, colIndex, classPlace, force);
        return null;
    }

}
