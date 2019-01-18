package com.spc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassDomainWithId extends ClassDomain implements Serializable {
    private  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        List<Map<String, Object>> li = new ArrayList<>();
        Map<String, Object> m1 = new HashMap<>();
        Map<String, Object> m2 = new HashMap<>();
        m1.put("commentFlag", 1);
        m2.put("commentFlag", 2);
        li.add(m1);
        li.add(m2);
        System.out.println(li);
        for ( Map<String, Object> m : li){
            int k = (int) m.get("commentFlag");
            System.out.println(k);
        }
    }
}
