package com.spc.service.wsdl.classroom;

import com.spc.service.wsdl.util.WebServiceUtil;
import org.springframework.stereotype.Service;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2019-01-02 13:59
 **/
@Service
public class ClassroomOccupy {


    /**
     * 占用教室
     * http://219.245.47.20/jwbiz/sys/emapWS/ws/classroomResource.write.do?wsdl
     * <p>
     * addClassRoomUsedForOtherSystem
     */
    public int addUsedClassroom(ClassRoomUsed[] classRoomUseds, String pkrid, String pkrname) {
        OperateResult operateResult;
        UserInfo userInfo = new UserInfo();

        userInfo.setUserId(pkrid);
        userInfo.setUserName(pkrname);
        int flag = 0;
        try {
            ClassroomResourceWriteLocator locator = new ClassroomResourceWriteLocator();

            locator.getClassroomResourceWritePort();
            ClassroomResourceWritePortSoapBindingStub bindingStub = (ClassroomResourceWritePortSoapBindingStub) locator.getClassroomResourceWritePort();
            operateResult = bindingStub.addClassRoomUsedForOtherSystem(classRoomUseds, userInfo);
            flag = operateResult.getCode();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return flag;
    }

    /**
     * 清除占用教室
     * http://219.245.47.20/jwbiz/sys/emapWS/ws/classroomResource.write.do?wsdl
     * <p>
     * deleteClassRoomUsedForOtherSystem
     */
    public int delUsedClassroom(ClassRoomUsed[] classRoomUseds, String pkrid, String pkrname) {
        int flag = 0;
        OperateResult operateResult;
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(pkrid);
        userInfo.setUserName(pkrname);
        try {
            ClassroomResourceWriteLocator locator = new ClassroomResourceWriteLocator();
            ClassroomResourceWritePortSoapBindingStub bindingStub = (ClassroomResourceWritePortSoapBindingStub) locator.getClassroomResourceWritePort();
            operateResult = bindingStub.deleteClassRoomUsedForOtherSystem(classRoomUseds, userInfo);
            flag = operateResult.getCode();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return flag;
    }

    public ClassRoomUsed createClassRoomUsed(String academicYear, String classSemester, String xxxqdm, Integer ksz,
                                             Integer jsz, int xq, int ksjc, int jsjc, String jasdm, String jxbid, String kbid) {
        ClassRoomUsed classRoomUsed = new ClassRoomUsed();

        classRoomUsed.setXNXQDM(WebServiceUtil.getXNXQDM(academicYear, classSemester));
        classRoomUsed.setXXXQDM(xxxqdm);
        classRoomUsed.setZYLXDM("101");
        classRoomUsed.setZC(WebServiceUtil.getZC(ksz, jsz));
        classRoomUsed.setXQ(xq);
        classRoomUsed.setKSJC(ksjc);
        classRoomUsed.setJSJC(jsjc);
        classRoomUsed.setJASDM(jasdm);
        classRoomUsed.setJXBID(jxbid);
        classRoomUsed.setKBID(kbid);

        return classRoomUsed;
    }

    public static void main(String[] args) {

        ClassroomOccupy classroomOccupy = new ClassroomOccupy();

        ClassRoomUsed classRoomUsed = classroomOccupy.createClassRoomUsed("2018-2019","春季", null,
                10, 17, 6, 1,4,"2027437", "","1667");

        ClassRoomUsed[] classRoomUseds = {classRoomUsed};
//        int flag = classroomOccupy.addUsedClassroom(classRoomUseds, "3118105316", "张发");
        int flag = classroomOccupy.delUsedClassroom(classRoomUseds, "3118105316", "张发");

        System.out.println(flag);
    }
}
