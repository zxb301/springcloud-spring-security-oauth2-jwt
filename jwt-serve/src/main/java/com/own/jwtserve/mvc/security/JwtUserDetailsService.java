package com.own.jwtserve.mvc.security;


import com.own.jwtserve.mvc.client.UserClient;
import com.own.jwtserve.mvc.entity.XcMenu;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        System.out.println("查找用户：" + name);
        XcUserExt userext = userClient.getUserext(name);
        if(userext == null)
        {
            throw new UsernameNotFoundException("没有该用户");
        }
        List<XcMenu> permissions = userext.getPermissions();
        //查询用户所有角色
        // List<XcRole>  xcRoleList = xcUserMapper.getUserRoleById(user.getId());
        if(permissions == null){
            permissions = new ArrayList<>();
        }
        List<String> user_permission = new ArrayList<>();
        permissions.forEach(item-> user_permission.add(item.getCode()));
        String user_permission_string  = StringUtils.join(user_permission.toArray(), ",");
        JwtUser userDetails = new JwtUser(userext.getId(),name,
                userext.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(user_permission_string),  userext.getUpdateTime());
        return userDetails;
    }
}
