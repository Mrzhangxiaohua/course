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

        classDomain.setTeaId(courseAll.getTeacherId());
        classDomain.setTeaName(courseAll.getTeacherName());
        classDomain.setClassGradePoint(0);

        logger.info("run 1");
        classDomain.setClassChooseNum(classAll.getStuChooseNum());
        logger.info("run 2");
        classDomain.setClassUpperLimit(courseAll.getStuNumUpperLimit());
        logger.info("run 3");

        if (classAll.getClassDateDesc() != null && !classAll.getClassDateDesc().isEmpty()) {
            classDomain.setClassDateDescription((convertDateDesc(classAll.getClassDateDesc())).get(0));
        }
        logger.info("run 4");
        classDomain.setClassPlace(classAll.getClassPlaceName());
        classDomain.setClassLength(0);
        logger.info("run 5");
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

        logger.info("count: " + count);

        return count;

    }

    @Override
    public int removeRecord(int id) {
        classDao.deleteByClassAllId(id);
        return 1;
    }

    @Override
    public int updateRecord(ClassAll classAll) {
        removeRecord(classAll.getId());
        insertRecord(classAll);
        return 1;
    }

    private List<String> convertDateDesc(String classDateDesc) {
        System.out.println(classDateDesc);
        // 首先划分得到每一个小时粒度的课程
        String[] descs = classDateDesc.split(",");
        List<Integer[]> descInts = new ArrayList<>();
        // 将所有的划分为一个数组
        for (String desc : descs) {
            String[] descStrs = desc.split("-");
            descInts.add(new Integer[]{Integer.parseInt(descStrs[1]), Integer.parseInt(descStrs[0])});
        }
//        System.out.println(descInts.get(0)[0] + descInts.get(0)[1]);
//        System.out.println(descInts.get(1)[0] + descInts.get(1)[1]);
        List<List<Integer>> res = new ArrayList<>();
        for (Integer[] ints : descInts) {
            if (res.isEmpty()) {
                List<Integer> temp = new ArrayList(Arrays.asList(ints));//**须定义时就进行转化**
                temp.add(2, 1);
//                ints[2] = 0;
                res.add(temp);
            }
            for (List<Integer> ints2 : res) {
                if (ints2.get(0) == ints[0] & (ints2.get(1) == (ints[1] - 1))) {
//                    ints2.get(2) = ints2.get(2) + 1;
                    ints2.set(2, ints2.get(2) + 1);
                } else if (ints2.get(0) == ints[0] & (ints2.get(1) == (ints[1] + 1))) {
                    ints2.set(1, ints2.get(1) - 1);
                    ints2.set(2, ints2.get(2) + 1);
                }
            }
        }
        System.out.println(res);
        List<String> resStr = new ArrayList<>();
        for (List<Integer> i : res) {
            resStr.add(Integer.toString(i.get(0) + 1) + ":" + Integer.toString(i.get(1) + 1) + ":" + i.get(2));
        }
        return resStr;

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
        List res = stl.convertDateDesc("0-4,1-4,");
        System.out.println(res);

        String className = "班";
        System.out.println(stl.getNum(className));
    }
}
