package org.teasoft.exam.bee.osql.annotation.moretableeasy;

import java.io.Serializable;

import org.teasoft.bee.osql.SuidType;
//import org.teasoft.bee.osql.annotation.Datetime;
import org.teasoft.bee.osql.annotation.Entity;
import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;

/**
*@author Honey
*Create on 2021-08-26 00:08:47
*/
@Entity("Clazz")
public class Clazz1 implements Serializable {

	private static final long serialVersionUID = 1591972382398L;

	private Integer id;
	private String classname;
	private String place;
	private String teachername;
//	@Datetime(suidType=SuidType.SELECT)
	private String remark;
	
	@JoinTable(mainField="id", subField="classno", joinType=JoinType.JOIN,subClass="Student1")
	private Student1 student;  //Student1

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

	 public Student1 getStudent() {
		return student;
	}

	public void setStudent(Student1 student) {
		this.student = student;
	}

	public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("Clazz[");			
		 str.append("id=").append(id);		 
		 str.append(",classname=").append(classname);		 
		 str.append(",place=").append(place);		 
		 str.append(",teachername=").append(teachername);		 
		 str.append(",remark=").append(remark);		 
		 
		 if(student==null)
			 str.append(",student").append("=null");	
		 else 
		   str.append(",").append(student.toString());
		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}