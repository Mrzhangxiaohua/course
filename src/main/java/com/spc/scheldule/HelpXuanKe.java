package com.spc.scheldule;


import com.spc.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HelpXuanKe {

    @Autowired
    StudentService studentService;

    @Scheduled(cron = "55 59 23 19 9 ?")
    public void reportCurrentTimeCron() throws InterruptedException {
        System.out.println("=================时间定时任务运行了====================");
        studentService.addCourse(13,"3118105316");
        studentService.addCourse(13,"3118305520");
        studentService.addCourse(13,"3118305556");
        studentService.addCourse(13,"3118105280");
        studentService.addCourse(13,"3118305527");
        studentService.addCourse(13,"3118305548");
        System.out.println("================时间定时任务运行完毕=================");
    }
}
