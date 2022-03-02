package org.teasoft.exam.bee.osql.annotation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.teasoft.bee.osql.SuidType;
import org.teasoft.bee.osql.annotation.Datetime;
import org.teasoft.bee.osql.annotation.Entity;
import org.teasoft.bee.osql.annotation.Updatetime;

/**
*@author Honey
*Create on 2020-10-01 12:41:06
*/
@Entity("Orders")
public class Orders2 implements Serializable {

	
	private static final long serialVersionUID = 1593472489996L;

	//time-->String
	private Long id;
	private String userid;
	private String name;
	private BigDecimal total;
	
//	@Createtime
	@Datetime(suidType=SuidType.SUID)
	private Timestamp createtime;
	private String remark;
	private String sequence;
	private String abc;
	
//	@Datetime(suidType=SuidType.SELECT)
	@Updatetime
	private java.sql.Date updatetime;
	
//	@Datetime(suidType=SuidType.SELECT)
//	private java.util.Date updatetime2;

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

//	public String getCreatetime() {
//		return createtime;
//	}
//
//	public void setCreatetime(String createtime) {
//		this.createtime = createtime;
//	}
	

	public String getRemark() {
		return remark;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	
//	public java.util.Date getUpdatetime2() {
//		return updatetime2;
//	}
//
//	public void setUpdatetime2(java.util.Date updatetime2) {
//		this.updatetime2 = updatetime2;
//	}

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

//	public String getUpdatetime() {
//		return updatetime;
//	}
//
//	public void setUpdatetime(String updatetime) {
//		this.updatetime = updatetime;
//	}
	
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
		 str.append("]");			 
		 return str.toString();			 
	 }

	public java.sql.Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(java.sql.Date updatetime) {
		this.updatetime = updatetime;
	}	
	 
	 
	 /*	private static final long serialVersionUID = 1598614651697L;

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
			 str.append("]");			 
			 return str.toString();			 
		 }	*/	
}