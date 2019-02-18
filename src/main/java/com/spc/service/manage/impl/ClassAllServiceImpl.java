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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 排课Service
 *
 * @author yzk
 * @date 2018-12-25
 */
@Service
public class ClassAllServiceImpl extends Base implements ClassAllService {

    /**
     * 每天一共13个学时, 4+2+4+3
     */
    private static final int CLASS_HOURS_PER_DAY = 13;
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

    private static final String CONFLICT_FLAG_TEACHER = "teacher";
    private static final String CONFLICT_FLAG_CLASSROOM = "classroom";

    @Autowired
    private ClassAllDao classAllDao;

    @Autowired
    private TeacherCurriculumInfo teacherCurriculumInfoService;

    @Autowired
    private GetUndergradFreeClassroomInfo freeClassroomService;

    @Autowired
    private ClassroomOccupy classroomOccupyService;

    @Autowired
    private TeacherOccupy teacherOccupyService;

    @Autowired
    private SynchroTable synchroTableService;

    @Override
    public List<ClassAll> getClassAll(Integer departId, String academicYear, String classSemester, String courseId,
                                      String courseName, String teacherId, String teacherName, String classPlaceId) {
        return classAllDao.selectClassAll(departId, academicYear, classSemester, courseId, courseName, teacherId, teacherName, classPlaceId);
    }


    @Override
    public String[][] getTeacherTimetable(String teacherId, String academicYear, String classSemester) {
        List<ClassAll> classes = classAllDao.selectClassAll(null, academicYear, classSemester, null,
                null, teacherId, null, null);
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
                sb.append("\n周次：").append(c.getStartWeek()).append("-").append(c.getEndWeek());
                sb.append("\n班级：").append(c.getClassName());
                timetable[i][j] = timetable[i][j] == null ? sb.toString() : timetable[i][j] + "\n\n" + sb.toString();
            }
        }

        return timetable;
    }

    @Transactional
    @Override
    public Map<String, String> scheduleClass(ClassAll c) {
        Map<String, String> res = new HashedMap<>();
        StringBuilder msgBuilder = new StringBuilder();
        StringBuilder conflictDescBuilder = new StringBuilder();
        // 用于标记冲突状态
        Map<String, Boolean> conflictFlag = new HashMap<>();
        conflictFlag.put(CONFLICT_FLAG_TEACHER, false);
        conflictFlag.put(CONFLICT_FLAG_CLASSROOM, false);

        // 上课时间
        String[] classDates = c.getClassDateDesc().split(ARRAY_SPLIT_CHAR);
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

        // 1. 校验班级名称冲突
        if (checkClassName(c, res, msgBuilder)) {
            return res;
        }

        // 2. 校验老师时间冲突
        String[] instructorIds = c.getInstructorId().split(ARRAY_SPLIT_CHAR);
        String[] instructorNames = c.getInstructorName().split(ARRAY_SPLIT_CHAR);

        // 2.1 校验老师已排课程时间冲突

        if (checkGraduateCourseTime(c, res, msgBuilder, conflictDescBuilder, timetableTFT, instructorIds, instructorNames, conflictFlag)) {
            return res;
        }

        // 2.2 校验本科时间冲突
        if (checkUndergraduateCourseTime(c, res, msgBuilder, conflictDescBuilder, timetableTFT, instructorIds, instructorNames, conflictFlag)) {
            return res;
        }

        // 3. 校验上课地点冲突
        if (c.getClassPlaceId() != null && !c.getClassPlaceId().isEmpty()) { // 会议室无id不判断冲突
            // 3.1 校验已排课程地点的冲突
            if (checkGraduateCoursePlace(c, res, msgBuilder, conflictDescBuilder, timetableTFT, conflictFlag)) {
                return res;
            }
            // 3.2 校验本科课程地点的冲突
            if (checkUndergraduateCoursePlace(c, res, msgBuilder, conflictDescBuilder, rows, cols, conflictFlag)) {
                return res;
            }
        }
        // 冲突状态
        c.setConflictDesc(conflictDescBuilder.toString());
        c.setScheduled(1);

        // 如果没有冲突，则保存对应的记录
        if (c.getId() != null) {
            ClassAll oldClass = classAllDao.selectClassAllById(c.getId());
            // 清空原有占用信息
            boolean freeFlag = freeClassroomAndTeacher(oldClass, res);
            if (!freeFlag) {
                return res;
            }

            // 修改记录
            int count = classAllDao.updateClass(c);
            // TODO CHECK
            synchroTableService.updateRecord(c);

            logger.info("updateClass: " + c.toString());

            // 先占用本科教务系统的老师、地点的相应时间
            // 1. 地点占用
            // 1.1 先判断是否有地点冲突,若有地点冲突，则跳过。------
            if (conflictFlag.get("classroom") == true){
                // 如果为空，则什么都不执行，只保存即可
            }else {// 没有强制，则进行webservervice占用
                if (useClassroom(c, res, rows, cols, false)) {
                    return res;
                }
            }
            // ---------------------------------------------------
//            if (useClassroom(c, res, rows, cols, false)) {
//                return res;
//            }

            // 2. 老师占用
            // ---------------------------------------------------
            if (conflictFlag.get("teacher") == true){
                // 如果为空，则什么都不执行，只保存即可
            }else {
                if (useTeacherTime(c, res, rows, cols, instructorIds, false)) {
                    return res;
                }
            }
            // ---------------------------------------------------
//            if (useTeacherTime(c, res, rows, cols, instructorIds, false)) {
//                return res;
//            }

            if (count > 0) {
                res.put("status", "success");
                res.put("msg", "提交成功！");
            } else {
                res.put("status", "error");
                res.put("msg", "提交失败，请重试！");
            }
        } else {
            // 新增记录
            int count = classAllDao.insertClass(c);
            // TODO CHECK
            synchroTableService.insertRecord(c);

            logger.info("insertClass: " + c.toString());
            if (count > 0) {
                // 先占用本科教务系统的老师、地点的相应时间
                // 1. 地点占用 ------------------------------
                if (conflictFlag.get("classroom") == true){
                    // 如果为空，则什么都不执行，只保存即可
                }else {// 没有强制，则进行webservervice占用
                    if (useClassroom(c, res, rows, cols, false)) {
                        return res;
                    }
                }
                // -----------------------------------------
//                if (useClassroom(c, res, rows, cols, true)) {
//                    return res;
//                }
                // 2. 老师占用 ------------------------------
                if (conflictFlag.get("teacher") == true){
                    // 如果为空，则什么都不执行，只保存即可
                }else {
                    if (useTeacherTime(c, res, rows, cols, instructorIds, false)) {
                        return res;
                    }
                }
                // -------------------------------------

//                if (useTeacherTime(c, res, rows, cols, instructorIds, true)) {
//                    return res;
//                }

                res.put("status", "success");
                res.put("msg", "提交成功！");
            } else {
                res.put("status", "error");
                res.put("msg", "提交失败，请重试！");
            }
        }
        return res;
    }

    private boolean useTeacherTime(ClassAll classAll, Map<String, String> res, int[] rows, int[] cols, String[] instructorIds, boolean del) {
        for (int i = 0; i < rows.length; i++) {
            int rowIndex = rows[i];
            int colIndex = cols[i];
            //若为强制排课，则不调用webServer
            for (int j = 0; j < instructorIds.length; j++) {
                int classHour = getClassHour(rowIndex);
                KzJskb kzJskb = teacherOccupyService.createKzJskb(classAll.getAcademicYear(), classAll.getClassSemester(),
                        classAll.getSchoolDistrictId().toString(), classAll.getStartWeek(), classAll.getEndWeek(),
                        colIndex + 1, classHour, classHour, instructorIds[j], classAll.getId().toString(), classAll.getId().toString());
                int flag = teacherOccupyService.addTeacherOccupyTime(kzJskb, classAll.getOperatorId(), classAll.getOperatorName());
                logger.info("=== addTeacherOccupyTime: " + kzJskb.toString() + "\n=== flag: " + flag);

                if (flag == 0) {
                    // 占用失败
                    // 回滚之前的老师占用记录
                    int iMax = i;
                    int jMax = j;
                    for (i = 0; i < rows.length; i++) {
                        for (j = 0; j < instructorIds.length; j++) {
                            rowIndex = rows[j];
                            colIndex = cols[j];
                            kzJskb = teacherOccupyService.createKzJskb(classAll.getAcademicYear(), classAll.getClassSemester(),
                                    null, null, null, null, null, null,
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
        classAll.setClassName("1班");
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

    /**
     * @param classAll
     * @param res
     * @param rows
     * @param cols
     * @param del      占用失败时，是否删除刚才插入的班级记录
     * @return
     */
    private boolean useClassroom(ClassAll classAll, Map<String, String> res, int[] rows, int[] cols, boolean del) {
        if (classAll.getClassPlaceId() == null || classAll.getClassPlaceId().isEmpty()) {
            return false;
        }
        ClassRoomUsed[] classRoomUseds = new ClassRoomUsed[rows.length];
        logger.info("=== useClassroom start ===");
        for (int i = 0; i < rows.length; i++) {
            int rowIndex = rows[i];
            int colIndex = cols[i];
            int classHour = getClassHour(rowIndex);

            // 占用教室时间，若强制排课，则不应该执行webservice
            ClassRoomUsed classRoomUsed = classroomOccupyService.createClassRoomUsed(classAll.getAcademicYear(), classAll.getClassSemester(),
                    classAll.getSchoolDistrictId().toString(), classAll.getStartWeek(), classAll.getEndWeek(), colIndex + 1, classHour, classHour,
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
     * @param c
     * @param res
     * @param msgBuilder
     * @param conflictDescBuilder
     * @param timetableTFT
     * @return
     */
    private boolean checkGraduateCoursePlace(ClassAll c, Map<String, String> res, StringBuilder msgBuilder, StringBuilder conflictDescBuilder, boolean[][] timetableTFT, Map<String, Boolean> conflictFlag) {
        int conflictDescOldLength = conflictDescBuilder.toString().length();
        List<ClassAll> classAllList = classAllDao.selectClassAllExcludeId(c.getAcademicYear(),
                c.getClassSemester(), null, c.getClassPlaceId(), 1, c.getId());
        if (!CollectionUtils.isEmpty(classAllList)) {
            for (ClassAll currentClass : classAllList) {
                // Step1: 周次重叠判断
//                if (currentClass.getEndWeek() < c.getStartWeek() || currentClass.getStartWeek() > c.getEndWeek()) {
//                    continue;
//                }
                for (int j = 0; j < currentClass.getClassWeeks().length(); j++) { // 此处有26长度和10几周
                    if(c.getClassWeeks().charAt(j) == currentClass.getClassWeeks().charAt(j)){
                        continue;
                    }
                }

                // Step2: 上课时间冲突判断
                String[] currentClassDates = currentClass.getClassDateDesc().split(ARRAY_SPLIT_CHAR);
                for (int j = 0; j < currentClassDates.length; j++) {
                    String[] indexes = currentClassDates[j].split(INDEX_SPLIT_CHAR);
                    int rowIndex = Integer.parseInt(indexes[0]);
                    int colIndex = Integer.parseInt(indexes[1]);
                    if (timetableTFT[rowIndex][colIndex]) {
                        msgBuilder.append("该上课时间与").append(currentClass.getInstructorName()).append("老师的").
                                append((currentClass.getCourseNameCHS() != null ? currentClass.getCourseNameCHS() : currentClass.getCourseNameEN())).
                                append(currentClass.getClassName()).append("上课地点冲突！\n");
                        conflictDescBuilder.append("p-").append("g").append("-").append(currentClass.getId()).append(ARRAY_SPLIT_CHAR);
                        logger.info(msgBuilder.toString());
                        logger.info(conflictDescBuilder.toString());
                        break;
                    }
                }
            }
        }
        // ----------------------------------------------
        if (c.getForce() == true && !checkMsg(c.getForce(), res, msgBuilder, conflictFlag, CONFLICT_FLAG_CLASSROOM, conflictDescBuilder.toString().length() > conflictDescOldLength)){
            conflictFlag.put("classroom", true);
            return false;
        }
        // ----------------------------------------------

        if (checkMsg(c.getForce(), res, msgBuilder, conflictFlag, CONFLICT_FLAG_CLASSROOM, conflictDescBuilder.toString().length() > conflictDescOldLength)) {
            return true;
        }
        return false;
    }

    /**
     * 校验本科上课地点的冲突
     */
    private boolean checkUndergraduateCoursePlace(ClassAll c, Map<String, String> res, StringBuilder msgBuilder, StringBuilder conflictDescBuilder, int[] rows, int[] cols, Map<String, Boolean> conflictFlag) {
        int conflictDescOldLength = conflictDescBuilder.toString().length();
        SpareClassRoom[] rooms = new SpareClassRoom[rows.length];
        for (int i = 0; i < rows.length; i++) {
            int classHour = getClassHour(rows[i]);
            SpareClassRoom room = freeClassroomService.createSparseClassRoom(c.getAcademicYear(), c.getClassSemester(),
                    c.getStartWeek(), c.getEndWeek(), cols[i] + 1, classHour, classHour);
            rooms[i] = room;
        }
        String freeRoomIds = freeClassroomService.getFreeClassrooms(rooms, c.getOperatorId(), c.getOperatorName());
        if (freeRoomIds == null || freeRoomIds.isEmpty()) {
            logger.info("目前教室已全被本科课程占用，或数据存在异常，请联系管理员！");
            msgBuilder.append("目前教室已全被本科课程占用，或数据存在异常，请联系管理员！\n");
            conflictDescBuilder.append("p-").append("u").append(ARRAY_SPLIT_CHAR);
            logger.info(msgBuilder.toString());
            logger.info(conflictDescBuilder.toString());
            // ---------------------------
            if (c.getForce() == true && !checkMsg(c.getForce(), res, msgBuilder, conflictFlag, CONFLICT_FLAG_CLASSROOM, conflictDescBuilder.toString().length() > conflictDescOldLength)){
                conflictFlag.put("classroom", true);
                return false;
            }
            // ---------------------------
            if (checkMsg(c.getForce(), res, msgBuilder, conflictFlag, CONFLICT_FLAG_CLASSROOM, conflictDescBuilder.toString().length() > conflictDescOldLength)) {
                return true;
            }
        } else {
            String[] freeRoomIdsArray = freeRoomIds.split(ARRAY_SPLIT_CHAR);
            boolean valid = false;
            for (int i = 0; i < freeRoomIdsArray.length; i++) {
                if (freeRoomIdsArray[i].equals(c.getClassPlaceId())) {
                    valid = true;
                    break;
                }
            }
            if (!valid) {
                msgBuilder.append("该教室已被本科课程占用，请选择其他教室！\n");
                conflictDescBuilder.append("p-").append("u").append(ARRAY_SPLIT_CHAR);
                logger.info(msgBuilder.toString());
                logger.info(conflictDescBuilder.toString());
                // ---------------------------
                if (c.getForce() == true && !checkMsg(c.getForce(), res, msgBuilder, conflictFlag, CONFLICT_FLAG_CLASSROOM, conflictDescBuilder.toString().length() > conflictDescOldLength)){
                    conflictFlag.put("classroom", true);
                    return false;
                }
                // ---------------------------
                if (checkMsg(c.getForce(), res, msgBuilder, conflictFlag, CONFLICT_FLAG_CLASSROOM, conflictDescBuilder.toString().length() > conflictDescOldLength)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 校验已排课程时间冲突
     *
     * @param c
     * @param res
     * @param msgBuilder
     * @param conflictDescBuilder
     * @param timetableTFT
     * @param instructorIds
     * @return
     */
    private boolean checkGraduateCourseTime(ClassAll c, Map<String, String> res, StringBuilder msgBuilder, StringBuilder conflictDescBuilder, boolean[][] timetableTFT, String[] instructorIds, String[] instructorNames, Map<String, Boolean> conflictFlag) {
        int conflictDescOldLength = conflictDescBuilder.toString().length();
        for (int i = 0; i < instructorIds.length; i++) {
            List<ClassAll> classAllList = classAllDao.selectClassAllExcludeId(c.getAcademicYear(), c.getClassSemester(), instructorIds[i], null, 1, c.getId());
            if (!classAllList.isEmpty()) {
                for (ClassAll currentClass : classAllList) {
                    // Step1: 周次重叠判断
                    for (int j = 0; j < currentClass.getClassWeeks().length(); j++) { // 此处有26长度和10几周
                        if(c.getClassWeeks().charAt(j) == currentClass.getClassWeeks().charAt(j)){
                            continue;
                        }
                    }
//                    System.out.println(sb);
//                    if (currentClass.getEndWeek() < c.getStartWeek() || currentClass.getStartWeek() > c.getEndWeek()) {
//                        continue;
//                    }
                    // Step2: 上课时间冲突判断
                    String[] currentClassDates = currentClass.getClassDateDesc().split(ARRAY_SPLIT_CHAR);
                    for (int j = 0; j < currentClassDates.length; j++) {
                        String[] indexes = currentClassDates[j].split(INDEX_SPLIT_CHAR);
                        int rowIndex = Integer.parseInt(indexes[0]);
                        int colIndex = Integer.parseInt(indexes[1]);
                        if (timetableTFT[rowIndex][colIndex]) {
                            msgBuilder.append("该上课时间与").append(instructorNames[i]).append("老师的").
                                    append((currentClass.getCourseNameCHS() != null ? currentClass.getCourseNameCHS() : currentClass.getCourseNameEN())).
                                    append(currentClass.getClassName()).append("授课时间冲突！\n");
                            conflictDescBuilder.append("t-").append("g").append("-").append(currentClass.getInstructorId()).
                                    append("-").append(currentClass.getInstructorName()).append("-").append(currentClass.getId()).append(ARRAY_SPLIT_CHAR);
                            logger.info(msgBuilder.toString());
                            logger.info(conflictDescBuilder.toString());
                            break;
                        }
                    }
                }
            }
        }
        // j-----------------------------------------------------如果强制排课，并且判断有教师冲突，则记录冲突类型，并继续执行
        if (c.getForce() == true && !checkMsg(c.getForce(), res, msgBuilder, conflictFlag, CONFLICT_FLAG_TEACHER, conflictDescBuilder.toString().length() > conflictDescOldLength)){
            conflictFlag.put("teacher", true);
            return false;
        }
        // ------------------------------------------------------
        if (checkMsg(c.getForce(), res, msgBuilder, conflictFlag, CONFLICT_FLAG_TEACHER, conflictDescBuilder.toString().length() > conflictDescOldLength)) {
            return true;
        }
        return false;
    }

    /**
     * 校验本科课程时间冲突
     *
     * @param c
     * @param res
     * @param msgBuilder
     * @param conflictDescBuilder
     * @param timetableTFT
     * @param instructorIds
     * @param instructorNames
     * @param conflictFlag
     * @return
     */
    private boolean checkUndergraduateCourseTime(ClassAll c, Map<String, String> res, StringBuilder msgBuilder, StringBuilder conflictDescBuilder, boolean[][] timetableTFT, String[] instructorIds, String[] instructorNames, Map<String, Boolean> conflictFlag) {
        int conflictDescOldLength = conflictDescBuilder.toString().length();
        instructors:
        for (int i = 0; i < instructorIds.length; i++) {
            List<TeacherOccupyTime> teacherOccupyTimes = teacherCurriculumInfoService.
                    queryTeacherOccupyTime(c.getOperatorId(), c.getOperatorName(), instructorIds[i], c.getAcademicYear(), c.getClassSemester());
            if (!CollectionUtils.isEmpty(teacherOccupyTimes)) {
                // Step1: 周次重叠判断
                occupyTimes:
                for (TeacherOccupyTime teacherOccupyTime : teacherOccupyTimes) {
                    logger.info(teacherOccupyTime.toString());
                    if (teacherOccupyTime.getWeeks() == null || teacherOccupyTime.getWeeks().length() == 0) {
                        continue;
                    }
                    weeks:
                    for (int j = c.getStartWeek() - 1; j < c.getEndWeek() && j < teacherOccupyTime.getWeeks().length(); j++) {
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
        // --------------------------------------
        if (c.getForce() == true && !checkMsg(c.getForce(), res, msgBuilder, conflictFlag, CONFLICT_FLAG_TEACHER, conflictDescBuilder.toString().length() > conflictDescOldLength)){
            conflictFlag.put("teacher", true);
            return false;
        }
        // ----------------------------------------
        if (checkMsg(c.getForce(), res, msgBuilder, conflictFlag, CONFLICT_FLAG_TEACHER, conflictDescBuilder.toString().length() > conflictDescOldLength)) {
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
        int count = classAllDao.countClassAllByClassNameExcludeId(classAll.getAcademicYear(), classAll.getClassSemester(),
                classAll.getCourseId(), classAll.getSchoolDistrictId(), classAll.getClassName(), classAll.getId());
        if (count > 0) {
            msgBuilder.append("在").append(classAll.getAcademicYear()).append(classAll.getClassSemester()).append(",");
            msgBuilder.append(classAll.getClassName()).append("已存在，请修改所属校区或修改班级名称！");

            // 该班级已存在，返回错误信息，提示修改
            res.put("status", "error");
            res.put("msg", msgBuilder.toString());
            return true;
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
    private boolean checkMsg(boolean force, Map<String, String> res, StringBuilder msgBuilder,Map<String, Boolean> conflictFlag, String conflictFlagKey, boolean conflictAdd) {
        String msg = msgBuilder.toString();
        // 非强制情况下，直接返回冲突信息
        if (!msg.isEmpty()) {
            res.put("status", "error");
            res.put("msg", msg);

            // update conflict flag
            if (conflictAdd) {
                conflictFlag.put(conflictFlagKey, true);
            }

            // 非强制情况下，直接返回冲突信息
            if (!force) {
                return true;
            } else {
                return false;
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

        boolean freeFlag = freeClassroomAndTeacher(classAll, res);
        if (!freeFlag) {
            return res;
        }

        int count = classAllDao.countClassAllByClassNameExcludeId(classAll.getAcademicYear(),
                classAll.getClassSemester(), classAll.getCourseId(), null, null, null);

        int updateCount;
        if (count > 1) {
            // del
            updateCount = classAllDao.delClassAllById(id);
        } else {
            // clear scheduled field
            updateCount = classAllDao.clearClassAllById(id, operatorId, operatorName);
        }

        if (updateCount > 0) {
            res.put("status", "success");
        } else {
            res.put("status", "error");
            res.put("msg", "数据删除异常，请重试！");
            return res;
        }

        if (count > 1) {
            // TODO CHECK
            synchroTableService.removeRecord(id);
        } else {
            clearUnusedField(classAll);
            synchroTableService.updateRecord(classAll);
        }
        return res;
    }

    private boolean freeClassroomAndTeacher(ClassAll c, Map<String, String> res) {
        if (c.getScheduled() == 0) {
            return true;
        }
        // 释放教室和老师的时间占用
        String[] classDates = c.getClassDateDesc().split(ARRAY_SPLIT_CHAR);
        int[] rows = new int[classDates.length];
        int[] cols = new int[classDates.length];
        for (int i = 0; i < classDates.length; i++) {
            String[] temp = classDates[i].split(INDEX_SPLIT_CHAR);
            int rowIndex = Integer.parseInt(temp[0]);
            int colIndex = Integer.parseInt(temp[1]);
            rows[i] = rowIndex;
            cols[i] = colIndex;
        }

        // 释放地点
        if (c.getClassPlaceId() != null && !c.getClassPlaceId().isEmpty()) {
            ClassRoomUsed[] classRoomUseds = new ClassRoomUsed[classDates.length];
            logger.info("=== freeClassroom start ===");
            for (int i = 0; i < classDates.length; i++) {
                int rowIndex = rows[i];
                int colIndex = cols[i];
                int classHour = getClassHour(rowIndex);
                ClassRoomUsed classRoomUsed = classroomOccupyService.createClassRoomUsed(c.getAcademicYear(), c.getClassSemester(), c.getSchoolDistrictId().toString(),
                        c.getStartWeek(), c.getEndWeek(), colIndex + 1, classHour, classHour,
                        c.getClassPlaceId(), c.getId().toString(), c.getId().toString());
                classRoomUseds[i] = classRoomUsed;
                logger.info("=== delUsedClassroom: " + classRoomUsed.toString());
            }
            int flag = classroomOccupyService.delUsedClassroom(classRoomUseds, c.getOperatorId(), c.getOperatorName());
            logger.info("=== freeClassroom end, flag: " + flag + "===");

            if (flag == 0) {
                res.put("status", "error");
                res.put("msg", "本科教务系统异常！");
                return false;
            }
        }

        // 释放老师时间资源
        String[] instructorIds = c.getInstructorId().split(ARRAY_SPLIT_CHAR);
        for (int i = 0; i < classDates.length; i++) {
            for (int j = 0; j < instructorIds.length; j++) {
                KzJskb kzJskb = teacherOccupyService.createKzJskb(c.getAcademicYear(), c.getClassSemester(),
                        null, null, null, null, null, null,
                        instructorIds[j], c.getId().toString(), c.getId().toString());
                int flag = teacherOccupyService.deleteTeacherOccupyTime(kzJskb, c.getOperatorId(), c.getOperatorName());
                logger.info("=== deleteTeacherOccupyTime: " + kzJskb.toString() + "\n=== flag: " + flag);
                if (flag == 0) {
                    // 释放失败
                    // 回滚之前的老师释放记录，重新占用
                    int iMax = i;
                    int jMax = j;
                    for (i = 0; i < classDates.length; i++) {
                        for (j = 0; j < instructorIds.length; j++) {
                            int rowIndex = rows[j];
                            int colIndex = cols[j];
                            int classHour = getClassHour(rowIndex);
                            kzJskb = teacherOccupyService.createKzJskb(c.getAcademicYear(), c.getClassSemester(),
                                    c.getSchoolDistrictId().toString(), c.getStartWeek(),
                                    c.getEndWeek(), colIndex + 1, classHour, classHour,
                                    instructorIds[j], c.getId().toString(), c.getId().toString());
                            flag = teacherOccupyService.addTeacherOccupyTime(kzJskb, c.getOperatorId(), c.getOperatorName());
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
        List<ClassAll> classes = classAllDao.selectClassAll(departId, academicYear, classSemester, null, null,
                null, null, null);
        return constructTimetable(classes);
    }

    /**
     * 获取上课节次，和本科教务系统同步
     *
     * @param rowIndex
     * @return
     */
    private int getClassHour(int rowIndex) {
        // 上午
        if (rowIndex < 4) {
            return rowIndex + 1;
        }
        // 中午 N1: 21, N2: 22
        if (rowIndex < 6) {
            return rowIndex + 17;
        }
        // 下午及晚上
        return rowIndex - 1;
    }
}
