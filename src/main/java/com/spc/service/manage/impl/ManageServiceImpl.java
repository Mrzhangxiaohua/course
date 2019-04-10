package com.spc.service.manage.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spc.controller.Base;
import com.spc.dao.*;
import com.spc.model.ClassApplicationDomain;
import com.spc.model.ClassDomain;
import com.spc.model.StudentApplicationDomain;
import com.spc.service.manage.ManageService;
import com.spc.util.MakeTimeTable;
import com.sun.xml.rpc.processor.model.soap.SOAPUnorderedStructureType;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

@Service
public class ManageServiceImpl extends Base implements ManageService {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private ClassDao classDao;
    @Autowired
    private GradeDao gradeDao;
    @Autowired
    private SchoolCalendarDao schoolCalendarDao;

    @Autowired
    private StudentApplicationDao studentApplicationDao;

    @Autowired
    private ClassApplicationDao classApplicationDao;

    @Autowired
    private TimeSwitchDao timeSwitchDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    FileInfoDao fileInfoDao;

    @Autowired
    GradePercentDao gradePercentDao;

    @Autowired
    ClassAllDao classAllDao;

    @Autowired
    CourseAllDao courseAllDao;

    @Override
    public String[][] findClasses(String stuId) {
        List<HashMap<String, Object>> lis = studentDao.findClasses(stuId,CURRENTSEMESTER);

        return MakeTimeTable.makeBigTable(lis, 0);
    }

    @Override
    public String[][] bigTable(String shenQingRenId, String shenQingRenName, String teaName,Integer departId) {

        List<HashMap<String, Object>> lis = classDao.findAllClasseSimpleMess(shenQingRenId, shenQingRenName, teaName,departId);
        return MakeTimeTable.makeBigTable(lis, 0);
    }

    @Override
    public List<StudentApplicationDomain> checkedMessage(int key, String stuId) {

        return studentApplicationDao.findall(key, stuId);
    }

    @Override
    public List<StudentApplicationDomain> checkedMessageAndDate(int key, String stuId, Date date) {
        java.sql.Date dateSql = new java.sql.Date(date.getTime());
        System.out.println(dateSql);
        return studentApplicationDao.findallWithDate(key, stuId, dateSql);
    }

    @Override
    @Transactional
    public int chooseCourse(int classId, String stuId) {
        System.out.println(classDao.haveStuInClass(classId, stuId));
        if (classDao.haveStuInClass(classId, stuId).isEmpty()) {
            classDao.updateChooseNum(classId, 1);
            studentDao.addChooseCourse(stuId, classId);
        }
        return 0;
    }

    @Override
    @Transactional
    public int deleteCourse(int classId, String stuId) {
        classDao.updateChooseNum(classId, -1);
        studentDao.deleteChooseCourse(stuId, classId);
        return 0;
    }

    @Override
    public int makeSure(int id, String classStr) {
        //通过的话就要将checked设置为1
        //通过的话要根据请求的内容做相应的调整
        StudentApplicationDomain studentApplicationDomain = studentApplicationDao.selectById(id);
        String stuId = studentApplicationDomain.getStuId();
        int classNum = studentApplicationDomain.getClassNum();
        int oldClassId = studentApplicationDomain.getClassId();

        switch (studentApplicationDomain.getCategory()) {
            case "新增课程":
                System.out.println("新增课程");
                List<Map<String, Object>> res = studentDao.findTimeChongTu(stuId, oldClassId);
                boolean canAdd = gradeDao.selectGrade(oldClassId, stuId).isEmpty() && res.isEmpty();
                if (canAdd) {
                    chooseCourse(oldClassId, stuId);
                }
                break;
            case "调整班级":
                System.out.println("调整班级");
                deleteCourse(oldClassId, stuId);
                int newClassId = studentDao.findClassNewId(oldClassId, classNum);
                chooseCourse(newClassId, stuId);
                break;
            case "重修课程":
                System.out.println("重修课程");
                chooseCourse(oldClassId, stuId);
                break;
            case "退选计划":
                System.out.println("退选计划");
//                chooseCourse(oldClassId,stuId);
                deleteCourse(oldClassId, stuId);
                break;
        }
        return studentApplicationDao.checked(id, 1);
    }

    @Override
    @Transactional
    public int makeSureClassApplication(int id,String courseId,int departId) {
        classApplicationDao.checkedClass(id, 1);
        ClassApplicationDomain cad = classApplicationDao.findById(id).get(0);
        String className = cad.getClassName();
        int classModuleNum = cad.getClassModuleNum();
        int classTime = cad.getClassTime();
        String teaId = cad.getTeaId();
        String teaName = cad.getTeaName();
        String courseInfo = cad.getCourseInfo();
        String teacherInfo = cad.getTeacherInfo();
        courseAllDao.insertCourse(departId,className,classModuleNum,classTime,teaId,teaName,courseInfo,teacherInfo,courseId);

        classAllDao.insertFirstClass(departId,className,classModuleNum,classTime,teaId,teaName,courseId,"1班");

        return 1;
    }

    @Override
    public int reject(int id) {
        //拒绝的话就要将checked设置为3
        return studentApplicationDao.checked(id, 3);
    }

    @Override
    public int rejectClassApplication(int id) {
        return classApplicationDao.checkedClass(id, 3);
    }

    @Override
    public void addCourse(ClassDomain cd) {
        classDao.insert(cd);
    }

    @Override
    public void deleteCourseRecord(int classId) {
        classDao.delete(classId);
    }


    @Override
    public int addCourseStudent(String stuId, String classId) {
//        String newStr = classStr.replace("(", ",").replace(")", "");
//        String[] strs = newStr.substring(0, newStr.length() - 1).split(",");
//
//        System.out.println(strs);
//        String className = strs[0];
//        Integer classNum = Integer.parseInt(strs[1]);
//        int classId = (int) studentDao.findClassesByNameAndNum(className, classNum).get("classId");
//        System.out.println("run here =" + classId);
        chooseCourse(Integer.parseInt(classId), stuId);
        return 0;
    }

    @Override
    public int deleteCourseStudent(String stuId, String classId) {
//        String newStr = classStr.replace("(", ",").replace(")", "");
//        String[] strs = newStr.substring(0, newStr.length() - 1).split(",");

//        System.out.println(newStr);
//        String className = strs[0];
//        Integer classNum = Integer.parseInt(strs[1]);
//        int classId = (int) studentDao.findClassesByNameAndNum(className, classNum).get("classId");
        deleteCourse(Integer.parseInt(classId), stuId);
        return 0;
    }

    @Override
    public int getClassId(String className, int classNum) {
        return (int) studentDao.findClassesByNameAndNum(className, classNum).get("classId");
    }

    @Override
    public int deleteApplication(int id) {
        classApplicationDao.deleteClassApp(id);
        return 0;
    }

    @Override
    public List findStudentByClassnameAndNum(String classId, int pageSize, int currentPage) {
//        int classId = (int) studentDao.findClassesByNameAndNum(className, classNum).get("classId");

        PageHelper.startPage(currentPage, pageSize);
        return studentDao.findStudent(Integer.parseInt(classId));
    }

    @Override
    public List findStudentByStudentId(int pageSize, int currentPage, String stuId) {
        PageHelper.startPage(currentPage, pageSize);
        return studentDao.findStudentByStudentId(stuId);
    }
    @Override
    public List<ClassApplicationDomain> checkedClassMessage(String shenQingRenId, String className, int tabKey, String shenqingrenname) {
        return classApplicationDao.findallClass(shenQingRenId, className, tabKey, shenqingrenname);
    }

    @Override
    public List<ClassApplicationDomain> checkedClassMessageAndDate(String shenQingRenId, String className, Date date, int tabKey, String shenqingrenname) {
        java.sql.Date dateSql = new java.sql.Date(date.getTime());
        System.out.println("时间time是======" + dateSql);
        return classApplicationDao.findallClassWithDate(shenQingRenId, className, date, tabKey, shenqingrenname);
    }

    @Override
    public int addTimeSwitch(int timeSwitch) {
        return timeSwitchDao.add(timeSwitch);
    }

    @Override
    public int updateTimeSwitch(int timeSwitch) {
        return timeSwitchDao.updateTimeSwitch(timeSwitch);
    }

    @Override
    public int updateTimeSwitch2(String startDate, String endDate) {
        return timeSwitchDao.updateTimeSwitch2(startDate, endDate);
    }
    @Override
    public List<Map> jilianSelect() {
        List<ClassDomain> classes = classDao.selectClasses(88888888, "", "", "", 88888888, 88888888, 1, 88888888, 1, 0);

        List<Map> res = new ArrayList<>();

        List<String> departTemp = new ArrayList<String>();
        List<String> classTemp = new ArrayList<String>();
        for (ClassDomain cd : classes) {
            //判断是否这个学院
            String departName = cd.getDepartName();
            int classId = cd.getClassId();
            String className = cd.getClassName();
            String classNum = String.valueOf(cd.getClassNum());
            int departId = cd.getDepartId();
            String allClassName = cd.getDepartName() + cd.getClassName();

            boolean in = false;
            if (departTemp.size() != 0) {
                for (String s : departTemp) {
                    if (s.equals(departName)) in = true;
                }
            }
            if (!in) departTemp.add(departName);
            //没有这个学院
            if (!in) {
                //创造课程
                //创造学院
                Map departM = creatClassOrDepartMap(departName, departId);
                Map classM = creatClassOrDepartMap(className, classId);

                Map classStrM = creatClassStrMap(classNum, classId);

                addClassOrDepart(classM, classStrM);
                addClassOrDepart(departM, classM);

                res.add(departM);
                classTemp.add(allClassName);
                departTemp.add(departName);
                //有这个学院
            } else {
                //判断有没有这个课程
                boolean in2 = false;
                if (classTemp.size() != 0) {
                    for (String s : classTemp) {
                        if (s.equals(allClassName)) in2 = true;
                    }
                }
                if (!in2) classTemp.add(allClassName);
//                System.out.println(allClassName);
                //没有这个课程
                if (!in2) {

                    Map classM = creatClassOrDepartMap(className, classId);
                    Map classStrM = creatClassStrMap(classNum, classId);
                    addClassOrDepart(classM, classStrM);
                    for (Map everyDe : res) {
                        if (everyDe.get("label").equals(departName)) {
                            addClassOrDepart(everyDe, classM);
                        }
                    }
                } else {//有这个课程
                    Map classStrM = creatClassStrMap(classNum, classId);
                    for (Map everyDe : res) {
                        if (everyDe.get("label").equals(departName)) {
                            List<Map> list = (List<Map>) everyDe.get("children");
                            for (Map everyClass : list) {
                                if (everyClass.get("label").equals(className)) {
                                    List<Map> list2 = (List<Map>) everyClass.get("children");
                                    list2.add(classStrM);
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }


    public Map creatClassStrMap(String classNum, int classId) {
        Map tempChild2 = new HashMap();
        tempChild2.put("value", classId);
        tempChild2.put("label", classNum + "班");
        return tempChild2;
    }

    public Map creatClassOrDepartMap(String className, int classId) {
        Map tempChild2 = new HashMap();
        tempChild2.put("value", classId);
        tempChild2.put("label", className);
        List<Map> res = new ArrayList<>();
        tempChild2.put("children", res);
        return tempChild2;
    }

    public Map addClassOrDepart(Map classMap, Map classStrMap) {
        List<Map> res = (List<Map>) classMap.get("children");
        res.add(classStrMap);
        return classMap;
    }

    public int addSchoolCalendar(String year, String firstWeek, String semester) {
        schoolCalendarDao.updateCalendarFlag();
        schoolCalendarDao.insertCalendar(year, semester, firstWeek);
        return 1;
    }

    @Override
    public int addTemplateFileInfo(String teaId, String fileName, String path, int type, String dep, String date, int flag) {
        fileInfoDao.updateFlagZero(type);
        return fileInfoDao.insertFileInfo(teaId, fileName, path, type, dep, date, flag);

    }

    @Override
    public int addGradePercent(int knsk, int xbsj, int zzxx, String userId, String date) {
        gradePercentDao.updateFlagZero();
        return gradePercentDao.insertGradePercent(knsk,xbsj,zzxx,userId,date);
    }

    @Override
    public List<Map<String, Object>> findAllStudent(int moduleId, String academicYear,int submit,int depId,String stuId) {
        List<Map<String,Object>> students=gradeDao.findAllStudent(academicYear,depId,stuId);
        List<Map<String,Object>> res=new ArrayList<>();
        if(moduleId==1) {
            for (Map stu:students) {
                Map<String,Object> student=new HashMap<>();
                String XH1= (String) stu.get("XH");
                String XM=(String) stu.get("XM");
                String departName=(String) stu.get("departName");
                String speciality=(String)stu.get("speciality");
                float grade= (float) stu.get("wlzzGrade");
                int isSubmit=(int) stu.get("wlzzIsSubmit");
//                if(isSubmit!=submit)
//                    continue;
                student.put("stuId",XH1);
                student.put("stuName",XM);
                student.put("grade",grade);
                student.put("isSubmit",isSubmit);
                student.put("departName",departName);
                student.put("speciality",speciality);
                res.add(student);
            }
        }
        if(moduleId==2) {
            for (Map stu:students) {
                Map<String,Object> student=new HashMap<>();
                String XH1= (String) stu.get("XH");
                String XM=(String) stu.get("XM");
                String departName=(String) stu.get("departName");
                String speciality=(String)stu.get("speciality");
                float grade= (float) stu.get("dektGrade");
                int isSubmit=(int) stu.get("dektIsSubmit");
//                if(isSubmit!=submit)
//                    continue;
                student.put("stuId",XH1);
                student.put("stuName",XM);
                student.put("grade",grade);
                student.put("isSubmit",isSubmit);
                student.put("departName",departName);
                student.put("speciality",speciality);
                res.add(student);
            }
        }
        if(moduleId==3) {
            for (Map stu : students) {
                Map<String,Object> student=new HashMap<>();
                String XH1= (String) stu.get("XH");
                String XM=(String) stu.get("XM");
                String departName=(String) stu.get("departName");
                String speciality=(String)stu.get("speciality");
                float grade= (float) stu.get("nlcsGrade");
                int isSubmit=(int) stu.get("nlcsIsSubmit");
//                if(isSubmit!=submit)
//                    continue;
                student.put("stuId",XH1);
                student.put("stuName",XM);
                student.put("grade",grade);
                student.put("isSubmit",isSubmit);
                student.put("departName",departName);
                student.put("speciality",speciality);
                res.add(student);
            }
        }
        return res;

    }

    @Override
    public List<Map<String, Object>> findStuById(String stuId, int moduleId) {
        List<Map<String,Object>> students=gradeDao.findStuById(stuId);
        if(students.size()!=0) {
            List<Map<String,Object>> students1=new ArrayList<>();
            Map<String, Object> stu = students.get(0);
            Map<String, Object> student = new HashMap<>();
            if (moduleId == 1) {
                String XM = (String) stu.get("XM");
                float grade = (float) stu.get("wlzzGrade");
                int isSubmit = (int) stu.get("wlzzIsSubmit");
                student.put("stuId", stuId);
                student.put("stuName", XM);
                student.put("grade", grade);
                student.put("isSubmit", isSubmit);
            }
            if (moduleId == 2) {
                String XM = (String) stu.get("XM");
                float grade = (float) stu.get("dektGrade");
                int isSubmit = (int) stu.get("dektIsSubmit");
                student.put("stuId", stuId);
                student.put("stuName", XM);
                student.put("grade", grade);
                student.put("isSubmit", isSubmit);
            }
            if (moduleId == 3) {
                String XM = (String) stu.get("XM");
                float grade = (float) stu.get("nlcsGrade");
                int isSubmit = (int) stu.get("nlcsIsSubmit");
                student.put("stuId", stuId);
                student.put("stuName", XM);
                student.put("grade", grade);
                student.put("isSubmit", isSubmit);
            }
            students1.add(student);
            return students1;
        }
        return students;
    }

    @Override
    public void updateScore(String stuId, float grade, int moduleId, int status) {
        if(moduleId==1){
            gradeDao.updateWlzzScore(stuId,grade,status);
        }
        if(moduleId==2){
            gradeDao.updateDektScore(stuId,grade,status);
        }
        if(moduleId==3){
            gradeDao.updateNlcsScore(stuId,grade,status);
        }
    }

    @Override
    public void insertStu(String stuId, String academicYear) {
        gradeDao.insertStu(stuId,academicYear);
    }

    @Override
    public List<Map<String, Object>> findAlldepartment() {
        return classDao.findAlldepartment();
    }

    @Override
    public Map insertGradeExcel(int moduleId, int fileInfoId,String academicYear) {
        int status=0;
        Map<String,Object> res=new HashMap<>();
        List<Map<String,Object>> result=new ArrayList<>();
        Map<String, Object> fileInfo = teacherDao.selectGradeExcel(fileInfoId);
        String fileName = (String) fileInfo.get("fileName");
        String path = (String) fileInfo.get("path");
        System.out.println(fileName);
        File file = new File(path);
        if (file == null) {
            res.put("flag",0);
            return res;
        }
        Workbook workbook = null;
        try (FileInputStream is = new FileInputStream(file)) {
            if (file.getName().endsWith(".xls")) {
                workbook = new HSSFWorkbook(is);
            } else if (file.getName().endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (workbook != null) {
            int sheetNum = workbook.getNumberOfSheets();
            for (int i = 0; i < sheetNum; i++) {
                System.out.println("进入第一个循环。。。");
                Sheet sheet = workbook.getSheetAt(i);
                for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                    Row row = sheet.getRow(j);
                    if (row == null) {
                        continue;
                    }
                    String stuName=row.getCell(0).getStringCellValue();
                    System.out.println("姓名："+stuName);
                    String stuId= null;
                    switch (row.getCell(1).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            DecimalFormat df = new DecimalFormat("0");
                            stuId = df.format(row.getCell(1).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            stuId=row.getCell(1).getStringCellValue();
                            break;
                    }
//                    DecimalFormat df = new DecimalFormat("0");
//                    String stuId = df.format(row.getCell(1).getNumericCellValue());
//                    if (stuId.indexOf(",") >= 0) {
//                        stuId = stuId.replace(",", "");
//                    }
                    System.out.println("学号："+stuId);
                    List<Map<String, Object>> stu = gradeDao.findStuById(stuId);
                    if (stu.size() == 0) {
                        Map<String,Object> li=new HashMap<>();
                        li.put("stuName",stuName);
                        li.put("stuId",stuId);
                        result.add(li);
                    }

                }
            }
            System.out.println("检查完毕。。。");
            if(result.size()!=0){
                res.put("list",result);
                res.put("flag",0);
                return  res;
            }
            for (int i = 0; i < sheetNum; i++) {
                System.out.println("进入第二个循环。。。");
                Sheet sheet = workbook.getSheetAt(i);
                System.out.println(sheet.getLastRowNum());
                for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                    Row row = sheet.getRow(j);
                    if (row == null) {
                        continue;
                    }
                    String stuId= null;
                    switch (row.getCell(1).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            DecimalFormat df = new DecimalFormat("0");
                            stuId = df.format(row.getCell(1).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            stuId=row.getCell(1).getStringCellValue();
                            break;
                    }
//                    if()
//                    DecimalFormat df = new DecimalFormat("0");
//                    String stuId = df.format(row.getCell(1).getNumericCellValue());
//                    String stuId = String.valueOf(row.getCell(1).getStringCellValue());
                    String grade = String.valueOf(row.getCell(4).getNumericCellValue());
                    System.out.println("成绩："+grade);
                    List<Map<String, Object>> stu = gradeDao.findStuById(stuId);
                    System.out.println("数组大小："+stu.size());
                    System.out.println("moduleId:"+moduleId);
                    if (stu.size() != 0) {
                        Map<String, Object> stu1 = stu.get(0);
                        if (moduleId == 1) {
                            int isSubmit = (int) stu1.get("wlzzIsSubmit");
                            if (isSubmit == 1)
                                continue;
                        }
                        if (moduleId == 2) {
                            int isSubmit = (int) stu1.get("dektIsSubmit");
                            if (isSubmit == 1)
                                continue;
                        }
                        if (moduleId == 3) {
                            int isSubmit = (int) stu1.get("nlcsIsSubmit");
                            if (isSubmit == 1)
                                continue;
                        }
                        if (moduleId == 1) {
                            gradeDao.updateWlzzScore(stuId, Float.parseFloat(grade), status);
                        }
                        if (moduleId == 2) {
                            gradeDao.updateDektScore(stuId, Float.parseFloat(grade), status);
                        }
                        if (moduleId == 3) {
                            gradeDao.updateNlcsScore(stuId, Float.parseFloat(grade), status);
                        }
                    }
                }
            }
        }
        res.put("flag",1);
        return res;
    }

    @Override
    public int findIsGrade(int moduleId, String academicYear) {
        List<Map<String,Object>> stu=new ArrayList<>();
        if(moduleId==1)
            stu=gradeDao.findWlzzIsGrade(academicYear);
        if(moduleId==2)
            stu=gradeDao.findDektIsGrade(academicYear);
        if(moduleId==3)
            stu=gradeDao.findNlcsIsGrade(academicYear);
        if(stu.size()==0)
            return 1;
        else
            return 0;
    }

    @Override
    public List<Map<String, Object>> findXbsjStudents(int classId) {
        return gradeDao.findXbsjStudents(classId);
    }

    @Override
    public List<Map<String, Object>> findKnskStudents(String classId) {
        return gradeDao.findKnskStudents(classId);
    }

    @Override
    public void updateXbsjChecked(int classId, String stuId,int isChecked) {
        gradeDao.updateXbsjChecked(classId,stuId,isChecked);
    }

    @Override
    public void updateKnskChecked(String classId, String stuId,int isChecked) {
        gradeDao.updateKnskChecked(classId,stuId,isChecked);
    }

    @Override
    public void updateXbsjSubmit(int classId) {
        gradeDao.updateXbsjSubmit(classId);
    }

    @Override
    public void updateKnskSubmit(String classId) {
        gradeDao.updateKnskSubmit(classId);
    }

    @Override
    public List<Map<String, Object>> findAllScore(int departId, String stuId) {
        List<Map<String,Object>> stuList=new ArrayList<>();
        stuList=gradeDao.findAllScore(departId,stuId);
        int xbsjPercent=gradeDao.findXbsjPercent();
        int knskPercent=gradeDao.findKnskPercent();
        int wlzzPercent=gradeDao.findWlzzPercent();
        int dektPercent=gradeDao.findDektPercent();
        int nlcsPercent=gradeDao.findNlcsPercent();
        for(Map stu:stuList)
        {
            if((float)stu.get("xbsjGrade")!=0 && (float)stu.get("knskGrade")!=0 && (float)stu.get("wlzzGrade")!=0 && (float)stu.get("dektGrade")!=0 && (float)stu.get("nlcsGrade")!=0) {
                float grade=(float)stu.get("xbsjGrade")*(float)xbsjPercent/100 + (float)stu.get("knskGrade")*(float)knskPercent/100 + (float)stu.get("wlzzGrade")*(float)wlzzPercent/100 + (float)stu.get("dektGrade")*(float)dektPercent/100 + (float)stu.get("nlcsGrade")*(float)nlcsPercent/100;
                stu.put("grade",grade);
            }
            else
                stu.put("grade",(float)0);

        }
        return stuList;
    }

    @Override
    public void uploadAllGradeOther(String stuId, float grade, int moduleId) {
        gradeDao.uploadAllGradeOther(stuId,grade,moduleId);
    }

    @Override
    public void updateIsSubmit(int moduleId) {
        if(moduleId==1)
            gradeDao.updateWlzzIsSubmit();
        if(moduleId==2)
            gradeDao.updateDektIsSubmit();
        if(moduleId==3)
            gradeDao.updateNlcsIsSubmit();
    }
}
