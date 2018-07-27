package com.spc.service.manage;

import com.spc.model.StudentApplicationDomain;

import java.util.Date;
import java.util.List;

public interface ManageService {
    String[][] findClasses(Integer stuId);

    String[][] bigTable();
    List<StudentApplicationDomain> checkedMessage(int key,int stuId);

    int makeSure(int id);
    int reject(int id);
}
