package com.spc.service.manage;

import com.spc.model.ClassApplicationDomain;
import com.spc.model.ClassDomain;
import com.spc.model.StudentApplicationDomain;

import java.util.Date;
import java.util.List;

public interface ManageService {
    String[][] findClasses(Integer stuId);

    String[][] bigTable();

    List<StudentApplicationDomain> checkedMessage(int key, int stuId);

    List<StudentApplicationDomain> checkedMessageAndDate(int key, int stuId, Date date);

    int makeSure(int id,String classStr);
    int makeSureClassApplication(int id);

    int reject(int id);
    int rejectClassApplication(int id);

    int chooseCourse(int classId,int stuId);
    int deleteCourse(int classId,int stuId);

    void addCourse(ClassDomain cd);
    void deleteCourseRecord(int classId);


    int addCourseStudent(int stuId,String stuName,String classStr);

    int deleteCourseStudent(int stuId,String classStr);

    int getClassId(String className,int classNum);

    List findStudentByClassnameAndNum(String className,int classNum,int pageSize,int currentPage);

    List<ClassApplicationDomain> checkedClassMessage(int teaId, String className,int tabKey);

    List<ClassApplicationDomain> checkedClassMessageAndDate(int teaId, String className, Date date,int tabKey);

}
