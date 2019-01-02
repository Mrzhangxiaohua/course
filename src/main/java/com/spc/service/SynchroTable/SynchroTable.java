package com.spc.service.SynchroTable;

import com.spc.model.ClassAll;
import com.spc.model.CourseAll;

public interface SynchroTable {
    public int synchroTable(ClassAll classAll);
    public int removeRecord(int id);
    public int updateRecord(ClassAll classAll);
}
