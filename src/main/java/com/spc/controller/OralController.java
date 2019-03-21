package com.spc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.spc.model.Oral;
import com.spc.service.oral.OralService;
import com.spc.service.oral.impl.OralServiceImpl;
import com.spc.util.CalculateWeekth;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Milingyun
 * @date 2019-03-12 14:34
 */

@Controller
public class OralController extends Base{
    @Autowired
    OralService oralService;

    @RequestMapping("manage/addOralItem")
    @ResponseBody
    public int addOralItem(@RequestParam("examineid") String examRoom, @RequestParam("teacherId") String teaId,
                           @RequestParam("teacherName") String teaName, @RequestParam("address") String place,
                           @RequestParam("data") String time,@RequestParam("stuLimit") int stuLimit,
                           HttpSession session) {
        String operatorId= (String) session.getAttribute("userId");
        String operatorName= (String) session.getAttribute("username");
       int flag=oralService.addOral(teaId,teaName,time,place,stuLimit,0,1, CURRENTSEMESTER,operatorId,operatorName,examRoom);
       return flag;
    }
    @RequestMapping("manage/removeOralItem")
    @ResponseBody
    public int removeOralItem(@RequestParam("id") String id,HttpSession session){
        String operatorId= (String) session.getAttribute("userId");
        String operatorName= (String) session.getAttribute("username");
        int flag=oralService.removeOral(id,operatorId,operatorName);
        return flag;
    }
    @RequestMapping("manage/updateOralItem")
    @ResponseBody
    public int updateOralItem(@RequestParam("id") int id,@RequestParam("examineid") String examRoom, @RequestParam("teacherId") String teaId,
                             @RequestParam("teacherName") String teaName, @RequestParam("address") String place,
                             @RequestParam("data") String time,@RequestParam("stuLimit") int stuLimit,
                             HttpSession session){
        String operatorId= (String) session.getAttribute("userId");
        String operatorName= (String) session.getAttribute("username");
        int flag=oralService.updateOral(id,teaId,teaName,time,examRoom,place,stuLimit,operatorId,operatorName);
        return flag;
    }
    @RequestMapping(value={"manage/findAllOralItems","student/findAllOralItems"})
    @ResponseBody
    public Map<String,Object> findAllOralItem(@RequestParam(required = false, defaultValue = "1") int currentPage,
                                              @RequestParam(required = false, defaultValue = "10") int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Map<String, Object>> orals = oralService.selectAllOral(CURRENTSEMESTER);
        Map result = new HashMap<String, Object>();
        result.put("currentPage", currentPage);
        result.put("pageSize", pageSize);
        result.put("total", ((Page) orals).getTotal());
        result.put("data", orals);
        return result;
    }

    @RequestMapping("student/selectOralItem")
    @ResponseBody
    public int selectOralItem(@RequestParam("id") int oralId,HttpSession session){
        String stuId= (String) session.getAttribute("userId");
        String stuName= (String) session.getAttribute("username");
       return oralService.chooseOral(stuId,stuName,oralId);
    }

    @RequestMapping("student/cancelOralItem")
    @ResponseBody
    public int cancelOralItem(@RequestParam("id") int oralId,HttpSession session){
        String stuId= (String) session.getAttribute("userId");
        return oralService.removeOralChoose(stuId,oralId);
    }

    @RequestMapping("teacher/findOralStudents")
    @ResponseBody
    public Map<String,Object> findOralStudentByTeaId(@RequestParam(required = false, defaultValue = "1") int currentPage,
                                                    @RequestParam(required = false, defaultValue = "10") int pageSize,
                                                     HttpSession session) {
        String teaId= (String) session.getAttribute("userId");
        Map result=new HashMap();
        PageHelper.startPage(currentPage, pageSize);
        List<Map<String, Object>> students = oralService.findOralStudentByTeaId(CURRENTSEMESTER,teaId);
        result.put("currentPage", currentPage);
        result.put("pageSize", pageSize);
        result.put("total", ((Page) students).getTotal());
        result.put("data",students);
        return result;
    }
}
