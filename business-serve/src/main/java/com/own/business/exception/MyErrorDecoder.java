package com.own.business.exception;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        String string = null;
        try {
            string = Util.toString(response.body().asReader());
            System.out.println(string);
        } catch (IOException e) {
            return new InternalApiException(ErrorMatrix.SYS_FAILED,string);
        }
        return new InternalApiException(ErrorMatrix.SYS_FAILED,string);
    }
}
