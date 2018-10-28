package com.spc.dao;

import com.spc.service.xjtu.webservice.info.xsd.UserInfoDto;
import org.apache.ibatis.annotations.Param;

public interface UserInfoDao {
    int addInformation(UserInfoDto userInfoDto);
    UserInfoDto selectById(@Param("id") String id);
}
