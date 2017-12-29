package com.et.controller;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.et.entity.Result;
import com.et.entity.Student;
import com.et.service.StudentService;
import com.et.utils.PageTools;




@Controller
public class StudentController {
	@Autowired
	StudentService service;
	/**
	 * ��ѯ�ķ���
	 * @param snameѧ������
	 * @param page ��ǰҳ
	 * @param rows ÿҳ��ʾ������
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryStudent")
	public PageTools queryStudent(String sname,Integer page,Integer rows){
		return service.queryStudent(sname,page,rows);
	}
	
	/**
	 * ɾ��ѧ��
	 */
	@ResponseBody
	@RequestMapping(value="/deleteStudent/{sid}",method=RequestMethod.DELETE)
	public Result deleteStudent(@PathVariable String sid,Integer page,Integer rows){
	/*	//ɾ��һ��
		Result rt=new Result();
		rt.setCode(1);
		try {
			//����쳣
			//String str=null;
			//str.toString();
			service.deleteStudent(Integer.parseInt(sid));
		} catch (Exception e) {
			rt.setCode(0);
			rt.setMessage(e);
		}
		return rt;*/
		
		// ɾ������
		Result rt = new Result();
		rt.setCode(1);
		
		String[] str=sid.split(",");
		
		try {
			//����쳣
			/*String str=null;
			str.toString();*/
			for(int i=0;i<str.length;i++){
				//ɾ��
				service.deleteStudent(Integer.parseInt(str[i]));
			}
		} catch (Exception e) {
			//ɾ��ʧ��
			rt.setCode(0);
			rt.setMessage(e);		
		}
		
		return rt;
	
	}
	
	
	/**
	 * �޸�ѧ����Ϣ
	 */
	@ResponseBody
	@RequestMapping(value="/updateStudent/{sid}",method=RequestMethod.PUT)
	public Result updateStudent(@PathVariable Integer sid,Student student,Integer page,Integer rows){
	
		student.setSid(sid);
		Result rt=new Result();
		rt.setCode(1);
		try {
			service.updateStudent(student);
		} catch (Exception e) {
			rt.setCode(0);
			rt.setMessage(e);
		}
		return rt;
	}
	
	/**
	 *���ѧ����Ϣ
	 */
	@ResponseBody
	@RequestMapping(value="/saveStudent",method=RequestMethod.POST)
	public Result saveStudent(Student student,MultipartFile  myImage){
		Result rt=new Result();
		rt.setCode(1);
		try {
			//��ȡ�ļ���
			String fileName=myImage.getOriginalFilename();
			File destFile=new File("E:\\myImages\\"+fileName);
			myImage.transferTo(destFile);
			service.saveFood(student);
		} catch (Exception e) {
			rt.setCode(0);
			rt.setMessage(e);
		}
		return rt;
	}
}
