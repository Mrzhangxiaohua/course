package com.spc.dao;

import com.spc.model.FileInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FileInfoDao {
    List<Map<String,Object>> selectTemplateFile();

    int insertFileInfo(@Param("teaId") String teaId,@Param("fileName") String fileName,@Param("pathName") String pathName,@Param("type") int type,@Param("dep") String dep, @Param("time") String date,@Param("flag") int flag);

    int updateFlagZero(@Param("type") int type);

    void insertFile(FileInfo fileInfo);

    Map<String, Object> selectGradeExcel(@Param("fileInfoId") int fileInfoId);

    FileInfo findById(@Param("fileInfoId") int fileInfoId);
}
