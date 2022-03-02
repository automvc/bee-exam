package org.teasoft.exam.bee.osql.annotation;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.Datetime;
import org.teasoft.bee.osql.annotation.JustFetch;

/**
*@author Honey
*Create on 2020-10-01 12:41:06
*/
public class TestUser implements Serializable {

	private static final long serialVersionUID = 1592134386464L;

	private Long id;
	private String email;
	private String lastName;
	
	@JustFetch("name")  //表列名,仅用于查询名称转换,在where条件不能使用
	private String name2;
//	@Ignore
	private String password;
	
	private String username;
	
//	@Datetime
	private String createtime;
	
//	@JustFetch("CONCAT(last_name,name)")
//	@JustFetch("last_name-- || name") //非法字符
//	@JustFetch("last_name; || name") //非法字符
	@JustFetch("last_name || name")
	private String fullName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	 public Date getCreatetime() {
//		return createtime;
//	}
//
//	public void setCreatetime(Date createtime) {
//		this.createtime = createtime;
//	}
	
	public String getCreatetime() {
		return createtime;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}	

	public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("TestUser[");			
		 str.append("id=").append(id);		 
		 str.append(",email=").append(email);		 
		 str.append(",lastName=").append(lastName);		 
		 str.append(",name=").append(name2);		 
		 str.append(",password=").append(password);		 
		 str.append(",username=").append(username);		 
		 str.append(",createtime=").append(createtime);		 
		 str.append("]");			 
		 return str.toString();			 
	 }

}
