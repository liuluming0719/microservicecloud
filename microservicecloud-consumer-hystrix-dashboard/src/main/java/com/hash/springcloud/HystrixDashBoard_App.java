package com.hash.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
//开启hystrix服务监控，访问http://localhost:9001/hystrix
@EnableHystrixDashboard
public class HystrixDashBoard_App {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashBoard_App.class, args);
	}
}
