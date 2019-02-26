package com.spc.service.SynchroTable;

import com.spc.model.ClassAll;

public interface SynchroTable {
    int insertRecord(ClassAll classAll);

    int removeRecord(int id);

    int updateRecord(ClassAll classAll);

    int insertRecord1(ClassAll classAll, Integer classID);
}
