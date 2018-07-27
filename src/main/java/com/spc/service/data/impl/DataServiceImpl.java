package com.spc.service.data.impl;

import com.spc.dao.DataDao;
import com.spc.service.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "dataService")
public class DataServiceImpl implements DataService {


    @Autowired
    private DataDao dataDao; //会报错 但是并不影响

    @Override
    public List<Map<String, Object>> getDepart() {
        return dataDao.getDepart();
    }
}
