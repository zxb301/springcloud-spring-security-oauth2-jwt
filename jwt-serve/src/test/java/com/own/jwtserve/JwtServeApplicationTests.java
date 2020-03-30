package com.own.jwtserve;

import com.own.jwtserve.mvc.oauth2.ServiceList;
import com.own.jwtserve.mvc.pojo.UserInfo;
import com.own.jwtserve.mvc.util.JwtUtils;
import com.own.jwtserve.mvc.util.RsaUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JwtServeApplicationTests {


  /*  private static final String pubKeyPath = "D:\\tmp\\rsa\\pub.pem";

    private static final String priKeyPath = "D:\\tmp\\rsa\\pri.pem";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU3NzU4Njg0OH0.imzZrjRVSR1BarT0P-g33OXmSiqb1She_oEzzsW9EeM9sM6RqhSKPah7uW3E5zrbKnWorJ6f7nQy8Z8bkctWL0V5IW2fkC7NkPFhEsmG2MA2uHf_7cG3yhiUY7JXN1-jSULs-0TsP5kHOnq_TSKoZvS84lIfAFyW806IYNUv4wA";

        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
*/

        @Autowired
        LoadBalancerClient loadBalancerClient;

        @Autowired
        RestTemplate restTemplate;

        //远程请求spring security获取令牌
        @Test
        public void testClient(){
            //从eureka中获取认证服务的地址（因为spring security在认证服务中）
            //从eureka中获取认证服务的一个实例的地址
            ServiceInstance serviceInstance = loadBalancerClient.choose(ServiceList.SERVICE_UCENTER_AUTH);
            //此地址就是http://ip:port
            URI uri = serviceInstance.getUri();
            //令牌申请的地址 http://localhost:40400/auth/oauth/token
            String authUrl =  uri+"/auth/oauth/token";
            //定义header
            LinkedMultiValueMap<String, String> header = new LinkedMultiValueMap<>();
            String httpBasic = getHttpBasic("XcWebApp", "XcWebApp");
            header.add("Authorization",httpBasic);

            //定义body
            LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("grant_type","password");
            body.add("username","admin");
            body.add("password","123456");

            HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(body, header);
            //String url, HttpMethod method, @Nullable HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables

            //设置restTemplate远程调用时候，对400和401不让报错，正确返回数据
            restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
                @Override
                public void handleError(ClientHttpResponse response) throws IOException {
                    if(response.getRawStatusCode()!=400 && response.getRawStatusCode()!=401){
                        super.handleError(response);
                    }
                }
            });

            ResponseEntity<Map> exchange = restTemplate.exchange(authUrl, HttpMethod.POST, httpEntity, Map.class);

            //申请令牌信息
            Map bodyMap = exchange.getBody();
            System.out.println(bodyMap);
        }

        //获取httpbasic的串
        private String getHttpBasic(String clientId,String clientSecret){
            String string = clientId+":"+clientSecret;
            //将串进行base64编码
            byte[] encode = Base64Utils.encode(string.getBytes());
            return "Basic "+new String(encode);
        }

        @Test
        public void testPasswrodEncoder(){
            //原始密码
            String password = "111111";
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            //使用BCrypt加密，每次加密使用一个随机盐
            for(int i=0;i<10;i++){
                String encode = bCryptPasswordEncoder.encode(password);
                System.out.println(encode);
                //校验
                boolean matches = bCryptPasswordEncoder.matches(password, encode);
                System.out.println(matches);
            }

        }



}
