 package com.et.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.et.dao.StudentMapper;
import com.et.entity.Student;
import com.et.entity.StudentExample;
import com.et.service.StudentService;
import com.et.utils.PageTools;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentMapper sm;
	/**
	 * ��ѯѧ��
	 */
	public PageTools queryStudent(String sname,Integer page,Integer rows){
		if(sname==null){
			sname="";
		}
		//����sql����ѯ�ܼ�¼��
		StudentExample se=new StudentExample();
		se.createCriteria().andSnameLike("%"+sname+"%");
		int totalCount=(int)sm.countByExample(se);
		PageTools pt=new PageTools(page, totalCount, rows);
		RowBounds rb=new RowBounds( pt.getStartIndex()-1, rows);
		List<Student> list=sm.selectByExampleWithRowbounds(se, rb);
		pt.setRows(list);
		return pt;
		
	}
	
	/**
	 * ��ȡ������
	 */
	public int queryStudentCount(StudentExample se){
		int totalCount=(int)sm.countByExample(se);
		return totalCount;
	}
	/**
	 *ͨ��idɾ��ѧ��
	 */
	public void deleteStudent(Integer sid) {
		sm.deleteByPrimaryKey(sid);
	}

	
	/**
	 * �޸�ѧ����Ϣ
	 */
	public void updateStudent(Student student) {
		sm.updateByPrimaryKey(student);
	}
	/**
	 * ���ѧ����Ϣ
	 */
	public void saveFood(Student student) {
		sm.insert(student);
	}
	
}
