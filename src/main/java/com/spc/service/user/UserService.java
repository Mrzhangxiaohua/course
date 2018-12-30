package com.spc.service.user;

import com.spc.model.UserDomain;

import java.util.Map;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface UserService {



    boolean addUser(UserDomain user);

    UserDomain findUsersById(String id);

    Map<String, Object> findDepId(String departCode);
}
