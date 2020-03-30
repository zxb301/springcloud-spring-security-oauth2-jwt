package com.own.eurekaserve01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServe01Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServe01Application.class, args);
	}

}
