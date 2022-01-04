package org.teasoft.exam.bee.osql.special.primarykey.entity;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.PrimaryKey;
import org.teasoft.bee.osql.annotation.Table;

/**
*@author Honey
*Create on 2021-07-08 22:25:17
*/
@Table("Noid")
public class CustomId implements Serializable {

	private static final long serialVersionUID = 1590272445571L;

	@PrimaryKey
	private String uuid;
	private String name;
	private Integer num;
	private String remark;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("CustomId[");			
		 str.append("uuid=").append(uuid);		 
		 str.append(",name=").append(name);		 
		 str.append(",num=").append(num);		 
		 str.append(",remark=").append(remark);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}