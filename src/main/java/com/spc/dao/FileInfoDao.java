package com.spc.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FileInfoDao {
    List<Map<String,Object>> selectTemplateFile();

    int insertFileInfo(@Param("teaId") String teaId,@Param("fileName") String fileName,@Param("path") String path,@Param("type") int type,@Param("dep") String dep, @Param("time") String date,@Param("flag") int flag);

    int updateFlagZero(@Param("dep") String dep,@Param("type") int type);
}