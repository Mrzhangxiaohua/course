package com.spc.service.manage;

import com.spc.model.ClassApplicationDomain;
import com.spc.model.ClassDomain;
import com.spc.model.StudentApplicationDomain;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ManageService {
    String[][] findClasses(String stuId);

    String[][] bigTable(String shenQingRenId, String shenQingRenName,String teaName);

    List<StudentApplicationDomain> checkedMessage(int key, String stuId);

    List<StudentApplicationDomain> checkedMessageAndDate(int key, String stuId, Date date);

    int makeSure(int id,String classStr);
    int makeSureClassApplication(int id);

    int reject(int id);
    int rejectClassApplication(int id);

    int chooseCourse(int classId,String stuId);
    int deleteCourse(int classId,String stuId);

    void addCourse(ClassDomain cd);
    void deleteCourseRecord(int classId);


    int addCourseStudent(String stuId ,String classStr);

    int deleteCourseStudent(String stuId,String classStr);

    int getClassId(String className,int classNum);

    int deleteApplication(int id);

    List findStudentByClassnameAndNum(String className,int classNum,int pageSize,int currentPage);

    List findStudentByStudentId(int pageSize, int currentPage, String stuId);

    List<ClassApplicationDomain> checkedClassMessage(String teaId, String className, int tabKey,String shenqingrenname);

    List<ClassApplicationDomain> checkedClassMessageAndDate(String teaId, String className, Date date,int tabKey,String shenqingrenname);

    int addTimeSwitch(int timeSwitch);
    int updateTimeSwitch(int timeSwitch);
    int updateTimeSwitch2(String startDate,String endDate);

    public List<Map> jilianSelect();
}
