package com.spc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class mainC {

    @RequestMapping("/classes")
    public  String classes(){
        return "course/showClass";
    }
}
