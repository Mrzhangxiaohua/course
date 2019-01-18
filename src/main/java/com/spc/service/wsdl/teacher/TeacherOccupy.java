package com.spc.service.wsdl.teacher;

import com.spc.service.wsdl.util.WebServiceUtil;
import com.spc.util.LoggerUtil;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2019-01-02 14:01
 **/
@Service
public class TeacherOccupy {

    private Logger logger = LoggerUtil.getLogger(this.getClass());

    /**
     * 老师占用
     * Webservice axis地址：地址：http://219.245.47.20/jwbiz/sys/emapWS/ws/pkCentre.pkzy.write.do?wsdl
     * 接口名称：addTeacherOccupyTime
     */
    public int addTeacherOccupyTime(KzJskb kzJskb, String pkrid, String pkrname) {
        int flag = 0;
        OperateResult operateResult;
        UserInfo userInfo = new UserInfo();

        userInfo.setUserId(pkrid);
        userInfo.setUserName(pkrname);

        try {
            PkCentrePkzyWriteLocator locator = new PkCentrePkzyWriteLocator();
            PkCentrePkzyWritePortSoapBindingStub stub = (PkCentrePkzyWritePortSoapBindingStub) locator.getPkCentrePkzyWritePort();
            operateResult = stub.addTeacherOccupyTime(kzJskb, userInfo);
            flag = operateResult.getCode();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return flag;
    }

    public KzJskb createKzJskb(String academicYear, String classSemester, String xxxqdm, Integer ksz, Integer jsz, Integer xq, Integer ksjc, Integer jsjc, String jsbh, String jxbid, String kbid) {
        if (academicYear == null || classSemester == null || academicYear.isEmpty() || classSemester.isEmpty()) {
            return null;
        }

        KzJskb kzJskb = new KzJskb();
        kzJskb.setXNXQDM(WebServiceUtil.getXNXQDM(academicYear, classSemester));
        kzJskb.setXXXQDM(xxxqdm);
        if (ksz != null && jsz != null) {
            kzJskb.setSKZC(WebServiceUtil.getZC(ksz, jsz));
        }
        kzJskb.setSKXQ(xq);
        kzJskb.setKSJC(ksjc);
        kzJskb.setJSJC(jsjc);
        kzJskb.setJSH(jsbh);
        kzJskb.setJXBID(jxbid);
        kzJskb.setKBID(kbid);

        return kzJskb;
    }

    /**
     * 清除老师占用
     * Webservice axis地址：地址：http://219.245.47.20/jwbiz/sys/emapWS/ws/pkCentre.pkzy.write.do?wsdl
     * <p>
     * 接口名称：deleteTeacherOccupyTime
     */
    public int deleteTeacherOccupyTime(KzJskb kzJskb, String pkrid, String pkrname) {
        if (kzJskb == null) {
            logger.info("deleteTeacherOccupyTime: kzJskb is null!");
            return 0;
        }
        int flag = 0;
        OperateResult operateResult;
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(pkrid);
        userInfo.setUserName(pkrname);

        try {
            PkCentrePkzyWriteLocator locator = new PkCentrePkzyWriteLocator();
            PkCentrePkzyWritePortSoapBindingStub stub = (PkCentrePkzyWritePortSoapBindingStub) locator.getPkCentrePkzyWritePort();
            operateResult = stub.deleteTeacherZyForThird(kzJskb, userInfo);
            flag = operateResult.getCode();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return flag;
    }

    public static void main(String[] args) {
        TeacherOccupy teacherOccupy = new TeacherOccupy();
//        KzJskb ksJskb = teacherOccupy.createKzJskb("2018-2019-2", "1", 1, 8, "0", 2, 1, 2, "0000001347", "test001", "test001");
//        int flag = teacherOccupy.addTeacherOccupyTime(ksJskb, "3118105316", "张发");
//        System.out.println(flag);
//        List flag=new ArrayList<>();
//       for(int i=0;i<5;i++){
            KzJskb kzJskb = teacherOccupy.createKzJskb("2018-2019", "春季", "4", 1, 4, 1, 3, 4, "0000011423", "1425", "1425");
          int flag= teacherOccupy.addTeacherOccupyTime(kzJskb, "3118105316", "张发");
            //        int flag2 = teacherOccupy.deleteTeacherOccupyTime(kzJskb, "3118105316", "张发");
//        }
        System.out.println(flag);

//        KzJskb kzJskb = teacherOccupy.createKzJskb("2018-2019", "春季", "1", null, null, null, null, null, "0000000745", "1425", "1425");
        KzJskb kzJskb = teacherOccupy.createKzJskb("2018-2019", "春季", null, null, null, null, null, null, "0002002065", null, null);
        int flag2 = teacherOccupy.deleteTeacherOccupyTime(kzJskb, "3118105316", "张发");
        System.out.println(flag2);
    }
}
