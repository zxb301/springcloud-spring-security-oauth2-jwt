package com.own.userserve.common.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class MyExceptionHandler {
    Logger logger = LoggerFactory.getLogger(getClass());


    @ExceptionHandler(InternalApiException.class)
    @ResponseBody
    public ResponseEntity<InternalApiException> handleBindException(
            InternalApiException ex, HttpServletResponse response) {
     /*   StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        ex.printStackTrace(pw);
        pw.flush();
        sw.flush();
        String error = sw.toString();*/
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;");
        return new ResponseEntity(ex.getCause().getMessage(),headers,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Exception> exceptionHandler(Exception exception) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;");
        return new ResponseEntity(exception.getMessage(),headers,HttpStatus.SERVICE_UNAVAILABLE);
    }


}
