package com.spc.service.data.impl;

import com.spc.dao.DataDao;
import com.spc.dao.UserInfoDao;
import com.spc.service.data.DataService;
import com.spc.service.xjtu.webservice.info.xsd.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "dataService")
public class DataServiceImpl implements DataService {


    @Autowired
    private DataDao dataDao; //会报错 但是并不影响

    @Autowired
    private UserInfoDao userInfo;

    @Override
    public List<Map<String, Object>> getDepart() {
        return dataDao.getDepart();
    }

    @Override
    public int storeUserInformation(UserInfoDto userInfoDto) {
        return userInfo.addInformation(userInfoDto);
    }

    @Override
    public int getXuanKeStu(String stuId) {
        return dataDao.selectXuanKeStu(stuId);
    }

    @Override
    public List<Map<String, String>> allXuanKeStu() {
        return dataDao.allXuanKeStu();
    }

}
