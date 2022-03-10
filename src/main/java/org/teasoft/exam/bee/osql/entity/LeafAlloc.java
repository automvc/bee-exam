package org.teasoft.exam.bee.osql.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
*@author Honey
*Create on 2020-10-01 12:41:06
*/
public class LeafAlloc implements Serializable {

	private static final long serialVersionUID = 1597359777172L;

	private Long id;
	private String bizTag;
	private Long maxId;
	private Integer step;
	private String description;
	private Timestamp updateTime;
	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBizTag() {
		return bizTag;
	}

	public void setBizTag(String bizTag) {
		this.bizTag = bizTag;
	}

	public Long getMaxId() {
		return maxId;
	}

	public void setMaxId(Long maxId) {
		this.maxId = maxId;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("LeafAlloc3[");			
		 str.append("id=").append(id);		 
		 str.append(",bizTag=").append(bizTag);		 
		 str.append(",maxId=").append(maxId);		 
		 str.append(",step=").append(step);		 
		 str.append(",description=").append(description);		 
		 str.append(",updateTime=").append(updateTime);		 
		 str.append(",version=").append(version);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}