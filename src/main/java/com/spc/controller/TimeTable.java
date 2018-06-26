package com.spc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timetable")
public class TimeTable {

    @RequestMapping("/show")
    public String showTimeTable(){
        System.out.println("run here");
        return "timetable/calendar";
    }
}
