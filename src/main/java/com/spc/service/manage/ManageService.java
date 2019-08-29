package com.spc.service.manage;

import com.spc.model.ClassDomain;
import com.spc.model.FileInfo;
import com.spc.model.StudentApplicationDomain;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ManageService {
    String[][] findClasses(String stuId);

    String[][] bigTable(String shenQingRenId, String shenQingRenName,String teaName,Integer departId);

    List<StudentApplicationDomain> checkedMessage(int key, String stuId);

    List<StudentApplicationDomain> checkedMessageAndDate(int key, String stuId, Date date);

    int makeSure(int id,String classStr);
    int makeSureClassApplication(int id,String courseId,int departId);

    int reject(int id);
    int rejectClassApplication(int id);

    int chooseCourse(int classId,String stuId);
    int deleteCourse(int classId,String stuId);

    void addCourse(ClassDomain cd);
    void deleteCourseRecord(int classId);


    int addCourseStudent(String stuId ,String classId);

    int deleteCourseStudent(String stuId, String classId);

    int getClassId(String className,int classNum);


    List findStudentByClassnameAndNum(String classId,int pageSize,int currentPage, String classSemester);

    List findStudentByStudentId(int pageSize, int currentPage, String stuId, String classSemester);

    int addTimeSwitch(int timeSwitch);
    int updateTimeSwitch(int timeSwitch);
    int updateTimeSwitch2(String startDate,String endDate);

    public List<Map> jilianSelect();

    int addSchoolCalendar(String year,String firstWeek, String semester);

    int addTemplateFileInfo(String teaId, String fileName, String path,int type,String dep, String date,int flag);

    Map getGradePercent();

    int addGradePercent(int knsk, int xbsj, int zzxx, int dekt, int qmnl,String userId, String date);

    FileInfo findAppFile(int fileInfoId);

    int deleteCourseAll(Integer id);

    List<Map<String,Object>> findAllStudent(int moduleId,String academicYear,int submit,int depId,String stuId);


    List<Map<String,Object>> findStuById(String stuId,int modelId);

    void updateScore(String stuId, Float grade, int modelId, int status);

    void insertStu(String stuId,String academicYear);

    List<Map<String,Object>> findAlldepartment();

    Map insertGradeExcel(int moduleId, int fileInfoId,String academicYear);

    int findIsGrade(int moduleId,String academicYear);

    List<Map<String,Object>> findXbsjStudents(int classId);

    List<Map<String,Object>> findKnskStudents(String classId);

    void updateXbsjChecked(int slassId,String stuId,int isChecked);

    void updateKnskChecked(String classId,String stuId,int isChecked);

   void  updateXbsjSubmit(int classId);

    void updateKnskSubmit(String classId);

    List<Map<String,Object>> findAllScore(int departId,String stuId);

    void uploadAllGradeOther(String stuId, Float grade, int moduleId);

    void updateIsSubmit(int moduleId);

    int deleteCourseApp(int id);
}

