package com.own.business.mvc.controller;

import com.own.business.config.JwtProperties;
import com.own.business.exception.ErrorMatrix;
import com.own.business.mvc.pojo.UserBussInfo;
import com.own.business.mvc.pojo.UserInfo;
import com.own.business.mvc.service.BussinessService;
import com.own.business.mvc.util.JwtUtils;
import com.own.business.mvc.util.XcOauth2Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/bussiness")
public class BussinessController {

    @Autowired
    BussinessService bussinessService;

    @Autowired
    JwtProperties properties;

    @RequestMapping("/id")
    public ResponseEntity<UserBussInfo> getUserById(HttpServletRequest request) {
        try {
            String token = request.getHeader("token");
            System.out.println(token + "----------");
            UserInfo userInfo = JwtUtils.getInfoFromToken(token, this.properties.getPublicKey());
            System.out.println(userInfo);
            UserBussInfo userBussInfo = bussinessService.getuserBussInfo();
            return ResponseEntity.ok(userBussInfo);
        } catch (Exception e) {
            return new ResponseEntity(ErrorMatrix.SYS_FILE_ERROR,HttpStatus.SERVICE_UNAVAILABLE);
        }

    }

    @RequestMapping("/getUser")
    @PreAuthorize("hasAuthority('xc_sysmanager')")
    public ResponseEntity<UserBussInfo> getUser(HttpServletRequest request) {
        try {
            XcOauth2Util xcOauth2Util = new XcOauth2Util();
            XcOauth2Util.UserJwt userJwt = xcOauth2Util.getUserJwtFromHeader(request);
            System.out.println(userJwt);
            UserBussInfo userBussInfo = bussinessService.getuserBussInfo();
            return ResponseEntity.ok(userBussInfo);
        } catch (Exception e) {
            return new ResponseEntity(ErrorMatrix.SYS_FILE_ERROR,HttpStatus.SERVICE_UNAVAILABLE);
        }

    }
}
