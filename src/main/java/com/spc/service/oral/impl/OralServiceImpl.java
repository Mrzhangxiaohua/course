package com.spc.service.oral.impl;

import com.spc.dao.OralDao;
import com.spc.model.Oral;
import com.spc.service.oral.OralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author Milingyun
 * @date 2019-03-12 15:18
 */

@Service
public class OralServiceImpl implements OralService {
    @Autowired
    OralDao oralDao;


    @Override
    public int removeOral(String id, String operatorId, String operatorName) {
        return oralDao.deleteOral(id,operatorId,operatorName);
    }

    @Override
    public int addOral(String teaId, String teaName, String time, String place, int stuLimit, int i, int i1, String currentSemester, String operatorId, String operatorName, String examRoom) {
        Oral oralItem=new Oral(teaId,teaName,time,place,stuLimit,0,1, currentSemester,operatorId,operatorName,examRoom);
        oralDao.insertOral(oralItem);
        return 0;
    }

    @Override
    public int updateOral(int id, String teaId, String teaName, String time, String examRoom, String place, int stuLimit, String operatorId, String operatorName) {
        return oralDao.updateOral(id,teaId,teaName,time,examRoom,place,stuLimit,operatorId,operatorName);
    }


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)//事务隔离，加锁
    public int chooseOral(String stuId, String stuName, int oralId) {
         Oral oral=oralDao.selectById(oralId);
         if(oral.getCurChoose()<oral.getStuLimit()){
             oralDao.addOralChoose(oralId);
             oralDao.insertOralChoose(stuId,stuName,oralId);
         }
        return 1;
    }

    @Override
    public int removeOralChoose(String stuId, int oralId) {
       return oralDao.deleteOralChoose(stuId,oralId);
    }

    @Override
    public List<Map<String,Object>> selectAllOral(String currentSemester) {
        return oralDao.selectAllOral(currentSemester);
    }

    @Override
    public List<Map<String, Object>> findOralStudentByTeaId(String currentSemester, String teaId) {
            return oralDao.selectStudentsByTeaId(currentSemester,teaId);
    }
}
