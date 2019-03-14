package com.spc.service.manage;

import com.spc.model.ClassAll;
import com.spc.service.classes.ClassService;
import com.spc.service.manage.stuAdjust.StuAdjustService;
import com.spc.service.teacher.TeacherService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    public StuAdjustService stuAdjustService;

    @Test
    public void testScheduleClass(){
        ClassAll c = new ClassAll();

        c.setAcademicYear("2018-2019");
        c.setClassDateDesc("0-6,1-6,");
        c.setClassHour(16);
        c.setClassName("3班");
        c.setClassPlaceId("1001375");
        c.setClassPlaceName("主楼A-104");
        c.setClassSemester("春季");
        c.setClassWeeks("00000011000000000000000000");
        c.setConflictDesc("");
        c.setCourseId("WS19018001");
        c.setCourseNameCHS("公共管理专业英语小班实践课程");
        c.setCourseNameEN("Academic English  of public administration");
        c.setDepartId(18);
        c.setEndWeek(8);
        c.setId(1684);
        c.setInstructorId("0002011101");
        c.setInstructorName("周忠良");
        c.setModuleId("3");
        c.setOperatorId("0000005146");
        c.setOperatorName("忽春娣");
        c.setScheduled(1);
        c.setSchoolDistrictId(1);
        c.setStartWeek(7);
        c.setStuChooseNum(0);
        c.setStuNumUpperLimit(20);
        c.setTeacherId("0002011101");
        c.setTeacherName("周忠良");
        c.setTeachingTeamIds("0002017104,0002015178,0002002120,0002004105,0002014080,FZB2014002");
        c.setTeachingTeamNames("吴启焰,杜金锋,王昕红,孟凡蓉,王立剑,柳江华");

        classAllService.scheduleClass(c);
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
}
