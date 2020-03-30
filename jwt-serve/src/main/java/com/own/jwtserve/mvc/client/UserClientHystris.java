package com.own.jwtserve.mvc.client;

import com.own.jwtserve.mvc.entity.SysUser;
import com.own.jwtserve.mvc.security.XcUserExt;
import feign.hystrix.FallbackFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserClientHystris implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient(){
            @Override
            public ResponseEntity<SysUser> queryUser(String username, String password) {
                String message = throwable.getCause().getMessage();
                System.out.println(message);
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

            @Override
            public XcUserExt getUserext(String username) {
                return null;
            }
        };
    }
}
