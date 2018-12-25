package com.spc.model;

import java.util.Date;

public class GradePercent {
    private int gradePercentId;
    private int KNSK;
    private int XBSJ;
    private int ZZXX;
    private String userId;
    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getGradePercentId() {
        return gradePercentId;
    }

    public void setGradePercentId(int gradePercentId) {
        this.gradePercentId = gradePercentId;
    }

    public int getKNSK() {
        return KNSK;
    }

    public void setKNSK(int KNSK) {
        this.KNSK = KNSK;
    }

    public int getXBSJ() {
        return XBSJ;
    }

    public void setXBSJ(int XBSJ) {
        this.XBSJ = XBSJ;
    }

    public int getZZXX() {
        return ZZXX;
    }

    public void setZZXX(int ZZXX) {
        this.ZZXX = ZZXX;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
