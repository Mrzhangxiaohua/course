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

    @Override
    public List<CourseAll> getCourseAllByYearAndDep(String year,int depId) {
        return courseAllDao.selectCourseAllByYearAndDep(year,depId);
    }

    @Override
    @Transactional
    public int addYearCourseAll(List<CourseAll> courseList, String userId, String username,String year) {
        int i=0;
        for(CourseAll courseAll:courseList){
            courseAll.setOperatorName("username");
            courseAll.setOperatorId("userId");
            courseAll.setOperateDate(new Date());
            int flag=courseAllDao.insertYearCourse(courseAll);
            //插入一个课程目录，同时在ClassAll中插入一个默认的一班
            classAllDao.addFirstClass(courseAll);
            if(flag==1){
                i++;
            }
        }
        if(i==courseList.size()){
            return 1;
        }
        return 0;
    }

    @Override
    public int addCourseApp(CourseApplication courseApp) {
        courseApp.setIsChecked(0);
        return courseAllDao.insertCourseApp(courseApp);

    }

    @Override
    public List<Map<String,Object>> findCourseApp(String date, String operatorId, String operatorName,int departId) {
        if(departId!=0) {
            List<Map<String, Object>> list = courseAllDao.selectCourseApp(date, operatorId, operatorName,departId);
            for (Map<String, Object> li : list) {
                if ((int) li.get("isChecked") == 0) {
                    li.put("status", "未审核");
                } else if ((int) li.get("isChecked") == 1) {
                    li.put("status", "审核通过");
                } else if ((int) li.get("isChecked") == 2) {
                    li.put("status", "已拒绝");
                } else {
                    li.put("status", "");
                }
            }
            return list;
        }
        return null;
    }

    @Override
    @Transactional
    public int checkCourseApp(List<Integer> idList, int result,int departId) {
        //通过开课申请，自动生成课程编码
        String courseId=null;
        if(result==1){
            StringBuilder courseIdPre=new StringBuilder();
            courseIdPre.append("WS");
            Calendar now = Calendar.getInstance();
            String currentYear=Integer.toString(now.get(Calendar.YEAR));
            //当前年份后两位
            String twoYear=currentYear.substring(currentYear.length()-2);
            courseIdPre.append(twoYear);
            //departId=0管理员？
            /*if(departId==0){
                return 0;
            }*/
            //三位departId
            courseIdPre.append(String.format("%03",departId));
            //查询当年流水号
            int count=courseAllDao.findCourseAppCount(twoYear);
            //对每个记录根据流水号生成courseId，并修改isChecked标志位
            for(Integer id:idList){
                count++;
                courseId= courseIdPre.toString()+String.format("%03",count);
                courseAllDao.updateCourseAppflag(id,result,courseId);
            }
        }else if(result==2){
            //2表示拒绝开课申请

            for(Integer id:idList){
                courseAllDao.updateCourseAppflag(id,result,courseId);
            }
        }
        return 0;
    }

    @Override
    public List<CourseApplication> findAllCourseApp() {
        return courseAllDao.findAllApp();

    }

    @Override
    public int addCourseAll(CourseApplication courseApp) {
        return 0;
    }

    @Override
    public int ModifyCourseAll(CourseAll courseAll, String userId,String username) {
        courseAll.setOperatorId(userId);
        courseAll.setOperatorName(username);
        courseAll.setOperateDate(new Date());
        return courseAllDao.updateCourseAll(courseAll);
    }
}
