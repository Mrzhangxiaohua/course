package com.spc.service.SynchroTable.impl;

import com.spc.controller.Base;
import com.spc.dao.ClassDao;
import com.spc.dao.CourseAllDao;
import com.spc.model.ClassAll;
import com.spc.model.ClassDomain;
import com.spc.model.CourseAll;
import com.spc.service.SynchroTable.SynchroTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class SynchroTableImpl extends Base implements SynchroTable {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("[^0-9]");

    @Autowired
    private ClassDao classDao;

    @Autowired
    private CourseAllDao courseAllDao;

    @Override
    public int insertRecord(ClassAll classAll) {

        CourseAll courseAll = courseAllDao.selectCourseAll(classAll.getCourseId());
        logger.info(courseAll.toString());
        ClassDomain classDomain = new ClassDomain();
        classDomain.setClassAllId(classAll.getId());
        classDomain.setClassName(courseAll.getCourseNameCHS());
        if (classAll.getClassName() != null && !classAll.getClassName().isEmpty()) {
            classDomain.setClassNum(getNum(classAll.getClassName()));
        }
        classDomain.setTeaId(classAll.getInstructorId());
        classDomain.setTeaName(classAll.getInstructorName());
        classDomain.setClassGradePoint(0);
        classDomain.setClassChooseNum(0);
        classDomain.setClassUpperLimit(courseAll.getStuNumUpperLimit());
        if (classAll.getClassDateDesc() != null && !classAll.getClassDateDesc().isEmpty()) {
            classDomain.setClassDateDescription(wrapDateDesc(convertDateDesc(classAll.getClassDateDesc())));
        }
        classDomain.setClassPlace(classAll.getClassPlaceName());
        classDomain.setClassLength(0);
        classDomain.setClassModuleNum(getMI(courseAll.getModuleId()));
        classDomain.setDepartId(courseAll.getDepartId());
        classDomain.setStartWeek(classAll.getStartWeek());
        classDomain.setEndWeek(classAll.getEndWeek());
        classDomain.setClassSemester(courseAll.getAcademicYear() + courseAll.getClassSemester());
        classDomain.setCourseInfo(courseAll.getCourseInfo());
        classDomain.setTeacherInfo(courseAll.getTeacherInfo());
        classDomain.setClassTime(courseAll.getClassHour());
        classDomain.setMainLecturer(classAll.getTeacherName());
        classDomain.setClassEncode(courseAll.getCourseId());
        classDomain.setShenQingRenId(null);
        classDomain.setSchoolDistrictId(classAll.getSchoolDistrictId());
        logger.info(classDomain.toString());
        int count = classDao.insert(classDomain);
        return count;
    }

    @Override
    public int insertRecord1(ClassAll classAll,Integer classID) {
        CourseAll courseAll = courseAllDao.selectCourseAll(classAll.getCourseId());
        logger.info(courseAll.toString());
        ClassDomain classDomain = new ClassDomain();
        classDomain.setClassAllId(classAll.getId());
        classDomain.setClassName(courseAll.getCourseNameCHS());
        if (classAll.getClassName() != null && !classAll.getClassName().isEmpty()) {
            classDomain.setClassNum(getNum(classAll.getClassName()));
        }
        classDomain.setTeaId(classAll.getInstructorId());
        classDomain.setTeaName(classAll.getInstructorName());
        classDomain.setClassGradePoint(0);
        classDomain.setClassChooseNum(0);
        classDomain.setClassUpperLimit(courseAll.getStuNumUpperLimit());
        if (classAll.getClassDateDesc() != null && !classAll.getClassDateDesc().isEmpty()) {
            classDomain.setClassDateDescription(wrapDateDesc(convertDateDesc(classAll.getClassDateDesc())));
        }
        classDomain.setClassId(classID);

        classDomain.setClassPlace(classAll.getClassPlaceName());
        classDomain.setClassLength(0);
        classDomain.setClassModuleNum(getMI(courseAll.getModuleId()));
        classDomain.setDepartId(courseAll.getDepartId());
        classDomain.setStartWeek(classAll.getStartWeek());
        classDomain.setEndWeek(classAll.getEndWeek());
        classDomain.setClassSemester(courseAll.getAcademicYear() + courseAll.getClassSemester());
        classDomain.setCourseInfo(courseAll.getCourseInfo());
        classDomain.setTeacherInfo(courseAll.getTeacherInfo());
        classDomain.setClassTime(courseAll.getClassHour());
        classDomain.setMainLecturer(classAll.getTeacherName());
        classDomain.setClassEncode(courseAll.getCourseId());
        classDomain.setShenQingRenId(null);
        classDomain.setSchoolDistrictId(classAll.getSchoolDistrictId());
        logger.info(classDomain.toString());
        int count = classDao.insert(classDomain);
        return count;
    }

    @Override
    public int removeRecord(int id) {
        classDao.deleteByClassAllId(id);
        return 1;
    }

    @Override
    public int updateRecord(ClassAll classAll) {
        // 不要偷懒，做真正的update(by zhangfa)
        //说的对(by xiaomi)
        Map map = classDao.getClassId(classAll.getId());
        Integer classID = (Integer) map.get("classId");
        //logger.info("准备要删除的在course中的classId为：" + classID + "====================");
        ClassDomain classDomain = new ClassDomain();
          removeRecord(classAll.getId());
        if (classAll.getClassDateDesc() != null) {
            CourseAll courseAll = courseAllDao.selectCourseAll(classAll.getCourseId());
            logger.info(courseAll.toString());

            classDomain.setClassAllId(classAll.getId());
            classDomain.setClassName(courseAll.getCourseNameCHS());
            if (classAll.getClassName() != null && !classAll.getClassName().isEmpty()) {
                classDomain.setClassNum(getNum(classAll.getClassName()));
            }
            classDomain.setClassChooseNum((Integer) map.get("classChooseNum"));
            classDomain.setTeaId(classAll.getInstructorId());
            classDomain.setTeaName(classAll.getInstructorName());
            classDomain.setClassGradePoint(0);
            classDomain.setClassUpperLimit(courseAll.getStuNumUpperLimit());
            if (classAll.getClassDateDesc() != null && !classAll.getClassDateDesc().isEmpty()) {
                classDomain.setClassDateDescription(wrapDateDesc(convertDateDesc(classAll.getClassDateDesc())));
            }
            classDomain.setClassId(classID);

            classDomain.setClassPlace(classAll.getClassPlaceName());
            classDomain.setClassLength(0);
            classDomain.setClassModuleNum(getMI(courseAll.getModuleId()));
            classDomain.setDepartId(courseAll.getDepartId());
            classDomain.setStartWeek(classAll.getStartWeek());
            classDomain.setEndWeek(classAll.getEndWeek());
            classDomain.setClassSemester(courseAll.getAcademicYear() + courseAll.getClassSemester());
            classDomain.setCourseInfo(courseAll.getCourseInfo());
            classDomain.setTeacherInfo(courseAll.getTeacherInfo());
            classDomain.setClassTime(courseAll.getClassHour());
            classDomain.setMainLecturer(classAll.getTeacherName());
            classDomain.setClassEncode(courseAll.getCourseId());
            classDomain.setShenQingRenId(null);
            classDomain.setSchoolDistrictId(classAll.getSchoolDistrictId());
        }
        int count = classDao.insert(classDomain);
        return count;
    }


    private List<String> convertDateDesc(String classDateDesc) {
        // 首先划分得到每一个小时粒度的课程
        String[] descs = classDateDesc.split(",");
        for (int i = 0; i < descs.length; i++) {//表示n次排序过程。
            for (int j = 1; j < descs.length - i; j++) {
                String[] ints = descs[j - 1].split("-");
                String[] ints1 = descs[j].split("-");
                if (Integer.parseInt(ints[0]) > Integer.parseInt(ints1[0])) {//前面的数字大于后面的数字就交换
                    //交换a[j-1]和a[j]
                    String temp;
                    temp = descs[j - 1];
                    descs[j - 1] = descs[j];
                    descs[j] = temp;
                }
            }
        }
        for (int i = 0; i < descs.length; i++) {//表示n次排序过程。
            for (int j = 1; j < descs.length - i; j++) {
                String[] ints = descs[j - 1].split("-");
                String[] ints1 = descs[j].split("-");
                if (Integer.parseInt(ints[1]) > Integer.parseInt(ints1[1])) {//前面的数字大于后面的数字就交换
                    String temp;
                    temp = descs[j - 1];
                    descs[j - 1] = descs[j];
                    descs[j] = temp;
                }
            }
        }
        List<List<Integer>> descInts = new ArrayList<>();
        for (String desc : descs) {
            String[] descStrs = desc.split("-");
            List<Integer> temp = new ArrayList<>();
            temp.add(Integer.parseInt(descStrs[1]) + 1);
            temp.add(Integer.parseInt(descStrs[0]) + 1);
            descInts.add(temp);
        }
        boolean flag = false;
        List<List> res = new ArrayList<>();
        int i = 0;
        while (i < descInts.size()) {
            if (i == descInts.size() - 1) {
                List temp = descInts.get(i);
                temp.add(2, 1);
                res.add(temp);
                break;
            } else {
                int j = i + 1;
                while (true) {
                    if (j == descInts.size()) break;
                    List<Integer> after = descInts.get(j);
                    List<Integer> pre = descInts.get(j - 1);
                    if (after.get(0) == pre.get(0) && (after.get(1) - pre.get(1) == 1)) {
                        j++;
                    } else {
                        break;
                    }
                }
                List temp = descInts.get(i);
                temp.add(2, j - i );
                res.add(temp);
                i = j;
            }
        }
        List<String> result = new ArrayList<>();
        for (int t = 0; t < res.size(); t++) {
            String temp = res.get(t).get(0) + ":" + res.get(t).get(1) + ":" + res.get(t).get(2);
            result.add(temp);
        }
        return result;

    }

    public String wrapDateDesc(List<String> temp){
        String res = "";
        for (int i=0;i<temp.size();i++){
            res  = res + temp.get(i) + ",";
        }
        return  res;
    }

    private Integer getMI(String moduleId) {
        return Integer.parseInt(moduleId.split(",")[0]);
    }

    private Integer getNum(String className) {
        if (null == className) {
            return null;
        }
        String res = NUMBER_PATTERN.matcher(className).replaceAll("");
        if (null == res || "".equals(res)) {
            return null;
        }
        return Integer.parseInt(res);
    }

    public static void main(String[] args) {
        SynchroTableImpl stl = new SynchroTableImpl();
//        String res = stl.wrapDateDesc(stl.convertDateDesc("2-1"));
        String res = stl.wrapDateDesc(stl.convertDateDesc("2-1,3-1,8-3,9-3,10-3,5-2,6-2,5-3,6-3,10-5"));
        System.out.println(res);

    }
}
