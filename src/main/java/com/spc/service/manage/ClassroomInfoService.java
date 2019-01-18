package com.spc.service.manage;

import com.spc.model.ClassroomInfo;

import java.util.List;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2018-12-30 20:47
 **/
public interface ClassroomInfoService {
    List<ClassroomInfo> getClassrooms(String schoolDistrictId, String classroomName);
}
