package com.et.service;

import com.et.entity.Emp;
import com.et.utils.PageTools;



public interface EmpService {
	
	
	/**
	 * 查询方法
	 */
	public abstract PageTools queryEmp(Integer id,String ename,Integer page,Integer rows);
	/**
	 * 修改员工信息
	 */
	public abstract void updateEmp(Emp emp);
	/**
	 * 添加员工信息
	 */
	public abstract void saveEmp(Emp emp);
	
	/**
	 * 通过id删除员工
	 */
	public  abstract void deleteEmp(Integer id);
}