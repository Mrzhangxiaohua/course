package com.spc.service.user.impl;

import com.spc.dao.UserDao;
import com.spc.dao.UserInfoDao;
import com.spc.model.UserDomain;
import com.spc.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;//这里会报错，但是并不会影响

    @Autowired
    private UserInfoDao userInfoDao;





    //    @Override
//    public boolean addUser(UserDomain user, int role) {
//        userDao.insert(user);
//        Integer uid = user.getUid();
//        userDao.insertRole(role, uid);
//        return true;
//    }
    @Override
    public boolean addUser(UserDomain user) {
        if(userDao.findUsersById(user.getStuId())==null){
            userDao.insert(user);
        }else{
            userDao.udpate(user);
        }
        return true;
    }

    @Override
    public int addStudent(String stuId, String stuName) {
        List<Map> res = userDao.findStudent(stuId);
        if(res.isEmpty()){
            return userDao.addStudent(stuId,stuName);
        }else{
            return 0;
        }
    }


    @Override
    public UserDomain findUsersById(String id) {
        System.out.println("id is "+id);
        return userDao.findUsersById(id);
    }

    @Override
    public Map<String, Object> findDepId(String departCode) {
        int size=userDao.findDepId(departCode).size();
        if(size==0){
            Map map=new HashMap<>();
            map.put("departId",0);
            return map;
        }
        return userDao.findDepId(departCode).get(0);
    }
}
