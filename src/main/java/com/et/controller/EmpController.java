package com.et.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.et.entity.Emp;
import com.et.entity.Result;
import com.et.service.EmpService;
import com.et.utils.PageTools;




@Controller
public class EmpController {
	@Autowired
	EmpService  service;
	/**
	 * ��ѯ�ķ���
	 */
	@ResponseBody
	@RequestMapping("/queryEmp")
	public PageTools queryEmp(Integer id,String ename,Integer page,Integer rows){
		
		return service.queryEmp(id,ename, page, rows);
	}
	
	/**
	 * �޸�Ա����Ϣ
	 */
	@ResponseBody
	@RequestMapping(value="/updateEmp/{id}",method=RequestMethod.PUT)
	public Result updateEmp(@PathVariable Integer id,Emp emp,Integer page,Integer rows){
	
		emp.setId(id);
		Result rt=new Result();
		rt.setCode(1);
		try {
			service.updateEmp(emp);
		} catch (Exception e) {
			rt.setCode(0);
			rt.setMessage(e);
		}
		return rt;
	}
	/**
	 *���Ա����Ϣ
	 */
	@ResponseBody
	@RequestMapping(value="/saveEmp",method=RequestMethod.POST)
	public Result saveEmp(Emp emp){
		Result rt=new Result();
		rt.setCode(1);
		try {
			
			service.saveEmp(emp);
		} catch (Exception e) {
			rt.setCode(0);
			rt.setMessage(e);
		}
		return rt;
	}
	
	/**
	 * ɾ��ѧ��
	 */
	@ResponseBody
	@RequestMapping(value="/deleteEmp/{id}",method=RequestMethod.DELETE)
	public Result deleteEmp(@PathVariable String id,Integer page,Integer rows){
	//ɾ��һ��
		Result rt=new Result();
		rt.setCode(1);
		try {
			//����쳣
			//String str=null;
			//str.toString();
			service.deleteEmp(Integer.parseInt(id));
		} catch (Exception e) {
			rt.setCode(0);
			rt.setMessage(e);
		}
		return rt;
	}
	
	
}
