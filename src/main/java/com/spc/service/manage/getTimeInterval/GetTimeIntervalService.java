package com.spc.service.manage.getTimeInterval;

import java.util.Map;

public interface GetTimeIntervalService {
    Map<String, Integer> getTimeInterval();

    int setTimeInterval(int timeInterval);
}
