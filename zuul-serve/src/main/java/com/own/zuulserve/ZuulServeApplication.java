package com.own.zuulserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulServeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServeApplication.class, args);
	}

}
