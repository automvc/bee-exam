package org.teasoft.exam.bee.osql.annotation.listmoretable2;

import java.io.Serializable;

import org.teasoft.bee.osql.SuidType;
import org.teasoft.bee.osql.annotation.Datetime;

/**
*@author Honey
*Create on 2021-08-26 00:10:15
*/
public class Student implements Serializable {

	private static final long serialVersionUID = 1591622324231L;

	private Integer id;
	private Integer sid;
	@Datetime(suidType=SuidType.SELECT)
	private String name;
	private Integer age;
	private Boolean sex;
	private String majorid;
	private Boolean flag;
	private Integer classno;	
	

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

	public String getMajorid() {
		return majorid;
	}

	public void setMajorid(String majorid) {
		this.majorid = majorid;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Integer getClassno() {
		return classno;
	}

	public void setClassno(Integer classno) {
		this.classno = classno;
	}
	


	public String toString(){	
		 StringBuffer str=new StringBuffer();	
		 str.append("Student[");			
		 str.append("id=").append(id);		 
		 str.append(",sid=").append(sid);		 
		 str.append(",name=").append(name);		 
		 str.append(",age=").append(age);		 
		 str.append(",sex=").append(sex);		 
		 str.append(",majorid=").append(majorid);		 
		 str.append(",flag=").append(flag);		 
		 str.append(",classno=").append(classno);	
		 
		 
		 str.append("]");			 
		 return str.toString();			 
	 }		 
}