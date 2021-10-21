package org.teasoft.exam.bee.osql.entity;

import java.io.Serializable;

/**
*@author Honey
*Create on 2021-10-16 23:31:57
*/
public class Columns implements Serializable {

	private static final long serialVersionUID = 1595557514689L;

	private Integer tableId;
	private Integer columnId;
	private String columnName;

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Integer getColumnId() {
		return columnId;
	}

	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("Columns[");			
		 str.append("tableId=").append(tableId);		 
		 str.append(",columnId=").append(columnId);		 
		 str.append(",columnName=").append(columnName);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}