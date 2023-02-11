package org.teasoft.exam.bee.prod.column;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.Column;
import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;

/**
*@author Honey
*Create on 2021-08-26 00:10:15
*/
public class Student implements Serializable {

	private static final long serialVersionUID = 1591622324231L;

	private Integer id;
	private Integer sid;
	private String name;
	private Integer age;
	private Boolean sex;
	
	@Column("majorid")
	private String majorid2;
	private Boolean flag;
	
	@Column("classno") //测试关联字段
	private Integer classno2;	
	
	@JoinTable(mainField="id", subField="id", joinType=JoinType.LEFT_JOIN)
	StudentHobby studentHobby;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

//	public String getMajorid() {
//		return majorid;
//	}
//
//	public void setMajorid(String majorid) {
//		this.majorid = majorid;
//	}
	
	public Boolean getFlag() {
		return flag;
	}

	public String getMajorid2() {
		return majorid2;
	}

	public void setMajorid2(String majorid2) {
		this.majorid2 = majorid2;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

//	public Integer getClassno() {
//		return classno;
//	}
//
//	public void setClassno(Integer classno) {
//		this.classno = classno;
//	}

	public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("Student[");			
		 str.append("id=").append(id);		 
		 str.append(",sid=").append(sid);		 
		 str.append(",name=").append(name);		 
		 str.append(",age=").append(age);		 
		 str.append(",sex=").append(sex);		 
		 str.append(",majorid2=").append(majorid2);		 
		 str.append(",flag=").append(flag);		 
		 str.append(",classno2=").append(classno2);	
		 
		 
		 str.append("]");			 
		 return str.toString();			 
	 }

	public Integer getClassno2() {
		return classno2;
	}

	public void setClassno2(Integer classno2) {
		this.classno2 = classno2;
	}		 
}