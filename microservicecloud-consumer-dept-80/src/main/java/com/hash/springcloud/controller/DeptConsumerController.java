package com.hash.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hash.springcloud.entities.Dept;

@RestController
public class DeptConsumerController {
	
	//private static final String REST_URL_PREFIX = "http://localhost:8001";
	/**
	 * 注册在EurekaServer中的微服务名称  MICROSERVICECLOUD-DEPT
	 */
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		//三个参数：url,requestMap ResponseBean.class
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, boolean.class);
	}
	@RequestMapping(value = "/consumer/dept/findById/{deptNo}")
	public Dept findById(@PathVariable("deptNo") Long deptNo) {
		//三个参数：url,requestMap ResponseBean.class
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/findById/"+deptNo, Dept.class);
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		//三个参数：url,requestMap ResponseBean.class
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
	}
	@RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/discovery",
                Object.class);
    }
}
