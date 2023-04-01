/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.geo;

import java.util.Arrays;

import org.teasoft.beex.osql.mongodb.MongodbSuidRichExt;
import org.teasoft.beex.osql.shortcut.BFX;

/**
 * @author Kingstar
 * @since  2.1
 */
public class GeoTest_Insert {
	
	public static void main(String[] args) {
		
		
		MongodbSuidRichExt suidRichExt=BFX.getMongodbSuidRichExt();
		
		Places places=new Places();
		
		places.setCategory("insert test");
		places.setName("insert test1");
		
		Location location=new Location();
		location.setType("Point");
		location.setCoordinates(Arrays.asList(-73.966,41.78));
		places.setLocation(location);
		int insertNum=suidRichExt.insert(places);
		
		System.out.println(insertNum);
	}

}
