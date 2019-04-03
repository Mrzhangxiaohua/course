package com.spc.service.oral;

import com.spc.model.Oral;

import java.util.List;
import java.util.Map;

/**
 * @author Milingyun
 * @date 2019-03-12 15:18
 */
public interface OralService {


    int removeOral(String id, String operatorId, String operatorName);

    int addOral(String teaId, String teaName, String time, String place, int stuLimit, int i, int i1, String currentsemester, String operatorId, String operatorName, String examRoom);

    int updateOral(int id, String teaId, String teaName, String time, String examRoom, String place, int stuLimit, String operatorId, String operatorName);

    int chooseOral(String stuId, String stuName, int oralId);

    int removeOralChoose(String stuId, int oralId);

    List<Map<String,Object>> selectAllOral(String currentSemester);

    List<Map<String, Object>> findOralStudentByTeaId(String currentSemester, String teaId);
}
