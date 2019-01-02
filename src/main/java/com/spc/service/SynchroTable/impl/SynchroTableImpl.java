package com.spc.service.SynchroTable.impl;

import com.spc.dao.ClassDao;
import com.spc.dao.CourseAllDao;
import com.spc.model.ClassAll;
import com.spc.model.ClassDomain;
import com.spc.model.CourseAll;
import com.spc.service.SynchroTable.SynchroTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SynchroTableImpl implements SynchroTable {

    @Autowired
    private ClassDao classDao;

    @Autowired
    private CourseAllDao courseAllDao;



    @Override
    public int synchroTable(ClassAll classAll) {

        CourseAll courseAll =courseAllDao.selectCourseAll(classAll.getCourseId());

        ClassDomain classDomain  = new ClassDomain();

        classDomain.setClassAllId(classAll.getId());
        classDomain.setClassName(courseAll.getCourseNameCHS());
        classDomain.setClassNum(getNum(classAll.getClassName()));

        classDomain.setTeaId(courseAll.getTeacherId());
        classDomain.setTeaName(courseAll.getTeacherName());
        classDomain.setClassGradePoint(0);
        classDomain.setClassChooseNum(classAll.getStuChooseNum());
        classDomain.setClassUpperLimit(courseAll.getStuNumUpperLimit());
        classDomain.setClassDateDescription(convertDateDesc(classAll.getClassDateDesc()).get(0));
        classDomain.setClassPlace(classAll.getClassPlaceName());
        classDomain.setClassLength(0);

        classDomain.setClassModuleNum(getMI(courseAll.getModuleId()));
        classDomain.setDepartId(courseAll.getDepartId());
        classDomain.setStartWeek(classAll.getStartWeek());
        classDomain.setEndWeek(classAll.getEndWeek());
        classDomain.setClassSemester(courseAll.getAcademicYear()+courseAll.getClassSemester());

        classDomain.setCourseInfo(courseAll.getCourseInfo());
        classDomain.setTeacherInfo(courseAll.getTeacherInfo());
        classDomain.setClassTime(courseAll.getClassHour());
        classDomain.setMainLecturer(classAll.getTeacherName());

        classDomain.setClassEncode(courseAll.getCourseId());
        classDomain.setShenQingRenId(" ");
        classDomain.setSchoolDistrictId(classAll.getSchoolDistrictId());

        classDao.insert(classDomain);

        return 1;

    }

    @Override
    public int removeRecord(int id) {
        classDao.deleteByClassAllId(id);
        return 1;
    }

    @Override
    public int updateRecord(ClassAll classAll) {
        removeRecord(classAll.getId());
        synchroTable(classAll);
        return 1;
    }

    private List<String> convertDateDesc(String classDateDesc) {
         String[] descs = classDateDesc.split(",");
         List<Integer[]> descInts = new ArrayList<>();
         for(String desc:descs){
            String[] descStrs = desc.split("-");
            descInts.add(new Integer[]{Integer.parseInt(descStrs[1]),Integer.parseInt(descStrs[0])});
         }
         List<Integer[]> res = new ArrayList<>();
         for(Integer[] ints:descInts){
             if(res.isEmpty()){
                 ints[2] = 0;
                 res.add(ints);
             }
             for(Integer[] ints2:res){
                if(ints2[0] == ints[0] & ints2[1] == (ints[1]-1) ){
                    ints2[2] = ints2[2] +1;
                }else if(ints2[0] == ints[0] & ints2[1] == (ints[1]+1) ){
                    ints2[1] = ints2[1] -1;
                    ints2[2] = ints2[2] +1;
                }
             }
         }
         List<String> resStr = new ArrayList<>();
         for(Integer[] i:res){
            resStr.add(Integer.toString(i[0]+1) + ":"+Integer.toString(i[1]+1)+":"+i[1]);
         }
         return resStr;

    }

    private Integer getMI(String moduleId) {
        return Integer.parseInt(moduleId.split(",")[0]);
    }

    private Integer getNum(String className){
        return Integer.parseInt(className.substring(0,1));
    }
}
