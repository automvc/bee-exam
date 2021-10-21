package org.teasoft.exam.bee.osql.entity;

import java.io.Serializable;

/**
*@author Honey
*Create on 2021-10-16 23:31:57
*/
public class Tables implements Serializable {

	private static final long serialVersionUID = 1590644473308L;

	private Integer tableId;
	private String tableName;

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("Tables[");			
		 str.append("tableId=").append(tableId);		 
		 str.append(",tableName=").append(tableName);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}