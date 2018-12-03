package com.spc.dao;

import org.apache.ibatis.annotations.Param;

public interface SchoolCalendarDao {
     int insertCalendar(@Param("year")String year,@Param("semester") String semester,@Param("firstWeek") String firstWeek);
     int updateCalendarFlag();
}
