package org.teasoft.exam.bee.prod;

import java.io.Serializable;
import java.sql.Timestamp;

/**
*@author Honey
*Create on 2022-04-14 11:22:23
*/
public class DictI18n implements Serializable {

	private static final long serialVersionUID = 1592308946239L;

	private Long id;
	private String tableName;
	private String colName;
	private String lang;
	private String key1;
	private String value1;
	private Boolean status;
	private String creater;
	private Timestamp createtime;
	private String updater;
	private Timestamp updatetime;
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getKey1() {
		return key1;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("DictI18n[");			
		 str.append("id=").append(id);		 
		 str.append(",tableName=").append(tableName);		 
		 str.append(",colName=").append(colName);		 
		 str.append(",lang=").append(lang);		 
		 str.append(",key1=").append(key1);		 
		 str.append(",value1=").append(value1);		 
		 str.append(",status=").append(status);		 
		 str.append(",creater=").append(creater);		 
		 str.append(",createtime=").append(createtime);		 
		 str.append(",updater=").append(updater);		 
		 str.append(",updatetime=").append(updatetime);		 
		 str.append(",remark=").append(remark);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}