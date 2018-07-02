package com.spc.dao;


import com.spc.model.UserDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    int insert(UserDomain record);

    UserDomain selectUsersById(@Param("userId")String userId);
}