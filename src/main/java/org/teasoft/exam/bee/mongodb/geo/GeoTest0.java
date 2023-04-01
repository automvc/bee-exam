/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.geo;

import java.util.List;

import org.teasoft.beex.osql.mongodb.MongodbSuidRichExt;
import org.teasoft.beex.osql.shortcut.BFX;
import org.teasoft.exam.comm.Printer;

/**
 * @author Kingstar
 * @since  2.1
 */
public class GeoTest0 {
	
	public static void main(String[] args) {
		
		
//		Point refPoint = new Point(new Position(-73.9667, 40.78));
//		collection.find(Filters.near("contact.location", refPoint, 5000.0, 1000.0))
//		        .forEach(doc -> System.out.println(doc.toJson()));
		
		
		MongodbSuidRichExt suidRichExt=BFX.getMongodbSuidRichExt();
		
//		Places places=new Places();
//		
//		List<Places> list=suidRichExt.near(places, "location", -73.9667, 40.78, 5000D, 1000D);
////		List<Places> list=suidRichExt.nearSphere(places, "location", -73.9667, 40.78, 5000D, 1000D);
//		
//		System.err.println(list.get(0).getLocation().getCoordinates().size()); //
//		System.err.println(list.get(0).getLocation().getCoordinates().get(0));//设置list成功
//		
////		Printer.printList(list);
		
		
		Places2 places2=new Places2();
		places2.setName("com");
		List<Places2> list2=suidRichExt.near(places2, "location", -73.9667, 40.78, 5000D, 1000D);
		Printer.printList(list2);
	}

}
