package org.teasoft.exam.bee.osql.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.annotation.Entity;
import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;

/**
*@author Honey
*Create on 2021-08-26 00:08:47
*/
@Entity("Clazz")
public class Clazz02 implements Serializable {

	private static final long serialVersionUID = 1591972382398L;

	private Integer id;
	private String classname;
	private String place;
	private String teachername;
	private String remark;
	
	@JoinTable(mainField="id", subField="id", joinType=JoinType.LEFT_JOIN,subAlias="stu02")
	private List<Student> studentList=new ArrayList<>();
	
	@JoinTable(mainField="id", subField="id", joinType=JoinType.LEFT_JOIN)
	private List<StudentHobby> studentHobbyList=new ArrayList<>();  //List type
	
//	@JoinTable(mainField="id", subField="id", joinType=JoinType.LEFT_JOIN)    //test exception
//	private List<StudentHobby> studentHobbyList2=new ArrayList<>();  //List type

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
	

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public List<StudentHobby> getStudentHobbyList() {
		return studentHobbyList;
	}

	public void setStudentHobbyList(List<StudentHobby> studentHobbyList) {
		this.studentHobbyList = studentHobbyList;
	}

	public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("Clazz[");			
		 str.append("id=").append(id);		 
		 str.append(",classname=").append(classname);		 
		 str.append(",place=").append(place);		 
		 str.append(",teachername=").append(teachername);		 
		 str.append(",remark=").append(remark);		 
		 
		 if(studentList==null)
			 str.append(",studentList").append("=null");	
		 else 
		   str.append(",").append(studentList.toString());
		 
		 if(studentHobbyList==null)
			 str.append(",studentHobbyList").append("=null");	
		 else 
		   str.append(",").append(studentHobbyList.toString());
		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}