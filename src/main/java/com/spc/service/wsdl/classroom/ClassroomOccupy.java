package com.spc.service.wsdl.classroom;

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
     * dsz 0 连续周 1 单周 2 双周
     *
     * @param ksz
     * @param jsz
     * @param dsz
     * @return
     */
    private String ksjszcm(Integer ksz, Integer jsz, String dsz) {
        if (ksz == null || jsz == null || dsz == null) {
            return null;
        }

        String zc = "";
        for (int i = 1; i <= 26; i++) {
            if (dsz.equals("0")) {
                if (i >= ksz && i <= jsz) {
                    zc += "1";
                } else {
                    zc += "0";
                }
            } else if (dsz.equals("1")) {
                if (i >= ksz && i <= jsz && i % 2 == 1) {
                    zc += "1";
                } else {
                    zc += "0";
                }
            } else if (dsz.equals("2")) {
                if (i >= ksz && i <= jsz && i % 2 == 0) {
                    zc += "1";
                } else {
                    zc += "0";
                }
            }
        }
        return zc;
    }

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

    public ClassRoomUsed createClassRoomUsed(String xnxqdm, String xxxqdm, Integer ksz, Integer jsz, String dsz, int xq, int ksjc, int jsjc, String jasdm, String jxbid, String kbid) {
        ClassRoomUsed classRoomUsed = new ClassRoomUsed();

        classRoomUsed.setXNXQDM(xnxqdm);
        classRoomUsed.setXNXQDM(xxxqdm);
        classRoomUsed.setZYLXDM("10");
        classRoomUsed.setZC(this.ksjszcm(ksz, jsz, dsz));
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

        ClassRoomUsed classRoomUsed = classroomOccupy.createClassRoomUsed("2018-2019-2", "1",
                1, 8, "0", 1, 1,2,"2040207", "1425","1425");

        ClassRoomUsed[] classRoomUseds = {classRoomUsed};
//        int flag = classroomOccupy.addUsedClassroom(classRoomUseds, "3118105316", "张发");
        int flag = classroomOccupy.delUsedClassroom(classRoomUseds, "3118105316", "张发");

        System.out.println(flag);
    }
}
