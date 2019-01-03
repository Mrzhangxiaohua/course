package com.spc.service.manage.impl;

import com.spc.controller.Base;
import com.spc.dao.ClassAllDao;
import com.spc.model.ClassAll;
import com.spc.service.SynchroTable.SynchroTable;
import com.spc.service.manage.ClassAllService;
import com.spc.service.wsdl.GetUndergradFreeClassrooms.GetUndergradFreeClassroomInfo;
import com.spc.service.wsdl.GetUndergradFreeClassrooms.SpareClassRoom;
import com.spc.service.wsdl.TeachersOccupyTimeWebservice.TeacherCurriculumInfo;
import com.spc.service.wsdl.TeachersOccupyTimeWebservice.TeacherOccupyTime;
import com.spc.service.wsdl.classroom.ClassRoomUsed;
import com.spc.service.wsdl.classroom.ClassroomOccupy;
import com.spc.service.wsdl.teacher.KzJskb;
import com.spc.service.wsdl.teacher.TeacherOccupy;
import org.apache.commons.collections4.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 排课Service
 *
 * @author yzk
 * @date 2018-12-25
 */
@Service
public class ClassAllServiceImpl implements ClassAllService {

    public  final Logger logger = LoggerFactory.getLogger(ClassAll.class);
    /**
     * 每学期共16周
     */
    private static final int WEEKS_PER_SEMESTER = 16;
    /**
     * 每天一共12个学时
     */
    private static final int CLASS_HOURS_PER_DAY = 12;
    /**
     * 每周一共7天
     */
    private static final int CLASS_DAYS_PER_WEEK = 7;
    /**
     * 字符串数组分隔符
     */
    private static final String ARRAY_SPLIT_CHAR = ",";
    /**
     * 时间rowIndex、colIndex分隔符
     */
    private static final String INDEX_SPLIT_CHAR = "-";

    @Autowired
    private ClassAllDao classAllDao;

    @Autowired
    private TeacherCurriculumInfo teacherCurriculumInfoService;

    @Autowired
    private GetUndergradFreeClassroomInfo undergradFreeClassroomInfoService;

    @Autowired
    private ClassroomOccupy classroomOccupyService;

    @Autowired
    private TeacherOccupy teacherOccupyService;

    @Autowired
    private SynchroTable synchroTableService;

    @Override
    public List<ClassAll> getClassAll(Integer departId, String academicYear, String classSemester, String courseName,
                                      String teacherId, String teacherName, String classPlaceId) {
        return classAllDao.selectClassAll(departId, academicYear, classSemester, courseName, teacherId, teacherName, classPlaceId);
    }


    @Override
    public String[][] getTeacherTimetable(String teacherId, String academicYear, String classSemester) {
        List<ClassAll> classes = classAllDao.selectClassAll(null, academicYear, classSemester, null,
                teacherId, null, null);
        return constructTimetable(classes);
    }

    /**
     * 构建课表
     *
     * @param classes
     * @return
     */
    private String[][] constructTimetable(List<ClassAll> classes) {
        String[][] timetable = new String[CLASS_HOURS_PER_DAY][CLASS_DAYS_PER_WEEK];

        for (ClassAll c : classes) {
            if (null == c.getInstructorName()) {
                continue;
            }
            if (null == c.getClassName()) {
                continue;
            }
            if (null == c.getStartWeek() || null == c.getEndWeek()) {
                continue;
            }
            if (null == c.getClassDateDesc()) {
                continue;
            }
            if (null == c.getClassPlaceName()) {
                continue;
            }

            // parse classDateDesc, eg: 2-2,3-2
            String[] classDates = c.getClassDateDesc().split(ARRAY_SPLIT_CHAR);
            for (int k = 0; k < classDates.length; k++) {
                String[] indexes = classDates[k].split(INDEX_SPLIT_CHAR);
                int i = Integer.parseInt(indexes[0]);
                int j = Integer.parseInt(indexes[1]);

                StringBuilder sb = new StringBuilder();
                sb.append("★课程：");
                if (c.getCourseNameCHS() != null) {
                    sb.append(c.getCourseNameCHS());
                } else {
                    sb.append(c.getCourseNameEN());
                }
                sb.append("\n教室：").append(c.getClassPlaceName());
                sb.append("\n授课教师：").append(c.getInstructorName());
                sb.append("\n上课地点：").append(c.getClassPlaceName());
                sb.append("\n周次：").append(c.getStartWeek()).append("-").append(c.getEndWeek());
                sb.append("\n班次：").append(c.getClassName());
                timetable[i][j] = timetable[i][j] == null ? sb.toString() : timetable[i][j] + "\n\n" + sb.toString();
            }
        }

        return timetable;
    }

    @Transactional
    @Override
    public Map<String, String> scheduleClass(ClassAll classAll) {
        Map<String, String> res = new HashedMap<>();
        StringBuilder msgBuilder = new StringBuilder();
        StringBuilder conflictDescBuilder = new StringBuilder();

        // 学年学期代码，用于wsdl调用
        String xnxqdm = classAll.getAcademicYear() + "-" + (classAll.getClassSemester().contains("春") ? 2 : 1);
        // 上课时间
        String[] classDates = classAll.getClassDateDesc().split(ARRAY_SPLIT_CHAR);
        int[] rows = new int[classDates.length];
        int[] cols = new int[classDates.length];
        boolean[][] timetableTFT = new boolean[CLASS_HOURS_PER_DAY][CLASS_DAYS_PER_WEEK];
        for (int i = 0; i < classDates.length; i++) {
            String[] temp = classDates[i].split(INDEX_SPLIT_CHAR);
            int rowIndex = Integer.parseInt(temp[0]);
            int colIndex = Integer.parseInt(temp[1]);
            rows[i] = rowIndex;
            cols[i] = colIndex;
            timetableTFT[rowIndex][colIndex] = true;
        }
        if (checkClassName(classAll, res, msgBuilder)) {
            return res;
        }

        // 2. 校验老师时间冲突
        String[] instructorIds = classAll.getInstructorId().split(ARRAY_SPLIT_CHAR);
        String[] instructorNames = classAll.getInstructorName().split(ARRAY_SPLIT_CHAR);

        // 2.1 校验已排课程时间冲突
        if (checkGraduateCourseTime(classAll, res, msgBuilder, conflictDescBuilder, timetableTFT, instructorIds)) {
            return res;
        }

        // 2.2 校验本科时间冲突
        if (checkUndergraduateCourseTime(classAll, res, msgBuilder, conflictDescBuilder, xnxqdm, timetableTFT, instructorIds, instructorNames)) {
            return res;
        }

        // 3. 校验上课地点冲突

        // 3.1 校验已排课程地点的冲突
        if (checkGraduateCoursePlace(classAll, res, msgBuilder, conflictDescBuilder, timetableTFT)) {
            return res;
        }

        // 3.2 校验本科课程地点的冲突
        if (checkUndergraduateCoursePlace(classAll, res, msgBuilder, conflictDescBuilder, xnxqdm, classDates, rows, cols)) {
            return res;
        }

        classAll.setConflictDesc(conflictDescBuilder.toString());
        classAll.setScheduled(1);

        // 如果没有冲突，则保存对应的记录
        if (classAll.getId() != null) {
            // 清空原有占用信息
            boolean freeFlag = freeClassroomAndTeacher(classAllDao.selectClassAllById(classAll.getId()), res);
            // 修改记录
            int count = classAllDao.updateClass(classAll);
            // TODO CHECK
            synchroTableService.updateRecord(classAll);

            logger.info("updateClass: " + classAll.toString());
            if (!freeFlag) {
                return res;
            }
            // 先占用本科教务系统的老师、地点的相应时间
            // 1. 地点占用
            if (useClassroom(classAll, res, xnxqdm, classDates, rows, cols, false)) {
                return res;
            }
            // 2. 老师占用
            if (useTeacherTime(classAll, res, xnxqdm, classDates, rows, cols, instructorIds, false)) {
                return res;
            }

            if (count > 0) {
                res.put("status", "success");
                res.put("msg", "提交成功！");
            } else {
                res.put("status", "error");
                res.put("msg", "提交失败，请重试！");
            }
        } else {
            // 新增记录
            int count = classAllDao.insertClass(classAll);
            // TODO CHECK
            synchroTableService.insertRecord(classAll);

            logger.info("insertClass: " + classAll.toString());
            if (count > 0) {
                // 先占用本科教务系统的老师、地点的相应时间
                // 1. 地点占用
                if (useClassroom(classAll, res, xnxqdm, classDates, rows, cols, true)) {
                    return res;
                }
                // 2. 老师占用
                if (useTeacherTime(classAll, res, xnxqdm, classDates, rows, cols, instructorIds, true)) {
                    return res;
                }

                res.put("status", "success");
                res.put("msg", "提交成功！");
            } else {
                res.put("status", "error");
                res.put("msg", "提交失败，请重试！");
            }
        }
        return res;
    }

    private boolean useTeacherTime(ClassAll classAll, Map<String, String> res, String xnxqdm, String[] classDates, int[] rows, int[] cols, String[] instructorIds, boolean del) {
        for (int i = 0; i < classDates.length; i++) {
            int rowIndex = rows[i];
            int colIndex = cols[i];

            for (int j = 0; j < instructorIds.length; j++) {
                KzJskb kzJskb = teacherOccupyService.createKzJskb(xnxqdm, classAll.getSchoolDistrictId().toString(), classAll.getStartWeek(),
                        classAll.getEndWeek(), "0", colIndex + 1, rowIndex + 1, rowIndex + 1,
                        instructorIds[j], classAll.getId().toString(), classAll.getId().toString());
                int flag = teacherOccupyService.addTeacherOccupyTime(kzJskb, classAll.getOperatorId(), classAll.getOperatorName());
                logger.info("=== addTeacherOccupyTime: " + kzJskb.toString() + "\n=== flag: " + flag);

                if (flag == 0) {
                    // 占用失败
                    // 回滚之前的老师占用记录
                    int iMax = i;
                    int jMax = j;
                    for (i = 0; i < classDates.length; i++) {
                        for (j = 0; j < instructorIds.length; j++) {
                            rowIndex = rows[j];
                            colIndex = cols[j];
                            kzJskb = teacherOccupyService.createKzJskb(xnxqdm, null, null, null, null, null, null, null,
                                    instructorIds[j], classAll.getId().toString(), classAll.getId().toString());
                            flag = teacherOccupyService.deleteTeacherOccupyTime(kzJskb, classAll.getOperatorId(), classAll.getOperatorName());
                            logger.info("=== deleteTeacherOccupyTime: " + kzJskb.toString() + "\n=== flag: " + flag);
                            if (i == iMax && j == jMax) {
                                // 回滚完毕
                                if (del) {
                                    classAllDao.delClassAllById(classAll.getId());
                                    // TODO CHECK
                                    synchroTableService.removeRecord(classAll.getId());
                                } else {
                                    classAllDao.clearClassAllById(classAll.getId(), classAll.getOperatorId(), classAll.getOperatorName());
                                    // TODO CHECK
                                    clearUnusedField(classAll);
                                    synchroTableService.updateRecord(classAll);
                                }
                                res.put("status", "error");
                                res.put("msg", "本科教务系统异常！");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private void clearUnusedField(ClassAll classAll) {
        classAll.setScheduled(null);
        classAll.setClassName(null);
        classAll.setInstructorId(null);
        classAll.setInstructorName(null);
        classAll.setStartWeek(null);
        classAll.setEndWeek(null);
        classAll.setClassDateDesc(null);
        classAll.setClassPlaceId(null);
        classAll.setClassPlaceName(null);
        classAll.setConflictDesc(null);
        classAll.setScheduled(0);
    }

    private boolean useClassroom(ClassAll classAll, Map<String, String> res, String xnxqdm, String[] classDates, int[] rows, int[] cols, boolean del) {
        ClassRoomUsed[] classRoomUseds = new ClassRoomUsed[classDates.length];
        logger.info("=== useClassroom start ===");
        for (int i = 0; i < classDates.length; i++) {
            int rowIndex = rows[i];
            int colIndex = cols[i];
            ClassRoomUsed classRoomUsed = classroomOccupyService.createClassRoomUsed(xnxqdm, classAll.getSchoolDistrictId().toString(),
                    classAll.getStartWeek(), classAll.getEndWeek(), "0", colIndex + 1, rowIndex + 1, rowIndex + 1,
                    classAll.getClassPlaceId(), classAll.getId().toString(), classAll.getId().toString());
            classRoomUseds[i] = classRoomUsed;
            logger.info("=== addUsedClassroom: " + classRoomUsed.toString());
        }
        int flag = classroomOccupyService.addUsedClassroom(classRoomUseds, classAll.getOperatorId(), classAll.getOperatorName());
        logger.info("=== useClassroom end, flag: " + flag + "===");
        if (flag == 0) {
            // 占用失败
            if (del) {
                classAllDao.delClassAllById(classAll.getId());
                // TODO CHECK
                synchroTableService.removeRecord(classAll.getId());
            } else {
                classAllDao.clearClassAllById(classAll.getId(), classAll.getOperatorId(), classAll.getOperatorName());
                // TODO CHECK
                clearUnusedField(classAll);
                synchroTableService.updateRecord(classAll);
            }
            res.put("status", "error");
            res.put("msg", "本科教务系统异常！");
            return true;
        }
        return false;
    }

    /**
     * 校验已排课程地点冲突
     *
     * @param classAll
     * @param res
     * @param msgBuilder
     * @param conflictDescBuilder
     * @param timetableTFT
     * @return
     */
    private boolean checkGraduateCoursePlace(ClassAll classAll, Map<String, String> res, StringBuilder msgBuilder, StringBuilder conflictDescBuilder, boolean[][] timetableTFT) {
        List<ClassAll> classAllList = classAllDao.selectClassAllExcludeId(classAll.getAcademicYear(),
                classAll.getClassSemester(), null, classAll.getClassPlaceId(), classAll.getId());
        if (!classAllList.isEmpty()) {
            for (ClassAll c : classAllList) {
                // Step1: 周次重叠判断
                if (c.getEndWeek() < classAll.getStartWeek() || c.getStartWeek() > classAll.getEndWeek()) {
                    continue;
                }
                // Step2: 上课时间冲突判断
                String[] currentClassDates = c.getClassDateDesc().split(ARRAY_SPLIT_CHAR);
                for (int j = 0; j < currentClassDates.length; j++) {
                    String[] indexes = currentClassDates[j].split(INDEX_SPLIT_CHAR);
                    int rowIndex = Integer.parseInt(indexes[0]);
                    int colIndex = Integer.parseInt(indexes[1]);
                    if (timetableTFT[rowIndex][colIndex]) {
                        msgBuilder.append("该上课时间与").append(c.getInstructorName()).append("老师的").
                                append((c.getCourseNameCHS() != null ? c.getCourseNameCHS() : c.getCourseNameEN())).
                                append(c.getClassName()).append("上课地点冲突！\n");
                        conflictDescBuilder.append("p-").append("g").append("-").append(c.getId()).append(ARRAY_SPLIT_CHAR);
                        logger.info(msgBuilder.toString());
                        logger.info(conflictDescBuilder.toString());
                        break;
                    }
                }
            }
        }
        if (checkMsg(classAll.getForce(), res, msgBuilder)) {
            return true;
        }
        return false;
    }

    /**
     * 校验本科上课地点的冲突
     */
    private boolean checkUndergraduateCoursePlace(ClassAll classAll, Map<String, String> res, StringBuilder msgBuilder, StringBuilder conflictDescBuilder, String xnxqdm, String[] classDates, int[] rows, int[] cols) {
        int[] scheduledWeeks = new int[WEEKS_PER_SEMESTER];
        for (int i = classAll.getStartWeek() - 1; i < classAll.getEndWeek(); i++) {
            scheduledWeeks[i] = 1;
        }
        StringBuilder scheduledWeeksSb = new StringBuilder();
        for (int i = 0; i < WEEKS_PER_SEMESTER; i++) {
            scheduledWeeksSb.append(scheduledWeeks[i]);
        }
        String scheduledWeeksStr = scheduledWeeksSb.toString();

        SpareClassRoom[] rooms = new SpareClassRoom[classDates.length];
        for (int i = 0; i < classDates.length; i++) {
            SpareClassRoom room = undergradFreeClassroomInfoService.createSparseClassRoom(xnxqdm,
                    scheduledWeeksStr, cols[i] + 1, rows[i] + 1, rows[i] + 1);
            rooms[i] = room;
        }
        String freeRoomIds = undergradFreeClassroomInfoService.getFreeClassrooms(rooms, classAll.getOperatorId(), classAll.getOperatorName());
        if (freeRoomIds == null || freeRoomIds.isEmpty()) {
            logger.info("目前教室已全被本科课程占用，或数据存在异常，请联系管理员！");
            msgBuilder.append("目前教室已全被本科课程占用，或数据存在异常，请联系管理员！\n");
            conflictDescBuilder.append("p-").append("u").append(ARRAY_SPLIT_CHAR);
            logger.info(msgBuilder.toString());
            logger.info(conflictDescBuilder.toString());

            if (checkMsg(classAll.getForce(), res, msgBuilder)) {
                return true;
            }
        } else {
            String[] freeRoomIdsArray = freeRoomIds.split(ARRAY_SPLIT_CHAR);
            boolean valid = false;
            for (int i = 0; i < freeRoomIdsArray.length; i++) {
                if (freeRoomIdsArray[i].equals(classAll.getClassPlaceId())) {
                    valid = true;
                    break;
                }
            }
            if (!valid) {
                msgBuilder.append("该教室已被本科课程占用，请选择其他教室！\n");
                conflictDescBuilder.append("p-").append("u").append(ARRAY_SPLIT_CHAR);
                logger.info(msgBuilder.toString());
                logger.info(conflictDescBuilder.toString());

                if (checkMsg(classAll.getForce(), res, msgBuilder)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 校验已排课程时间冲突
     *
     * @param classAll
     * @param res
     * @param msgBuilder
     * @param conflictDescBuilder
     * @param timetableTFT
     * @param instructorIds
     * @return
     */
    private boolean checkGraduateCourseTime(ClassAll classAll, Map<String, String> res, StringBuilder msgBuilder, StringBuilder conflictDescBuilder, boolean[][] timetableTFT, String[] instructorIds) {
        for (int i = 0; i < instructorIds.length; i++) {
            List<ClassAll> classAllList = classAllDao.selectClassAllExcludeId(classAll.getAcademicYear(), classAll.getClassSemester(), instructorIds[i], null, classAll.getId());
            if (!classAllList.isEmpty()) {
                for (ClassAll c : classAllList) {
                    // Step1: 周次重叠判断
                    if (c.getEndWeek() < classAll.getStartWeek() || c.getStartWeek() > classAll.getEndWeek()) {
                        continue;
                    }
                    // Step2: 上课时间冲突判断
                    String[] currentClassDates = c.getClassDateDesc().split(ARRAY_SPLIT_CHAR);
                    for (int j = 0; j < currentClassDates.length; j++) {
                        String[] indexes = currentClassDates[j].split(INDEX_SPLIT_CHAR);
                        int rowIndex = Integer.parseInt(indexes[0]);
                        int colIndex = Integer.parseInt(indexes[1]);
                        if (timetableTFT[rowIndex][colIndex]) {
                            msgBuilder.append("该上课时间与").append(c.getInstructorName()).append("老师的").
                                    append((c.getCourseNameCHS() != null ? c.getCourseNameCHS() : c.getCourseNameEN())).
                                    append(c.getClassName()).append("授课时间冲突！\n");
                            conflictDescBuilder.append("t-").append("g").append("-").append(c.getInstructorId()).
                                    append("-").append(c.getInstructorName()).append("-").append(c.getId()).append(ARRAY_SPLIT_CHAR);
                            logger.info(msgBuilder.toString());
                            logger.info(conflictDescBuilder.toString());
                            break;
                        }
                    }
                }
            }
        }
        if (checkMsg(classAll.getForce(), res, msgBuilder)) {
            return true;
        }
        return false;
    }

    /**
     * 校验本科课程时间冲突
     *
     * @param classAll
     * @param res
     * @param msgBuilder
     * @param conflictDescBuilder
     * @param xnxqdm
     * @param timetableTFT
     * @param instructorIds
     * @param instructorNames
     * @return
     */
    private boolean checkUndergraduateCourseTime(ClassAll classAll, Map<String, String> res, StringBuilder msgBuilder, StringBuilder conflictDescBuilder, String xnxqdm, boolean[][] timetableTFT, String[] instructorIds, String[] instructorNames) {
        instructors:
        for (int i = 0; i < instructorIds.length; i++) {
            List<TeacherOccupyTime> teacherOccupyTimes = teacherCurriculumInfoService.
                    queryTeacherOccupyTime(classAll.getOperatorId(), classAll.getOperatorName(), instructorIds[i], xnxqdm);
            if (!teacherOccupyTimes.isEmpty()) {
                // Step1: 周次重叠判断
                occupyTimes:
                for (TeacherOccupyTime teacherOccupyTime : teacherOccupyTimes) {
                    logger.info(teacherOccupyTime.toString());
                    if (teacherOccupyTime.getWeeks() == null || teacherOccupyTime.getWeeks().length() == 0) {
                        continue;
                    }
                    weeks:
                    for (int j = classAll.getStartWeek() - 1; j < classAll.getEndWeek() && j < teacherOccupyTime.getWeeks().length(); j++) {
                        // 判断开课期间是否存在本科课程
                        if (teacherOccupyTime.getWeeks().charAt(j) == '1') {
                            // Step2: 存在课程，判断上课时间是否冲突
                            hours:
                            for (int k = teacherOccupyTime.getHourStartIndex(); k <= teacherOccupyTime.getHourEndIndex(); k++) {
                                if (timetableTFT[k][teacherOccupyTime.getDayIndex()]) {
                                    msgBuilder.append("该上课时间与").append(instructorNames[i]).append("老师的本科授课时间冲突！\n");
                                    conflictDescBuilder.append("t-").append("u").append("-").append(instructorIds[i]).append("-").append(instructorNames[i]).append(ARRAY_SPLIT_CHAR);
                                    logger.info(msgBuilder.toString());
                                    logger.info(conflictDescBuilder.toString());
                                    break occupyTimes;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (checkMsg(classAll.getForce(), res, msgBuilder)) {
            return true;
        }
        return false;
    }

    /**
     * 校验班级名称冲突
     *
     * @param classAll
     * @param res
     * @param msgBuilder
     * @return
     */
    private boolean checkClassName(ClassAll classAll, Map<String, String> res, StringBuilder msgBuilder) {
        // 1. 校验班级是否已经存在，在新建班级时进行该校验
        if (classAll.getId() == null) {
            int count = classAllDao.countClassAllByClassName(classAll.getAcademicYear(), classAll.getClassSemester(),
                    classAll.getCourseId(), classAll.getSchoolDistrictId(), classAll.getClassName());
            if (count > 0) {
                msgBuilder.append("在").append(classAll.getAcademicYear()).append(classAll.getClassSemester()).append(",");
                msgBuilder.append(classAll.getClassName()).append("已存在，请修改所属校区或修改班级名称！");

                // 该班级已存在，返回错误信息，提示修改
                res.put("status", "error");
                res.put("msg", msgBuilder.toString());
                return true;
            }
        }
        return false;
    }

    /**
     * 检测冲突信息
     *
     * @param force
     * @param res
     * @param msgBuilder
     * @return
     */
    private boolean checkMsg(boolean force, Map<String, String> res, StringBuilder msgBuilder) {
        String msg;
        msg = msgBuilder.toString();
        // 非强制情况下，直接返回冲突信息
        if (!msg.isEmpty()) {
            res.put("status", "error");
            res.put("msg", msg);
            // 非强制情况下，直接返回冲突信息
            if (!force) {
                return true;
            }
        }
        return false;
    }

    @Transactional
    @Override
    public Map<String, String> delClass(int id, String operatorId, String operatorName) {
        ClassAll classAll = classAllDao.selectClassAllById(id);
        Map<String, String> res = new HashedMap<>();
        if (classAll == null) {
            res.put("status", "error");
            res.put("msg", "该班级已被删除，请刷新页面！");
            return res;
        }

        int count = classAllDao.countClassAllByClassName(classAll.getAcademicYear(),
                classAll.getClassSemester(), classAll.getCourseId(), null, null);

        int updateCount;
        if (count > 1) {
            // del
            updateCount = classAllDao.delClassAllById(id);
        } else {
            // clear scheduled field
            updateCount = classAllDao.clearClassAllById(id, operatorId, operatorName);
        }

        if (updateCount > 0) {
            boolean freeFlag = freeClassroomAndTeacher(classAll, res);
            if (!freeFlag) {
                return res;
            }
            res.put("status", "success");
        } else {
            res.put("status", "error");
            res.put("msg", "数据删除异常，请重试！");
        }

        logger.info("count: " + count);
        if (count > 1) {
            logger.info("del");
            // TODO CHECK
//            synchroTableService.removeRecord(id);
        } else {
            logger.info("clear");
            clearUnusedField(classAll);
            synchroTableService.updateRecord(classAll);
        }
        return res;
    }

    private boolean freeClassroomAndTeacher(ClassAll classAll, Map<String, String> res) {
        if (classAll.getScheduled() == 0) {
            return true;
        }
        // 释放教室和老师的时间占用
        String[] classDates = classAll.getClassDateDesc().split(ARRAY_SPLIT_CHAR);
        int[] rows = new int[classDates.length];
        int[] cols = new int[classDates.length];
        for (int i = 0; i < classDates.length; i++) {
            String[] temp = classDates[i].split(INDEX_SPLIT_CHAR);
            int rowIndex = Integer.parseInt(temp[0]);
            int colIndex = Integer.parseInt(temp[1]);
            rows[i] = rowIndex;
            cols[i] = colIndex;
        }
        String xnxqdm = classAll.getAcademicYear() + "-" + (classAll.getClassSemester().contains("春") ? 2 : 1);

        // 释放地点
        ClassRoomUsed[] classRoomUseds = new ClassRoomUsed[classDates.length];
        logger.info("=== freeClassroom start ===");
        for (int i = 0; i < classDates.length; i++) {
            int rowIndex = rows[i];
            int colIndex = cols[i];
            ClassRoomUsed classRoomUsed = classroomOccupyService.createClassRoomUsed(xnxqdm, classAll.getSchoolDistrictId().toString(),
                    classAll.getStartWeek(), classAll.getEndWeek(), "0", colIndex + 1, rowIndex + 1, rowIndex + 1,
                    classAll.getClassPlaceId(), classAll.getId().toString(), classAll.getId().toString());
            classRoomUseds[i] = classRoomUsed;
            logger.info("=== delUsedClassroom: " + classRoomUsed.toString());
        }
        int flag = classroomOccupyService.delUsedClassroom(classRoomUseds, classAll.getOperatorId(), classAll.getOperatorName());
        logger.info("=== freeClassroom end, flag: " + flag + "===");

        if (flag == 0) {
            res.put("status", "error");
            res.put("msg", "本科教务系统异常！");
            return false;
        }

        // 释放老师
        String[] instructorIds = classAll.getInstructorId().split(ARRAY_SPLIT_CHAR);
        for (int i = 0; i < classDates.length; i++) {
            for (int j = 0; j < instructorIds.length; j++) {
                KzJskb kzJskb = teacherOccupyService.createKzJskb(xnxqdm, null, null, null, null, null, null, null,
                        instructorIds[j], classAll.getId().toString(), classAll.getId().toString());
                flag = teacherOccupyService.deleteTeacherOccupyTime(kzJskb, classAll.getOperatorId(), classAll.getOperatorName());
                logger.info("=== deleteTeacherOccupyTime: " + kzJskb.toString() + "\n=== flag: " + flag);
                if (flag == 0) {
                    // 占用失败
                    // 回滚之前的老师释放记录
                    int iMax = i;
                    int jMax = j;
                    for (i = 0; i < classDates.length; i++) {
                        for (j = 0; j < instructorIds.length; j++) {
                            int rowIndex = rows[j];
                            int colIndex = cols[j];
                            kzJskb = teacherOccupyService.createKzJskb(xnxqdm, classAll.getSchoolDistrictId().toString(), classAll.getStartWeek(),
                                    classAll.getEndWeek(), "0", colIndex + 1, rowIndex + 1, rowIndex + 1,
                                    instructorIds[j], classAll.getId().toString(), classAll.getId().toString());
                            flag = teacherOccupyService.addTeacherOccupyTime(kzJskb, classAll.getOperatorId(), classAll.getOperatorName());
                            logger.info("=== addTeacherOccupyTime: " + kzJskb.toString() + "\n=== flag: " + flag);
                            if (i == iMax && j == jMax) {
                                res.put("status", "error");
                                res.put("msg", "本科教务系统异常！");
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String[][] getDepartTimeTable(int departId, String academicYear, String classSemester) {
        List<ClassAll> classes = classAllDao.selectClassAll(departId, academicYear, classSemester, null,
                null, null, null);
        return constructTimetable(classes);
    }
}
