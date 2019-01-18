package com.spc.model;

import java.util.Date;

public class TeacherInfo {
    private String JSBH;

    private String JSXM;

    private Integer XBM;

    private Date CSRQ;

    private String YXSH;

    private String XSMC;

    private String EMAIL;

    private String SFZH;

    private Integer STATU;

    private String JSGRZYCLJ;

    public String getJSBH() {
        return JSBH;
    }

    public void setJSBH(String JSBH) {
        this.JSBH = JSBH == null ? null : JSBH.trim();
    }

    public String getJSXM() {
        return JSXM;
    }

    public void setJSXM(String JSXM) {
        this.JSXM = JSXM == null ? null : JSXM.trim();
    }

    public Integer getXBM() {
        return XBM;
    }

    public void setXBM(Integer XBM) {
        this.XBM = XBM;
    }

    public Date getCSRQ() {
        return CSRQ;
    }

    public void setCSRQ(Date CSRQ) {
        this.CSRQ = CSRQ;
    }

    public String getYXSH() {
        return YXSH;
    }

    public void setYXSH(String YXSH) {
        this.YXSH = YXSH == null ? null : YXSH.trim();
    }

    public String getXSMC() {
        return XSMC;
    }

    public void setXSMC(String XSMC) {
        this.XSMC = XSMC == null ? null : XSMC.trim();
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL == null ? null : EMAIL.trim();
    }

    public String getSFZH() {
        return SFZH;
    }

    public void setSFZH(String SFZH) {
        this.SFZH = SFZH == null ? null : SFZH.trim();
    }

    public Integer getSTATU() {
        return STATU;
    }

    public void setSTATU(Integer STATU) {
        this.STATU = STATU;
    }

    public String getJSGRZYCLJ() {
        return JSGRZYCLJ;
    }

    public void setJSGRZYCLJ(String JSGRZYCLJ) {
        this.JSGRZYCLJ = JSGRZYCLJ == null ? null : JSGRZYCLJ.trim();
    }
}