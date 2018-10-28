package com.spc.model;

import java.io.Serializable;

public class ClassDomainWithId extends ClassDomain implements Serializable {
    private  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
