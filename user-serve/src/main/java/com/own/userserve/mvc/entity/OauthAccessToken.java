package com.own.userserve.mvc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zxb
 * @since 2019-12-27
 */
@TableName("oauth_access_token")
public class OauthAccessToken extends Model<OauthAccessToken> {

    private static final long serialVersionUID = 1L;

    private String tokenId;

    private String token;

    private String authenticationId;

    private String userName;

    private String clientId;

    private String authentication;

    private String refreshToken;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    protected Serializable pkVal() {
        return this.authenticationId;
    }

    @Override
    public String toString() {
        return "OauthAccessToken{" +
            "tokenId=" + tokenId +
            ", token=" + token +
            ", authenticationId=" + authenticationId +
            ", userName=" + userName +
            ", clientId=" + clientId +
            ", authentication=" + authentication +
            ", refreshToken=" + refreshToken +
        "}";
    }
}
