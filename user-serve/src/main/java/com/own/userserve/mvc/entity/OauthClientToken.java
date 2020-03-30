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
@TableName("oauth_client_token")
public class OauthClientToken extends Model<OauthClientToken> {

    private static final long serialVersionUID = 1L;

    private String tokenId;

    private String token;

    private String authenticationId;

    private String userName;

    private String clientId;

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

    @Override
    protected Serializable pkVal() {
        return this.authenticationId;
    }

    @Override
    public String toString() {
        return "OauthClientToken{" +
            "tokenId=" + tokenId +
            ", token=" + token +
            ", authenticationId=" + authenticationId +
            ", userName=" + userName +
            ", clientId=" + clientId +
        "}";
    }
}
