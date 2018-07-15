package com.spc.service.grade;

import com.spc.dao.GradeDao;
import com.spc.model.GradeDomain;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GradeService {
    public int insert(GradeDomain gradeDomain);
    public List<GradeDomain> selectGrade (Integer classId, Integer stuId);
    public int addScore(int classId,int stuId,int score);

}
