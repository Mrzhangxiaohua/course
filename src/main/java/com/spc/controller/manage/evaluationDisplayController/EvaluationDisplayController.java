package com.spc.controller.manage.evaluationDisplayController;

import com.spc.controller.Base;
import com.spc.service.manage.evaluationDisplay.EvaluationDisplayService;
import com.spc.util.RequestPayload;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 对应学生端评价的页面
 * @Author: zf
 * @Date: 2019/4/7 18:25
 */
@Controller
@RequestMapping("/manage")

public class EvaluationDisplayController extends Base {

    @Autowired
    private EvaluationDisplayService evaluationDisplayService;

    /**
     * 返获取学生评价的信息
     * @param request
     * @return 学生的评价
     */
    @RequestMapping(value = "/evaluationDisplay",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> evaluationDisplay(HttpServletRequest request){
        String json = RequestPayload.getRequestPayload(request);
        Map<String,Object> map = new HashMap<>();
        try {
            JSONObject obj = new JSONObject(json);
            String classId = obj.getString("classId");
            map = evaluationDisplayService.getAllClassEvaluation(classId);
//            return evaluationList;
        }catch (Exception e){
            e.printStackTrace();
            String classId = "39";
            map = evaluationDisplayService.getAllClassEvaluation(classId);
//            return evaluationList;
        }
        return map;
    }

    /**
     * 获取级联信息
     * @return 学院 - 课程名 - 班级号
     */
    @RequestMapping(value = "/getCascade")
    @ResponseBody
    public List<Map> getCascade() {
        return evaluationDisplayService.getCascade();
    }
}
