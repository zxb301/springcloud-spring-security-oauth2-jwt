package com.own.business.mvc.service;

import com.alibaba.fastjson.JSON;
import com.own.business.exception.InternalApiException;
import com.own.business.mvc.client.UserRemoteClient;
import com.own.business.mvc.pojo.BussinessInfo;
import com.own.business.mvc.pojo.UserBussInfo;
import com.own.business.mvc.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BussinessServiceImp implements BussinessService {

    @Autowired
    UserRemoteClient userRemoteClient;


    @Override
    public UserBussInfo getuserBussInfo()  {
        try {
            BussinessInfo bussinessInfo = new BussinessInfo();
            bussinessInfo.setId(Long.valueOf("1"));
            bussinessInfo.setNum("01");

            ResponseEntity<UserInfo> result = userRemoteClient.getUserById();
            if (!result.getStatusCode().equals(HttpStatus.OK)) {
                return null;
            }
            UserBussInfo userBussInfo = new UserBussInfo();
            UserInfo user = JSON.parseObject(JSON.toJSONString(result.getBody()), UserInfo.class);
            userBussInfo.setUserInfo(user);
            userBussInfo.setBussinessInfo(bussinessInfo);
            return userBussInfo;
        }catch (Exception e){
             throw e;
        }

    }
}
