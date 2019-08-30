package com.spc.service.grade.impl;

import com.spc.controller.Base;
import com.spc.dao.GradeDao;
import com.spc.dao.GradePercentDao;
import com.spc.model.GradeDomain;
import com.spc.model.GradePercent;
import com.spc.service.grade.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
    public List<Map<String, Object>> selectGrade(Integer classId, String stuId) {
        //TODO 判断有几个模块，显示几个模块的成绩
        // 1. 获取模块和title，用于判断几个模块
//        List<Map<String, Object>> getTitle = gradeDao.selectGetTitle();
        List<Map<String, Object>> getGrade = gradeDao.getModelGrade(stuId);
        // 2. 获取学生的各个模块的成绩成绩
        return getGrade;
    }

    // 获取模块
    @Override
    public List<Map<String, Object>> selectGetTitle() {
        List<Map<String, Object>> getTitle = gradeDao.selectGetTitle();
        List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < getTitle.size(); i++) {
            Map<String, Object> data = new HashMap<>();
            String model = (String) getTitle.get(i).get("model") + getTitle.get(i).get("gradePercentage") + "%";
            data.put("title", model);
            String modelEng = (String) getTitle.get(i).get("modelEng");
            data.put("dataIndex", modelEng);
            logger.info(String.valueOf(data));
            res.add(data);
        }
        Map<String, Object> gradeAll = new HashMap<>();
        gradeAll.put("title","总成绩");
        gradeAll.put("dataIndex","gradeAll");
        res.add(gradeAll);
        logger.info("=======================" + res);
        return res;
    }

    @Override
    public void uploadAllGradeKnsk(String stuId, Float grade) {
        gradeDao.uploadAllGradeKnsk(stuId,grade);
    }

    @Override
    public void uploadAllGradeXbsj(String stuId, float grade) {
        gradeDao.uploadAllGradeXbsj(stuId,grade);
    }


    @Override
    public int addScore(int classId, String stuId, int score) {
        return gradeDao.addScore(stuId, classId, score);
    }


}
