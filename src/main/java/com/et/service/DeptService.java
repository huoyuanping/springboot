package com.et.service;

import java.util.List;

import com.et.entity.TreeNode;



public interface DeptService {
	/**
	 * ��ѯ����
	 */
	public List<TreeNode> queryDept(Integer pid);
	
}