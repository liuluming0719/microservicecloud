package com.hash.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

	/**
	 * 配置RestTemplate
	 * 通过RestTemplate调用提供者服务 ，发送rest请求
	 * 提供了多种访问http服务的方法，
	 * 针对于访问rest服务<strong>客户端</strong>的调用的模板类
	 * @return
	 */

@Configuration
public class ConfigBean {

	@Bean
	@LoadBalanced //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力 默认轮询     
	//springcloud Ribbon是基于Netflix Ribbon实现的一套客户端  负载均衡的工具
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
//	@Bean
//	public IRule myRule() {
//		return new RandomRule();//选用的随机算法，Ribbon默认是轮询算法
//	}
}
