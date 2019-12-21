package com.hash.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hash.springcloud.entities.Dept;

//Feign面向接口编程
@FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {

	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean  add(Dept dept);
	
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public List<Dept> list();
	
	@RequestMapping(value="/dept/findById/{deptNo}",method=RequestMethod.GET)
	public Dept findById(@PathVariable("deptNo") Long deptNo);
}
