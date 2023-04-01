package org.teasoft.exam.bee.mongodb.geo;

import java.io.Serializable;

import org.teasoft.bee.osql.annotation.GenId;
import org.teasoft.bee.osql.annotation.GenUUID;
import org.teasoft.bee.osql.annotation.Geo2dsphere;
import org.teasoft.bee.osql.annotation.Table;
import org.teasoft.bee.osql.annotation.customizable.Json;

/**
 * @author Honey
 * Create on 2023-03-26 12:08:40
 */
@Table("places")
public class Places3 implements Serializable {

	private static final long serialVersionUID = 1596145310658L;

	@GenUUID
	private String id;
	private String name;
	@Geo2dsphere
	private Location3 location;
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

	public Location3 getLocation() {
		return location;
	}

	public void setLocation(Location3 location) {
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