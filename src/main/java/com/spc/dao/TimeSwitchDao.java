package com.spc.dao;

import org.apache.ibatis.annotations.Param;

public interface TimeSwitchDao {
    int add(@Param("timeSwitch") int timeSwitch);

    int updateTimeSwitch(@Param("timeSwitch") int timeSwitch);

    int get();
}
