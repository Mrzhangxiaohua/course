package com.spc.scheldule;


import com.spc.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HelpXuanKe {

    @Autowired
    StudentService studentService;

    @Scheduled(cron = "50 59 21 8 1 ?")
    public void reportCurrentTimeCron() throws InterruptedException {
        System.out.println("=================时间定时任务运行了====================");
        studentService.addCourse(480,"3118105316",5);
        studentService.addCourse(480,"3118305520",5);
        studentService.addCourse(480,"3118305556",5);
        studentService.addCourse(480,"3118105280",5);
        studentService.addCourse(480,"3118305527",5);
        studentService.addCourse(480,"3118305548",5);
        //其他学生
        studentService.addCourse(480,"3118305528",5);
        studentService.addCourse(480,"3118105307",5);
        System.out.println("================时间定时任务运行完毕=================");

    }
}
