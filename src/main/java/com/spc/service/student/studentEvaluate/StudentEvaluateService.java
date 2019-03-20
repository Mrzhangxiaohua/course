package com.spc.service.student.studentEvaluate;

import org.json.JSONArray;

import java.util.List;
import java.util.Map;

public interface StudentEvaluateService {
    List<Map<String, Object>> selectList(String stuId);

    int stuEvaluate(Integer classId, String stuId, JSONArray score1, JSONArray score2, JSONArray score3);
}
