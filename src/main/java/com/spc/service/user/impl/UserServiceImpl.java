package com.spc.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.spc.dao.UserDao;
import com.spc.model.RoleDomain;
import com.spc.model.UserDomain;
import com.spc.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;//这里会报错，但是并不会影响

    @Override
    public boolean addUser(UserDomain user,int role) {
        userDao.insert(user);
        Integer uid = user.getUid();
        userDao.insertRole(role,uid);
        return true;
    }

    @Override
    public UserDomain findUsersByName(String userName) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
//        PageHelper.startPage(pageNum, pageSize);
        return userDao.findUsersByName(userName);
    }
}
