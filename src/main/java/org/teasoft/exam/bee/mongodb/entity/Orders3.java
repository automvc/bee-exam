/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.entity;

import java.io.Serializable;

/**
 * @author Kingstar
 * @since  2.0
 */
public class Orders3 implements Serializable {
	
	private static final long serialVersionUID = 1593604354717L;
	
	private String id;
	private String name;
	private String remark;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	 public String toString(){	
		 StringBuilder str=new StringBuilder();	
		 str.append("Orders3[");			
		 str.append("id=").append(id);		 
		 str.append(",name=").append(name);		 
		 str.append(",remark=").append(remark);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		

}
