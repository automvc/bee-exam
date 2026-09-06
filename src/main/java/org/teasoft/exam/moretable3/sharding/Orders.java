package org.teasoft.exam.moretable3.sharding;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;
import org.teasoft.bee.osql.annotation.JustFetch;
import org.teasoft.bee.osql.annotation.Table;

/**
*@author Honey
*Create on 2020-03-03 11:33:21
*/
//@Table("")
public class Orders implements Serializable {

	private static final long serialVersionUID = 1592526978329L;
	
	@JoinTable(mainField="userid", subField="id", joinType=JoinType.LEFT_JOIN, subClass = TestUser.class)  //ok //... from orders left join test_user on orders.userid=test_user.username where ...
    private TestUser testUser;
	
	public TestUser getTestUser() {
		return testUser;
	}

	public void setTestUser(TestUser testUser) {
		this.testUser=testUser;
	}
	

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
	
	@JustFetch //只用于接收数据
	private String sumOrderid;
	
	@JustFetch
	private String avgOrderid;
	
	public String getSumOrderid() {
		return sumOrderid;
	}

	public void setSumOrderid(String sumOrderid) {
		this.sumOrderid = sumOrderid;
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

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Orders {");
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
		str.append(",sumOrderid=").append(sumOrderid);
		str.append(",avgOrderid=").append(avgOrderid);
		
		if (getTestUser() != null) {
			str.append(",testUser=").append(getTestUser().toString());
		} else {
			str.append(",testUser=null");
		}
		
		str.append("}");
		return str.toString();
	}	
	
}