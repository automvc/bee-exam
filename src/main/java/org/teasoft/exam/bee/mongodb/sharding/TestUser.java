package org.teasoft.exam.bee.mongodb.sharding;

import java.io.Serializable;

/**
 * @author Honey
 * Create on 2023-01-25 22:27:57
 */
public class TestUser implements Serializable {

	private static final long serialVersionUID = 1594429986253L;

	private Long id;
	private String password;
	private String username;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	 public String toString(){	
		 StringBuilder str=new StringBuilder();	
		 str.append("TestUser[");			
		 str.append("id=").append(id);		 
		 str.append(",password=").append(password);		 
		 str.append(",username=").append(username);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}