 package com.et.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.et.dao.EmpMapper;
import com.et.entity.Emp;
import com.et.entity.EmpExample;
import com.et.entity.EmpExample.Criteria;
import com.et.service.EmpService;
import com.et.utils.PageTools;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpMapper em;
	public PageTools queryEmp(Integer id,String ename,Integer page,Integer rows){
		if(ename==null){
			ename="";
		}
		
		//����sql����ѯ�ܼ�¼��
		EmpExample se=new EmpExample();
		Criteria criteria = se.createCriteria();
		criteria.andEnameLike("%"+ename+"%");
		if(id!=null){
			criteria.andDeptidEqualTo(id);
		}
		int totalCount=(int)em.countByExample(se);
		PageTools pt=new PageTools(page, totalCount, rows);
		RowBounds rb=new RowBounds( pt.getStartIndex()-1, rows);
		List<Emp> list=em.selectByExampleWithRowbounds(se, rb);
		pt.setRows(list);
		return pt;
		
	}
	
	/**
	 * ��ȡ������
	 */
	public int queryEmpCount(EmpExample se){
		int totalCount=(int)em.countByExample(se);
		return totalCount;
	}
	
	
	/**
	 * �޸�Ա����Ϣ
	 */
	public void updateEmp(Emp emp) {
		em.updateByPrimaryKey(emp);
		
	}
	/**
	 * ���Ա����Ϣ
	 */
	public void saveEmp(Emp emp) {
		em.insert(emp);
		
	}
	/**
	 * ͨ��idɾ��Ա��
	 */
	public void deleteEmp(Integer id) {
		em.deleteByPrimaryKey(id);
		
	}
	
	
}
