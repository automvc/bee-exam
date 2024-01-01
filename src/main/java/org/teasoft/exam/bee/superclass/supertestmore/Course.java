package org.teasoft.exam.bee.superclass.supertestmore;

import org.teasoft.bee.osql.annotation.Table;

@Table("Course2")
public class Course {
	
	private Long id;
	private String name;
	private String subject;
	private String teacher;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
}
