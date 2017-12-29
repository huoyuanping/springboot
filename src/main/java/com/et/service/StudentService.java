package com.et.service;

import com.et.entity.Student;
import com.et.utils.PageTools;



public interface StudentService {
	/**
	 * 查询方法
	 * @param sname学生姓名
	 * @param page 当前页
	 * @param rows 每页显示多少行
	 * @return
	 */
	public abstract PageTools queryStudent(String sname,Integer page,Integer rows);
	/**
	 * 通过id删除学生
	 * @param sid 学生id
	 */
	public  abstract void deleteStudent(Integer sid);
	/**
	 * 修改学生信息
	 * @param student 学生对象
	 */
	public abstract void updateStudent(Student student);
	/**
	 * 添加学生信息
	 * @param student 学生对象
	 */
	public abstract void saveFood(Student student);
}