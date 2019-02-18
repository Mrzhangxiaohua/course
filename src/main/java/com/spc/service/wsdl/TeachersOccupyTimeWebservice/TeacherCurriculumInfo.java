package com.spc.service.wsdl.TeachersOccupyTimeWebservice;

import com.spc.controller.Base;
import com.spc.service.wsdl.util.WebServiceUtil;
import org.springframework.stereotype.Service;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * 仅适用于本科
 */
@Service
public class TeacherCurriculumInfo extends Base {

    /**
     * 每天一共13个学时
     */
    private static final int CLASS_HOURS_PER_DAY = 13;
    /**
     * 每周一共7天
     */
    private static final int CLASS_DAYS_PER_WEEK = 7;

    /**
     * 本段代码获取教师授课信息，上课周次，节次，星期
     *
     * @param userId   查询者的userId
     * @param userName 查询者的userName
     * @param teacherId    被查询者（教师）的teaId
     * @param academicYear 学年
     * @param classSemester 开课季节，查询课程的时间段由学年和学期确定，学年学期代码（2018秋就是2018-2019-1 2019春就是2018-2019-2）
     * @return 返回一个list, 里面map放的每个课程的信息,
     * skxq: 周几有课    ksjc: 课程开始节次    jsjc: 课程结束节次       ksz:课程开始周       jsz:课程结束周
     * 如:
     * skxq:1         ksjc:5                jsjc:6                  ksz:9                jsz:13
     */
    public List<TeacherOccupyTime> queryTeacherOccupyTime(String userId, String userName, String teacherId, String academicYear, String classSemester) {
        KzJskbResult kzJskbResult = new KzJskbResult();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUserName(userName);

        List<TeacherOccupyTime> res = new ArrayList<>();

        try {
            KzJskb kzJskb = new KzJskb();
            kzJskb.setJSH(teacherId);
            kzJskb.setXNXQDM(WebServiceUtil.getXNXQDM(academicYear, classSemester));
            PkCentrePkzyQueryLocator locator = new PkCentrePkzyQueryLocator();
            PkCentrePkzyQueryPortSoapBindingStub stub = null;
            try {
                stub = (PkCentrePkzyQueryPortSoapBindingStub) locator.getPkCentrePkzyQueryPort();
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            try {
                QueryConfig config = new QueryConfig();
                config.setPageSize(100);
                kzJskbResult = stub.queryTeacherOccupyTime(kzJskb, config, null, userInfo);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            // 查询失败，直接返回
            if (kzJskbResult.getCode() == 0) {
                logger.error(kzJskbResult.getMsg());
                return res;
            }

            KzJskb[] temp = kzJskbResult.getResult();
            for (int i = 0; i < temp.length; i++) {
                System.out.println(temp[i].toString());
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

                res.add(new TeacherOccupyTime(skzc, skxq - 1, getClassHourIndex(ksjc), getClassHourIndex(jsjc)));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return res;
    }

    /**
     * 获取老师的占用时间表，true表示占用
     * @param teacherId
     * @param academicYear
     * @param classSemester
     * @param startWeek
     * @param endWeek
     * @param operatorId
     * @param operatorName
     * @return
     */
    public boolean[][] getTeacherOccupyTime(String teacherId, String academicYear, String classSemester, int startWeek, int endWeek, String classWeeks, String operatorId, String operatorName) {
        List<TeacherOccupyTime> teacherOccupyTimes = this.queryTeacherOccupyTime(operatorId, operatorName, teacherId, academicYear,classSemester);
        boolean[][] res = new boolean[CLASS_HOURS_PER_DAY][CLASS_DAYS_PER_WEEK];
        for (TeacherOccupyTime teacherOccupyTime : teacherOccupyTimes) {
            // TODO fix
            String weeks = "00000011110000000000001110";
            for (int i = 0; i < weeks.length() && i < teacherOccupyTime.getWeeks().length(); i++) {
                if (weeks.charAt(i) == '1' && teacherOccupyTime.getWeeks().charAt(i) == '1'){
                    for (int j = teacherOccupyTime.getHourStartIndex(); j <= teacherOccupyTime.getHourEndIndex(); j++) {
                        // true 表示有占用
                        res[j][teacherOccupyTime.getDayIndex()] = true;
                    }
                    break;
                }
            }

        }
        return res;
    }

    private int getClassHourIndex(int classHour) {
        if (classHour <= 4) {
            return classHour -1;
        }
        if (classHour <= 11) {
            return classHour + 1;
        }
        return classHour - 17;
    }

    public static void main(String[] args) {
        TeacherCurriculumInfo aClass = new TeacherCurriculumInfo();
        List<TeacherOccupyTime> res = aClass.queryTeacherOccupyTime("3118105316", "张发", "0002002065", "2018-2019", "春季");
        boolean[][] occupyTimes = aClass.getTeacherOccupyTime("0002002065", "2018-2019", "春季", 1, 8, "", "3118105316", "张发");
        for (TeacherOccupyTime teacherOccupyTime : res) {
            System.out.println(teacherOccupyTime);
        }
        for (int i = 0; i < CLASS_HOURS_PER_DAY; i++) {
            for (int j = 0; j < CLASS_DAYS_PER_WEEK; j++) {
                System.out.print(occupyTimes[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
