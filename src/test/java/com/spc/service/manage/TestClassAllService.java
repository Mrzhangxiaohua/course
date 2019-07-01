package com.spc.service.manage;

import com.spc.model.ClassAll;
import com.spc.service.classes.ClassService;
import com.spc.service.manage.evaluationDisplay.EvaluationDisplayService;
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

    @Autowired
    EvaluationDisplayService evaluationDisplayService;

    @Test
    public void testScheduleClass(){
        ClassAll c = new ClassAll();

        c.setAcademicYear("2019-2020");
        c.setStuChooseNum(20);
        c.setClassDateDesc("0-1,1-1,");
        c.setClassHour(16);
        c.setClassName("1班");
        c.setClassPlaceId("1001374");
        c.setClassPlaceName("主楼A-103");
        c.setClassSemester("秋季");
        c.setClassWeeks("11111111000000000000000000");
        c.setConflictDesc("");
        c.setCourseId("WS19012001");
        c.setCourseNameCHS("英语实用口语实践");
        c.setCourseNameEN("Practical Oral English");
        c.setDepartId(12);
        c.setEndWeek(8);
        c.setId(null);
        c.setInstructorId("0000011423");
        c.setInstructorName("冯广宜");
        c.setIsModify(false);
        c.setModuleId("1");

        c.setOperatorId("0002017115");
        c.setOperatorName("董博");
        c.setScheduled(0);
        c.setSchoolDistrictId(1);
        c.setStartWeek(1);
        c.setStuChooseNum(0);
        c.setStuNumUpperLimit(20);
        c.setTeacherId("0000011423");
        c.setTeacherName("冯广宜");
        c.setTeachingTeamIds("0192018007,0192017003,0192018011,0192018008,0192018012,0192018013");
        c.setTeachingTeamNames("Erica,June,Amy,Reine,Raechel,Julian");

        classAllService.scheduleClass(c);
        System.out.println("===jieshu");
    }

    @Test
    public void testDel(){
        classAllService.delClass(2333,"0002017115", "0002017115");
        System.out.println("成功");
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
    public void testEvaluationDisplayService(){
        evaluationDisplayService.getAllClassEvaluation("91");
        System.out.println(evaluationDisplayService.getAllClassEvaluation("91"));
        System.out.println("-----");
    }

    @Test
    public void testFreeTeacherTimeAndPlace(){

    }
}
