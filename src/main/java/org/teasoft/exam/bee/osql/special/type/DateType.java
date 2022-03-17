package org.teasoft.exam.bee.osql.special.type;

import java.io.Serializable;
import java.sql.Timestamp;
//import java.sql.Timestamp;
//import java.sql.Date;
import java.util.Date;

/**
*@author Honey
*Create on 2022-03-02 16:38:29
*/
public class DateType implements Serializable {

	private static final long serialVersionUID = 1592085476311L;

	private Long id;
//	private Timestamp date1;
//	private Date date2;
	
	private Date date1;
	private java.sql.Date date2;
	
	private Timestamp createtime;
	
	private String remark;
	
	private String userId;
	private String userid;
	
	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	/*public Timestamp getDate1() {
		return date1;
	}
	
	public void setDate1(Timestamp date1) {
		this.date1 = date1;
	}
	
	public Date getDate2() {
		return date2;
	}
	
	public void setDate2(Date date2) {
		this.date2 = date2;
	}*/

	public java.sql.Date getDate2() {
		return date2;
	}

	public void setDate2(java.sql.Date date2) {
		this.date2 = date2;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("DateType[");			
		 str.append("id=").append(id);		 
		 str.append(",date1=").append(date1);		 
		 str.append(",date2=").append(date2);		 
		 str.append(",createtime=").append(createtime);		 
		 str.append(",remark=").append(remark);		 
		 str.append(",userId=").append(userId);		 
		 str.append(",userid=").append(userid);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}