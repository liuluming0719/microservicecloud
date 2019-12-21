package com.hash.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.hash.springcloud.dao.DeptDao;
import com.hash.springcloud.entities.Dept;
import com.hash.springcloud.service.DeptService;

@Primary
@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptDao;
	
	@Override
	public Boolean add(Dept dept) {
		
		return deptDao.addDept(dept);
	}

	@Override
	public Dept get(Long deptNo) {
		
		return deptDao.findById(deptNo);
	}

	@Override
	public List<Dept> list() {
		
		return deptDao.findAll();
	}

}
