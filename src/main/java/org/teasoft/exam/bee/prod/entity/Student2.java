package org.teasoft.exam.bee.prod.entity;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.Dict;
import org.teasoft.bee.osql.annotation.DictI18n;
import org.teasoft.bee.osql.annotation.Table;

/**
*@author Honey
*Create on 2022-02-16 16:30:48
*/
//@Table("Student")
public class Student2 implements Serializable {

	private static final long serialVersionUID = 1593906236489L;

	private Long id;
	private Integer sid;
	@DictI18n
	private String name;
	private Integer age;
//	@Dict(map = "0=女,1=男")
	@Dict(map = "0=女,1=男",nullToValue="未知")
	private String sex;
	@DictI18n
	private String majorid;
//	@Dict(map = "0=No,1=Yes",nullToValue="?")
	@Dict(map = "0=No,1=Yes,=empty,",nullToValue="?")
	private String flag;
	private Integer classno;
	
	public Student2(){
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMajorid() {
		return majorid;
	}

	public void setMajorid(String majorid) {
		this.majorid = majorid;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
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
		 str.append("Student2[");			
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