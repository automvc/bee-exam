package org.teasoft.exam.bee.osql.sharding.anno;

import java.io.Serializable;
import java.math.BigDecimal;

import org.teasoft.bee.osql.annotation.Entity;
import org.teasoft.bee.osql.annotation.Sharding;

/**
 * @author Honey
 * Create on 2022-08-23 23:31:36
 */
@Entity("Orders")
public class Orders4 implements Serializable {

	private static final long serialVersionUID = 1596710362247L;

	private Long id;
	private Long userid;
	private Long orderid;
	private String name;
	private BigDecimal total;
	private String createtime;
//	@Sharding(tabRule = "remark %6")  //Sharding注解,不用appointDS,appointTab时,至少要以下三项
	@Sharding(tabRule = "remark %6",dsName="ds",dsRule = "remark %6/3")
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
		 str.append("Orders1[");			
		 str.append("id=").append(id);		 
		 str.append(",userid=").append(userid);		 
		 str.append(",orderid=").append(orderid);		 
		 str.append(",name=").append(name);		 
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