package com.own.business.mvc.client;

import com.own.business.mvc.pojo.UserBussInfo;
import com.own.business.mvc.pojo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

//@FeignClient(name ="user-serve",configuration = {FeignConfig.class},fallbackFactory = UserRemoteClientHystris.class)
@FeignClient(name ="user-serve",fallbackFactory = UserRemoteClientHystris.class)
public interface UserRemoteClient {

    @PostMapping("/user/id")
    ResponseEntity<UserInfo> getUserById() ;
}
