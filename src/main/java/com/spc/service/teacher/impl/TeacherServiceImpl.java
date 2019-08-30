package com.spc.service.teacher.impl;

import com.spc.controller.Base;
import com.spc.dao.*;
import com.spc.model.ClassApplicationDomain;
import com.spc.model.FileInfo;
import com.spc.service.teacher.TeacherService;
import com.spc.util.MakeTimeTable;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TeacherServiceImpl extends Base implements TeacherService {

    @Autowired
    ClassApplicationDao classApplicationDao;

    @Autowired
    TeacherInfoDao teacherInfoDao;

    @Autowired
    ClassDao classDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;

    @Autowired
    IssueGradeDao issueGradeDao;

    @Autowired
    FileInfoDao fileInfoDao;

    @Autowired
    SchoolCalendarDao schoolCalendarDao;

    @Autowired
    GradeDao gradeDao;


    @Override
    public int addClassApplication(ClassApplicationDomain classApplicationDomain) {
        return classApplicationDao.add(classApplicationDomain);
    }

    @Override
    public String[][] findCourseTable(String teaId) {
        List<HashMap<String, Object>> lis = classDao.findCourseTable(teaId, CURRENTSEMESTER);
        logger.info(lis.toString());
        return MakeTimeTable.makeBigTable(lis, 0);
    }

    @Override
    public List<Map<String, Object>> findApplication(String teaId) {
        return classApplicationDao.findByTeaId(teaId);
    }

    @Override
    public List findStudentByClassnameAndNum(String className, int classNum) {
        int classId = (int) studentDao.findClassesByNameAndNum(className, classNum).get("classId");
        return studentDao.findStudent(classId, "");
    }

    @Override
    public int issueGrade(int classId, int model1, int model2) {
        if (issueGradeDao.select(classId) == null) {
            issueGradeDao.insert(classId, model1, model2);
        } else {
            issueGradeDao.update(classId, model1, model2);
        }
        return 0;
    }

    @Override
    public int addComment(String classId, String suggestion, String teaId, List<String> scores, String stuId) {
        int totalScore = 0;
        for (String score : scores) {
            totalScore += Integer.parseInt(score);
        }
        System.out.println("===========添加评论============");

        return teacherDao.addComment(stuId, classId, suggestion, totalScore, teaId);
    }

    @Override
    public List<Map<String, Object>> courseList(String teaId) {
        return teacherDao.courseList(teaId);
    }

    @Override
    public List<Map<String, Object>> courseStudentList(String classId) {
        return teacherDao.courseStudentList(classId);
    }

    @Override
    public List<Map<String, Object>> findStudentAndStatus(int classId, String teaId) {
        List students = studentDao.findStudent(classId,"");
        List<Map<String, Object>> studentList = new ArrayList<>();
        if (students.size() > 0) {
            for (int i = 0; i < students.size(); i++) {
                Map<String, Object> studentMap = new HashMap<>();
                studentMap.put("stuId", ((Map<String, Object>) students.get(i)).get("stuId"));
                studentMap.put("stuName", ((Map<String, Object>) students.get(i)).get("stuName"));
                studentMap.put("departName", ((Map<String, Object>) students.get(i)).get("departName"));
                int commentStatus = 0;//0表示未评价
                String stuId = (String) ((Map<String, Object>) students.get(i)).get("stuId");
                int count = teacherDao.findCommentStatus(stuId, teaId, Integer.toString(classId));
                if (count >= 1) {
                    commentStatus = 1;//1表示已评价
                }
                studentMap.put("commentStatus", commentStatus);
                studentList.add(studentMap);
            }
        }
        return studentList;
    }

    @Override
    public Map<String, Object> findCommentByClassIdAndStuId(int classId, int stuId) {
        List<Map<String, Object>> comment = teacherDao.findCommentByClassIdAndStuId(classId, stuId);
        if (comment.size() == 0) {
            return null;
        }
        return comment.get(0);
    }

    @Override
    public Map<String, Object> findCurrentCalendar() {
        return schoolCalendarDao.currentCalendar();
    }

    @Override
    public int addWeekComment(int classId, String teaId, int weekth, List<Map<String, Object>> commentList) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        System.out.println(date);
        for (Map<String, Object> comment : commentList) {
            List list = classDao.findWeekComment((String) comment.get("stuId"), weekth, Integer.toString(classId));
            System.out.println(comment);
            if (list.size() == 0) {
                System.out.println("size=0");
                System.out.println(comment.get("score1"));
                System.out.println(comment.get("score2"));
                System.out.println(comment.get("score3"));
                System.out.println(comment.get("score4"));
                System.out.println(weekth);
                System.out.println(classId);
                System.out.println(teaId);
                System.out.println(comment.get("suggestion"));
                teacherDao.insertWeekComment((String) comment.get("stuId"), teaId, classId, (String) comment.get("score1"),
                        (String) comment.get("score2"), (String) comment.get("score3"), (String) comment.get("score4"), (String) comment.get("suggestion"), weekth, date);
                System.out.println("size=0hou");
            } else if (list.size() > 0) {
                teacherDao.updateWeekComment((String) comment.get("stuId"), teaId, classId, (String) comment.get("score1"),
                        (String) comment.get("score2"), (String) comment.get("score3"), (String) comment.get("score4"), (String) comment.get("suggestion"), weekth, date);
            }
        }
        return 1;
    }

    @Override
    public Map<String, Object> findTemplateFile() {
        Map<String, Object> fileInfo = fileInfoDao.selectTemplateFile().get(0);
        System.out.println(fileInfo);
        return fileInfo;
    }

    @Override
    public int addFileInfo(String teaId, String fileName, String path, int type, String dep, String date, int flag) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setUserId(teaId);
        fileInfo.setFileName(fileName);
        fileInfo.setPath(path);
        fileInfo.setType(type);
        fileInfo.setDep(dep);
        fileInfo.setTime(date);
        fileInfo.setFlag(flag);
        fileInfoDao.insertFile(fileInfo);
        return fileInfo.getFileInfoId();
    }

    /**
     * 查询管理员设置的成绩比例，KNSK表示课内授课的成绩百分比，XBSJ表示小班实践成绩百分比，ZZXX表示自主学习成绩百分比
     *
     * @return
     */
    @Override
    public Map<String, Object> findGradePercent() {
        return teacherDao.findGradePercent();
    }

    @Override
    public Map<String, Object> findCourseClassTime(String classNum, String stuId) {
        return teacherDao.findCourseClassTime(classNum, stuId);
    }

    @Override
    public int uploadFile(MultipartFile file, String userId, String dep, int type, String filePath) {
        if (file.isEmpty()){
            return 0;
        }
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);

        String path = filePath + fileName;
        File dest = new File(path);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();// 新建文件夹
        }
        try {
            file.transferTo(dest);// 文件写入
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date=sdf.format(new Date());

            FileInfo fileInfo = new FileInfo();
            fileInfo.setUserId(userId);
            fileInfo.setFileName(fileName);
            fileInfo.setPath(path);
            fileInfo.setType(type);
            fileInfo.setDep(dep);
            fileInfo.setTime(date);
            fileInfo.setFlag(1);
            fileInfoDao.insertFile(fileInfo);
            return fileInfo.getFileInfoId();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertGradeExcel(int status, int classId, int fileInfoId) {
        Map<String, Object> fileInfo = (Map<String, Object>) fileInfoDao.selectGradeExcel(fileInfoId).get(0);
        String fileName = (String) fileInfo.get("fileName");
        String path = (String) fileInfo.get("path");
        File file = new File(path + fileName);
        if (file == null) {
            return 0;
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
                Sheet sheet = workbook.getSheetAt(i);
                for (int j = 1; j < sheet.getLastRowNum(); j++) {
                    Row row = sheet.getRow(j);
                    if (row == null) {
                        continue;
                    }

                    String stuId = row.getCell(1).getStringCellValue();
                    String grade = row.getCell(4).getStringCellValue();
                    if (grade != null && grade.equals("")) {
                        gradeDao.updateGrade(classId, stuId, Float.parseFloat(grade));
                    }

                }
                if (status == 1)
                    classDao.updateGradeFlag(classId);
            }
            return 1;
        }


        return 0;
    }

    @Override
    public int insertKnskGradeExcel(int status, String JXBID, int fileInfoId) {
        Map<String, Object> fileInfo = (Map<String, Object>) fileInfoDao.selectGradeExcel(fileInfoId).get(0);
        String fileName = (String) fileInfo.get("fileName");
        String path = (String) fileInfo.get("path");
        File file = new File(path + fileName);
        if (file == null) {
            return 0;
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
                Sheet sheet = workbook.getSheetAt(i);
                for (int j = 1; j < sheet.getLastRowNum(); j++) {
                    Row row = sheet.getRow(j);
                    if (row == null) {
                        continue;
                    }

                    String stuId = row.getCell(1).getStringCellValue();
                    String grade = row.getCell(4).getStringCellValue();
                    if (grade != null && grade.equals("")) {
                        gradeDao.updateKnskGrade(JXBID, stuId, Float.parseFloat(grade));
                    }

                }
                if (status == 1)
                    classDao.updateKnskGradeFlag(JXBID);
            }
            return 1;
        }


        return 0;
    }

    @Override
    public void updateKnskScore(String JXBID, String stuId, float grade) {
        gradeDao.updateKnskGrade(JXBID, stuId, grade);
    }

    @Override
    public List<Map<String, Object>> showGradeExcel(int fileInfoId) {
        List<Map<String, Object>> students = new ArrayList<>();
        Map<String, Object> fileInfo = teacherDao.selectGradeExcel(fileInfoId);
        String fileName = (String) fileInfo.get("fileName");
        String path = (String) fileInfo.get("path");
        File file = new File(path );
        if (file == null) {
            return null;
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
                Sheet sheet = workbook.getSheetAt(i);
                System.out.println(sheet.getLastRowNum());
                for (int j = 1; j <=sheet.getLastRowNum(); j++) {
                    Row row = sheet.getRow(j);
                    if (row == null) {
                        continue;
                    }
                    Map<String, Object> stu = new HashMap<>();
                    String stuName = row.getCell(0).getStringCellValue();
                    String stuId = row.getCell(1).getStringCellValue();
                    String departName = row.getCell(2).getStringCellValue();
                    String speciality = row.getCell(3).getStringCellValue();
                    String grade = String.valueOf(row.getCell(4).getNumericCellValue());
                    stu.put("stuName", stuName);
                    stu.put("stuId", stuId);
                    stu.put("departName", departName);
                    stu.put("speciality", speciality);
                    stu.put("xbsjGrade", Float.parseFloat(grade));
                    students.add(stu);
                }
            }
        }


        return students;
    }

    @Override
    public List<Map<String, Object>> showKnskGradeExcel(int fileInfoId) {
        List<Map<String, Object>> students = new ArrayList<>();
        Map<String, Object> fileInfo = teacherDao.selectGradeExcel(fileInfoId);
        String fileName = (String) fileInfo.get("fileName");
        String path = (String) fileInfo.get("path");
        File file = new File(path );
        if (file == null) {
            return null;
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
                Sheet sheet = workbook.getSheetAt(i);
                System.out.println(sheet.getLastRowNum());
                for (int j = 1; j <=sheet.getLastRowNum(); j++) {
                    Row row = sheet.getRow(j);
                    if (row == null) {
                        continue;
                    }
                    Map<String, Object> stu = new HashMap<>();
                    String stuName = row.getCell(0).getStringCellValue();
                    String stuId = row.getCell(1).getStringCellValue();
                    String departName = row.getCell(2).getStringCellValue();
                    String speciality = row.getCell(3).getStringCellValue();
                    String grade = String.valueOf(row.getCell(4).getNumericCellValue());
                    stu.put("stuName", stuName);
                    stu.put("stuId", stuId);
                    stu.put("departName", departName);
                    stu.put("speciality", speciality);
                    stu.put("knskGrade", Float.parseFloat(grade));
                    students.add(stu);
                }
            }
        }
        return students;
    }
    public String getTeaName(String teaId){
        return teacherInfoDao.selectTeaName(teaId);
    }
}