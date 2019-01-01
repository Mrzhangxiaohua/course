package com.spc.service.wsdl.TeachersOccupyTimeWebservice;

import com.spc.controller.Base;
import org.springframework.stereotype.Service;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 仅适用于本科
 */
@Service
public class TeacherCurriculumInfo extends Base {
    /**
     * 本段代码获取教师授课信息，上课周次，节次，星期
     *
     * @param userId   查询者的userId
     * @param userName 查询者的userName
     * @param teaId    被查询者（教师）的teaId
     * @param xnxqdm   查询课程的时间段,学年学期代码（2018秋就是2018-2019-1 2019春就是2018-2019-2）
     * @return 返回一个list, 里面map放的每个课程的信息,
     * skxq: 周几有课    ksjc: 课程开始节次    jsjc: 课程结束节次       ksz:课程开始周       jsz:课程结束周
     * 如:
     * skxq:1         ksjc:5                jsjc:6                  ksz:9                jsz:13
     */
    public List<TeacherOccupyTime> queryTeacherOccupyTime(String userId, String userName, String teaId, String xnxqdm) {
        KzJskbResult kzJskbResult = new KzJskbResult();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUserName(userName);

        List<TeacherOccupyTime> res = new ArrayList<>();

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

            // 查询失败，直接返回
            if (kzJskbResult.getCode() == 0) {
                logger.error(kzJskbResult.getMsg());
                return res;
            }

            KzJskb[] kzJskbs = kzJskbResult.getResult();
            if (kzJskbs == null || kzJskbs.length == 0) {
                return res;
            }

            for (int i = 0; i < kzJskbs.length; i++) {
                // 返回星期
                Integer skxq = kzJskbs[i].getSKXQ();
                // 返回开始节次
                Integer ksjc = kzJskbs[i].getKSJC();
                // 返回结束节次
                Integer jsjc = kzJskbs[i].getJSJC();
                // 返回周次，000000001000000000000000000000，表示在第九周有一节课
                String skzc = kzJskbs[i].getSKZC();

                res.add(new TeacherOccupyTime(skzc, skxq - 1, ksjc - 1, jsjc - 1));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return res;
    }

    public static void main(String[] args) {
        TeacherCurriculumInfo aClass = new TeacherCurriculumInfo();
        List<TeacherOccupyTime> res = aClass.queryTeacherOccupyTime("3118105316", "张发", "0000008742", "2018-2019-1");
        for (TeacherOccupyTime teacherOccupyTime: res) {
            System.out.println(teacherOccupyTime);
        }
    }
}
