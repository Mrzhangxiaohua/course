package com.spc.dao;

import com.spc.model.GradeDomain;
import com.spc.model.Oral;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OralDao {
    int insertOral(Oral oralItem);

    int deleteOral(@Param("id") String id, @Param("operatorId") String operatorId,@Param("operatorName") String operatorName);

    int updateOral(@Param("id") int id,@Param("teaId") String teaId,@Param("teaName") String teaName,
                   @Param("testTime") String time, @Param("examRoom") String examRoom,@Param("place") String place,
                   @Param("stuLimit") int stuLimit, @Param("operatorId") String operatorId,
                   @Param("operatorName") String operatorName);

    int insertOralChoose(@Param("stuId")String stuId,@Param("stuName") String stuName,@Param("oralId") int oralId);

    int addOralChoose(@Param("oralId")int oralId);

    Oral selectById(@Param("oralId") int oralId);

    int deleteOralChoose(@Param("stuId")String stuId,@Param("oralId") int oralId);

    List<Map<String, Object>> selectAllOral(@Param("currentSemester")String currentSemester);

    List<Map<String, Object>> selectStudentsByTeaId(@Param("currentSemester")String currentSemester,@Param("teaId") String teaId);
}
