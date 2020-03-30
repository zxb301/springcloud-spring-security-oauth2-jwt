package com.own.business;

import com.own.business.config.FeginInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class BusinessApplication {

	public static void main(String[] args) {

		SpringApplication.run(BusinessApplication.class, args);
	}


	@Bean
	public FeginInterceptor feginInterceptor(){
		return  new FeginInterceptor();
	}

}
