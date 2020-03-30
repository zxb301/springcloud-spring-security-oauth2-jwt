package com.own.userserve.mvc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.own.userserve.mvc.entity.XcMenu;
import com.own.userserve.mvc.entity.XcUser;
import com.own.userserve.mvc.mapper.XcMenuMapper;
import com.own.userserve.mvc.mapper.XcUserMapper;
import com.own.userserve.mvc.pojo.XcUserExt;
import com.own.userserve.mvc.service.IXcUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxb
 * @since 2019-12-26
 */
@Service
public class XcUserServiceImpl extends ServiceImpl<XcUserMapper, XcUser> implements IXcUserService {

    @Autowired
    XcUserMapper xcUserMapper;

    @Autowired
    XcMenuMapper xcMenuMapper;

    @Override
    public XcUserExt getUserext(String username) {
        //根据账号查询xcUser信息
        XcUser xcUser = xcUserMapper.selectOne(new QueryWrapper<XcUser>().eq("username",username));
        if(xcUser == null){
            return null;
        }
        //用户id
        String userId = xcUser.getId();
        //查询用户所有权限
        List<XcMenu> xcMenus = xcMenuMapper.selectPermissionByUserId(userId);
        XcUserExt xcUserExt = new XcUserExt();
        BeanUtils.copyProperties(xcUser,xcUserExt);
        //设置权限
        xcUserExt.setPermissions(xcMenus);
        return xcUserExt;
    }
}
