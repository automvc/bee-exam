package org.teasoft.exam.bee.superclass.supertestmore;

import java.util.List;

import org.teasoft.bee.osql.annotation.Column;
import org.teasoft.bee.osql.annotation.Entity;
import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;

@Entity("EntityClass")
public class EntityClass2 extends BaseClass{

	private Long id;
//	@Column("name2")
	private String name;
	
//	@JoinTable(mainField="id", subField="id")
//	private School school;
	
	@JoinTable(mainField="id", subField="id",subClazz = Course.class ,joinType=JoinType.LEFT_JOIN)
	private List<Course> list;
	
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
	
	public List<Course> getList() {
		return list;
	}
	public void setList(List<Course> list) {
		this.list = list;
	}
	
//	public School getSchool() {
//		return school;
//	}
//	public void setSchool(School school) {
//		this.school = school;
//	}
	
	
	
}
