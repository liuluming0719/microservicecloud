package com.hash.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.hash.springcloud.entities.Dept;

@Mapper
@Repository
public interface DeptDao {

	 /**
	  * 添加，插入操作
	  * @param dept
	  * @return
	  */
    boolean addDept(Dept dept);

    /**
     * 根据部门id查找
     * @param deptNo
     * @return
     */
    Dept findById(Long deptNo);

    /**
     * 查询全部
     * @return
     */
    List<Dept> findAll();
}
