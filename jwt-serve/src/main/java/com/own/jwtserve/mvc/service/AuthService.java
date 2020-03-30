package com.own.jwtserve.mvc.service;

import com.own.jwtserve.mvc.oauth2.AuthToken;

public interface AuthService {
    String authentication(String username, String password);

    AuthToken login(String username, String password, String clientId, String clientSecret);
}
