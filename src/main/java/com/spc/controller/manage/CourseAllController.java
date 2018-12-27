package com.spc.controller.manage;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spc.controller.Base;
import com.spc.model.CourseAll;
import com.spc.service.manage.CourseAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class CourseAllController extends Base {

    @Autowired
    private CourseAllService courseAllService;

    /**
     * 获取课程列表
     *
     * @param currentPage
     * @param pageSize
     * @param id
     * @param departId
     * @param moduleId
     * @param courseId
     * @param courseName
     * @param teacherId
     * @param teacherName
     * @param classSemester
     * @param classDateDesc
     * @param classPlace
     * @return
     */
    @RequestMapping("/getCourseAll")
    @ResponseBody
    public Map<String, Object> getCourseAll(@RequestParam(required = false, defaultValue = "1") int currentPage,
                                            @RequestParam(required = false, defaultValue = "10") int pageSize,
                                            @RequestParam(required = false) Integer id,
                                            @RequestParam(required = false) Integer departId,
                                            @RequestParam(required = false) Integer moduleId,
                                            @RequestParam(required = false) String courseId,
                                            @RequestParam(required = false) String courseName,
                                            @RequestParam(required = false) String teacherId,
                                            @RequestParam(required = false) String teacherName,
                                            @RequestParam(required = false) String classSemester,
                                            @RequestParam(required = false) String classDateDesc,
                                            @RequestParam(required = false) String classPlace) {
        PageHelper.startPage(currentPage, pageSize);
        List<CourseAll> courses = courseAllService.getCourseAll(id, departId, moduleId, courseId, courseName,
                teacherId, teacherName, classSemester, classDateDesc, classPlace);
        System.out.println(courses);

        Map<String, Object> res = new HashMap<>();
        res.put("status", "SUCCESS");

        Map<String, Object> data = new HashMap<>();
        data.put("total", ((Page) courses).getTotal());
        System.out.printf("total = %s\n", ((Page) courses).getTotal());
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
    public String[][] getTeacherTimetable(String teacherId, String classSemester) {
        return courseAllService.getTeacherTimetable(teacherId, classSemester);
    }

    /**
     * 对某门课程进行排课处理
     *
     * @param id
     * @param rowIndex 第几节，下标自0开始
     * @param colIndex 周几，下标自0开始
     * @param classPlace
     * @param force         是否在有冲突时仍强制排课
     * @return
     */
    @RequestMapping("/scheduleCourse")
    @ResponseBody
    public Map<String, Object> scheduleCourse(@RequestParam int id,
                                              @RequestParam int rowIndex,
                                              @RequestParam int colIndex,
                                              @RequestParam String classPlace,
                                              @RequestParam(required = false, defaultValue = "false") boolean force) {
        return courseAllService.scheduleCourse(id, rowIndex, colIndex, classPlace, force);
    }

}
