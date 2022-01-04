package org.teasoft.exam.bee.osql.special.primarykey.entity;

import java.io.Serializable;

/**
*@author Honey
*Create on 2022-01-03 13:09:46
*/
public class TestPrimaryKey implements Serializable {

	private static final long serialVersionUID = 1598866930570L;

	private Long myid;
	private String name;
	private String remark;
	private String remark2;

	public Long getMyid() {
		return myid;
	}

	public void setMyid(Long myid) {
		this.myid = myid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("TestPrimaryKey[");			
		 str.append("myid=").append(myid);		 
		 str.append(",name=").append(name);		 
		 str.append(",remark=").append(remark);		 
		 str.append(",remark2=").append(remark2);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}