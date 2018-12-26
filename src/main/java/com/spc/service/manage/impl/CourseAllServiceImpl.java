package com.spc.service.manage.impl;

import com.spc.dao.CourseAllDao;
import com.spc.model.CourseAll;
import com.spc.service.manage.CourseAllService;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 排课Service
 *
 * @author yzk
 * @date 2018-12-25
 */
@Service
public class CourseAllServiceImpl implements CourseAllService {

    // 每天一共12个学时
    private static final int CLASS_HOURS_PER_DAY = 12;
    // 每周一共7天
    private static final int CLASS_DAYS_PER_WEEK = 7;

    @Autowired
    private CourseAllDao courseAllDao;

    @Override
    public List<CourseAll> getCourseAll(Integer id, Integer departId, Integer moduleId,
                                        String courseId, String courseName, String teacherId, String teacherName,
                                        String classSemester, String classDateDesc, String classPlace) {

        return courseAllDao.select(id, departId, moduleId, courseId, courseName,
                teacherId, teacherName, classSemester, classDateDesc, classPlace);
    }

    @Override
    public String[][] getTeacherTimetable(String teacherId, String classSemester) {
        List<CourseAll> courses = courseAllDao.select(null, null, null, null,
                null, teacherId, null, classSemester, null, null);
        return constructTimetable(courses);
    }

    /**
     * 构建课表
     *
     * @param courses
     * @return
     */
    private String[][] constructTimetable(List<CourseAll> courses) {
        String[][] timetable = new String[CLASS_HOURS_PER_DAY][CLASS_DAYS_PER_WEEK];

        for (CourseAll course : courses) {
            if (course.getClassDateDesc() != null && course.getClassPlace() != null) {
                // parse classDateDesc, eg: 2-2,3-2
                String[] classDates = course.getClassDateDesc().split(",");
                for (int k = 0; k < classDates.length; k++) {
                    String[] indexes = classDates[k].split("-");
                    int i = Integer.parseInt(indexes[0]);
                    int j = Integer.parseInt(indexes[1]);

                    StringBuilder sb = new StringBuilder();
                    sb.append("★课程：");
                    if (course.getCourseNameCHS() != null) {
                        sb.append(course.getCourseNameCHS());
                    } else {
                        sb.append(course.getCourseNameEN());
                    }
                    sb.append(",教室：").append(course.getClassPlace());
                    sb.append(",授课教师：").append(course.getInstructorName());
                    sb.append(",周次：").append(course.getStartWeek()).append("-").append(course.getEndWeek());
                    sb.append(",班次：").append(course.getCourseId());
                    timetable[i][j] = sb.toString();
                }
            }
        }

        return timetable;
    }

    @Override
    public Map<String, Object> scheduleCourse(int id, int rowIndex, int colIndex, String classPlace, boolean force) {
        Map<String, Object> res = new HashedMap<>();

        // get course
        CourseAll course = courseAllDao.selectCourseById(id);
        if (null == course) {
            res.put("status", "error");
            res.put("conflict", false);
            res.put("desc", "对应的课程不存在，请联系管理员！");
            return res;
        }

        StringBuilder conflictDescBuilder = new StringBuilder();
        StringBuilder descBuilder = new StringBuilder();

        // 原有冲突处理
        String oldConflictDesc = course.getConflictDesc();
        if (oldConflictDesc != null) {
            parseConflictDesc(oldConflictDesc, descBuilder);
        }

        /*
         * 1. 与该老师研究生已排课程冲突
         */
        // 时间冲突
        List<CourseAll> courses = courseAllDao.selectCoursesByTeacherIdAndClassSemester(course.getTeacherId(), course.getClassSemester());
        conflictJudge(rowIndex, colIndex, course, courses, conflictDescBuilder, descBuilder, "t", "时间");

        /*
         * 2. 与该地点研究生已排课程冲突
         * */
        courses = courseAllDao.selectCoursesByClassPlaceAndClassSemester(classPlace, course.getClassSemester());
        conflictJudge(rowIndex, colIndex, course, courses, conflictDescBuilder, descBuilder, "p", "地点");

        // TODO 2. 与该老师本科课程冲突


        String conflictDesc = conflictDescBuilder.toString();
        String desc = descBuilder.toString();
        if (!conflictDesc.isEmpty() && !force) {
            res.put("status", "conflict");
            res.put("conflict", true);
            res.put("desc", desc);
            return res;
        } else {
            // update database:
            String newClassDateDesc = (course.getClassDateDesc() == null ? "" : course.getClassDateDesc()) + rowIndex + "-" + colIndex + ",";
            String newConflictDesc = (course.getConflictDesc() == null ? "" : course.getConflictDesc()) + conflictDesc;
            int updateResult = courseAllDao.updateCourseSchedule(id, newClassDateDesc, classPlace, newConflictDesc);

            if (updateResult == 1) {
                res.put("status", "success");
                res.put("conflict", conflictDesc.isEmpty());
                res.put("desc", desc);
                return res;
            } else {
                res.put("status", "error");
                res.put("conflict", conflictDesc.isEmpty());
                res.put("desc", "数据保存错误，请重试！");
                return res;
            }
        }
    }

    /**
     * 原有冲突解析
     *
     * @param conflictDesc
     * @param descBuilder
     */
    private void parseConflictDesc(String conflictDesc, StringBuilder descBuilder) {
        // TODO
    }

    /**
     * 冲突判断
     *
     * @param rowIndex
     * @param colIndex
     * @param course
     * @param courses
     * @param conflict
     * @param desc
     * @param conflictWord
     * @param descWord
     */
    private void conflictJudge(int rowIndex, int colIndex, CourseAll course, List<CourseAll> courses,
                               StringBuilder conflict, StringBuilder desc, String conflictWord, String descWord) {
        if (!courses.isEmpty()) {
            for (CourseAll c : courses) {
                // 冲突判断
                // step1: 周次重叠判断
                if (c.getEndWeek() < course.getStartWeek() || c.getStartWeek() > course.getEndWeek()) {
                    continue;
                }
                // step2: 上课时间冲突判断
                String[] classDates = course.getClassDateDesc().split(",");
                for (int k = 0; k < classDates.length; k++) {
                    String[] indexes = classDates[k].split("-");
                    int i = Integer.parseInt(indexes[0]);
                    int j = Integer.parseInt(indexes[1]);

                    if (i == rowIndex && j == colIndex) {
                        conflict.append(c.getId()).append("-").append(conflictWord).append(",");
                        desc.append(descWord).append("冲突：").append(c.getTeacherName()).append(" ");
                        if (c.getCourseNameCHS() != null) {
                            desc.append(c.getCourseNameCHS());
                        } else {
                            desc.append(c.getCourseNameEN());
                        }
                        desc.append(" ");
                        desc.append(c.getClassId()).append("班\n");
                    }
                }
            }
        }
    }
}
