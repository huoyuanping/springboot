package com.et.service;

import com.et.entity.Emp;
import com.et.utils.PageTools;



public interface EmpService {
	
	
	/**
	 * ��ѯ����
	 */
	public abstract PageTools queryEmp(Integer id,String ename,Integer page,Integer rows);
	/**
	 * �޸�Ա����Ϣ
	 */
	public abstract void updateEmp(Emp emp);
	/**
	 * ���Ա����Ϣ
	 */
	public abstract void saveEmp(Emp emp);
	
	/**
	 * ͨ��idɾ��Ա��
	 */
	public  abstract void deleteEmp(Integer id);
}