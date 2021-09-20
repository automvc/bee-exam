/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.moretable.entity;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.Entity;
import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;

/**
 * @author Kingstar
 * @since  1.9.8
 */
@Entity("TestUser")
public class TestUser2 implements Serializable {

	private static final long serialVersionUID = 1592134386464L;

	private Long id;
	private String email;
	private String lastName;
	private String name;
	private String password;
	private String username;
	private String createtime;
	
	@JoinTable(mainField="id", subField="id", joinType=JoinType.LEFT_JOIN)
	private Assigncourse assigncourse;
	
	@JoinTable(mainField="id", subField="id", joinType=JoinType.LEFT_JOIN)
	private Assignexam Assignexam;
	
	
	public Assigncourse getAssigncourse() {
		return assigncourse;
	}

	public void setAssigncourse(Assigncourse assigncourse) {
		this.assigncourse = assigncourse;
	}

	public Assignexam getAssignexam() {
		return Assignexam;
	}

	public void setAssignexam(Assignexam assignexam) {
		Assignexam = assignexam;
	}

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
		 str.append("TestUser[");			
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
