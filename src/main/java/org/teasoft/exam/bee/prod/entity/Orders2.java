package org.teasoft.exam.bee.prod.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.teasoft.bee.osql.SuidType;
import org.teasoft.bee.osql.annotation.Datetime;
import org.teasoft.bee.osql.annotation.Desensitize;
import org.teasoft.bee.osql.annotation.Entity;

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
	private String createtime;
//	@CreateBy(handler = CreateByHandler.class, suidType = SuidType.INSERT)
	private String remark;

//	@AutoSetString(handler = CreateByHandler.class, suidType = SuidType.SELECT)
	@Desensitize(start = 5, size = 2, mask = "*")
	private String sequence;
//	@AutoSetString(handler = CreateByHandler.class, suidType = SuidType.SELECT)
//	@Desensitize(start = 6, size = 3, mask = "*") //开始位置超过字符长度,将不转换
	@Desensitize(start = 1, size = 2, mask = "*")
	private String abc;
	@Datetime(suidType = SuidType.UPDATE)
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
		StringBuffer str = new StringBuffer();
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
}