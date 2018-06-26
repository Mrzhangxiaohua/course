package com.spc.controller.data;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.spc.service.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/data")
public class MyData {

    @Autowired
    private DataService dataService;


    @RequestMapping("/getDepart")
    public StringBuilder getDepart(){
        List<HashMap<Integer,String>>  li = dataService.getDepart();
        System.out.println("run heree");
        StringBuilder str = new StringBuilder("[");
        for(HashMap<Integer,String> sli : li) {
            try {
                StringBuilder jsons =new StringBuilder(new ObjectMapper().writeValueAsString(sli));
                str.append(jsons);
                str.append(",");
            } catch (Exception exception) {
            }
        }
        str.deleteCharAt(str.length()-1);
        str.append("]");
        System.out.println(str);
        return str;
    }
}
