/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.geo;

import java.io.Serializable;
import java.util.List;

import org.teasoft.bee.osql.annotation.Geo2dsphere;
import org.teasoft.bee.osql.annotation.Table;

/**
 * @author Kingstar
 * @since  2.1
 */
@Table("hotel")
public class Hotel2 implements Serializable {
	private static final long serialVersionUID = 1594101281856L;
	private String id;
	private String name;
	private List<Double> raid;
//	@Geo2dSphere  //注解用在类上
	private Gps2 gps;
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
	public Hotel2 setName(String name) {
		this.name = name;
		return this;
	}
	public List<Double> getRaid() {
		return raid;
	}
	public Hotel2 setRaid(List<Double> raid) {
		this.raid = raid;
		return this;
	}

	public Gps2 getGps() {
		return gps;
	}
	public Hotel2 setGps(Gps2 gps) {
		this.gps = gps;
		return this;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", raid=" + raid + ", gps2=" + gps.toString()
				+ ", category=" + category + "]";
	}
}
