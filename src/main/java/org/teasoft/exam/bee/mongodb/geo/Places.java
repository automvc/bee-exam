package org.teasoft.exam.bee.mongodb.geo;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.GenUUID;
import org.teasoft.bee.osql.annotation.Table;
import org.teasoft.bee.osql.annotation.customizable.Json;

/**
 * @author Honey
 * Create on 2023-03-26 12:08:40
 */
//@Table("places0")
public class Places implements Serializable {

	private static final long serialVersionUID = 1596145310658L;

	@GenUUID
	private String id;
	private String name;
	@Json
	private Object  location;
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

//	public Location getLocation() {
//		return location;
//	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Object getLocation() {
		return location;
	}

	public void setLocation(Object location) {
		this.location = location;
	}

	public String getCategory() {
		return category;
	}

//	public String getLocation() {
//		return location;
//	}
//
//	public void setLocation(String location) {
//		this.location = location;
//	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Places [id=" + id + ", name=" + name + ", location=" + location + ", category="
				+ category + "]";
	}
	
	

}