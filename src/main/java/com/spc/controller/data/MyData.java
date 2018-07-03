package com.spc.controller.data;

import com.spc.service.data.DataService;
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


    @RequestMapping("/getDepart")
    @ResponseBody
    public List<Map<String, String>> getDepart(){
        return dataService.getDepart();
    }
}
