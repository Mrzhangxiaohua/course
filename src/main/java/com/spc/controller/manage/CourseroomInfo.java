package com.spc.controller.manage;

import com.spc.controller.Base;
import com.spc.model.ClassRoomInfo;
import com.spc.service.wsdl.GetUndergradFreeClassrooms.GetUndergradFreeClassroomInfo;
import com.spc.service.manage.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import static com.spc.service.wsdl.GetUndergradFreeClassrooms.GetUndergradFreeClassroomInfo.GetInfo;

@RequestMapping("/manage")
@Controller
public class CourseroomInfo extends Base {
//
//    @Autowired
//    private ClassRoomService classRoomService;
//
//    @RequestMapping("/classroominfo")
//    @ResponseBody
//    public Map<String, Object> getClassRoom(){
//        Map<String, Object> classRooms = new HashMap<>();
//        GetUndergradFreeClassroomInfo getUndergradFreeClassroomInfo = new GetUndergradFreeClassroomInfo();
//        String rooms = getUndergradFreeClassroomInfo.getFreeClassroom(GetInfo("2018-2019-1","1111111111000000000001111",
//                2,1, 9), "3118105316", "张发");
////        List<ClassRoomInfo> classAndRoom =
//        return null;
//    }
}
