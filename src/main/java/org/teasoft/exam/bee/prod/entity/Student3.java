package org.teasoft.exam.bee.prod.entity;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.Entity;
import org.teasoft.bee.osql.annotation.MultiTenancy;

/**
*@author Honey
*Create on 2022-02-16 16:30:48
*/
@Entity("Student2")
public class Student3 implements Serializable {

	private static final long serialVersionUID = 1593906236489L;

//	@MultiTenancy(dsRule = "id%2",dsName = "bee",tabRule = "id%2",tabName = "student_")  //student_1
	@MultiTenancy(dsRule = "id%2",dsName = "bee",tabRule = "id%3",tabName = "student")  //student2
//	@MultiTenancy(dsRule = "id%2",dsName = "bee",tabRule = "id%3")  //student_1
//	@MultiTenancy(dsRule = "id%2",dsName = "bee",tabRule = "id%2") //只测表尾缀
//	@MultiTenancy(dsRule = "id%2",dsName = "bee",tabRule = "id%2",handler=CustomDefaultMultiTenancyHandler.class)
//	@MultiTenancy(dsRule = "id%2",dsName = "bee",tabRule = "id%2",handler=AbstractMultiTenancyHandler2.class)
	private Long id;
	private Integer sid;
	private String name;
	private Integer age;
	private String sex;
	private String majorid;
	private String flag;
	private Integer classno;
	
	public Student3(){
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