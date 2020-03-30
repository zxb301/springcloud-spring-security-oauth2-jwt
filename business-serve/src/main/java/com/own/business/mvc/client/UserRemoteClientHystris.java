package com.own.business.mvc.client;

import com.own.business.exception.InternalApiException;
import com.own.business.mvc.pojo.UserInfo;
import feign.hystrix.FallbackFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserRemoteClientHystris implements FallbackFactory<UserRemoteClient> {

    @Override
    public UserRemoteClient create(Throwable throwable) {
        return new UserRemoteClient(){
            @Override
            public ResponseEntity<UserInfo> getUserById() {
                InternalApiException cause =(InternalApiException) throwable;
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json;");
                System.out.println(cause.getMessage());
                return new ResponseEntity(cause.getMessage(),headers,HttpStatus.SERVICE_UNAVAILABLE);
            }
        };
    }
}
