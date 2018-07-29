package com.spc.dao;

import org.apache.ibatis.annotations.Param;

public interface IssueGradeDao {

    public int insert(@Param("classId") int classId,@Param("issueOrNot") int issurOrNot);
}
