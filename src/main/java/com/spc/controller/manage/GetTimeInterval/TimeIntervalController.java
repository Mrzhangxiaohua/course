package com.spc.controller.manage.GetTimeInterval;

import com.spc.controller.Base;
import com.spc.service.manage.evaluationDisplay.EvaluationDisplayService;
import com.spc.service.manage.getTimeInterval.GetTimeIntervalService;
import com.spc.util.RequestPayload;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/8/28 21:44
 */

@Controller
@RequestMapping("/manage")
public class TimeIntervalController extends Base {

    @Autowired
    private GetTimeIntervalService getTimeIntervalService;

    @RequestMapping("/getTimeInterval")
    @ResponseBody
    public Map<String, Integer> getTimeInterval(){
        return getTimeIntervalService.getTimeInterval();
    }

    @RequestMapping(value = "/setTimeInterval",  method = RequestMethod.POST)
    @ResponseBody
    public int setTimeInterval(HttpServletRequest request){
        String json = RequestPayload.getRequestPayload(request);
        try {
            JSONObject obj = new JSONObject(json);
            int timeInterval = Integer.parseInt(obj.getString("timeInterval"));
            logger.info(timeInterval + "---------------=====================");
//            timeInterval = 5;
            return getTimeIntervalService.setTimeInterval(timeInterval);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
