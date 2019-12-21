package com.hash.springcloud.service;

import java.util.List;

import com.hash.springcloud.entities.Dept;

public interface DeptService {

	Boolean add(Dept dept);
	
	Dept get(Long deptNo);
	
	List<Dept> list();
}
