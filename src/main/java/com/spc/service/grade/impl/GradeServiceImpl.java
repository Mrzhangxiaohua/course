package com.spc.service.grade.impl;

import com.spc.controller.Base;
import com.spc.dao.GradeDao;
import com.spc.dao.GradePercentDao;
import com.spc.model.GradeDomain;
import com.spc.model.GradePercent;
import com.spc.service.grade.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GradeServiceImpl extends Base implements GradeService {
    @Autowired
    GradeDao gradeDao;

    @Autowired
    GradePercentDao getGradePercent;
    @Override
    public int insert(GradeDomain gradeDomain) {
        return gradeDao.insert(gradeDomain);
    }

    @Override
    public List<GradeDomain> selectGrade(Integer classId, String stuId) {
        //TODO 判断有几个模块，显示几个模块的成绩
        int part = 3;
        if (part == 3){
            // 1.获取学生选择的课程 2.
            List<GradeDomain> gradeList = gradeDao.selectGrade(classId, stuId);
            List<GradePercent> percents = getGradePercent.getGradePercent();
            for (int i = 0; i < gradeList.size(); i++) {
                String[] charGrade = gradeList.get(i).getGradeAll().split(",");
                // 成绩三个顺序是，WlzzxxGrade,XbsjGrade, KnskGrade
                gradeList.get(i).setWlzzxxGrade(Float.valueOf(charGrade[0]));
                gradeList.get(i).setXbsjGrade(Float.valueOf(charGrade[1]));
                gradeList.get(i).setKnskGrade(Float.valueOf(charGrade[2]));
                // 拿到百分比
                System.out.println(percents.get(0).getZZXX() + "=====" + percents.get(0).getXBSJ()+"=====" + percents.get(0).getKNSK());
                String pecent = String.valueOf(percents.get(0).getZZXX()) + "%" +
                                String.valueOf(percents.get(0).getXBSJ()) + "%" +
                                String.valueOf(percents.get(0).getKNSK()) + "%";
                gradeList.get(i).setPercent(pecent);
            }
            return gradeList;
        }else if (part == 5){

        }
        return null;
    }

    @Override
    public int addScore(int classId, String stuId, int score) {
        return gradeDao.addScore(stuId, classId, score);
    }


}
