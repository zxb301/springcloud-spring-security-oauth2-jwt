package com.own.userserve.mvc.controller;

import com.own.userserve.mvc.entity.SysUser;
import com.own.userserve.mvc.pojo.XcUserExt;
import com.own.userserve.mvc.service.IXcUserService;
import com.own.userserve.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.own.userserve.mvc.pojo.UserInfo;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    IXcUserService xcUserService;

    @RequestMapping("/id")
    public ResponseEntity<UserInfo> getUserById() {
        try {
            Map map = new HashMap();
            UserInfo userInfo = userService.getUserById();
            return ResponseEntity.ok(userInfo);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);

        }
    }


/*    @RequestMapping("/id")
    public ResponseEntity<UserInfo> getUserById(HttpServletResponse response) throws InternalApiException  {

        try {
            UserInfo userInfo = userService.getUserById();
            return ResponseEntity.ok(userInfo);
        } catch (Exception e) {
            throw new InternalApiException(ErrorMatrix.SYS_FAILED,ErrorMatrix.SYS_FILE_ERROR);
            //response.setStatus(201);
            //return Result(ErrorMatrix.CODE_FAILED, ErrorMatrix.SYS_FILE_ERROR);
        }
    }*/

    @RequestMapping("/queryUser")
    public ResponseEntity<SysUser> queryUser(String username, String password) {
        try {
            SysUser sysUser = userService.queryUser(username, password);
            return ResponseEntity.ok(sysUser);
        } catch (Exception e) {
          /*  HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json;");*/
            return new ResponseEntity(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @RequestMapping("/getUserext")
    public XcUserExt getUserext(String username) {
        XcUserExt xcUserExt = xcUserService.getUserext(username);
        return xcUserExt;

    }
}
