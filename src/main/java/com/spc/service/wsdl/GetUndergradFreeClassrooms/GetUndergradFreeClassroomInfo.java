package com.spc.service.wsdl.GetUndergradFreeClassrooms;

import com.spc.controller.Base;
import org.springframework.stereotype.Service;

/**
 * 仅适用于本科
 */
@Service
public class GetUndergradFreeClassroomInfo extends Base {
    public String getFreeClassrooms(SpareClassRoom[] spareClassRoom, String userId, String userName) {
        QueryConfig config = new QueryConfig();
        config.setPageSize(0);
        config.setPageNumber(-1);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUserName(userName);
        String msg = "";
        try {
            ClassroomResourceReadLocator locator = new ClassroomResourceReadLocator();
            ClassroomResourceReadPortSoapBindingStub bindingStub = (ClassroomResourceReadPortSoapBindingStub) locator.getClassroomResourceReadPort();
            ClassRoomResult classRoomResult = bindingStub.querySpareClassRoomForOtherSystem(spareClassRoom, config, null, userInfo);
            if (classRoomResult.getCode() == 0) {
                logger.error(classRoomResult.getMsg());
                return null;
            }
            msg = classRoomResult.getMsg();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return msg;
    }

    public SpareClassRoom createSparseClassRoom(String XNXQDM, String ZC, int XQ, int KSJC, int JSJC) {
        return new SpareClassRoom(null, null, null, null, null, null, null, null,
                null, null, null, null, null, XQ, null, JSJC, null,
                KSJC, null, ZC, null, XNXQDM, null, null, null, null,
                null, null, null, null, null, null, null);
    }



    public static void main(String[] args) {
        GetUndergradFreeClassroomInfo getUndergradFreeClassroomInfo = new GetUndergradFreeClassroomInfo();

        SpareClassRoom classRoom1 = getUndergradFreeClassroomInfo.createSparseClassRoom("2018-2019-2", "0001110000000000", 1, 1, 2);
        SpareClassRoom classRoom2 = getUndergradFreeClassroomInfo.createSparseClassRoom("2018-2019-1", "0000000001000000", 3, 1, 1);
        SpareClassRoom[] classRooms = {classRoom1};

        String res = getUndergradFreeClassroomInfo.getFreeClassrooms(classRooms, "3118105316", "张发");
        System.out.println(res);

    }
}
