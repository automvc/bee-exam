package org.teasoft.exam.bee.osql.sharding.moretable.entity;

import java.io.Serializable;

/**
 * @author Honey
 * Create on 2022-09-05 15:31:10
 */
public class Ordersdetail implements Serializable {

	private static final long serialVersionUID = 1592085161536L;

	private Long id;
	private Long orderid;
	private Long userid;
	private Long item;
	private String detail;
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getItem() {
		return item;
	}

	public void setItem(Long item) {
		this.item = item;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	 public String toString(){	
		 StringBuilder str=new StringBuilder();	
		 str.append("Ordersdetail[");			
		 str.append("id=").append(id);		 
		 str.append(",orderid=").append(orderid);		 
		 str.append(",userid=").append(userid);		 
		 str.append(",item=").append(item);		 
		 str.append(",detail=").append(detail);		 
		 str.append(",remark=").append(remark);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}