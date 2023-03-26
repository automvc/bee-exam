package org.teasoft.exam.bee.mongodb.geo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Honey
 * Create on 2023-03-25 22:34:35
 */
public class Location implements Serializable {

	private static final long serialVersionUID = 1594101281857L;

	private String type;
	private List<Double> coordinates;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return "Location [type=" + type + ", coordinates=" + coordinates + "]";
	}

}