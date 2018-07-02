package com.spc.service.user;

import com.spc.model.UserDomain;

import java.util.List;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface UserService {

    int addUser(UserDomain user);

    UserDomain findUsersById(String userId);

}
