package org.teasoft.exam.bee.osql.sharding.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.teasoft.bee.osql.annotation.Column;
import org.teasoft.bee.osql.annotation.Entity;
import org.teasoft.bee.osql.annotation.JustFetch;

/**
 * @author Honey
 * Create on 2022-10-10 21:35:44
 */
@Entity("Orders")
public class OrdersGroupResponse implements Serializable {

	private static final long serialVersionUID = 1593604354717L;

	private Long id;
	
//	private Long userid;
	
	@Column("userid")
	private Long userId;
	
	private Long orderid;
	private String name;
	private BigDecimal total;
	private Integer num;
	private String createtime;
	private String remark;
	private String sequence;
	private String abc;
	private String updatetime;
	
	@JustFetch()
	private String maxTotal;
	
	@JustFetch("")
	private Double minTotal;
	
	@JustFetch("")
	private Double avgTotal;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


//	public Long getUserid() {
//		return userid;
//	}
//
//	public void setUserid(Long userid) {
//		this.userid = userid;
//	}
	
	public Long getOrderid() {
		return orderid;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
	
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
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
		 str.append("Orders[");			
		 str.append("id=").append(id);		 
//		 str.append(",userid=").append(userid);		 
		 str.append(",userId=").append(userId);		 
		 str.append(",orderid=").append(orderid);		 
		 str.append(",name=").append(name);		 
		 str.append(",total=").append(total);		 
		 str.append(",num=").append(num);		 
		 str.append(",createtime=").append(createtime);		 
		 str.append(",remark=").append(remark);		 
		 str.append(",sequence=").append(sequence);		 
		 str.append(",abc=").append(abc);		 
		 str.append(",updatetime=").append(updatetime);		 
		 str.append(",maxTotal=").append(maxTotal);		 
		 str.append(",minTotal=").append(minTotal);		 
		 str.append(",avgTotal=").append(avgTotal);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}