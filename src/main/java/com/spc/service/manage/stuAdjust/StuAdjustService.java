package com.spc.service.manage.stuAdjust;

import org.json.JSONArray;

import java.util.List;
import java.util.Map;

public interface StuAdjustService {
    List<Map<String, Object>> getAllCourse(String CURRENTSEMESTER, String departId);

    int moveStudent(JSONArray stuId, Integer oldClassId, Integer newClassId);
}
