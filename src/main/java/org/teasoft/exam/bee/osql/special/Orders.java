package org.teasoft.exam.bee.osql.special;

import java.io.Serializable;
import java.math.BigDecimal;

import org.teasoft.bee.osql.annotation.Column;

/**
*@author Honey
*Create on 2022-07-11 12:41:06
*/
	public class Orders implements Serializable {

	
	private static final long serialVersionUID = 1593472489996L;

	private Long id;
	private String userid;
	@Column(value="name")
	private String name2;
	private BigDecimal total;
	private String createtime;
	private String remark;
	private String sequence;
	private String abc;
	private String updatetime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
	
	public BigDecimal getTotal() {
		return total;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getAbc() {
		return abc;
	}

	public void setAbc(String abc) {
		this.abc = abc;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("Orders[");			
		 str.append("id=").append(id);		 
		 str.append(",userid=").append(userid);		 
		 str.append(",name2=").append(name2);		 
		 str.append(",total=").append(total);		 
		 str.append(",createtime=").append(createtime);		 
		 str.append(",remark=").append(remark);		 
		 str.append(",sequence=").append(sequence);		 
		 str.append(",abc=").append(abc);		 
		 str.append(",updatetime=").append(updatetime);		 
		 str.append("]");			 
		 return str.toString();			 
	 }	
}