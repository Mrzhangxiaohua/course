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
        c.setClassDateDesc("12-6,");
        c.setClassHour(16);
        c.setClassName("233333班");
        c.setClassPlaceId("1002397");
        c.setClassPlaceName("主楼B-205");
        c.setClassSemester("春季");
        c.setClassWeeks("11111111000000000000000000");
        c.setConflictDesc("");
        c.setCourseId("WS19005001");
        c.setCourseNameCHS("电子与信息工程英语专业实践");
        c.setCourseNameEN("English Practice for Electronic and Information Engineering");
        c.setDepartId(5);
        c.setEndWeek(8);
        c.setId(2030);
        c.setInstructorId("0002016056");
        c.setInstructorName("李辰");
        c.setIsModify(true);
        c.setModuleId("3");

        c.setOperatorId("0002017115");
        c.setOperatorName("董博");
        c.setScheduled(1);
        c.setSchoolDistrictId(1);
        c.setStartWeek(1);
        c.setStuChooseNum(0);
        c.setStuNumUpperLimit(28);
        c.setTeacherId("0002011042");
        c.setTeacherName("杜清河");
        c.setTeachingTeamIds("0002013070,0002017003,0002016056,0002017046,0002018035,0002001021,0002012002,SZB2014013,0002011065,0002012094,0002010100,SZB2013058,0002009260");
        c.setTeachingTeamNames("刘明,陈晓明,李辰,李峰,蔡寅,易文辉,高贞贞,惠维,徐静,张洁,陈希,王熠晨,周迪");

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
}
