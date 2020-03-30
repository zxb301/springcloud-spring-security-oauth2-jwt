package com.own.jwtserve.mvc.util;


import com.own.jwtserve.mvc.security.XcUserExt;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClock;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author: li
 * @create: 2018-10-23
 **/
@Component
public class JwtUtils implements Serializable {
    private static final long serialVersionUID = -3301605591108950415L;
    private Clock clock = DefaultClock.INSTANCE;
    /**
     * 私钥加密token
     *
     * @param userInfo      载荷中的数据
     * @param privateKey    私钥
     * @param expireMinutes 过期时间，单位秒
     * @return
     * @throws Exception
     */
    public static String generateToken(XcUserExt userInfo, PrivateKey privateKey, int expireMinutes) throws Exception {
        return Jwts.builder()
                .claim(JwtConstans.JWT_KEY_ID, userInfo.getId())
                .claim(JwtConstans.JWT_KEY_USER_NAME, userInfo.getUsername())
                //.claim(JwtConstans.JWT_KEY_USER_PERMISSIONS, userInfo.getPermissions())
                .setExpiration(DateTime.now().plusDays(expireMinutes).toDate())
                .signWith(SignatureAlgorithm.RS256, privateKey)
                .compact();
    }

    /**
     * 私钥加密token
     *
     * @param userInfo      载荷中的数据
     * @param privateKey    私钥字节数组
     * @param expireMinutes 过期时间，单位秒
     * @return
     * @throws Exception
     */
    public static String generateToken(XcUserExt userInfo, byte[] privateKey, int expireMinutes) throws Exception {
        return Jwts.builder()
                .claim(JwtConstans.JWT_KEY_ID, userInfo.getId())
                .claim(JwtConstans.JWT_KEY_USER_NAME, userInfo.getUsername())
                //.claim(JwtConstans.JWT_KEY_USER_PERMISSIONS, userInfo.getPermissions())
                .setExpiration(DateTime.now().plusMinutes(expireMinutes).toDate())
                .signWith(SignatureAlgorithm.RS256, RsaUtils.getPrivateKey(privateKey))
                .compact();
    }

    /**
     * 公钥解析token
     *
     * @param token     用户请求中的token
     * @param publicKey 公钥
     * @return
     * @throws Exception
     */
    private static Jws<Claims> parserToken(String token, PublicKey publicKey) {
        return Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
    }

    /**
     * 公钥解析token
     *
     * @param token     用户请求中的token
     * @param publicKey 公钥字节数组
     * @return
     * @throws Exception
     */
    private static Jws<Claims> parserToken(String token, byte[] publicKey) throws Exception {
        return Jwts.parser().setSigningKey(RsaUtils.getPublicKey(publicKey))
                .parseClaimsJws(token);
    }

    /**
     * 获取token中的用户信息
     *
     * @param token     用户请求中的令牌
     * @param publicKey 公钥
     * @return 用户信息
     * @throws Exception
     */
    public static XcUserExt getInfoFromToken(String token, PublicKey publicKey) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, publicKey);
        Claims body = claimsJws.getBody();
        XcUserExt xcUserExt = new XcUserExt();
        xcUserExt.setId(ObjectUtils.toString(body.get(JwtConstans.JWT_KEY_ID)));
        xcUserExt.setUsername(ObjectUtils.toString(body.get(JwtConstans.JWT_KEY_USER_NAME)));
        xcUserExt.setPermissions(null);
        return xcUserExt;
    }

    /**
     * 获取token中的用户信息
     *
     * @param token     用户请求中的令牌
     * @param publicKey 公钥
     * @return 用户信息
     * @throws Exception
     */
    public static XcUserExt getInfoFromToken(String token, byte[] publicKey) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, publicKey);
        Claims body = claimsJws.getBody();
        XcUserExt xcUserExt = new XcUserExt();
        xcUserExt.setId(ObjectUtils.toString(body.get(JwtConstans.JWT_KEY_ID)));
        xcUserExt.setUsername(ObjectUtils.toString(body.get(JwtConstans.JWT_KEY_USER_NAME)));
        xcUserExt.setPermissions(null);
        return xcUserExt;
    }
}