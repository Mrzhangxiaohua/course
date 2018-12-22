package com.spc.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FileInfoDao {
    List<Map<String,Object>> selectTemplateFile();

    int insertFileInfo(@Param("teaId") String teaId,@Param("fileName") String fileName,@Param("path") String path, @Param("time") String date);
}
