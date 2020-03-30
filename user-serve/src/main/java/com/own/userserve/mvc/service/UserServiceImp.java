package com.own.userserve.mvc.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.own.userserve.mvc.entity.XcMenu;
import com.own.userserve.mvc.entity.XcUser;
import com.own.userserve.mvc.mapper.SysUserMapper;
import com.own.userserve.mvc.entity.SysUser;
import com.own.userserve.mvc.pojo.UserInfo;
import com.own.userserve.mvc.pojo.XcUserExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp extends ServiceImpl<SysUserMapper, SysUser> implements UserService {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public UserInfo getUserById() {
        try {
            //int i = 10 / 0;
            UserInfo userInfo = new UserInfo();
            userInfo.setId(Long.valueOf("1"));
            userInfo.setUsername("张三");
            userInfo.setAge(18);
            return userInfo;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public SysUser queryUser(String username, String password) {
        try {
            SysUser sysUser = sysUserMapper.selectOne(new QueryWrapper<SysUser>().eq("name", username));
            return sysUser;
        } catch (Exception e) {
            throw e;
        }

    }

}
