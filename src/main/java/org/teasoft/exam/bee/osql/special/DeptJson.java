/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class DeptJson {
//	jsonValue={"deptId": "1", "deptName": "部门1", "deptLeaderId": "3"}
	
	private String deptId; 
	private String deptName;
	private String deptLeaderId;
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptLeaderId() {
		return deptLeaderId;
	}
	public void setDeptLeaderId(String deptLeaderId) {
		this.deptLeaderId = deptLeaderId;
	}

}
