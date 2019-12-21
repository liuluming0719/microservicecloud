package com.hash.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hash.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

/**
 * @description 统一处理DeptClientService这个类中的熔断，主业务与熔断方法解耦
 * @author admin
 *
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {

		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dept findById(Long deptNo) {
				 return new Dept().setDeptNo(deptNo).setDeptName("该Id"+ deptNo +"没有对应的信息，Consumer客户端提供的降级信息，此刻服务provider已经关闭")
		                    .setDbSource("no this database in MySql");
			}
			
			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}
}
