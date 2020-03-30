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
@TableName("oauth_refresh_token")
public class OauthRefreshToken extends Model<OauthRefreshToken> {

    private static final long serialVersionUID = 1L;

    private String tokenId;

    private String token;

    private String authentication;

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
    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "OauthRefreshToken{" +
            "tokenId=" + tokenId +
            ", token=" + token +
            ", authentication=" + authentication +
        "}";
    }
}
