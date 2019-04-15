package com.spc.service.manage.evaluationDisplay;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/4/7 18:31
 */
public interface EvaluationDisplayService {

    Map<String, Object> getAllClassEvaluation(String classId);

    List<Map> getCascade();
}
