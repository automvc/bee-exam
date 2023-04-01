/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.geo;

import java.io.Serializable;
import java.util.List;

import org.teasoft.bee.osql.annotation.Geo2dsphere;

/**
 * @author Kingstar
 * @since  2.1
 */
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1594101281856L;
	private String id;
	private String name;
	private List<Double> raid;
	@Geo2dsphere
	private Gps gps;
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
	public Hotel setName(String name) {
		this.name = name;
		return this;
	}
	public List<Double> getRaid() {
		return raid;
	}
	public Hotel setRaid(List<Double> raid) {
		this.raid = raid;
		return this;
	}
	public Gps getGps() {
		return gps;
	}
	public Hotel setGps(Gps gps) {
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
		return "Hotel [id=" + id + ", name=" + name + ", raid=" + raid + ", gps=" + gps.toString()
				+ ", category=" + category + "]";
	}
}
