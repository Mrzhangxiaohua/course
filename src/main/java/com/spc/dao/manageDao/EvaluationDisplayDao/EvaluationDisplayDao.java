package com.spc.dao.manageDao.EvaluationDisplayDao;

import com.spc.model.ClassDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EvaluationDisplayDao {

    List<Map<String, Object>> getAllClassEvaluation(@Param("classId") String classId);

    List<ClassDomain> getAllClasses();

    List<Map> evaluateCount(@Param("classId") String classId);

    int classUpperLimit(@Param("classId") String classId);
}
