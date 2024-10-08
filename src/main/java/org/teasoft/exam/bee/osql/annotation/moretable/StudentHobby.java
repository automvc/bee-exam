package org.teasoft.exam.bee.osql.annotation.moretable;

import java.io.Serializable;

import org.teasoft.bee.osql.SuidType;
import org.teasoft.bee.osql.annotation.Datetime;

/**
*@author Honey
*Create on 2021-08-26 17:08:34
*/
public class StudentHobby implements Serializable {

	private static final long serialVersionUID = 1593647669662L;

	private Integer id;
//	private String stuId;
	private Integer stuId;
	private String hobby;
//	@Datetime(suidType=SuidType.SELECT)
	@Datetime(suidType=SuidType.MODIFY)
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public String getStuId() {
//		return stuId;
//	}
//
//	public void setStuId(String stuId) {
//		this.stuId = stuId;
//	}
	

	public String getHobby() {
		return hobby;
	}

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("StudentHobby[");			
		 str.append("id=").append(id);		 
		 str.append(",stuId=").append(stuId);		 
		 str.append(",hobby=").append(hobby);		 
		 str.append(",remark=").append(remark);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}