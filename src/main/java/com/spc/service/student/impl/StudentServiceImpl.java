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
import org.springframework.transaction.annotation.Isolation;
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


    @Override
    public String[][] findClasses(String stuId) {
//        int stuId = Integer.parseInt(authMess.userDetails().getUserid());
        List<HashMap<String, Object>> lis = studentDao.findClasses(stuId);
        System.out.println(lis);
        return MakeTimeTable.makeBigTable(lis, 1);
    }

    private boolean timechongtu(String stuId, int classId) {
        // 找到该学生的所有上课时间
        List<Map> maps = classDao.findStudentClassTime(stuId);
        // 转化成数组类型
        List<long[]> times = StudentTimeLoad.StudentTimeLoad(maps);
        // 该课程的数组的类型
        Map map = classDao.findClassTimeById(classId);
        // 将课程的上课时间转化成数组类型
        List<long[]> classTime = StudentTimeLoad.TimeLoad(map);

        return TimeConflict.confilct(times, classTime);
    }

    @Override
    public int addCourse(int classId, String stuId,Integer departId) {
        // 该学生所选的所有课程
        List<HashMap<String, Object>> lis = studentDao.findClasses(stuId);

        // 计算该学生的所有课时
        Integer allTime = 0;
        for (HashMap recode : lis) {
            allTime += (int) recode.get("classTime");
        }
        //查询要选择的课程是哪个学院的
        ClassDomain course = classDao.findClassById(classId);
        // 查询要选择的课程的课时数
        int classTime = course.getClassTime();
        // 查询要选择的课程的院系号
        int courseDepartId = course.getDepartId();
        if (courseDepartId != 12 && courseDepartId != departId) {
            return 1;
        }
        logger.info(stuId+"学生已经选了"+ allTime+"课时");
        // 判断这个课程和该学生有没有时间冲突
        boolean chongtu = timechongtu(stuId, classId);
        if (allTime == 32) {
            // 已经选够32学时
            logger.info("已经选够32学时，不能再选");
            return 1;
        } else if(chongtu){
            // 有课程冲突
            logger.info("有课程冲突，不能选择");
            return 1;
        } else if (allTime == 24) {
            if (courseDepartId == departId) {
                // 要选择的是自己学院的课程
                if (classTime == 8) {
                    //课时是8课时
                    addyuanzi(classId, stuId);
                } else {
                    // 课时多了，不能添加
                    return 1;
                }
            } else return 1; // 选择的是其他学院的课程
        } else if (allTime == 16) {
            // 得到已经选择的课程id
            Integer haveSelectCourseDepartId = getSelectCourseDepartId(lis);
            logger.info("选择的课程id是"+haveSelectCourseDepartId);
            if (haveSelectCourseDepartId == 12) {
                // 如果是外国语学院的课程
                boolean notKaiKe = classDao.kaiKe(departId).isEmpty();
                if (notKaiKe == false) {
                    logger.info("该学生所在的学院开课了");
                    // 该学生的自己的学院已经开课了
                    if (departId == courseDepartId) {
                        //如果要选择的是自己学院的课，则添加课程
                        addyuanzi(classId, stuId);
                    } else {
                        // 如果不是自己学院的课程，不成功
                        return 3;
                    }
                } else {
                    logger.info("该学生所在的学院没有开课了");
                    //自己学院没有开课
                    if (courseDepartId == 12) {
                        // 选择的课程是外国语学院的
                        addyuanzi(classId, stuId);
                    } else {
                        return 2;
                    }
                }
            } else if (haveSelectCourseDepartId != 12 && haveSelectCourseDepartId == departId) {
                if (courseDepartId == 12) {
                    addyuanzi(classId, stuId);
                } else {
                    return 1;
                }
            }
        } else if (allTime == 8) {
            if (courseDepartId == 12) {
                addyuanzi(classId, stuId);
            } else if (courseDepartId == departId) {
                if (classTime == 8) {
                    addyuanzi(classId, stuId);
                } else {
                    return 2;
                }
            }
        } else {
            addyuanzi(classId, stuId);
        }
        return 0;
    }

    private Integer getSelectCourseDepartId(List<HashMap<String, Object>> lis) {
        HashMap recode = lis.get(0);
        return (int)(recode.get("departId"));
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int addyuanzi(int classId, String stuId) {
//        首先给该行数据加锁
        ClassDomain course = classDao.findCourseByIdForUpdate(classId);
        if (course.getClassChooseNum() < course.getClassUpperLimit()) {
            studentDao.addChooseCourse(stuId, classId);
            classDao.updateChooseNum(classId, 1);
            return 6;
        }
        return 4;
    }

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

        // 1.首先是得到学生的id,并且获得参数
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

        // 2.找到这个学生的所选课程
        List<GradeDomain> gradeDomains = gradeDao.selectGrade(88888888, stuId);

        System.out.println("\n");
        System.out.printf("startWeek = %d", startWeek);
        System.out.printf("endWeek = %d", endWeek);

        // 3. 按照分页查询出当前页的数据
        PageHelper.startPage(currentPage, pageSize);
        List<ClassDomain> classes = classDao.selectClasses(departId, classname, teaname, teaId, startWeek, endWeek, hasWaiGuoYu, modelsId, classNum, classChooseNum);

        // 4. 将这个学生的所选课程id加入到下面的set里
        Set<Integer> haveAddClass = new HashSet<>();
        if (!gradeDomains.isEmpty()) {
            for (int j = 0; j < gradeDomains.size(); j++) {
                int id = gradeDomains.get(j).getClassId();
                System.out.println("\n");
                System.out.printf("id %d", id);
                haveAddClass.add(id);
            }
        }

        // 5. 对于每一条数据添加所需的字段内容
        for (int i = 0; i < classes.size(); i++) {
            int classId = classes.get(i).getClassId();
            int limit = classes.get(i).getClassUpperLimit();
            int chooseNum = classes.get(i).getClassChooseNum();

            if (haveAddClass.contains(classId)) {
                // 如果该学生已经选择了这门课 ，可以显示取消按钮，不显示添加按钮
                classes.get(i).setShowDeleteButton(true);//显示取消按钮
                classes.get(i).setNotShowAddButton(true);//不显示添加按钮
            } else if (!haveAddClass.contains(classId) & limit == chooseNum) {
                // 如果该学生没有选择这门课，但是该课程已经达到了上线人数，那么就既不显示取消按钮，也不显示添加按钮
                classes.get(i).setShowDeleteButton(false);//不显示取消按钮
                classes.get(i).setNotShowAddButton(true);//不显示添加按钮
            } else if (!haveAddClass.contains(classId) & limit > chooseNum) {
                // 如果该学生没有选择这门课，但是没有达到课程上线，那么就显示添加按钮，不现实取消按钮
                classes.get(i).setShowDeleteButton(false);//不显示取消按钮
                classes.get(i).setNotShowAddButton(false);//显示添加按钮
            }
        }
        for (ClassDomain classDomain : classes) {
            System.out.println(classDomain.isNotShowAddButton() + ":" + classDomain.isShowDeleteButton());
            classDomain.setButtonGroup(Boolean.toString(!classDomain.isNotShowAddButton()) + ":" + Boolean.toString(classDomain.isShowDeleteButton()));
            String[] descs = classDomain.getClassDateDescription().split(",");
            StringBuffer res = new StringBuffer();
            for (String desc:descs){
                String[] d = desc.split(":");
                Integer a = Integer.parseInt(d[0]);
                Integer b = Integer.parseInt(d[1]);
                Integer c = Integer.parseInt(d[2].replace(",",""));
                res.append(CourseDateTrans.dateToString(a, b, c));
                res.append(",");
            }

            String s = res.toString().substring(0,res.length()-1);
            classDomain.setClassDateDescription(s);
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
}
