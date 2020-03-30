package com.own.dashboardserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DashboardServeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardServeApplication.class, args);
	}




}
