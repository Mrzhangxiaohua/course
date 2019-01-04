package com.spc.service.wsdl.util;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description 上课时间
 * @create 2019-01-04 14:02
 **/
public class ClassDate {

    private int xq;
    private int ksjc;
    private int jsjc;

    public ClassDate(int xq, int ksjc, int jsjc) {
        this.xq = xq;
        this.ksjc = ksjc;
        this.jsjc = jsjc;
    }

    public int getXq() {
        return xq;
    }

    public void setXq(int xq) {
        this.xq = xq;
    }

    public int getKsjc() {
        return ksjc;
    }

    public void setKsjc(int ksjc) {
        this.ksjc = ksjc;
    }

    public int getJsjc() {
        return jsjc;
    }

    public void setJsjc(int jsjc) {
        this.jsjc = jsjc;
    }
}
