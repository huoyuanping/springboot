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
	 * ��ѯ���ű�
	 */
	public List<TreeNode> queryDept(Integer pid){
		//����sql����ѯ�ܼ�¼��
		DeptExample se=new DeptExample();
		se.createCriteria().andPidEqualTo(pid);
		List<Dept> list=dm.selectByExample(se);
		List<TreeNode> deptList=new ArrayList<TreeNode>();
		for (Dept d : list) {
			TreeNode tn=new TreeNode();
			tn.setId(d.getId());
			tn.setText(d.getDname());
			//�жϵ�ǰ�ڵ����Ƿ�����ӽڵ�
			if(queryDept(d.getId()).size()==0){
				tn.setState("open");
			}
			deptList.add(tn);
		}
		return deptList;
		
	}
	

}
