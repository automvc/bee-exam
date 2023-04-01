/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.geo;

/**
 * @author Kingstar
 * @since  2.1
 */
public class GeomArrayBean {
	
		private String type;
		private Double [] coordinates;
		
		public GeomArrayBean(){
			type = "Point";
		}
		public String getType(){
			return type;
		}
		
		public void setType(String type){
			this.type = type;
		}
		
		public Double [] getCoordinates(){
			return coordinates;
		}
		
		public void setCoordinates(Double [] coordinates){
			this.coordinates = coordinates;
		}
		
}
