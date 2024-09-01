package org.teasoft.exam.bee.osql.sharding.moretable.entity;

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
public class Myorders implements Serializable {

	private static final long serialVersionUID = 1596710362247L;
	
	@JoinTable(mainField="userid,orderid", subField="userid,orderid", joinType=JoinType.JOIN)
	Ordersdetail ordersdetail;
	
	private Long id;
	private Long userid;
	private Long orderid;
	private String name;
	private BigDecimal total;
	private String createtime;
	private String remark;
	private String sequence;
	private String abc;
	private String updatetime;
	
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
		 StringBuilder str=new StringBuilder();	
		 str.append("Myorders[");			
		 str.append("id=").append(id);		 
		 str.append(",userid=").append(userid);		 
		 str.append(",orderid=").append(orderid);		 
		 str.append(",name=").append(name);		 
		 str.append(",total=").append(total);		 
		 str.append(",createtime=").append(createtime);		 
		 str.append(",remark=").append(remark);		 
		 str.append(",sequence=").append(sequence);		 
		 str.append(",abc=").append(abc);		 
		 str.append(",maxTotal=").append(maxTotal);		 
		 str.append(",minTotal=").append(minTotal);		 
		 str.append(",avgTotal=").append(avgTotal);	
		 str.append(",updatetime=").append(updatetime);	
		 
		 if(ordersdetail==null)
			 str.append(",ordersdetail").append("=null");	
		 else 
		   str.append(",").append(ordersdetail.toString());
		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}