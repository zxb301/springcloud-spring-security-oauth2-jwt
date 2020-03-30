package com.own.userserve.mvc.service;

import com.own.userserve.mvc.entity.SysUser;
import com.own.userserve.mvc.pojo.UserInfo;
import com.own.userserve.mvc.pojo.XcUserExt;

public interface UserService  {
    UserInfo getUserById();

    SysUser queryUser(String username, String password);

}
