package org.teasoft.exam.bee.osql.entity;

import java.io.Serializable;

/**
*@author Honey
*Create on 2020-09-19 19:02:36
*/
public class LeafAlloc implements Serializable {

	private static final long serialVersionUID = 1593861377170L;

	private Long id;
	private String bizTag;
	private Long maxId;
	private Integer step;
	private String description;
	private String updateTime;
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

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
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
		 str.append("LeafAlloc[");			
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