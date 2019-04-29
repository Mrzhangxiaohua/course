package com.spc.service.manage;

import com.spc.model.ClassAll;
import com.spc.service.classes.ClassService;
import com.spc.service.manage.stuAdjust.StuAdjustService;
import com.spc.service.student.StudentService;
import com.spc.service.student.studentEvaluate.StudentEvaluateService;
import com.spc.service.teacher.TeacherService;
import com.spc.service.wsdl.TeachersOccupyTimeWebservice.TeacherCurriculumInfo;
import com.spc.service.wsdl.TeachersOccupyTimeWebservice.TeacherOccupyTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/2/19 21:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestClassAllService {

    @Autowired
    public ClassAllService classAllService;

    @Autowired
    public StudentEvaluateService studentEvaluateService;

    @Autowired
    public StuAdjustService stuAdjustService;

    @Autowired
    ClassroomInfoService classroomInfoService;
    @Autowired
    TeacherCurriculumInfo teacherCurriculumInfo;

    @Autowired
    ManageService manageService;
    @Test
    public void testScheduleClass(){
        ClassAll c = new ClassAll();

        c.setAcademicYear("2018-2019");
        c.setStuChooseNum(20);
        c.setClassDateDesc("0-6,1-6,2-6,3-6,");
        c.setClassHour(16);
        c.setClassName("5班");
        c.setClassPlaceId("2027433");
        c.setClassPlaceName("综合楼-404");
        c.setClassSemester("春季");
        c.setClassWeeks("00000000011111111000000000");
        c.setConflictDesc("");
        c.setCourseId("WS19015001");
        c.setCourseNameCHS("高级医学研究英语实践");
        c.setCourseNameEN("Advanced Medical Research Initiation");
        c.setDepartId(15);
        c.setEndWeek(17);
        c.setId(1992);
        c.setInstructorId("SZB2013115");
        c.setInstructorName("韩晶");
        c.setIsModify(true);
        c.setModuleId("4");

        c.setOperatorId("0002017115");
        c.setOperatorName("董博");
        c.setScheduled(1);
        c.setSchoolDistrictId(2);
        c.setStartWeek(10);
        c.setStuChooseNum(0);
        c.setStuNumUpperLimit(22);
        c.setTeacherId("0002004120");
        c.setTeacherName("吕社民");
        c.setTeachingTeamIds("1100000106,1200006045,0002008039,0000011377,0000010562");
        c.setTeachingTeamNames("马清涌,王岗,吕海侠,方宇,孟列素");

        classAllService.scheduleClass(c);
        System.out.println("===jieshu");
    }

    @Test
    public void testStuAdjustController(){
        String value = "{\"stuList\":[\"3118105307\",\"3118105217\"],\"newClassId\":468,\"oldClassId\":476}";
        try {
            JSONObject obj = new JSONObject(value);
            JSONArray stuId = obj.getJSONArray("stuList");
            Integer oldClassId = obj.getInt("oldClassId");
            Integer newClassId = obj.getInt("newClassId");
            System.out.println(stuId);
            // 2. 根据获得的信息进行调整班级
            int x = stuAdjustService.moveStudent(stuId, oldClassId, newClassId);
            System.out.println(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStudentEvaluate(){
        String json = "{\n" +
                "\t\"classId\": 480,\n" +
                "\t\"stuId\": 3118105316,\n" +
                "\t\"score1\": [\"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\", \"10\"],\n" +
                "\t\"score2\": [\"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"税收数\", \"8\", \"9\", \"10\"],\n" +
                "\t\"score3\": [\"1\", \"2\", \"3\", \"4\", \"5\", \"我是\", \"7\", \"8\", \"9\", \"10\"]\n" +
                "}";
        JSONArray a = new JSONArray();

        studentEvaluateService.stuEvaluate(480, "3118105316",a,a,a);
        System.out.println("成功");
    }
    @Test
    public void testSelectList(){
        studentEvaluateService.selectList("3118305556");
    }

    @Test
    public void testj(){
        manageService.findStudentByStudentId(10, 1, "3118105316");
        System.out.println("aaa");
    }
}
