package com.et.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.et.entity.Emp;
import com.et.entity.TreeNode;
import com.et.service.DeptService;




@Controller
public class DeptController {
	@Autowired
	DeptService service;
	/**
	 * ��ѯ�ķ���
	 */
	@ResponseBody
	@RequestMapping("/queryDept")
	public List<TreeNode> queryDept(Integer id){
		if(id==null){
			id=0;
		}
		return service.queryDept(id);
	}
	
	
}
