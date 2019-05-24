package com.spc.service.manage.impl;

import com.spc.dao.*;
import com.spc.model.CourseAll;
import com.spc.model.CourseApplication;
import com.spc.model.TeacherInfo;
import com.spc.service.manage.CourseAllService;
//import com.sun.xml.internal.bind.v2.model.core.ID;
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

    @Autowired
    private DepartmentDao departmentDao;

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
    public int addCourseApp(CourseApplication courseApp) {
        String departName=departmentDao.selectById(courseApp.getDepartId()).get(0);
        courseApp.setDepartName(departName);
        return courseAllDao.insertCourseApp(courseApp);

    }


    @Override
    @Transactional
    public int checkCourseApp(List<Integer> idList, int result,  String username, String userId) {
        //通过开课申请，自动生成课程编码
        String courseId = null;
        if (result == 1) {

            String courseIdPre = "WS";
//            Calendar now = Calendar.getInstance();
//            String currentYear = Integer.toString(now.get(Calendar.YEAR));
//            //当前年份后两位
//            String twoYear = currentYear.substring(currentYear.length() - 2);
//            courseIdPre.append(twoYear);


            //对每个记录根据流水号生成courseId，并修改isChecked标志位
            for (Integer id : idList) {

                CourseApplication courseApp = courseAllDao.findById(id).get(0);

                int type=courseApp.getCategory();
                //新增的课程需要自动生成courseId
                if(type==2) {
                    String twoYear=courseApp.getAcademicYear().substring(2,4);
                    int departId = courseApp.getDepartId();
                    //查询当年流水号
                    int count = courseAllDao.findCourseCount(twoYear + String.format("%03d", departId));
                    count++;
                    courseId = courseIdPre +twoYear+ String.format("%03d", departId) + String.format("%03d", count);
                    courseApp.setCourseId(courseId);
                    courseAllDao.updateCourseAppflag(id, result, courseId);
                }else if(type==1||type==3){
                    courseId=courseApp.getCourseId();
                    courseAllDao.updateCourseAppflag(id,result,null);
                }

                    //通过的课插入CourseAll表，当年课程目录
                    CourseAll courseAll = new CourseAll();
                    courseAll.setCourseAppId(id);
                    courseAll.setDepartId(courseApp.getDepartId());
                    courseAll.setCourseId(courseApp.getCourseId());
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
                    courseAll.setCourseAppId(new Integer(id));
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
    public List<CourseApplication> findAllCourseApp(String operatorId, String operatorName, String operateDate, int tabKey,String departId, int type) {
        return courseAllDao.findAllAppByDate(operatorName, operatorId, operateDate, tabKey,departId,type);

    }

    @Override
    public List<CourseApplication> findAllCourseApp(String operatorId, String operatorName, int tabKey,String departId,int type) {
        return courseAllDao.findAllApp(operatorName, operatorId, tabKey,departId,type);

    }

    @Override
    public int addCourseAll(CourseAll courseAll) {
        StringBuilder courseIdPre = new StringBuilder();
        courseIdPre.append("WS");
        Calendar now = Calendar.getInstance();
        //学年两位
        String twoYear = courseAll.getAcademicYear().substring(2,4);
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
    public int addDepartFormer(int id,String username,String userId) {
        CourseAll courseAll = courseAllDao.findCourseAllById(id).get(0);
        CourseApplication ca=new CourseApplication();
        ca.setDepartId(courseAll.getDepartId());
        ca.setDepartName(departmentDao.selectById(courseAll.getDepartId()).get(0));
        ca.setCourseNameCHS(courseAll.getCourseNameCHS());
        ca.setCourseNameEN(courseAll.getCourseNameEN());
        ca.setModuleId(Integer.parseInt(courseAll.getModuleId()));
        Calendar now = Calendar.getInstance();
        int currentYear=now.get(Calendar.YEAR);
        ca.setAcademicYear(currentYear+"-"+(currentYear+1));
        ca.setClassSemester(courseAll.getClassSemester());
        ca.setClassHour(courseAll.getClassHour());
        ca.setStuNumUpperLimit(courseAll.getStuNumUpperLimit());
        ca.setTeacherId(courseAll.getTeacherId());
        ca.setTeacherName(courseAll.getTeacherName());
        ca.setTeachingTeamIds(courseAll.getTeachingTeamIds());
        ca.setTeachingTeamNames(courseAll.getTeachingTeamNames());
        ca.setCourseInfo(courseAll.getCourseInfo());
        ca.setTeacherInfo(courseAll.getTeacherInfo());
        ca.setIsChecked(3);
        ca.setCategory(1);
        ca.setCourseId(courseAll.getCourseId());
        ca.setOperatorId(userId);
        ca.setOperatorName(username);
        return courseAllDao.insertCourseApp(ca);
    }

    @Override
    @Transactional
    public int commitApp(String academicYear,int departId) {
        List<CourseApplication> list=courseAllDao.findAppByYear(academicYear,departId);
        for(CourseApplication ca:list) {
            courseAllDao.updateCourseAppflag(ca.getId(), 0, null);
        }
        return 1;
    }

    @Override
    public int modifyCourseApp(CourseApplication ca, String username, String userId) {
        ca.setOperatorName(username);
        ca.setOperatorId(userId);
        if(ca.getCategory()==1){
            ca.setCategory(3);
        }
        return courseAllDao.updateCourseApp(ca);
    }

    @Override
    public List findDepartCourseApp(int departId, String academicYear, String courseId, String courseName) {
        return courseAllDao.selectDepartCourseApp(departId,academicYear, courseId,courseName);
    }

    @Override
    public int findFlag() {
        return courseAllDao.selectFlag();
    }

    @Override
    public int updateFlag(int flag) {
        return courseAllDao.updateCourseAllFlag(flag);
    }

    @Override
    @Transactional
    public int cancelCheck(List<Integer> idList) {
        for(int id:idList){

            CourseApplication ca = courseAllDao.findById(id).get(0);
            if(ca.getIsChecked()==0){
                return 0;
            }

            if(ca.getIsChecked()==1){
                courseAllDao.deleteCourseAllByAppId(id);
            }
            if(ca.getCategory()==2){
                ca.setCourseId(null);
            }
                ca.setIsChecked(3);

            courseAllDao.updateAppCheck(ca);
        }
        return 1;
    }

    @Override
    public List<Map<String, Object>> findCourseAllDepartList(String academicYear) {

        List<Map<String,Object>> departList=courseAllDao.selectAllDepart(academicYear);

        return departList;
    }

    @Override
    public List<Map<String, Object>> findCourseAllByYearAndDepart(String academicYear, int departId) {
        return  courseAllDao.findByYearAndDepart(academicYear,departId);
    }

    @Override
    public int ExistCourseAll(CourseAll courseAll) {
       return courseAllDao.findCourseAllCount(courseAll);
    }

    @Override
    public int modifyCourseAll(CourseAll courseAll, String userId, String username) {
        courseAll.setOperatorId(userId);
        courseAll.setOperatorName(username);
        courseAll.setOperateDate(new Date());
        return  courseAllDao.updateCourseAll(courseAll);
    }
}
