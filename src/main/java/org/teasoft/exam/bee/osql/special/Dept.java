package org.teasoft.exam.bee.osql.special;

import java.io.Serializable;

/**
*@author Honey
*Create on 2021-10-25 21:35:58
*/
public class Dept implements Serializable {

	private static final long serialVersionUID = 1599384498761L;

	private Integer id;
	private String dept;
	//test Json field (eg: mysql 5.7)  
	private String jsonValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getJsonValue() {
		return jsonValue;
	}

	public void setJsonValue(String jsonValue) {
		this.jsonValue = jsonValue;
	}

	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("Dept[");			
		 str.append("id=").append(id);		 
		 str.append(",dept=").append(dept);		 
		 str.append(",jsonValue=").append(jsonValue);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}