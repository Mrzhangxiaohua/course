package com.spc.model;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description IceSelectDataSource
 * @create 2018-12-29 20:43
 **/
public class IceSelectDataSource {
    private String value;
    private String label;
    private boolean disabled;

    public IceSelectDataSource(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public IceSelectDataSource(String value, String label, boolean disabled) {
        this.label = label;
        this.value = value;
        this.disabled = disabled;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
