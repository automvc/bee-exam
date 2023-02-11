package org.teasoft.exam.bee.prod.column;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.Column;
import org.teasoft.bee.osql.annotation.Entity;
import org.teasoft.bee.osql.annotation.PrimaryKey;

/**
*@author Honey
*Create on 2022-02-24 10:56:48
*/
@Entity("ColumnTest")
public class ColumnTest2 implements Serializable {

	private static final long serialVersionUID = 1592836260459L;
	
	@Column("uuid")
	@PrimaryKey
	private String id;
	
	private String name;
	
	@Column("num")
	private Integer num2;
	
	private String remark;
	private String ch;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
//	public String getId2() {
//		return id2;
//	}
//
//	public void setId2(String id2) {
//		this.id2 = id2;
//	}
	
	
	public String getName() {
		return name;
	}

//	public String getID() {
//		return ID;
//	}
//
//	public void setID(String iD) {
//		ID = iD;
//	}

	public void setName(String name) {
		this.name = name;
	}

//	public Integer getNum() {
//		return num;
//	}
//
//	public void setNum(Integer num) {
//		this.num = num;
//	}

	public String getRemark() {
		return remark;
	}

	public Integer getNum2() {
		return num2;
	}

	public void setNum2(Integer num2) {
		this.num2 = num2;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCh() {
		return ch;
	}

	public void setCh(String ch) {
		this.ch = ch;
	}

	 public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("ColumnAnnoTest[");			
		 str.append("id=").append(id);		 
//		 str.append("id=").append(id2);		 
//		 str.append("id=").append(ID);		 
		 str.append(",name=").append(name);		 
		 str.append(",num2=").append(num2);		 
		 str.append(",remark=").append(remark);		 
		 str.append(",ch=").append(ch);		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}