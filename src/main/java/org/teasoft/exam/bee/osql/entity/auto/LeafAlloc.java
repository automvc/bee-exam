package org.teasoft.exam.bee.osql.entity.auto;

import java.io.Serializable;
import java.sql.Timestamp;

import org.teasoft.bee.osql.annotation.Entity;

/**
*@author Honey
*Create on 2020-06-13 18:42:08
*/
//@Table("LeafAlloc${version}")
@Entity("LeafAlloc${version}")
public class LeafAlloc implements Serializable {

	private static final long serialVersionUID = 1596826223978L;

	private Long id;
	private String bizTag;
	private Long maxId;
	private Integer step;
	private String description;
	private Timestamp updateTime;
	private Long version;

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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
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