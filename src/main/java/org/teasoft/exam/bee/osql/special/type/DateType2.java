package org.teasoft.exam.bee.osql.special.type;

import java.io.Serializable;
import java.sql.Timestamp;
//import java.sql.Timestamp;
//import java.sql.Date;
import java.util.Date;

import org.teasoft.bee.osql.annotation.Entity;

/**
*@author Honey
*Create on 2022-03-02 16:38:29
*/
@Entity("DateType")
public class DateType2 implements Serializable {

	private static final long serialVersionUID = 1592085476311L;

	private Long id;
//	private Timestamp date1;
//	private Date date2;
	
	private Date date1;
	private Date date3;
	private java.sql.Date date2;
	private String remark;
	
	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	
	public Date getDate3() {
		return date3;
	}

	public void setDate3(Date date3) {
		this.date3 = date3;
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

	public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("DateType[");			
		 str.append("id=").append(id);		 
		 str.append(",date1=").append(date1);		 
		 str.append(",date2=").append(date2);		 
		 str.append(",date3=").append(date3);		 
		 str.append(",remark=").append(remark);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}