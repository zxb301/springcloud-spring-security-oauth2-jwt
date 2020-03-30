package com.own.zuulserve.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class Oauth2LoginFilter extends ZuulFilter {

    @Autowired
    AuthService authService;
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        //得到request
        HttpServletRequest request = requestContext.getRequest();
        //得到response
        HttpServletResponse response = requestContext.getResponse();
        //取cookie中的身份令牌
       /* String tokenFromCookie = authService.getTokenFromCookie(request);
        if(StringUtils.isEmpty(tokenFromCookie)){
            //拒绝访问
            access_denied();
            return null;
        }*/
        //从header中取身份令牌
        String jtiFromHeader = authService.getJwtFromHeader(request);
        if(StringUtils.isEmpty(jtiFromHeader)){
            //拒绝访问
            access_denied();
            return null;
        }
        //从redis取出jwt的过期时间
        long expire = authService.getExpire(jtiFromHeader);
        if(expire<0){
            //拒绝访问
            access_denied();
            return null;
        }
        System.out.println(authService.getAccessToken(jtiFromHeader));

        Map map = JSON.parseObject(authService.getAccessToken(jtiFromHeader), Map.class);
        System.out.println(JSON.toJSONString(map.get("jwt_token")));
        requestContext.addZuulRequestHeader("Authorization","Bearer "+map.get("jwt_token"));
        return null;
    }


    //拒绝访问
    private void access_denied(){
        RequestContext requestContext = RequestContext.getCurrentContext();
        //得到response
        HttpServletResponse response = requestContext.getResponse();
        //拒绝访问
        requestContext.setSendZuulResponse(false);
        //设置响应代码
        requestContext.setResponseStatusCode(200);
        //构建响应的信息
       // ResponseResult responseResult = new ResponseResult(CommonCode.UNAUTHENTICATED);
        //转成json
        //String jsonString = JSON.toJSONString(responseResult);
        requestContext.setResponseBody("拒绝访问");
        //转成json，设置contentType
        response.setContentType("application/json;charset=utf-8");
    }
}
