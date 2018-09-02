package com.spc.dao;

import com.spc.service.xjtu.webservice.info.xsd.UserInfoDto;

public interface UserInfoDao {
    int addInformation(UserInfoDto userInfoDto);
}
