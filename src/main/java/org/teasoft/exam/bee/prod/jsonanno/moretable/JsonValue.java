package org.teasoft.exam.bee.prod.jsonanno.moretable;

import java.io.Serializable;

/**
*@author Honey
*Create on 2022-03-06 13:37:32
*/
public class JsonValue implements Serializable {

	private static final long serialVersionUID = 1593190900011L;

	private String deptId;
	private String deptName;
	private String deptLeaderId;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLeaderId() {
		return deptLeaderId;
	}

	public void setDeptLeaderId(String deptLeaderId) {
		this.deptLeaderId = deptLeaderId;
	}

	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("JsonValue[");			
		 str.append("deptId=").append(deptId);		 
		 str.append(",deptName=").append(deptName);		 
		 str.append(",deptLeaderId=").append(deptLeaderId);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}