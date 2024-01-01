package org.teasoft.exam.bee.superclass.supertestmore;

import org.teasoft.bee.osql.annotation.Column;
import org.teasoft.bee.osql.annotation.JoinTable;

public class EntityClass extends BaseClass{

	private Long id;
	@Column("name2")
	private String name;
	
	@JoinTable(mainField="id", subField="id")
	private School school;
	
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
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	
}
