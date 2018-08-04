create table Course
(
  classId              int auto_increment
    primary key,
  className            varchar(200) not null,
  classNum             int          not null,
  teaId                int          not null,
  teaName              varchar(200) not null,
  classGradePoint      int          not null,
  classChooseNum       int          not null,
  classUpperLimit      int          not null,
  classDateDescription varchar(200) not null,
  classPlace           varchar(200) not null,
  classLength          int          not null,
  classModuleNum       int          not null,
  departId             int          not null,
  startWeek            int          not null,
  endWeek              int          not null,
  classSemester        varchar(200) not null,
  courseInfo           varchar(200) not null,
  teacherInfo          varchar(200) not null,
  classTime            int          not null,
  mainLecturer         varchar(200) not null
)DEFAULT CHARSET = utf8
  engine = InnoDB;


INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('数据库', 2, 2018123003, '李三', 2, 3, 50, '4:1', 'B座501', 2, 1, 5, 2, 17, '2018春', '这是一门计算机基础课程', '教学经验丰富', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('c语言程序设计', 1, 2018100001, '张发', 1, 3, 20, '1:1', 'B座201', 2, 1, 5, 2, 17, '2018春', '这是一门计算机基础课程', '教学经验丰富', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('JAVA程序设计', 2, 2018122002, '于红茶', 2, 51, 50, '1:2', 'B座203', 2, 1, 12, 2, 17, '2018秋', '这是一门计算机基础课程', '教学经验丰富', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('c语言程序设计', 2, 2018100001, '张发', 1, 6, 20, '1:1', 'B座201', 2, 1, 5, 2, 17, '2018春', '这是一门计算机基础课程', '教学经验丰富', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('JAVA程序设计', 3, 2018122002, '于红茶', 2, 36, 40, '1:2', 'B座203B', 2, 1, 12, 3, 6, '2018秋', '这是一门外国语学院的课', '于洪潮老师真的很帅', 12, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('JAVA程序设计', 4, 2018122002, '于红茶', 2, 20, 50, '1:2', 'B座203', 2, 1, 12, 1, 8, '2018秋', '小于真的很棒棒哦', '于老师', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('JAVA程序设计', 1, 2018122002, '张发二', 2, 26, 50, '1:2', 'B座203', 2, 1, 12, 6, 13, '2018秋', '不吹不黑', '于老师', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('高级英语口语', 2, 2018122009, '张发九', 1, 3, 50, '3:1', 'B座401', 2, 3, 26, 2, 17, '2018春', '这是一门计算机基础课程', '教学经验丰富', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('马克思原理', 2, 2018123002, '李二', 2, 3, 50, '3:4', 'B座503', 2, 1, 14, 2, 17, '2018秋', '这是一门计算机基础课程', '教学经验丰富', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('物理', 2, 2018123009, '李十', 1, 2, 50, '5:3', 'A座401', 2, 1, 6, 2, 17, '2018春', '这是一门计算机基础课程', '教学经验丰富', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('高等数学', 2, 2018123008, '李九', 1, 4, 50, '5:2', 'A座303', 2, 1, 9, 2, 17, '2018春', '这是一门计算机基础课程', '教学经验丰富', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('VC++程序设计', 2, 2018123007, '李八', 2, 2, 50, '5:1', 'A座203', 2, 1, 5, 2, 17, '2018春', '这是一门计算机基础课程', '教学经验丰富', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('电子技术基础', 2, 2018123006, '李七', 2, 2, 50, '4:4', 'A座103', 2, 1, 5, 2, 17, '2018春', '这是一门计算机基础课程', '教学经验丰富', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('随机过程', 2, 2018123005, '李六', 2, 2, 50, '4:3', 'B座504', 2, 1, 9, 2, 17, '2018春', '这是一门计算机基础课程', '教学经验丰富', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('有机化学', 2, 2018124001, '赵一', 1, 3, 50, '5:4', 'A座403', 2, 1, 17, 2, 17, '2018春', '这是一门计算机基础课程', '教学经验丰富', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('英语写作', 2, 2018122008, '张发八', 2, 4, 50, '2:4', 'B座403', 2, 3, 26, 2, 17, '2018春', '这是一门计算机基础课程', '教学经验丰富', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('线性代数', 2, 2018122006, '张发六', 2, 4, 50, '2:2', 'B座302', 2, 1, 9, 2, 17, '2018秋', '这是一门计算机基础课程', '教学经验丰富', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('计算机网络', 2, 2018122005, '张发五', 2, 4, 50, '2:1', 'B座301', 2, 1, 5, 2, 17, '2018秋', '这是一门计算机基础课程', '教学经验丰富', 16, '老大');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('Big data and deep learning', 12, 0, '12', 12, 0, 12, '2:1', '12', 12, 1, 1, 12, 12, '1', '大数据', '张发是个好老师。', 12, '张发');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('张发', 12, 12, '12', 12, 0, 2, '1:1', '12', 12, 4, 7, 12, 12, '1', '12', '12', 12, '12');
INSERT INTO course.Course (className, classNum, teaId, teaName, classGradePoint, classChooseNum, classUpperLimit, classDateDescription, classPlace, classLength, classModuleNum, departId, startWeek, endWeek, classSemester, courseInfo, teacherInfo, classTime, mainLecturer) VALUES ('s', 12, 0, '12', 12, 0, 12, '1:1', '12', 12, 1, 1, 12, 12, '1', 'd', 'd', 3, 's');