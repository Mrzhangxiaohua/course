package com.spc.service.grade;

import com.spc.dao.GradeDao;
import com.spc.model.GradeDomain;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface GradeService {
    public int insert(GradeDomain gradeDomain);

    public List<Map<String, Object>> selectGrade(Integer classId, String stuId);

    public int addScore(int classId, String stuId, int score);

    List<Map<String, Object>> selectGetTitle();

    void uploadAllGradeKnsk(String stuId,float grade);

    void uploadAllGradeXbsj(String stuId,float grade);

}
