package com.spc.controller.student.studentEvaluateController;

import com.spc.controller.Base;
import com.spc.service.student.studentEvaluate.StudentEvaluateService;
import com.spc.util.RequestPayload;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @Description: 主要完成学生评教页面的功能
 * @Author: zf
 * @Date: 2019/3/20 10:48
 */

@Controller
@RequestMapping("/student")

public class StuEvaluateController extends Base {

    @Autowired
    StudentEvaluateService studentEvaluateService;

    /**
     * 根据学生选择的课程判断是否评教过
     *
     * @param session
     * @return 学生选课结果
     */
    @RequestMapping(value = "/stuSelectList")
    @ResponseBody
    public List<Map<String, Object>> selectList(HttpSession session) {
        String stuId = (String) session.getAttribute("userId");
        return studentEvaluateService.selectList(stuId);
    }

    /**
     * 完成评价的功能
     *
     * @param request 接收前端传递的评价内容
     * @return 成功则返回插入信息，否则返回 0
     */
    @RequestMapping(value = "/stuEvaluate")
    @ResponseBody
    public int stuEvaluate(HttpServletRequest request) {
        String json = RequestPayload.getRequestPayload(request);
        logger.info(json);
        try {
            JSONObject obj = new JSONObject(json);
            Integer classId = obj.getInt("classId");
            String stuId = obj.getString("stuId");
            JSONArray score1 = obj.getJSONArray("score1");
            JSONArray score2 = obj.getJSONArray("score2");
            JSONArray score3 = obj.getJSONArray("score3");
            return studentEvaluateService.stuEvaluate(classId, stuId, score1, score2, score3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

