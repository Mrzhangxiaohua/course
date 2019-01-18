package com.spc.service.student.impl;

import com.github.pagehelper.PageHelper;
import com.spc.controller.Base;
import com.spc.dao.*;
import com.spc.model.ClassDomain;
import com.spc.model.GradeDomain;
import com.spc.service.student.StudentService;
import com.spc.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service(value = "studentService")
public class StudentServiceImpl extends Base implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ClassDao classDao;

    @Autowired
    private StudentApplicationDao studentApplicationDao;

    @Autowired
    private GradeDao gradeDao;

    @Autowired
    private TimeSwitchDao timeSwitchDao;

    @Autowired
    private WaitingDao waitingDao;

    @Override
    public String[][] findClasses(String stuId) {
//        int stuId = Integer.parseInt(authMess.userDetails().getUserid());
        List<HashMap<String, Object>> lis = studentDao.findClasses(stuId);
//        String temp[][] = new String[10][7];
//        System.out.println(lis);
//        if (!lis.isEmpty()) {
//            for (HashMap<String, Object> li : lis) {
//                System.out.println("=======检测============");
//                System.out.println(li.get("startWeek"));
//                String date = (String) li.get("classDateDescription");
//                String classPlace = (String) li.get("classPlace");
//                String teaName = (String) li.get("teaName");
//                System.out.println(li.get("startWeek"));
//                String startWeek = Integer.toString((Integer) li.get("startWeek"));
//                String endWeek = Integer.toString((Integer) li.get("endWeek"));
//                String classNum = Integer.toString((Integer) li.get("classNum"));
//                String className = (String) li.get("className");
//
//                String[] ints = date.split(":");
//                Integer r = ints[0].toCharArray()[0] - '0';
//                Integer l = ints[1].toCharArray()[0] - '0';
//
//                String context = "★课程：" + className + ',' + "教室：" + classPlace + ',' + "教师：" + teaName + ',' + "周次：" + startWeek + "-" + endWeek + ',' + "班次：" + classNum;
//                temp[(l - 1) * 2][r - 1] = context;
//                temp[(l - 1) * 2 + 1][r - 1] = context;
//            }
//        }
//
//        return temp;
        return MakeTimeTable.makeBigTable(lis, 1);
    }

    private boolean timechongtu(String stuId, int classId) {
        List<Map> maps = classDao.findStudentClassTime(stuId);
        List<long[]> times = StudentTimeLoad.StudentTimeLoad(maps);
        Map map = classDao.findClassTimeById(classId);
        List<long[]> classTime = StudentTimeLoad.TimeLoad(map);

        return TimeConflict.confilct(times, classTime);
    }

    @Override
    public int addCourse(int classId, String stuId) {
        //首先得到学生id
        boolean weixuan = gradeDao.selectGrade(classId, stuId).isEmpty();
        if (weixuan) {
////            boolean noShijianchongtu = studentDao.findTimeChongTu(stuId, classId).isEmpty();

            boolean chongtu = timechongtu(stuId, classId);

            if (!chongtu) {
                ClassDomain course = classDao.findClassById(classId);
                boolean noChaobiao = course.getClassChooseNum() < course.getClassUpperLimit();
                if (noChaobiao) {
                    return addyuanzi(classId, stuId);
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    @Transactional
    public int addyuanzi(int classId, String stuId) {

        classDao.updateChooseNum(classId, 1);
        studentDao.addChooseCourse(stuId, classId);

        ClassDomain course = classDao.findClassById(classId);
        if (course.getClassChooseNum() > course.getClassUpperLimit()) {
            throw new RuntimeException();
        }
        return 0;
    }

    @Transactional
    @Override
    public int updateWaitingFlag(int id) {
        return waitingDao.updateFlag(id);

    }

    @Override
    public int deleteWaiting(int id) {
        return waitingDao.delete(id);
    }

    @Override
    public Map<String, Object> findWaitStatus(int id) {
        Map<String,Object>waiting=waitingDao.findById(id).get(0);
        Map<String,Object> res=new HashMap<>();
        int flag= (int) waiting.get("flag");
        if(flag==0){
            res.put("status","已成功补位！");
        }else if(flag==1){
            String time= (String) waiting.get("time");
            int classId= (int) waiting.get("classId");
            int order = (int) waitingDao.findOrder(time,classId).get(0).get("order");
            res.put("status","目前排在第"+order+"位");
        }
        return null;
    }



     /*  @Override
       public Map<String, Object> lookUpWaitingOrder(String stuId,int classId) {
           Map<String,Object> waiting=waitingDao.findByStuAndClass(stuId,classId).get(0);
           String time= (String) waiting.get("time");
           int order = (int) waitingDao.findOrder(time,classId).get(0).get("order");
            waiting.put("order",order);
           return waiting;
       }
*/
    @Override
    public int deleteCourse(int classId, String stuId) {
        if (!gradeDao.selectGrade(classId, stuId).isEmpty()) {
            classDao.updateChooseNum(classId, -1);
            return studentDao.deleteChooseCourse(stuId, classId);
        } else {
            return 0;
        }
    }


    @Override
    public int addApplication(int classId, int states, String reason, int classNum, String stuId) {
        return studentApplicationDao.add(stuId, classId, states, reason, 2, classNum);
    }

    @Override
    public List<ClassDomain> selectClassed(Map<String, Object> map) {

        //获得学生id
        String stuId = (String) map.get("stuId");
        Integer currentPage = (Integer) map.get("currentPage");
        Integer pageSize = (Integer) map.get("pageSize");
        Integer startWeek = (Integer) map.get("startWeek");
        Integer endWeek = (Integer) map.get("endWeek");
        Integer departId = (Integer) map.get("departId");
        Integer modelsId = (Integer) map.get("modelsId");
        String teaId = (String) map.get("teaId");
        String classname = (String) map.get("classname");
        String teaname = (String) map.get("teaname");
        Integer hasWaiGuoYu = (Integer) map.get("hasWaiGuoYu");
        Integer classNum = (Integer) map.get("classNum");
        Integer classChooseNum = (Integer) map.get("classChooseNum");

        //这个是学生选择的课程
        List<GradeDomain> gradeDomains = gradeDao.selectGrade(88888888, stuId);

        System.out.println("\n");
        System.out.printf("startWeek = %d", startWeek);
        System.out.printf("endWeek = %d", endWeek);


        PageHelper.startPage(currentPage, pageSize);
        List<ClassDomain> classes = classDao.selectClasses(departId, classname, teaname, teaId, startWeek, endWeek, hasWaiGuoYu, modelsId, classNum, classChooseNum);

        System.out.println(classes);
        Set<Integer> haveAddClass = new HashSet<>();
        if (!gradeDomains.isEmpty()) {
            for (int j = 0; j < gradeDomains.size(); j++) {
                int id = gradeDomains.get(j).getClassId();
                System.out.println("\n");
                System.out.printf("id %d", id);
                haveAddClass.add(id);
            }
        }
        for (int i = 0; i < classes.size(); i++) {
            int classId = classes.get(i).getClassId();
            int limit = classes.get(i).getClassUpperLimit();
            int chooseNum = classes.get(i).getClassChooseNum();
            if (haveAddClass.contains(classId)) {
                classes.get(i).setShowDeleteButton(true);//显示取消按钮
                classes.get(i).setNotShowAddButton(true);//不显示添加按钮
            } else if (!haveAddClass.contains(classId) & limit == chooseNum) {
                classes.get(i).setShowDeleteButton(false);//不显示取消按钮
                classes.get(i).setNotShowAddButton(true);//不显示添加按钮
            } else if (!haveAddClass.contains(classId) & limit > chooseNum) {
                classes.get(i).setShowDeleteButton(false);//不显示取消按钮
                classes.get(i).setNotShowAddButton(false);//显示添加按钮
            }
//            if (limit == chooseNum){
//                Collections.swap(classes,);
//            }

        }
        for (ClassDomain classDomain : classes) {
            System.out.println(classDomain.isNotShowAddButton() + ":" + classDomain.isShowDeleteButton());
            classDomain.setButtonGroup(Boolean.toString(!classDomain.isNotShowAddButton()) + ":" + Boolean.toString(classDomain.isShowDeleteButton()));
            String[] d = classDomain.getClassDateDescription().split(":");
            Integer a = Integer.parseInt(d[0]);
            Integer b = Integer.parseInt(d[1]);
            classDomain.setClassDateDescription(new String(CourseDateTrans.dateToString(a, b)));
        }
        return classes;
    }

    @Override
    public Map getClassTime(String stuId) {
        List<Map<String, Object>> li1 = studentDao.getWaiStudyTime(stuId);
        List<Map<String, Object>> li2 = studentDao.getNotWaiStudyTime(stuId);

        int sum1 = 0;
        for (Map<String, Object> l : li1) {
            int temp = (int) l.get("classTime");
            sum1 += temp;
        }
        int sum2 = 0;
        for (Map<String, Object> l : li2) {
            int temp = (int) l.get("classTime");
            sum2 += temp;
        }

        Map<String, Object> res = new HashMap<>();
        res.put("waiguoyu", sum1);
        res.put("notwaiguoyu", sum2);
        return res;
    }


//    @Override
//    public List<HashMap<String,Object>> findAllClassName(int student,String stuId) {
//        if(student==1){
//            List<HashMap<String, Object>> lis = studentDao.findClasses(stuId);
//            System.out.println(lis);
//            return lis;
//        }else {
//            List<HashMap<String, Object>> liM = studentDao.findAllClassName();
//            for (HashMap<String, Object> aM : liM) {
//                String className = (String) aM.get("className");
//                String classNum = Integer.toString((Integer) aM.get("classNum"));
//                aM.put("classStr", className + "(" + classNum + "班)");
//            }
//            System.out.println(liM);
//            return liM;
//        }
//    }


    @Override
    public List<HashMap<String, Object>> findAllClassName(int student, String stuId) {
        if (student == 1) {
            List<HashMap<String, Object>> lis = studentDao.findClasses(stuId);
            return lis;

        } else {
            List<HashMap<String, Object>> liM = studentDao.findAllClassName();
            for (HashMap<String, Object> aM : liM) {
                String className = (String) aM.get("className");
                String classNum = Integer.toString((Integer) aM.get("classNum"));
                aM.put("classStr", className + "(" + classNum + "班)");
            }
            return liM;
        }

    }

    @Override
    public int getTimeSwtich() {
        Map map = timeSwitchDao.get2();
        System.out.println("时间西段是："+map);
        java.sql.Timestamp start = (java.sql.Timestamp) map.get("start");
        java.sql.Timestamp end = (java.sql.Timestamp) map.get("end");
        System.out.println(start);

        Date now = null;
        java.util.Date sdate = new java.util.Date(start.getTime());
        java.util.Date edate = new java.util.Date(end.getTime());
        now = new Date();
        System.out.println("现在是=" + now + "开始是" + sdate + "结束时" + edate);
        if (now.before(sdate) || now.after(edate)) {
            return 0;
        }
        return 1;
    }
<<<<<<< Updated upstream
=======

    @Override
    public int addComment(String stuId, String teaId, String[] score, String words) {
        int num = 0;
        for (int i = 0; i < score.length; i++){
            num = num + Integer.parseInt(score[i]);
        }
        String scores = String.valueOf(num);
        System.out.println(stuId + "---------" + teaId + "---------" + scores + "------------" + words);
        return studentDao.addComment(stuId, teaId, scores, words);
    }

    @Override
    public List<Map<String, Object>> selectList(String stuId) {
        System.out.println("==========" + stuId + "==========");
        List<Map<String, Object>> list= studentDao.selectList(stuId);
        System.out.println(list);
        //判断是否评教过
        List<Map<String, Object>> m = studentDao.findIsComment(stuId);
        System.out.println("================" + m + "=======libiao=========");
        if(m.size() == 0){
            list.get(0).put("isComment", '0');//0表示未评教
        }else {
            list.get(0).put("isComment", '1');
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<Map<String, Object>> selectList1(String stuId) {
        List<Map<String, Object>> list= studentDao.selectList(stuId);//找到学生所选课表
        for (int i = 0; i < list.size(); i++){
            list.get(i).put("isComment", '0');
        }
//        System.out.println(list);
        return list;
    }

    @Override
    public List<Map<String, Object>> showTeacomment(String stuId) {
        return studentDao.showTeacomment(stuId);
    }

    @Override
    public int addCommentWeekly(String stuId) {
        /**
         * 获取上课开始时间，并计算第几周
         * 获得学生本次是否评价，若评价则不可重复评价，若未评价，则允许评价
         */
//        CalculateWeekth week = new CalculateWeekth();
        String CHUSHISHIJIAN = "2018-09-02 00:00:00";//每一个学期的第一周的星期一
        String CHUSHISHIJIAN2 = "2018-09-01 23:59:59";//每一个学期的第一周的星期一
        int startWeek = 0;
        int endWeek = 0;
        List<Map<String, Object>> li= studentDao.selectList(stuId);
        for (Map map : li){
            for (Object k : map.keySet()){
                startWeek = (int) map.get("startWeek");
                endWeek = (int) map.get("endWeek");
            }
        }
//        System.out.println(startWeek);
        int week = endWeek - startWeek + 1;//总的周数
        //课程开始时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        startWeek = (startWeek - 1) * 7;
//        endWeek = (endWeek - 1) * 7;
        try {
            Date date = df.parse(CHUSHISHIJIAN);
            Date data = df.parse(CHUSHISHIJIAN2);
            //获取当前系统时间
            Date now = df.parse(df.format(new Date()));
            Calendar calNow = Calendar.getInstance();
            calNow.setTime(now);
            //每周开始时间
            Calendar calStart = Calendar.getInstance();
            calStart.setTime(date);
            Calendar calEnd= Calendar.getInstance();
            calEnd.setTime(data);
            calStart.add(Calendar.DATE, 7 * (startWeek - 1));//开始周加上初始上课周的时间
            calEnd.add(Calendar.DATE, 7 * (startWeek - 1));
            for (int i = 1; i <= week; i++){
                calStart.add(Calendar.DATE,7 * (i - 1));
                calEnd.add(Calendar.DATE, 7 * i);
                if(calNow.after(calStart) && calNow.before(calEnd)){
                    System.out.println(i);
                    return i + startWeek;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Map<String, Object>> addCommentWeeklyTrue(String stuId) {
        return studentDao.addCommentWeeklyTrue(stuId);
    }

    @Override
    public int addCommentWeeklyFinal(String stuId, String classId, String comment, String currWeek,
                                     String teaId, int score1, int score2, int score3, int score4) {
        int scor = score1 + score2 + score3 + score4;
        String score = String.valueOf(scor);
        return studentDao.addCommentWeeklyFinal(stuId, classId, score, comment, currWeek, teaId, score1, score2, score3, score4);
    }


    @Override
    public List<Map<String, Object>> showCommentList(String stuId, String classId) {
        List<Map<String, Object>> list = studentDao.showCommentList(stuId, classId);//获取学生真正的评价信息
//        System.out.println("======" + list + "========");
        int startWeek = 0;
        int endWeek = 0;
        List<Map<String, Object>> li = studentDao.selectList(stuId);
        for (Map map : li){
            for (Object k : map.keySet()){
                startWeek = (int) map.get("startWeek");
                endWeek = (int) map.get("endWeek");
            }
        }
        int week = endWeek - startWeek + 1;//总的周数   11-4 + 1 = 8
        int b = list.size(); //作为补充
        int k = week - list.size(); // 先生成一个完整的数组，大小为需要评价的周次数  8 - 1
//        System.out.println(week);
        if(list.size() != 0 ){
            //先生成相应的八个信息
            for (int i = 0; i < k; i++){
                Map<String, Object> m = new HashMap<>();
                m.put("commentFlag", "0");              //0表示未评价
                list.add(m);
            }
//            System.out.println("添加后完全的list" + list);//生成八个信息
//            System.out.println(list.get(0).get("classWeek")+ "-----------" + list.get(1).get("classWeek"));
            //学生周次是4-11周
            int start = startWeek;
            int index = 0;

            for (int i = 1; i<= week; i++){
                if(!(String.valueOf(list.get(index).get("classWeek"))).equals(String.valueOf(start))){
//                    System.out.println(list.get(index).get("classWeek") + "=========" + String.valueOf(start));
                    Map<String, Object> m = new HashMap<>();
                    m.put("commentFlag","0");
                    m.put("test", "2333");
                    list.add(index, m);
//                    System.out.println("未走到else");
                    index = index + 1;
                    start = start + 1;
                }else {
                    start = start + 1;
                    index = index + 1;//索引后移一位
                }
            }
//            System.out.println("插入后完整的list" + list);//生成l 16个
            int len = list.size() - 1;
            for (int i = len; i > week - 1 ; i--){//清除冗余 b = list.size()
                list.remove(i);
            }
            //数据格式的转换
            Map<String, Object> m1 = new HashMap<>();
            m1.put("data", list);
            Map<String, Object> m2 = new HashMap<>();
            m2.put("startWeek",startWeek);
            List <Map<String, Object>>l = new ArrayList<>();
            l.add(m2);
            l.add(m1);
//            System.out.println("最终的list" + l);
            return l;
        }else {
            List <Map<String, Object>>l = new ArrayList<>();
            for (int i = 0; i < k; i++){
                Map<String, Object> m = new HashMap<>();
                m.put("commentFlag", "0");
                list.add(i, m);
            }
            Map<String, Object> m2 = new HashMap<>();
            m2.put("startWeek",startWeek);
            Map<String, Object> m1 = new HashMap<>();
            m1.put("data", list);
            l.add(m2);
            l.add(m1);
            System.out.println("添加后完全的list" + l);
            return l;
        }
    }

    @Override
    public int addWaiting(String stuId, int classId, int flag,String time) {
       return  waitingDao.insert(stuId,classId,flag,time);
    }

    @Override
    public List<Map<String, Object>> findWaiting(Integer classId) {
        return  waitingDao.selectWaitings(classId);
    }
>>>>>>> Stashed changes
}
