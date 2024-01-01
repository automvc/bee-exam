package org.teasoft.exam.bee.superclass.supertestanno;

import org.teasoft.bee.osql.annotation.Column;

public class EntityClass extends BaseClass{

	private Long id;
	@Column("name2")
	private String name;
	
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
	
}
