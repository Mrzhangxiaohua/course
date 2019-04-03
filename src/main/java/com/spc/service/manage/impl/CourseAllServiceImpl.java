package com.spc.service.manage.impl;

import com.spc.dao.ClassAllDao;
import com.spc.dao.CourseAllDao;
import com.spc.dao.TeacherDao;
import com.spc.dao.TeacherInfoDao;
import com.spc.model.CourseAll;
import com.spc.model.CourseApplication;
import com.spc.model.TeacherInfo;
import com.spc.service.manage.CourseAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2019-01-03 19:00
 **/
@Service
public class CourseAllServiceImpl implements CourseAllService {

    @Autowired
    private CourseAllDao courseAllDao;

    @Autowired
    private TeacherInfoDao teacherInfoDao;

    @Autowired
    private ClassAllDao classAllDao;

    @Override
    public List<TeacherInfo> getTeachersByCourse(String courseId, String academicYear, String classSemester) {
        CourseAll courseAll = courseAllDao.selectCourseAllWithParams(courseId, academicYear, classSemester);
        List<TeacherInfo> res = new ArrayList<>();
        List<String> teacherIds = new ArrayList<>();
        if (courseAll == null) {
            return res;
        }
        if (courseAll.getTeacherId() != null) {
            teacherIds.add(courseAll.getTeacherId());
        }
        if (courseAll.getTeachingTeamIds() != null && !courseAll.getTeachingTeamIds().isEmpty()) {
            String[] tmp = courseAll.getTeachingTeamIds().split(",");
            teacherIds.addAll(Arrays.asList(tmp));
        }

        if (teacherIds.isEmpty()) {
            return res;
        }

        return teacherInfoDao.selectByTeacherIds(teacherIds);
    }

//    @Override
//    public List<CourseAll> getCourseAllByYearAndDep(String year,int depId) {
//        return courseAllDao.selectCourseAllByYearAndDep(year,depId);
//    }

//    @Override
//    @Transactional
//    public int addYearCourseAll(List<CourseAll> courseList, String userId, String username,String year) {
//        int i=0;
//        for(CourseAll courseAll:courseList){
//            courseAll.setOperatorName("username");
//            courseAll.setOperatorId("userId");
//            courseAll.setOperateDate(new Date());
//            int flag=courseAllDao.insertYearCourse(courseAll);
//            //插入一个课程目录，同时在ClassAll中插入一个默认的一班
//            classAllDao.addFirstClass(courseAll);
//            if(flag==1){
//                i++;
//            }
//        }
//        if(i==courseList.size()){
//            return 1;
//        }
//        return 0;
//    }

    @Override
    public int addCourseApp(CourseApplication courseApp) {
        courseApp.setIsChecked(0);
        return courseAllDao.insertCourseApp(courseApp);

    }


    @Override
    @Transactional
    public int checkCourseApp(List<Integer> idList, int result, int departId, String username, String userId) {
        //通过开课申请，自动生成课程编码
        String courseId = null;
        if (result == 1) {
            StringBuilder courseIdPre = new StringBuilder();
            courseIdPre.append("WS");
            Calendar now = Calendar.getInstance();
            String currentYear = Integer.toString(now.get(Calendar.YEAR));
            //当前年份后两位
            String twoYear = currentYear.substring(currentYear.length() - 2);
            courseIdPre.append(twoYear);
            //departId=0管理员？
            /*if(departId==0){
                return 0;
            }*/
            //三位departId
            courseIdPre.append(String.format("%03d", departId));
            //查询当年流水号
            int count = courseAllDao.findCourseCount(twoYear + String.format("%03d", departId));
            //对每个记录根据流水号生成courseId，并修改isChecked标志位
            for (Integer id : idList) {
                count++;
                courseId = courseIdPre.toString() + String.format("%03d", count);
                courseAllDao.updateCourseAppflag(id, result, courseId);
                //通过的课插入CourseAll表，当年课程目录
                CourseApplication courseApp = courseAllDao.findById(id).get(0);
                CourseAll courseAll = new CourseAll();
                courseAll.setDepartId(courseApp.getDepartId());
                courseAll.setCourseId(courseId);
                courseAll.setCourseNameCHS(courseApp.getCourseNameCHS());
                courseAll.setCourseNameEN(courseApp.getCourseNameEN());
                courseAll.setModuleId(Integer.toString(courseApp.getModuleId()));
                courseAll.setAcademicYear(courseApp.getAcademicYear());
                courseAll.setClassSemester(courseApp.getClassSemester());
                courseAll.setClassHour(courseApp.getClassHour());
                courseAll.setStuNumUpperLimit(courseApp.getStuNumUpperLimit());
                courseAll.setTeacherId(courseApp.getTeacherId());
                courseAll.setTeacherName(courseApp.getTeacherName());
                courseAll.setTeachingTeamIds(courseApp.getTeachingTeamIds());
                courseAll.setTeachingTeamNames(courseApp.getTeachingTeamNames());
                courseAll.setCourseInfo(courseApp.getCourseInfo());
                courseAll.setTeacherInfo(courseApp.getTeacherInfo());
                courseAll.setOperateDate(new Date());
                courseAll.setOperatorId(userId);
                courseAll.setOperatorName(username);
                courseAllDao.insertPassApp(courseAll);

            }
        } else if (result == 2) {
            //2表示拒绝开课申请

            for (Integer id : idList) {
                courseAllDao.updateCourseAppflag(id, result, courseId);
            }
        }
        return 0;
    }

    @Override
    public List<CourseApplication> findAllCourseApp(String operatorId, String operatorName, String operateDate, int tabKey) {
        return courseAllDao.findAllAppByDate(operatorName, operatorId, operateDate, tabKey);

    }

    @Override
    public List<CourseApplication> findAllCourseApp(String operatorId, String operatorName, int tabKey) {
        return courseAllDao.findAllApp(operatorName, operatorId, tabKey);

    }

    @Override
    public int addCourseAll(CourseAll courseAll) {
        StringBuilder courseIdPre = new StringBuilder();
        courseIdPre.append("WS");
        Calendar now = Calendar.getInstance();
        String currentYear = Integer.toString(now.get(Calendar.YEAR));
        //当前年份后两位
        String twoYear = currentYear.substring(currentYear.length() - 2);
        courseIdPre.append(twoYear);
        //三位departId
        courseIdPre.append(String.format("%03d", courseAll.getDepartId()));
        //查询当年流水号
        int count = courseAllDao.findCourseCount(twoYear + String.format("%03d", courseAll.getDepartId()));
        count++;
        String courseId = courseIdPre.toString() + String.format("%03d", count);
        courseAll.setCourseId(courseId);
        courseAllDao.insertPassApp(courseAll);
        return 0;
    }

    @Override
    public List<Map<String, Object>> findCourseAll(String academicYear, String courseId, String courseName, int departId) {
        List<Map<String, Object>> list = courseAllDao.findCourseAll(academicYear, courseId, courseName, departId);
        return list;
    }

    @Override
    public CourseAll findCourseAll(int id) {
        return courseAllDao.findCourseAllById(id).get(0);
    }

    @Override
    @Transactional
    public int makeSureCourseAll(String academicYear) {
        List<CourseAll> list=courseAllDao.findNotSure(academicYear);
        //修改标志位
        courseAllDao.updateFlag(academicYear);
        //在classAll中批量插入一班
        for(CourseAll courseAll:list){
            classAllDao.addFirstClass(courseAll);
        }
       return 1;
    }

    @Override
    public int ModifyCourseAll(CourseAll courseAll, String userId, String username) {
        courseAll.setOperatorId(userId);
        courseAll.setOperatorName(username);
        courseAll.setOperateDate(new Date());
        return  courseAllDao.updateCourseAll(courseAll);
    }
}
