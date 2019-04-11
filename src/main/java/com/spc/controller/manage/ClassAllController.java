package com.spc.controller.manage;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spc.controller.Base;
import com.spc.model.*;
import com.spc.service.manage.*;
import com.spc.service.wsdl.GetUndergradFreeClassrooms.GetUndergradFreeClassroomInfo;
import com.spc.service.wsdl.TeachersOccupyTimeWebservice.TeacherCurriculumInfo;
import com.spc.util.ResponseWrap;
import com.spc.view.ManageTablePdfView;
import com.spc.view.StudentTablePdfView;
import com.sun.xml.rpc.processor.model.soap.SOAPUnorderedStructureType;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description 排课Controller
 * @create 2018-12-25 16:24
 **/
@RequestMapping("/manage")
@Controller
public class ClassAllController extends Base {

    @Autowired
    private ClassAllService classAllService;

    @Autowired
    private CourseAllService courseAllService;

    @Autowired
    private SchoolDistrictService schoolDistrictService;

    @Autowired
    private TeacherInfoService teacherInfoService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ClassroomInfoService classroomInfoService;

    @Autowired
    private TeacherCurriculumInfo teacherCurriculumInfoService;

    @Autowired
    private GetUndergradFreeClassroomInfo freeClassroomService;

    /**
     * 获取课程列表--超管
     *
     * @param currentPage
     * @param pageSize
     * @param courseName
     * @param teacherId
     * @param teacherName
     * @param classSemester
     * @return
     */
      @RequestMapping("/getClassAll")
    @ResponseBody
    public Map<String, Object> getClassAll(@RequestParam(required = false, defaultValue = "1") int currentPage,
                                           @RequestParam(required = false, defaultValue = "10") int pageSize,
                                           @RequestParam(required = false) String academicYear,
                                           @RequestParam(required = false) String classSemester,
                                           @RequestParam(required = false) String courseId,
                                           @RequestParam(required = false) String courseName,
                                           @RequestParam(required = false) String teacherId,
                                           @RequestParam(required = false) String teacherName,
                                           @RequestParam(required = false) String classPlaceId,
                                           @RequestParam(required = false) String selectDepartId,
                                           HttpServletRequest request) {
        // get user's departId
        HttpSession httpSession = request.getSession();
        Object departIdObject = httpSession.getAttribute("departId");
        if (null == departIdObject||departIdObject.equals("0")) {
            return null;
        }

        int departId = Integer.parseInt(departIdObject.toString());
//        int departId = 8;

        PageHelper.startPage(currentPage, pageSize);
        List<ClassAll> courses = classAllService.getClassAll(departId, academicYear, classSemester, courseId,
                courseName, teacherId, teacherName, classPlaceId, selectDepartId);

        Map<String, Object> res = new HashMap<>();
        res.put("status", "SUCCESS");

        Map<String, Object> data = new HashMap<>();
        data.put("total", ((Page) courses).getTotal());
        data.put("pageSize", pageSize);
        data.put("currentPage", currentPage);
        data.put("list", courses);
        res.put("data", data);
        return res;
    }
    /*
    * 院管课程列表
    * */
    @RequestMapping("/getClassAllDepart")
    @ResponseBody
    public Map<String, Object> getClassAllDepart(@RequestParam(required = false, defaultValue = "1") int currentPage,
                                           @RequestParam(required = false, defaultValue = "10") int pageSize,
                                           @RequestParam(required = false) String academicYear,
                                           @RequestParam(required = false) String classSemester,
                                           @RequestParam(required = false) String courseId,
                                           @RequestParam(required = false) String courseName,
                                           @RequestParam(required = false) String teacherName,
                                           @SessionAttribute("departId") Object departIdStr) {
        if (null == departIdStr||departIdStr.equals("0")) {
            return null;
        }

        int departId = Integer.parseInt(departIdStr.toString());
        PageHelper.startPage(currentPage, pageSize);
        List<ClassAll> courses = classAllService.getClassAllDepart(departId, academicYear, classSemester, courseId, courseName,  teacherName);

        Map<String, Object> res = new HashMap<>();
        res.put("status", "SUCCESS");

        Map<String, Object> data = new HashMap<>();
        data.put("total", ((Page) courses).getTotal());
        data.put("pageSize", pageSize);
        data.put("currentPage", currentPage);
        data.put("list", courses);
        res.put("data", data);
        return res;
    }

    /**
     * 获取某个老师的上课课表
     *
     * @param teacherId
     * @return
     */
    @RequestMapping("/getTeacherTimetable")
    @ResponseBody
    public String[][] getTeacherTimetable(@RequestParam String teacherId, @RequestParam String academicYear, @RequestParam String classSemester) {
        return classAllService.getTeacherTimetable(teacherId, academicYear, classSemester);
    }

    /**
     * 获取所有校区
     *
     * @return
     */
    @RequestMapping("/getSchoolDistricts")
    @ResponseBody
    public List<IceSelectDataSource> getSchoolDistricts() {
        return schoolDistrictService.getAllSchoolDistricts();
    }


    /**
     * 获取某门课程的授课老师
     *
     * @param courseId
     * @param academicYear
     * @param classSemester
     * @return
     */
    @RequestMapping("/getTeachersByCourse")
    @ResponseBody
    public List<TeacherInfo> getTeachersByCourse(String courseId, String academicYear, String classSemester) {
        return courseAllService.getTeachersByCourse(courseId, academicYear, classSemester);
    }

    /**
     * 获取所有老师
     *
     * @return
     */
    @RequestMapping("/getTeachers")
    @ResponseBody
    public Map<String, Object> getTeachers(@RequestParam(required = false, defaultValue = "1") int currentPage,
                                           @RequestParam(required = false, defaultValue = "10") int pageSize,
                                           @RequestParam(required = false) Integer departId,
                                           @RequestParam(required = false) String teacherName) {
        PageHelper.startPage(currentPage, pageSize);
        List<TeacherInfo> teachers = teacherInfoService.getAllTeachers(departId, teacherName);

        Map<String, Object> res = new HashMap<>();
        res.put("status", "SUCCESS");

        Map<String, Object> data = new HashMap<>();
        data.put("total", ((Page) teachers).getTotal());
        data.put("pageSize", pageSize);
        data.put("currentPage", currentPage);
        data.put("list", teachers);
        res.put("data", data);
        return res;
    }

    /**
     * 获取所有教室（可排课）
     *
     * @return
     */
    @RequestMapping("/getClassrooms")
    @ResponseBody
    public Map<String, Object> getClassrooms(@RequestParam(required = false, defaultValue = "1") int currentPage,
                                             @RequestParam(required = false, defaultValue = "10") int pageSize,
                                             @RequestParam(required = false) String schoolDistrictId,
                                             @RequestParam(required = false) String classroomName) {
        PageHelper.startPage(currentPage, pageSize);
        List<ClassroomInfo> classrooms = classroomInfoService.getClassrooms(schoolDistrictId, classroomName);

        Map<String, Object> res = new HashMap<>();
        res.put("status", "SUCCESS");

        Map<String, Object> data = new HashMap<>();
        data.put("total", ((Page) classrooms).getTotal());
        data.put("pageSize", pageSize);
        data.put("currentPage", currentPage);
        data.put("list", classrooms);
        res.put("data", data);
        return res;
    }

    /**
     * 获取所有学院
     *
     * @return
     */
    @RequestMapping("/getDepartments")
    @ResponseBody
    public List<IceSelectDataSource> getDepartments() {
        return departmentService.getDepartments();
    }

    /**
     * 对某门课程进行排课处理
     * <p>
     * id    如果有，表示修改，如果没有，表示新增
     * force 是否在有冲突时仍强制排课
     *
     * @return
     */
    @PostMapping(value = "/scheduleClass")
    @ResponseBody
    public Map<String, String> scheduleClass(@RequestBody ClassAll classAll, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        String operatorId = httpSession.getAttribute("userId").toString();
        String operatorName = httpSession.getAttribute("username").toString();

        classAll.setOperatorId(operatorId);
        classAll.setOperatorName(operatorName);
        logger.info("scheduleClass: " + classAll.toString());
        return classAllService.scheduleClass(classAll);
    }

    /**
     * 删除班级
     *
     * @param id
     * @return
     */
    @GetMapping("/delClass")
    @ResponseBody
    public Map<String, String> delClass(@RequestParam int id, HttpServletRequest request) {
        logger.info("delClass, id: " + id);
        HttpSession httpSession = request.getSession();
        String operatorId = httpSession.getAttribute("userId").toString();
        String operatorName = httpSession.getAttribute("username").toString();

        return classAllService.delClass(id, operatorId, operatorName);
    }

    /**
     * 获取某个学院的上课课表
     *
     * @param classSemester 春、秋、departId
     *
     * @return
     */
    @RequestMapping("/getDepartTimeTable")
    @ResponseBody
    public String[][] getDepartTimeTable(@RequestParam String academicYear, @RequestParam String classSemester,
                                         @RequestParam(value="departmentId",required = false,defaultValue = "88888") String depId,HttpSession session) {
        if(depId.equals("0")){
            return null;
        }
        if ( depId.equals("88888")){
           depId = session.getAttribute("departId").toString();
       }
        int departId = Integer.parseInt(depId);
        System.out.println(departId);
        return classAllService.getDepartTimeTable(departId, academicYear, classSemester);
    }

    /**
     * 获取某个学院的上课课表 pdf格式
     *
     * @param classSemester 春、秋、departId
     * @return
     */
    @RequestMapping("/getDepartTimeTablePdf")
    @ResponseBody
    public ModelAndView getDepartTimeTablePdf(@RequestParam String academicYear, @RequestParam String classSemester,
                                              @RequestParam(required = false, defaultValue = "8888") int depId,
                                              @RequestParam(required = false, defaultValue = "88888888") String depName,
                                              HttpSession session, HttpServletResponse response) {
        if(depId==8888){
            depId= (int) session.getAttribute("departId");
            depName= (String) session.getAttribute("dep");
        }

        //根据学生的名称设置pdf的文件名
        response = ResponseWrap.setName(response, depName + "课表", "pdf");

        String[][] tableData = classAllService.getDepartTimeTable(depId, academicYear, classSemester);
        Map res = new HashMap();
        res.put("data", tableData);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style", "higher");
        model.put("student", 1);
        return new ModelAndView(new StudentTablePdfView(), model);
    }

    /**
     * 获取某个学院的上课课表 excel格式
     *
     * @param classSemester 春、秋、departId
     * @return
     */
    @RequestMapping("/getDepartTimeTableExcel")
    @ResponseBody
    public void getDepartTimeTableExcel(@RequestParam String academicYear, @RequestParam String classSemester,
                                        @RequestParam(required = false, defaultValue = "8888") int depId,
                                        @RequestParam(required = false, defaultValue = "88888888") String depName,
                                        HttpSession session, HttpServletResponse response) {

        if(depId==8888){
            depId= (int) session.getAttribute("departId");
            depName= (String) session.getAttribute("dep");
        }
        String[][] tables = classAllService.getDepartTimeTable(depId, academicYear, classSemester);
        List<CourseTableExcelDomain> liC = new ArrayList<>();
        for (int i = 0; i < tables.length; i = i + 1) {
            liC.add(new CourseTableExcelDomain(i, tables[i][0], tables[i][1], tables[i][2], tables[i][3]
                    , tables[i][4], tables[i][5], tables[i][6]));
        }

        //设置课表的名称
        response = ResponseWrap.setName(response, depName + "课表", "xls");

        ExportParams params = new ExportParams();
        params.setTitle("课表");
        Workbook workbook = ExcelExportUtil.exportExcel(params, CourseTableExcelDomain.class, liC);
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**a'ge
     * 一键获取所有学院的上课课表 excel格式
     *
     * @param classSemester 春、秋、departId
     * @return
     */
    @RequestMapping("/getAllDepartTimeTableExcel")
    @ResponseBody
    public void getAllDepartTimeTableExcel(@RequestParam String academicYear,
                                        @RequestParam String classSemester,HttpServletResponse response){
        List<Map<String,Object>> departList=classAllService.findDepartList(academicYear,classSemester);
        List<Map<String,Object>> list=new ArrayList<>();
        System.out.println(departList);
        for(Map<String,Object> depart:departList){
            int departId= (int) depart.get("departId");
            String departName= (String) depart.get("departName");
            String[][] tables = classAllService.getDepartTimeTable(departId, academicYear, classSemester);
            List<CourseTableExcelDomain> liC = new ArrayList<>();
            for (int i = 0; i < tables.length; i = i + 1) {
                liC.add(new CourseTableExcelDomain(i, tables[i][0], tables[i][1], tables[i][2], tables[i][3]
                        , tables[i][4], tables[i][5], tables[i][6]));
            }
            Map<String,Object> map=new HashMap<>();
            ExportParams params = new ExportParams();
            params.setTitle(departName+"总课表");
            params.setSheetName(departName);
            map.put("title",params);
            map.put("data",liC);
            map.put("entity",CourseTableExcelDomain.class);
            list.add(map);
        }


        //设置课表的名称
        response = ResponseWrap.setName(response,  "全学院总课表", "xls");

//        ExportParams params = new ExportParams();
//        params.setTitle("课表");
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(classSemester);
    }

    /**
     * 一键获取某个学院的上课课表 pdf格式
     *
     * @param classSemester 春、秋、departId
     * @return
     */
    @RequestMapping("/getAllDepartTimeTablePdf")
    @ResponseBody
    public ModelAndView getAllDepartTimeTablePdf(@RequestParam String academicYear, @RequestParam String classSemester,
                                                  HttpSession session, HttpServletResponse response) {


        response = ResponseWrap.setName(response, "全学院总课表", "pdf");
        List<Map<String,Object>> departList=classAllService.findDepartList(academicYear,classSemester);
        List<Map<String,Object>> tableList=new ArrayList<>();
        for(Map<String,Object> depart:departList){
            int departId= (int) depart.get("departId");
            String departName= (String) depart.get("departName");
            String[][] tableData = classAllService.getDepartTimeTable(departId, academicYear, classSemester);
            Map<String,Object> map = new HashMap<>();
            map.put("departName",departName);
            map.put("table",tableData);
            tableList.add(map);
        }


        Map res = new HashMap();
        res.put("data", tableList);
        Map<String, Object> model = new HashMap<>();
        model.put("res", res);
        model.put("style", "higher");
        System.out.println("after");
        return new ModelAndView(new ManageTablePdfView(), model);
    }

    /**
     * 获取departId
     *
     * @param request
     * @return
     */
    @RequestMapping("/getDepartId")
    @ResponseBody
    public Integer getDepartId(HttpServletRequest request) {
        Object departIdObject = request.getSession().getAttribute("departId");
        if (null == departIdObject) {
            return null;
        }
        return Integer.parseInt(departIdObject.toString());
    }

    @RequestMapping("/getTeacherOccupyTime")
    @ResponseBody
//    classWeeks是0101的串
    public boolean[][] getTeacherOccupyTime(String teacherId, String academicYear, String classSemester, int startWeek, int endWeek, String classWeeks, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        String operatorId = httpSession.getAttribute("userId").toString();
        String operatorName = httpSession.getAttribute("username").toString();
        return teacherCurriculumInfoService.getTeacherOccupyTime(teacherId, academicYear, classSemester, startWeek, endWeek, classWeeks, operatorId, operatorName);
    }

    @RequestMapping("/getFreeClassrooms")
    @ResponseBody
    public String[] getFreeClassrooms(String academicYear, String classSemester, int startWeek, int endWeek, String classDateDesc, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        String operatorId = httpSession.getAttribute("userId").toString();
        String operatorName = httpSession.getAttribute("username").toString();

        return freeClassroomService.getAllFreeClassrooms(academicYear, classSemester, startWeek, endWeek, classDateDesc, operatorId, operatorName);
    }


    /**
     * 一键获取所有学院的上课的一维课表 excel格式
     *
     * @param classSemester 春、秋、departId
     * @return
     */
    @RequestMapping("/getOneDimTimeTableExcel")
    @ResponseBody
    public void getAllDepartOneDimTimeTableExcel(@RequestParam String academicYear,
                                           @RequestParam String classSemester,HttpServletResponse response) throws IOException {
        List<Map<String,Object>> departList=classAllService.findDepartList(academicYear,classSemester);
        List<Map<String,Object>> list=new ArrayList<>();
        HSSFWorkbook workbook = new HSSFWorkbook();
        for(Map<String,Object> depart:departList){
            int departId= (int) depart.get("departId");
            String departName= (String) depart.get("departName");
            List<Map<String,Object>> tables = classAllService.getOneDimDepartTimeTable(departId, academicYear, classSemester);
            HSSFSheet sheet = workbook.createSheet(departName+"总课表");
            CellRangeAddress region = new CellRangeAddress(0,0,0,6);//起始行,结束行,起始列,结束列
            sheet.addMergedRegion(region);
            RegionUtil.setBorderBottom(HSSFCellStyle.BORDER_THIN,region, sheet, workbook);
            HSSFRow row1 = sheet.createRow(0);
            row1.createCell(0).setCellValue(departName+"总课表");
            String[] headers={"课程标号","课程名称","班级名称","学时","任课教师","人数","上课时间"};
            HSSFRow headerRow=sheet.createRow(1);
            for (int i = 0; i < headers.length; i = i + 1) {
                HSSFCell cell=headerRow.createCell(i);
                HSSFRichTextString text=new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }
            int rowNum=2;
            for( Map<String,Object> tab:tables) {
                HSSFRow row = sheet.createRow(rowNum);
                String classTime="";
                String week="";
                String weekTime=(String)tab.get("classDateDescription");
                String [] weekTimes1=weekTime.split(",");
                String[] weekdays={"  星期一  ","  星期二  ","  星期三  ","  星期四  ","  星期五  ","  星期六  ","  星期日  "};
                String[] courseTime={"上1","上2","上3","上4","N1","N2","下5","下6","下7","下8","晚9","晚10","晚11"};
                for(int i=0;i<weekTimes1.length;i++)
                {
                    String [] weekTimes=weekTimes1[i].split(":");
                    week=week+weekdays[Integer.parseInt(weekTimes[0])-1];
                    week=week+courseTime[Integer.parseInt(weekTimes[1])-1];
                    for(int n=Integer.parseInt(weekTimes[2])-1;n>0;n--)
                        week=week+courseTime[Integer.parseInt(weekTimes[1])-1+n];
                }
                classTime=classTime+tab.get("name")+"-"+tab.get("classPlace")+"周次:第"+tab.get("startWeek")+"-"+tab.get("endWeek")+"周"+"  连续周"+week;
                row.createCell(0).setCellValue((String)tab.get("courseId"));
                row.createCell(1).setCellValue((String) tab.get("courseNameCHS"));
                row.createCell(2).setCellValue((String) tab.get("className"));
                row.createCell(3).setCellValue((int)tab.get("classHour"));
                row.createCell(4).setCellValue((String) tab.get("teaName"));
                row.createCell(5).setCellValue((int)tab.get("classChooseNum"));
                row.createCell(6).setCellValue(classTime);
                rowNum++;
            }
        }
        String fileName ="小班实践总课表"  + ".xls";//设置要导出的文件的名字
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName,"utf-8"));
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

    /**
     * 一键获取所有教室的上课课表 excel格式
     *
     * @param classSemester 春、秋、departId
     * @return
     */
    @RequestMapping("/getAllRoomTimeTableExcel")
    @ResponseBody
    public void getAllRoomTimeTableExcel(@RequestParam String academicYear,
                                           @RequestParam String classSemester,HttpServletResponse response) {
        List<Map<String, Object>> roomList = classAllService.findRoomList(academicYear, classSemester);
        List<Map<String, Object>> list = new ArrayList<>();
        for(Map<String,Object> room:roomList){
            if(room==null) continue;
            String roomName= (String) room.get("classPlaceName");
            String[][] tables = classAllService.getRoomTimeTable(roomName, academicYear, classSemester);
            List<CourseTableExcelDomain> liC = new ArrayList<>();
            for (int i = 0; i < tables.length; i = i + 1) {
                liC.add(new CourseTableExcelDomain(i, tables[i][0], tables[i][1], tables[i][2], tables[i][3]
                        , tables[i][4], tables[i][5], tables[i][6]));
            }
            Map<String,Object> map=new HashMap<>();
            ExportParams params = new ExportParams();
            params.setTitle(academicYear+classSemester+"研究生课程表---（"+roomName+")");
            params.setSheetName(roomName);
            map.put("title",params);
            map.put("data",liC);
            map.put("entity",CourseTableExcelDomain.class);
            list.add(map);
        }
        response = ResponseWrap.setName(response,  "所有教室总课表", "xls");
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一键获取所有教室的上课的一维课表 excel格式
     *
     * @param classSemester 春、秋、departId
     * @return
     */
    @RequestMapping("/getRoomOneDimTimeTableExcel")
    @ResponseBody
    public void getAllRoomOneDimTimeTableExcel(@RequestParam String academicYear,
                                                 @RequestParam String classSemester,HttpServletResponse response) throws IOException {
        List<Map<String,Object>> roomList=classAllService.findRoomList(academicYear,classSemester);
        List<Map<String,Object>> list=new ArrayList<>();
        HSSFWorkbook workbook = new HSSFWorkbook();
        for(Map<String,Object> room:roomList){
            if(room==null) continue;
            String roomName= (String) room.get("classPlaceName");
            List<Map<String,Object>> tables = classAllService.getOneDimRoomTimeTable(roomName, academicYear, classSemester);
            HSSFSheet sheet = workbook.createSheet(academicYear+classSemester+"研究生课程表---（"+roomName+")");
            sheet.setColumnWidth(0, 4000);
            sheet.setColumnWidth(1, 6500);
            sheet.setColumnWidth(2, 4000);
            sheet.setColumnWidth(3, 4000);
            sheet.setColumnWidth(4, 4000);
            sheet.setColumnWidth(5, 4000);
            sheet.setColumnWidth(6, 6500);
            HSSFFont headfont = workbook.createFont();
            headfont.setFontName("宋体");
            headfont.setFontHeightInPoints((short) 14);// 字体大小
            HSSFCellStyle headstyle = workbook.createCellStyle();
            headstyle.setFont(headfont);
            headstyle.setAlignment(HorizontalAlignment.CENTER);// 左右居中
            headstyle.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
            headstyle.setLocked(true);
            headstyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
            headstyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
            headstyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
            headstyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
            headstyle.setWrapText(true);

            HSSFFont textfont = workbook.createFont();
            textfont.setFontName("宋体");
            textfont.setFontHeightInPoints((short) 10);// 字体大小
            HSSFCellStyle textstyle = workbook.createCellStyle();
            textstyle.setFont(textfont);
            textstyle.setAlignment(HorizontalAlignment.CENTER);// 左右居中
            textstyle.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
            textstyle.setLocked(true);
            textstyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
            textstyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
            textstyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
            textstyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
            textstyle.setWrapText(true);

            CellRangeAddress region = new CellRangeAddress(0,0,0,6);//起始行,结束行,起始列,结束列
            sheet.addMergedRegion(region);
            RegionUtil.setBorderBottom(HSSFCellStyle.BORDER_THIN,region, sheet, workbook);
            HSSFRow row1 = sheet.createRow(0);
            row1.setHeightInPoints(22);
            HSSFCell cell0=row1.createCell(0);

            cell0.setCellStyle(headstyle);
            cell0.setCellValue(academicYear+classSemester+"研究生课程表---（"+roomName+")");
            for(int j=1;j<=6;j++){
                cell0=row1.createCell(j);
                cell0.setCellStyle(headstyle); //style为带边框的样式 上面有定义
                cell0.setCellValue("");
            }
            String[] headers={"课程标号","课程名称","班级名称","学时","任课教师","人数","上课时间"};
            HSSFRow headerRow=sheet.createRow(1);
            headerRow.setHeightInPoints(22);
            for (int i = 0; i < headers.length; i = i + 1) {
                HSSFCell cell=headerRow.createCell(i);
                HSSFRichTextString text=new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
                cell.setCellStyle(textstyle);
            }
            int rowNum=2;
            for( Map<String,Object> tab:tables) {
                HSSFRow row = sheet.createRow(rowNum);
                row.setHeightInPoints(48);
                String classTime="";
                String week="";
                String weekTime=(String)tab.get("classDateDescription");
                String [] weekTimes1=weekTime.split(",");
                String[] weekdays={"  星期一  ","  星期二  ","  星期三  ","  星期四  ","  星期五  ","  星期六  ","  星期日  "};
                String[] courseTime={"上1","上2","上3","上4","N1","N2","下5","下6","下7","下8","晚9","晚10","晚11"};
                for(int i=0;i<weekTimes1.length;i++)
                {
                    String [] weekTimes=weekTimes1[i].split(":");
                    week=week+weekdays[Integer.parseInt(weekTimes[0])-1];
                    week=week+courseTime[Integer.parseInt(weekTimes[1])-1];
                    for(int n=Integer.parseInt(weekTimes[2])-1;n>0;n--)
                        week=week+courseTime[Integer.parseInt(weekTimes[1])-1+n];
                }
                classTime=classTime+tab.get("name")+"-"+tab.get("classPlace")+"周次:第"+tab.get("startWeek")+"-"+tab.get("endWeek")+"周"+"  连续周"+week;
                HSSFCell cell = row.createCell(0);
                cell.setCellValue((String)tab.get("courseId"));
                cell.setCellStyle(textstyle);
                cell = row.createCell(1);
                cell.setCellValue((String) tab.get("courseNameCHS"));
                cell.setCellStyle(textstyle);
                cell = row.createCell(2);
                cell.setCellValue((String) tab.get("className"));
                cell.setCellStyle(textstyle);
                cell = row.createCell(3);
                cell.setCellValue((int)tab.get("classHour"));
                cell.setCellStyle(textstyle);
                cell = row.createCell(4);
                cell.setCellValue((String) tab.get("teaName"));
                cell.setCellStyle(textstyle);
                cell = row.createCell(5);
                cell.setCellValue((int)tab.get("classChooseNum"));
                cell.setCellStyle(textstyle);
                cell = row.createCell(6);
                cell.setCellValue(classTime);
                cell.setCellStyle(textstyle);
                rowNum++;
            }
        }
        String fileName ="小班实践一维教室总课表"  + ".xls";//设置要导出的文件的名字
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName,"utf-8"));
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

    /**
     * 修改选课人数上限
     *
     * @param
     * @return
     */
    @RequestMapping("/updata/stuNumUpperLimit")
    @ResponseBody
    public void updateStuNumUpperLimit(@RequestParam int id,@RequestParam int stuNumUpperLimit) {
        int classAllId=id;
        classAllService.updateStuNumUpperLimit(classAllId,stuNumUpperLimit);
    }
}
