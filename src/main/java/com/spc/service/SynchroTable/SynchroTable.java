package com.spc.service.SynchroTable;

import com.spc.model.ClassAll;
import com.spc.model.CourseAll;

public interface SynchroTable {
    int insertRecord(ClassAll classAll);

    int removeRecord(int id);

    int updateRecord(ClassAll classAll);
}
