package com.spc.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface TimeSwitchDao {
    int add(@Param("timeSwitch") int timeSwitch);

    int updateTimeSwitch(@Param("timeSwitch") int timeSwitch);
    int updateTimeSwitch2( @Param("startDate") String startDate,  @Param("endDate") String  endDate);

    Map get2();
    int get();
}
