package com.spc.service.manage.impl;

import com.spc.dao.ClassroomInfoDao;
import com.spc.model.ClassroomInfo;
import com.spc.service.manage.ClassroomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomInfoServiceImpl implements ClassroomInfoService {

    @Autowired
    private ClassroomInfoDao classroomInfoDao;

    @Override
    public List<ClassroomInfo> getClassrooms(String schoolDistrictId, String classroomName) {
        return classroomInfoDao.selectAll(schoolDistrictId, classroomName);
    }

    @Override
    public int getClassRoomToSchoolDistrict(String classroomNameId) {
        return classroomInfoDao.getSchoolDistrict(classroomNameId);
    }
}
