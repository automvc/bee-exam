package org.teasoft.exam.bee.osql.entity;

import java.io.Serializable;
import java.util.List;

import org.teasoft.bee.osql.annotation.Entity;
import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;

/**
*@author Honey
*Create on 2021-10-13 13:41:33
*/
@Entity("Tables")
public class Tables2 implements Serializable {

	private static final long serialVersionUID = 1592797891739L;

	private Integer tableId;
	private String tableName;
	
	@JoinTable(mainField="table_id", subField="table_id",subClass="Columns", joinType=JoinType.JOIN)
	private List<Columns> list;
	
	public List<Columns> getList() {
		return list;
	}

	public void setList(List<Columns> list) {
		this.list = list;
	}

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
		 str.append("Tables2[");			
		 str.append("tableId=").append(tableId);		 
		 str.append(",tableName=").append(tableName);
		 
		 if(list==null) {
//			 str.append(",list").append("=null");	
		 }else { 
		   str.append(",").append(list.toString());
		 }
		 
		 str.append("]");
		 
		 return str.toString();			 
	 }		 
}