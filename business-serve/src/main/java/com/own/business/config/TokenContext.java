package com.own.business.config;

public class TokenContext   {

    private static final ThreadLocal<String> tokenLocal = new ThreadLocal<String>();

    public TokenContext() {
    }

    public static String getToken(){
        return  tokenLocal.get();
    }

    public static void setToken(String token){
        tokenLocal.set(token);
    }

    public static void remToken(){
        tokenLocal.remove();
    }




}
