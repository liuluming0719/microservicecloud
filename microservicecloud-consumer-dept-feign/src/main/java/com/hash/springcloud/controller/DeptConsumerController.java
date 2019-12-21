package com.hash.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hash.springcloud.entities.Dept;
import com.hash.springcloud.service.DeptClientService;

@RestController
public class DeptConsumerController {
	
	@Autowired
	private DeptClientService clientService;  //Feign面向接口编程
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		return clientService.add(dept); 
	}
	
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list(){
		return clientService.list();
	}
	
	@RequestMapping(value="/consumer/dept/findById/{deptNo}")
	public Dept findById(@PathVariable("deptNo") Long deptNo) {
		return clientService.findById(deptNo);
	}
}
