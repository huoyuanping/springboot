 package com.et.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.et.dao.DeptMapper;
import com.et.entity.Dept;
import com.et.entity.DeptExample;
import com.et.entity.Student;
import com.et.entity.TreeNode;
import com.et.service.DeptService;
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptMapper dm;
	/**
	 * 查询部门表
	 */
	public List<TreeNode> queryDept(Integer pid){
		//发起sql语句查询总记录数
		DeptExample se=new DeptExample();
		se.createCriteria().andPidEqualTo(pid);
		List<Dept> list=dm.selectByExample(se);
		List<TreeNode> deptList=new ArrayList<TreeNode>();
		for (Dept d : list) {
			TreeNode tn=new TreeNode();
			tn.setId(d.getId());
			tn.setText(d.getDname());
			//判断当前节点下是否存在子节点
			if(queryDept(d.getId()).size()==0){
				tn.setState("open");
			}
			deptList.add(tn);
		}
		return deptList;
		
	}
	

}
