package org.teasoft.exam.bee.osql.extend;

import java.io.Serializable;
import java.math.BigDecimal;

/**
*@author Honey
*/
	public class Orders  extends BaseEntity  implements Serializable {

	
	private static final long serialVersionUID = 1593472489996L;

	//time-->String
	private Long id;
	private String userid;
	private String name;
	private BigDecimal total;
	
	private Long orderid;
//	@Createtime
//	private String createtime;
//	private String remark;
//	private String sequence;
//	private String abc;
//	private String updatetime;

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
	
	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("Orders[");			
		 str.append("id=").append(id);		 
		 str.append(",userid=").append(userid);		 
		 str.append(",orderid=").append(orderid);		 
		 str.append(",name=").append(name);		 
		 str.append(",total=").append(total);		 
		 str.append(",createtime=").append(getCreatetime());		 
		 str.append(",remark=").append(getRemark());		 
		 str.append(",sequence=").append(getSequence());		 
		 str.append(",abc=").append(getAbc());		 
		 str.append(",updatetime=").append(getUpdatetime());		 
		 str.append("]");			 
		 return str.toString();			 
	 }	
	 
	 
}