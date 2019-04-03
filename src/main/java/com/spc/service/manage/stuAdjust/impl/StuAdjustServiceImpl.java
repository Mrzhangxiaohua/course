package com.spc.service.manage.stuAdjust.impl;

import com.spc.controller.Base;
import com.spc.dao.manageDao.StuAdjustmentDao.StuAdjustDao;
import com.spc.service.manage.stuAdjust.StuAdjustService;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: zf
 * @Description:
 * @Date: 2019/1/24 15:17
 */

@Service
public class StuAdjustServiceImpl extends Base implements StuAdjustService {

    @Autowired
    private StuAdjustDao stuAdjustDao;

    @Override
    public List<Map<String, Object>> getAllCourse(String CURRENTSEMESTER, String departId) {
        // 根据学院，取出所有课程数据
        List<Map<String, Object>> getAllCourse = stuAdjustDao.getAllCourse(CURRENTSEMESTER, departId);
        return stuAdjustDao.getAllCourse(CURRENTSEMESTER, departId);
    }

    @Override
    public int moveStudent(JSONArray stuId, Integer oldClassId, Integer newClassId) {
        // 1.判断移动的人数是否小于容量数
        int stuIdLen = stuId.length();
        Map<String, Object> capacity= stuAdjustDao.findCapacity(newClassId);
        int leftCapacity = (int) capacity.get("classUpperLimit") - (int)capacity.get("classChooseNum");
        // 2.当移动数小于等于容量数，且当前班级不等于要移动到的班级，则可以插入
        if (stuIdLen <= leftCapacity && !oldClassId.equals(newClassId)){
            // 2.1 获取要更新的
            for (int i = 0; i < stuId.length(); i++){
                try {
                    String s = String.valueOf(stuId.get(i));
                    stuAdjustDao.moveStudent(s, oldClassId, newClassId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return 1; // 表示成功执行
        }
        return 0; // 错误执行
    }
}
