package com.spc.service.manage;

import com.spc.model.StudentApplicationDomain;

import java.util.List;

public interface ManageService {
    String[][] findClasses(Integer stuId);

    String[][] bigTable();
    List<StudentApplicationDomain> checkedMessage(int key);
}
