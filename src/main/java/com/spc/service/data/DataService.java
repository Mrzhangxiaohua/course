package com.spc.service.data;

import com.spc.service.xjtu.webservice.info.xsd.UserInfoDto;

import java.util.List;
import java.util.Map;

public interface DataService {
    List<Map<String, Object>> getDepart();

    int storeUserInformation(UserInfoDto userInfoDto);

    int getXuanKeStu(String stuId);

}
