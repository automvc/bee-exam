package org.teasoft.exam.bee.prod.jsonanno.moretable;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.JoinTable;

/**
*@author Honey
*Create on 2022-03-07 21:30:05
*/
public class Company implements Serializable {

	private static final long serialVersionUID = 1597025300241L;

	private Integer id;
	private String comName;
	private Integer deptId;
	private String remark;

	@JoinTable(mainField = "dept_id", subField = "id")
	private Dept dept;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Company[");
		str.append("id=").append(id);
		str.append(",comName=").append(comName);
		str.append(",deptId=").append(deptId);
		str.append(",remark=").append(remark);
		if (dept != null)
			str.append(",dept=").append(dept.toString());
		else
			str.append(",dept=null");
		str.append("]");
		return str.toString();
	}
}