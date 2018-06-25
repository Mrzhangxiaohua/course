package com.spc.service.data.impl;

import com.spc.dao.DataDao;
import com.spc.service.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service(value = "dataService")
public class DataServiceImpl implements DataService {


    @Autowired
    private DataDao dataDao; //会报错 但是并不影响

    @Override
    public List<HashMap<Integer,String>>  getDepart() {
        return dataDao.getDepart();
    }
}
