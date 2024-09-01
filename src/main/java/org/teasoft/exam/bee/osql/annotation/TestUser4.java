package org.teasoft.exam.bee.osql.annotation;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.Datetime;
import org.teasoft.bee.osql.annotation.Entity;
import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JustFetch;

/**
*@author Honey
*Create on 2020-10-01 12:41:06
*/
@Entity("TestUser")
public class TestUser4 implements Serializable {

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
//	@JustFetch("last_name || name")
	@JustFetch("CONCAT(last_name, name)") //mysql
	private String fullName;
	
	@JustFetch() //只获取值,不会用字段转到select,where中
	private String count1;
	
    @JoinTable(mainField = "id",subField = "id",subAlias = "t2")
	TestUser4 testUser;
	
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
	
	public String getCount1() {
		return count1;
	}

	public void setCount1(String count1) {
		this.count1 = count1;
	}

	public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("TestUser[");			
		 str.append("id=").append(id);		 
		 str.append(",email=").append(email);		 
		 str.append(",lastName=").append(lastName);		 
		 str.append(",fullName=").append(fullName);		 
		 str.append(",name=").append(name2);		 
		 str.append(",count1=").append(count1);		 
		 str.append(",password=").append(password);		 
		 str.append(",username=").append(username);		 
		 str.append(",createtime=").append(createtime);		 
		 str.append("]");			 
		 return str.toString();			 
	 }

}
