package com.spc.service.wsdl.GetUndergradFreeClassrooms;

import com.spc.service.wsdl.util.ClassDate;
import com.spc.service.wsdl.util.WebServiceUtil;
import com.spc.util.LoggerUtil;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 仅适用于本科
 */
@Service
public class GetUndergradFreeClassroomInfo {

    private Logger logger = LoggerUtil.getLogger(this.getClass());

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

    public SpareClassRoom createSparseClassRoom(String academicYear, String classSemester, int startWeek, int endWeek, int XQ, int KSJC, int JSJC) {
        return new SpareClassRoom(null, null, null, null, null, null, null, null,
                null, null, null, null, null, XQ, null, JSJC, null,
                KSJC, null, WebServiceUtil.getZC(startWeek, endWeek), null, WebServiceUtil.getXNXQDM(academicYear, classSemester), null, null, null, null,
                null, null, null, null, null, null, null);
    }


    public String[] getAllFreeClassrooms(String academicYear, String classSemester, int startWeek, int endWeek,
                                         String classDateDesc, String operatorId, String operatorName) {
        List<ClassDate> classDates = WebServiceUtil.getClassDates(classDateDesc);

        if (classDates == null || classDates.isEmpty()) {
            return null;
        }

        SpareClassRoom[] classRooms = new SpareClassRoom[classDates.size()];
        for (int i = 0; i < classRooms.length; i++) {
            ClassDate classDate = classDates.get(i);
            classRooms[i] = this.createSparseClassRoom(academicYear, classSemester, startWeek, endWeek, classDate.getXq(), classDate.getKsjc(), classDate.getJsjc());
        }
        String res = this.getFreeClassrooms(classRooms, operatorId, operatorName);
        if (res == null) {
            logger.error("没有查询到空闲教室！");
            return null;
        }
        return res.split(",");
    }

    public static void main(String[] args) {
        GetUndergradFreeClassroomInfo getUndergradFreeClassroomInfo = new GetUndergradFreeClassroomInfo();

        SpareClassRoom classRoom1 = getUndergradFreeClassroomInfo.createSparseClassRoom("2018-2019","春季", 1,8, 1, 1, 2);
        SpareClassRoom classRoom2 = getUndergradFreeClassroomInfo.createSparseClassRoom("2018-2019","秋季", 1, 8, 3, 1, 1);
        SpareClassRoom[] classRooms = {classRoom1};

        String res = getUndergradFreeClassroomInfo.getFreeClassrooms(classRooms, "3118105316", "张发");
        System.out.println(res);

    }

}
