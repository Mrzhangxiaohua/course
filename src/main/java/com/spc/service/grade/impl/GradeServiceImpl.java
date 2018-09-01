package com.spc.service.grade.impl;

import com.spc.dao.GradeDao;
import com.spc.model.GradeDomain;
import com.spc.service.grade.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeDao gradeDao;

    @Override
    public int insert(GradeDomain gradeDomain) {
        return gradeDao.insert(gradeDomain);
    }

    @Override
    public List<GradeDomain> selectGrade(Integer classId, String stuId) {
        System.out.println(classId);
        System.out.println(stuId);
        return gradeDao.selectGrade(classId, stuId);
    }

    @Override
    public int addScore(int classId, String stuId, int score) {
        return gradeDao.addScore(stuId, classId, score);
    }


}
