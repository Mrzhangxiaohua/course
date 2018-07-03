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
    public boolean addUser(HttpServletRequest request) {
        UserDomain user = new UserDomain();

        String username=request.getParameter("userName");
        String password=request.getParameter("password");
        String  role=request.getParameter("role");
        String  number=request.getParameter("number");
        System.out.printf("number is%s\n",number);


        user.setPassword(password);
        user.setRole(null);
        user.setUserName(username);
        user.setNum(Integer.parseInt(number));

        userDao.insert(user);
        System.out.println(user.getUid());

        System.out.printf("%d\n",role.toCharArray()[0]-'0');
        System.out.printf("%d",user.getUid());
        userDao.insertRole(role.toCharArray()[0]-'0',user.getUid());
//        roleDao.insert(uid,role);
//        return userDao.insert(userName,password,role);
        return true;
    }

    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    @Override
    public UserDomain findUsersByName(String userName) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
//        PageHelper.startPage(pageNum, pageSize);
        return userDao.findUsersByName(userName);
    }
}
