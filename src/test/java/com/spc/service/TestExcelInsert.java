import com.spc.dao.FileInfoDao;
import com.spc.model.ClassAll;
import com.spc.service.classes.ClassService;
import com.spc.service.manage.stuAdjust.StuAdjustService;
import com.spc.service.student.StudentService;
import com.spc.service.student.studentEvaluate.StudentEvaluateService;
import com.spc.service.teacher.TeacherService;
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


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestExcelInsert {
    @Autowired
    FileInfoDao fileInfoDao;

    @Test
    public void testExcel(){
    Map<String, Object> info= (Map<String, Object>) fileInfoDao.selectGradeExcel(18).get(0);
        System.out.println( info.get("fileName"));
    }

}
