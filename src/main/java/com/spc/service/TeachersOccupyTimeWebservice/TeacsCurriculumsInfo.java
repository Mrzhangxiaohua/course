package com.spc.service.TeachersOccupyTimeWebservice;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacsCurriculumsInfo {
    /**
     * 本段代码获取教师授课信息，上课周次，节次，星期
     * @param userId 查询者的userId
     * @param userName 查询者的userName
     * @param teaId 被查询者（教师）的teaId
     * @param xnxqdm 查询课程的时间段,学年学期代码（例2017-2018学年第一学期：2017-2018-1）
     * @return 返回一个list,里面map放的每个课程的信息,
     *          skxq: 周几有课    ksjc: 课程开始节次    jsjc: 课程结束节次       ksz:课程开始周       jsz:课程结束周
     *          如:
     *          skxq:1         ksjc:5                 jsjc:6                  ksz:9                jsz:13
     */
        private List<Map<String, Object>> queryTeacherOccupyTime(String userId,String userName , String teaId,String xnxqdm) {
            KzJskbResult kzJskbResult = new KzJskbResult();
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(userId);  // 填写查询者的userId
            userInfo.setUserName(userName); // 填写查询者的userName
            List<Map<String, Object>> list = new ArrayList<>();
            try {
                KzJskb kzJskb = new KzJskb();
                kzJskb.setJSH(teaId);
                kzJskb.setXNXQDM(xnxqdm);
                PkCentrePkzyQueryLocator locator = new PkCentrePkzyQueryLocator();
                PkCentrePkzyQueryPortSoapBindingStub stub = null;
                try {
                    stub = (PkCentrePkzyQueryPortSoapBindingStub) locator.getPkCentrePkzyQueryPort();
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
                try {
                    kzJskbResult = stub.queryTeacherOccupyTime(kzJskb, null, null, userInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                System.out.println(kzJskbResult.getMsg()); // 判断是否查询成功

                KzJskb[] kzJskbs = kzJskbResult.getResult();

                for (int i = 0; i < kzJskbs.length; i++) {
                    Integer skxq = kzJskbs[i].getSKXQ(); // 返回星期
                    Integer ksjc = kzJskbs[i].getKSJC(); // 返回开始节次
                    Integer jsjc = kzJskbs[i].getJSJC(); // 返回结束节次
                    String skzc = kzJskbs[i].getSKZC();  // 返回周次，000000001000000000000000000000，表示在第九周有一节课
                    String[] zcarr = skzc.split("");

                    Map<String, Object> m = new HashMap<>();
                    m.put("skxq", skxq);
                    m.put("ksjc", ksjc);
                    m.put("jsjc", jsjc);
                    Integer ksz = 0;
                    Integer jsz = 0;

                    for (int j = 0; j < zcarr.length; j++) {
                        if(zcarr[j].equals("1")){
                            ksz = j + 1;    // 起始周为j
                            break;
                        }
                    }
                    for (int j = ksz - 1; j < zcarr.length; j++) {
                        if(zcarr[j].equals("0")){
                            jsz = j;    // 起始周为j
                            break;
                        }
                    }
                    m.put("ksz", ksz);
                    m.put("jsz", jsz);
                    list.add(m);
            }
        }catch (Exception e){
                System.out.println(e);
            }
            for (Map<String, Object> m : list) {
                for(String k : m.keySet()){
                    System.out.println(k + ":" + m.get(k));
                }
                System.out.println("--------------------------------------------");
            }
            return list;
    }

//    public static void main(String[] args) {
//        TeacsCurriculumsInfo aClass  = new TeacsCurriculumsInfo();
//        aClass.queryTeacherOccupyTime("3118105316","张发", "0000008742","2018-2019-1");
//    }
}
