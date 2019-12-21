package com.hash.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hash.springcloud.entities.Dept;
import com.hash.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {

	@Autowired
	private DeptService deptService = null;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return deptService.add(dept);
	}
	@RequestMapping(value = "/dept/findById/{deptNo}", method = RequestMethod.GET)
    //一旦调用服务方法失败并抛出了异常信息之后，会自动调用@HystrixCommand标注好的fallbackMethod，调用类中指定的方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept findById(@PathVariable("deptNo") Long deptNo) {
        Dept dept = this.deptService.get(deptNo);
        if(dept == null){
            throw new RuntimeException("该Id：" + deptNo + "没有对应的信息");
        }
        return dept;
    }
	
	 public Dept processHystrix_Get(@PathVariable("deptNo") Long deptNo) {
	        return new Dept().setDeptNo(deptNo).setDeptName("该Id"+ deptNo +"没有对应的信息,null -- @HystrixCommand")
	                    .setDbSource("no this database in MySql");
	    }
	
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public List<Dept> list() {
		return deptService.list();
	}
	
	/**
     * 增加自己服务描述的接口
     * @return
     */
    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        System.out.println("总共有多少个微服务"+list.size());

        //查询STUDY-SPRINGCLOUD-DEPT 服务
        List<ServiceInstance> instances = discoveryClient.getInstances("STUDY-SPRINGCLOUD-DEPT");

        //打印STUDY-SPRINGCLOUD-DEPT服务信息
        for (ServiceInstance element :instances){
            System.out.println(element.getServiceId());
            System.out.println(element.getHost());
            System.out.println(element.getPort());
            System.out.println(element.getUri());
        }
        return this.discoveryClient;

    }
}
