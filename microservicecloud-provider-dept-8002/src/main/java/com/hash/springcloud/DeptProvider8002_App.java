package com.hash.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //本服务启动后会自动注册进Eureka服务
@EnableDiscoveryClient  //发现               Eureka的服务与发现
public class DeptProvider8002_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8002_App.class, args);
	}
}
