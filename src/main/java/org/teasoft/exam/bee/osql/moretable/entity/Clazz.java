package org.teasoft.exam.bee.osql.moretable.entity;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;
import org.teasoft.exam.bee.osql.entity.Student;

/**
*@author Honey
*Create on 2021-08-26 00:08:47
*/
public class Clazz implements Serializable {

	private static final long serialVersionUID = 1591972382398L;

	private Integer id;
	private String classname;
	private String place;
	private String teachername;
	private String remark;
	
	@JoinTable(mainField="id", subField="classno", joinType=JoinType.LEFT_JOIN)
	private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

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