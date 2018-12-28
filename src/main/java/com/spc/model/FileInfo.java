package com.spc.model;

import org.joda.time.DateTime;

public class FileInfo {
    private int fileInfoId;
    private String fileName;
    private String path;
    private int type;
    private String userId;
    private String time;
    private String dep;
    private int flag;

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public int getFileInfoId() {
        return fileInfoId;
    }

    public void setFileInfoId(int fileInfoId) {
        this.fileInfoId = fileInfoId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setType(int type) { this.type = type; }

    public int getType() { return type; }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTime() { return time;  }

    public void setTime(String time) { this.time = time; }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
