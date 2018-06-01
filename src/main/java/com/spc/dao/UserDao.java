package com.spc.dao;


import com.spc.model.UserDomain;

import java.util.List;

public interface UserDao {

    int insert(UserDomain record);

    List<UserDomain> selectUsers();
}