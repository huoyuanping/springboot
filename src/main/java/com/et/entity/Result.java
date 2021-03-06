package com.et.entity;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * 返回状态对象的类
 * @author Administrator
 *
 */
public class Result {
	/**
	 * 定义代码
	 * 0表示失败
	 * 1表示成功
	 */
	private int code;
	/**
	 * 定义失败的消息
	 */
	private String message;

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		if(message!=null&&message.length()>1000){
			
			return message.substring(0,1000);
		}
		return message;
	}
	public void setMessage(Exception msg) {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		msg.printStackTrace(new PrintStream(baos));
		this.message =new String( baos.toByteArray());
	}
	
	
}
