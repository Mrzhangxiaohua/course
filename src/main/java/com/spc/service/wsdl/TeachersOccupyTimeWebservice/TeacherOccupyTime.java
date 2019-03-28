package com.spc.service.wsdl.TeachersOccupyTimeWebservice;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description
 * @create 2018-12-31 14:49
 **/
public class TeacherOccupyTime {
    /**
     *  教室代码
     */
    private String jasdm;
    /**
     * 上课周次字符串，1表示有课，下标表示（第几周 - 1），
     */
    private String weeks;
    /**
     * 周几有课，用自0开始的下标表示，周一时为0，周二时为1
     */
    private int dayIndex;
    /**
     * 第几节课开始，下标自0开始
     */
    private int hourStartIndex;
    /**
     * 第几节课结束，下标自0开始
     */
    private int hourEndIndex;


    public TeacherOccupyTime(String jasdm, String weeks, int dayIndex, int hourStartIndex, int hourEndIndex) {
        this.jasdm = jasdm;
        this.weeks = weeks;
        this.dayIndex = dayIndex;
        this.hourStartIndex = hourStartIndex;
        this.hourEndIndex = hourEndIndex;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }

    public int getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    public int getHourStartIndex() {
        return hourStartIndex;
    }

    public void setHourStartIndex(int hourStartIndex) {
        this.hourStartIndex = hourStartIndex;
    }

    public int getHourEndIndex() {
        return hourEndIndex;
    }

    public void setHourEndIndex(int hourEndIndex) {
        this.hourEndIndex = hourEndIndex;
    }

    public String getJasdm() {
        return jasdm;
    }

    public void setJasdm(String jasdm) {
        this.jasdm = jasdm;
    }

    @Override
    public String toString() {
        return "TeacherOccupyTime{" +
                "jasdm=" + jasdm +
                ", weeks='" + weeks + '\'' +
                ", dayIndex=" + dayIndex +
                ", hourStartIndex=" + hourStartIndex +
                ", hourEndIndex=" + hourEndIndex +
                '}';
    }
}
