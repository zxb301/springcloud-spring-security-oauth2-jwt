package com.own.jwtserve.mvc.client;

import com.own.jwtserve.mvc.entity.SysUser;
import com.own.jwtserve.mvc.security.XcUserExt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-serve", fallbackFactory = UserClientHystris.class)
public interface UserClient {
    @RequestMapping("/user/queryUser")
    ResponseEntity<SysUser> queryUser(@RequestParam("username") String username, @RequestParam("password") String password);

    @RequestMapping("/user/getUserext")
    XcUserExt getUserext(@RequestParam("username") String username);
}
