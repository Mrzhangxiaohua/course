package com.spc.dao;


import com.spc.model.UserDomain;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;
import java.util.Map;

public interface UserDao {

    int insert(UserDomain user);
//
//    @Insert("insert into Role_user(roleId, uId) values(#{roleId}, #{uId})")
//    int insertRole(@Param("roleId") Integer roleId, @Param("uId") Integer uId);

    UserDomain findUsersById(@Param("stuId") String stuId);

}