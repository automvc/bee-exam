package org.teasoft.exam.bee.osql.moretable.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;
import org.teasoft.bee.osql.annotation.Table;

/**
*@author Honey
*Create on 2020-03-03 11:33:21
*/
@Table("orders${month}")
public class Orders implements Serializable {

	private static final long serialVersionUID = 1592526978329L;
	
//	@JoinTable(mainField="userid", subField="username")
//	@JoinTable(mainField="userid", subField="username", joinType=JoinType.LEFT_JOIN)  //ok //... from orders left join test_user on orders.userid=test_user.username where ...
	@JoinTable(mainField="userid,name", subField="username,name", joinType=JoinType.JOIN)
//	@JoinTable(mainField="userid", subField="username",subAlias="myuser" , joinType=JoinType.FULL_JOIN)
//	@JoinTable()
    private TestUser testUser;
	
	public TestUser getTestUser() {
		return testUser;
	}

	public void setTestUser(TestUser testUser) {
		this.testUser=testUser;
	}
	

	private Long id;
	private String userid;
	private String name;
	private BigDecimal total;
	private Timestamp createtime;
	private String remark;
	private String sequence;
	private String abc;
	private Timestamp updatetime;

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

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
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

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("Orders[");			
		 str.append("id=").append(id);		 
		 str.append(",userid=").append(userid);		 
		 str.append(",name=").append(name);		 
		 str.append(",total=").append(total);		 
		 str.append(",createtime=").append(createtime);		 
		 str.append(",remark=").append(remark);		 
		 str.append(",sequence=").append(sequence);		 
		 str.append(",abc=").append(abc);		 
		 str.append(",updatetime=").append(updatetime);		 
		 
		 if(testUser==null)
			 str.append(",user").append("=null");	
		 else 
		   str.append(",").append(testUser.toString());
		 
		 str.append("]");			 
		 return str.toString();			 
	 }		
	
}