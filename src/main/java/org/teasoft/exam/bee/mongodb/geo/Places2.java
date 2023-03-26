package org.teasoft.exam.bee.mongodb.geo;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.Table;



/**
 * 嵌入式文档使用String类型
 * @author Honey
 * Create on 2023-03-26 12:08:40
 */
@Table("places")
public class Places2 implements Serializable {

	private static final long serialVersionUID = 1596145310658L;

	private String id;
	private String name;
	private String location;   //嵌入式文档使用String类型
	private String category;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Places [id=" + id + ", name=" + name + ", location=" + location + ", category="
				+ category + "]";
	}
	
	

}