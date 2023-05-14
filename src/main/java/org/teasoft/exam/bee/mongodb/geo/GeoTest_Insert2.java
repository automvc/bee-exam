/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.geo;

import org.teasoft.beex.osql.mongodb.MongodbSuidRichExt;
import org.teasoft.beex.osql.shortcut.BFX;

/**
 * @author Kingstar
 * @since  2.1
 */
public class GeoTest_Insert2 {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		
		MongodbSuidRichExt suidRichExt=BFX.getMongodbSuidRichExt();
		
		Places3 places=new Places3();
		
		places.setCategory("insert test");
		places.setName("insert test1");
		
		Location3 location=new Location3();
		location.setType("Point");
		location.setCoordinates(new Double[]{-73.966,41.78});
		places.setLocation(location);
		int insertNum=suidRichExt.insert(places);
		
		System.out.println(insertNum);
	}

}
