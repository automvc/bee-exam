package org.teasoft.exam.bee.osql.dialect;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.Entity;
import org.teasoft.bee.osql.annotation.PrimaryKey;

/**
*@author Honey
*Create on 2021-07-08 22:25:17
*/
@Entity("Noid")
public class Noid2 implements Serializable {

	private static final long serialVersionUID = 1590272445571L;

	@PrimaryKey
	private String uuId;
	private String name;
	private Integer num;
	private String remark;

//	public String getUuid() {
//		return uuid;
//	}
//
//	public void setUuid(String uuid) {
//		this.uuid = uuid;
//	}
	

	public String getName() {
		return name;
	}

	public String getUuId() {
		return uuId;
	}

	public void setUuId(String uuId) {
		this.uuId = uuId;
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
		 str.append("Noid[");			
//		 str.append("uuid=").append(uuid);		 
		 str.append(",name=").append(name);		 
		 str.append(",num=").append(num);		 
		 str.append(",remark=").append(remark);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}