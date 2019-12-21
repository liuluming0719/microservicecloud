package com.hash.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import MySelfRule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
/**
 * 在启动该微服务式是能去加载我们定义的Ribbon配置类
 * configuration：用我们指定的配置规则
 * MyRandomRule.class：我们自定义的Ribbon负载均衡规则，官方文档给出了明确指示，这个自定义配置类不能放在@ComponentScan所
 *                      扫描的当前包以及子包下，否则我们自定义的这个配置类就会被所有的Ribbon客户端共享，也就是说，我们达
 *                      不到特殊定制化的目的了。
 */
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
public class DeptConsumer80_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
