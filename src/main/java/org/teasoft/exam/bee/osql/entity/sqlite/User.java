package org.teasoft.exam.bee.osql.entity.sqlite;

import java.io.Serializable;

/**
*@author Honey
*Create on 2020-09-19 11:55:17
*/
public class User implements Serializable {

	private static final long serialVersionUID = 1597026185125L;

	private Long id;
	private String email;
	private String lastName;
	private String name;
	private String password;
	private String username;
	private String createtime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("User[");			
		 str.append("id=").append(id);		 
		 str.append(",email=").append(email);		 
		 str.append(",lastName=").append(lastName);		 
		 str.append(",name=").append(name);		 
		 str.append(",password=").append(password);		 
		 str.append(",username=").append(username);		 
		 str.append(",createtime=").append(createtime);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}