package com.spc.service.manage.getTimeInterval.impl;

import com.spc.controller.Base;
import com.spc.dao.manageDao.TimeIntervalDao.TimeIntervalDao;
import com.spc.service.manage.getTimeInterval.GetTimeIntervalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description:
 * @Author: zf
 * @Date: 2019/8/28 21:51
 */
@Service
public class GetTimeIntervalImpl extends Base implements GetTimeIntervalService {

    @Autowired
    TimeIntervalDao timeIntervalDao;

    @Override
    public Map<String, Integer> getTimeInterval() {
        return timeIntervalDao.getTimeInterval();
    }

    @Override
    public int setTimeInterval(int timeInterval) {
        timeIntervalDao.setTimeInterval(timeInterval);
        return 0;
    }
}
