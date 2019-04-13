package com.spc.controller;

import com.spc.service.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这个是公用数据的接口类、
 *
 * @author yuhongchao
 */
@RestController
@RequestMapping("/data")
public class BaseDataContoller extends Base {

    @Autowired
    private DataService dataService;

    /**
     * 数据：获得基础的院系信息
     *select/classes
     * @return list(map)
     */

    @RequestMapping("/getDepart")
    @ResponseBody
    public List<Map<String, Object>> getDepart(HttpSession session) {
        logger.info(session.getAttribute("username") + "查询院系列表");
        return dataService.getDepart();
    }

    /**
     * 为了显示用户姓名
     *
     * @return map
     */
    @RequestMapping("/getUserName")
    @ResponseBody
    public Map<String, Object> getUserName(HttpSession session) {
        Map res = new HashMap();
        res.put("UserName", session.getAttribute("username"));
        return res;
    }

}
