package com.spc.service.wsdl.teacher;

import org.springframework.stereotype.Service;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2019-01-02 14:01
 **/
@Service
public class TeacherOccupy {

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

    public KzJskb createKzJskb(String xnxqdm, String xxxqdm, Integer ksz, Integer jsz, String dsz, Integer xq, Integer ksjc, Integer jsjc, String jsbh, String jxbid, String kbid) {
        KzJskb kzJskb = new KzJskb();
        kzJskb.setXNXQDM(xnxqdm);
        kzJskb.setXXXQDM(xxxqdm);
        kzJskb.setSKZC(this.ksjszcm(ksz, jsz, dsz));
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

        KzJskb kzJskb = teacherOccupy.createKzJskb("2018-2019-2", "1", null, null, null, null, null, null, "0000000745", "1425", "1425");
        int flag2 = teacherOccupy.deleteTeacherOccupyTime(kzJskb, "3118105316", "张发");
        System.out.println(flag2);
    }
}
