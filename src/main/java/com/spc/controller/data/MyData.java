package com.spc.controller.data;

import com.spc.service.data.DataService;
import com.spc.util.AuthMess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class MyData {

    @Autowired
    private DataService dataService;

    @Autowired
    private AuthMess authMess;


    @RequestMapping("/getDepart")
    @ResponseBody
    public List<Map<String, Object>> getDepart() {
        return dataService.getDepart();
    }

    @RequestMapping("/getUserName")
    @ResponseBody
    public String getUserName() {
        return authMess.userName();
    }
}
