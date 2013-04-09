package com.archie.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


public class User {

	private int uid;
	@NotEmpty(message="用户名不能为空")
	@Size(max=10,message="最多为10个字符")
	private String uname;
	@NotEmpty(message="用户密码不能为空")
	@Size(max=10,message="最多为10个字符")
	private String upwd;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
}
