package com.spc.dao.manageDao.TimeIntervalDao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface TimeIntervalDao {
    Map<String, Integer> getTimeInterval();

    int setTimeInterval(@Param("timeInterval") Integer timeInterval);
}
