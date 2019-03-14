package com.spc.controller.manage.studentAdjustController;

import com.spc.controller.Base;
import com.spc.service.manage.stuAdjust.StuAdjustService;
import com.spc.util.RequestPayload;
import org.json.JSONArray;
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
 * @Author: zf
 * @Description:
 * @Date: 2019/1/24 11:10
 */

@RequestMapping("/manage")
@Controller

public class StuAdjustController extends Base {

    @Autowired StuAdjustService stuAdjustService;

    // 获取所有开课季节的课程

    @RequestMapping("/getAllCourse")
    @ResponseBody
    public List<Map<String, Object>> getAllCourse(@RequestParam(required = false, defaultValue = "") String departId){
        return stuAdjustService.getAllCourse(Base.CURRENTSEMESTER, departId);
    }

    // 根据学生Id替换班级
    @RequestMapping(value = "/moveStudent", method = RequestMethod.POST)
    @ResponseBody
    public int moveStudent(HttpServletRequest request){
        try {
            JSONObject obj = new JSONObject(RequestPayload.getRequestPayload(request));
            logger.info("接收到的对象信息为："+obj);
            // 1. 需要获取到学生ID，目前的班级classId，要调整到的班级classId
            JSONArray stuId = obj.getJSONArray("stuList");
            logger.info("解析到的学号信息为："+stuId);
            Integer oldClassId = obj.getInt("oldClassId");
            Integer newClassId = obj.getInt("newClassId");
            // 2. 根据获得的信息进行调整班级
            return stuAdjustService.moveStudent(stuId, oldClassId, newClassId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
