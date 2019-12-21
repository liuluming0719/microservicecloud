package com.hash.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable{

	 /**
     *  部门编号 主键
     */
    private Long deptNo;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 数据库名称
     */
    private String dbSource;
    
    
//	public Dept(String deptName) {
//		super();
//		this.deptName = deptName;
//	}

//	public Dept setDeptNo(Long deptNo2) {
//		// TODO Auto-generated method stub
//		return null;
//	}
    
}
