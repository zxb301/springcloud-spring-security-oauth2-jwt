package com.own.jwtserve.mvc.controller;

import com.own.jwtserve.config.JwtProperties;
import com.own.jwtserve.mvc.oauth2.AuthCode;
import com.own.jwtserve.mvc.oauth2.AuthToken;
import com.own.jwtserve.mvc.oauth2.ExceptionCast;
import com.own.jwtserve.mvc.security.JwtUser;
import com.own.jwtserve.mvc.security.JwtUserDetailsService;
import com.own.jwtserve.mvc.security.XcUserExt;
import com.own.jwtserve.mvc.service.AuthService;
import com.own.jwtserve.mvc.util.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {


    @Value("${auth.clientId}")
    String clientId;
    @Value("${auth.clientSecret}")
    String clientSecret;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProperties properties;

    @Autowired
    JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private AuthService authService;

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/test")
    public String test() {
        return "jwt-serve";
    }

    //整合jwt
    @RequestMapping("login")
    public ResponseEntity<String> login(String username, String password) {

        //1.登录校验
        String token = this.authService.authentication(username, password);
        if (StringUtils.isBlank(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.ok(token);
    }
    //整合Security+jwt
    @RequestMapping("login-security")
    public ResponseEntity<String> loginSecurity(String username, String password) {
        try {
            UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(
                    username, password
            );
            // Perform the security
            Authentication authentication = authenticationManager.authenticate(upToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Reload password post-security so we can generate token
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            // final String token = jwtTokenUtil.generateToken(userDetails);

            // JwtUser jwtUser = (JwtUser)jwtUserDetailsService.loadUserByUsername(username);
            //申请令牌
            JwtUser jwtUser = (JwtUser) userDetails;

            XcUserExt xcUserExt = new XcUserExt();
            xcUserExt.setId(jwtUser.getId());
            xcUserExt.setUsername(jwtUser.getUsername());
            xcUserExt.setPermissions(null);
            String token = JwtUtils.generateToken(xcUserExt,
                    properties.getPrivateKey(), properties.getExpire());
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
    //整合Security+jwt+oauth2
    @PostMapping("/userlogin")
    public ResponseEntity<String> login( String username, String password,String verifycode) {
        if(StringUtils.isEmpty(username)){
            ExceptionCast.cast(AuthCode.AUTH_USERNAME_NONE);
        }
        if(StringUtils.isEmpty(password)){
            ExceptionCast.cast(AuthCode.AUTH_PASSWORD_NONE);
        }
        //验证码判断

        //申请令牌
        AuthToken authToken =  authService.login(username,password,clientId,clientSecret);

        //用户身份令牌
        String access_token = authToken.getAccess_token();

        return ResponseEntity.ok(access_token);
    }
}
