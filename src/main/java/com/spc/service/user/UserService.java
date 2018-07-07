package com.spc.service.user;

import com.spc.model.UserDomain;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface UserService {

    boolean addUser(UserDomain user,int role);

    UserDomain findUsersByName(String name);

}
