package com.spc.service.GetUndergradFreeClassrooms;

import com.spc.service.webservice.GetInfo;

public class GetUndergradFreeClassroomInfo {
    public String getFreeClassroom(SpareClassRoom[] spareClassRoom,String pkrid,String pkrname){
        ClassRoomResult classRoomResult = new ClassRoomResult();
        QueryConfig config = new QueryConfig();
        config.setPageSize(0);
        config.setPageNumber(-1);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(pkrid);
        userInfo.setUserName(pkrname);
        String jsdm = "";
        try {
            ClassroomResourceReadLocator locator = new ClassroomResourceReadLocator();
            ClassroomResourceReadPortSoapBindingStub bindingStub = (ClassroomResourceReadPortSoapBindingStub) locator.getClassroomResourceReadPort();
            classRoomResult=bindingStub.querySpareClassRoomForOtherSystem(spareClassRoom, config, null, userInfo);
            System.out.println(classRoomResult.getMsg());
            jsdm = classRoomResult.getMsg();
        } catch (Exception e) {
            System.err.println(e);
        }
        return jsdm;
    }
    public static SpareClassRoom[] GetInfo(String XNXQDM, String ZC, int XQ, int KSJC, int JSJC){
        SpareClassRoom[] classRoom = {new SpareClassRoom(null, null, null, null, null, null, null, null,
                null, null, null, null, null,XQ, null,JSJC, null,
                KSJC,null,ZC,null,XNXQDM, null, null, null, null,
                null,  null, null, null, null, null, null)};
        return classRoom;
    }
    public static void main(String[] args) {
        GetUndergradFreeClassroomInfo getUndergradFreeClassroomInfo = new GetUndergradFreeClassroomInfo();
        getUndergradFreeClassroomInfo.getFreeClassroom(GetInfo("2018-2019-1","1111111111000000000001111",
                2,1, 9), "3118105316", "张发");
//        getUndergradFreeClassroomInfo.getFreeClassroom(classRooms,"3118105316", "张发");
    }
}
