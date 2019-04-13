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
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/4/7 18:25
 */
@Controller
@RequestMapping("/manage")

public class EvaluationDisplayController extends Base {

    @Autowired
    private EvaluationDisplayService evaluationDisplayService;

    /**
     * 返回学生评价的信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/evaluationDisplay",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> evaluationDisplay(HttpServletRequest request){
        String json = RequestPayload.getRequestPayload(request);
        try {
            JSONObject obj = new JSONObject(json);
            String classId = obj.getString("classId");
            Map<String, Object> evaluationList = evaluationDisplayService.getAllClassEvaluation(classId);
            return evaluationList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取已做评价的班级信息
     * @return
     */
    @RequestMapping(value = "/getExistInformation")
    @ResponseBody
    public List<Map<String, Object>> getExistInformation(){
        return evaluationDisplayService.getExistInformation();
    }

    /**
     * 获取级联信息，方便检索
     * @return
     */
    @RequestMapping(value = "/getCascade")
    @ResponseBody
    public List<Map> getCascade() {
        return evaluationDisplayService.getCascade();
    }
}
