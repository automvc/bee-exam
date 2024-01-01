package org.teasoft.exam.bee.superclass.supertestmore;

import org.teasoft.bee.osql.annotation.Column;

public class BaseClass extends BaseSuper{
	
	@Column("remark1")
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
