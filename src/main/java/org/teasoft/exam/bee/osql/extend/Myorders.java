package org.teasoft.exam.bee.osql.extend;

import java.io.Serializable;
import java.math.BigDecimal;

import org.teasoft.bee.osql.annotation.Ignore;
import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;
import org.teasoft.bee.osql.annotation.JustFetch;

/**
 * @author Honey
 * Create on 2022-08-23 23:31:36
 */
public class Myorders extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1596710362247L;
	
	@JoinTable(mainField="userid,orderid", subField="userid,orderid", joinType=JoinType.JOIN)
	Ordersdetail ordersdetail;
	
	private Long id;
	private Long userid;
	private Long orderid;
	private String name;
	private BigDecimal total;
//	private String createtime;
//	private String remark;
//	private String sequence;
//	private String abc;
//	private String updatetime;
	
	@Ignore()
	private String maxTotal;
	
	@Ignore()
	private Double minTotal;
	
	@Ignore()
	private Double avgTotal;
	
	public Ordersdetail getOrdersdetail() {
		return ordersdetail;
	}

	public void setOrdersdetail(Ordersdetail ordersdetail) {
		this.ordersdetail = ordersdetail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
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
		 StringBuilder str=new StringBuilder();	
		 str.append("Myorders[");			
		 str.append("id=").append(id);		 
		 str.append(",userid=").append(userid);		 
		 str.append(",orderid=").append(orderid);		 
		 str.append(",name=").append(name);		 
		 str.append(",total=").append(total);		 
		 str.append(",createtime=").append(getCreatetime());		 
		 str.append(",remark=").append(getRemark());		 
		 str.append(",sequence=").append(getSequence());		 
		 str.append(",abc=").append(getAbc());		 
		 str.append(",maxTotal=").append(maxTotal);		 
		 str.append(",minTotal=").append(minTotal);		 
		 str.append(",avgTotal=").append(avgTotal);	
		 str.append(",updatetime=").append(getUpdatetime());	
		 
		 if(ordersdetail==null)
			 str.append(",ordersdetail").append("=null");	
		 else 
		   str.append(",").append(ordersdetail.toString());
		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}