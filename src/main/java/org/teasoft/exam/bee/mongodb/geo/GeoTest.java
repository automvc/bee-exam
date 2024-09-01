/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.geo;

import java.util.List;

import org.teasoft.bee.mongodb.BoxPara;
import org.teasoft.bee.mongodb.CenterPara;
import org.teasoft.bee.mongodb.NearPara;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.beex.osql.mongodb.IndexType;
import org.teasoft.beex.osql.mongodb.MongodbSuidRichExt;
import org.teasoft.beex.osql.shortcut.BFX;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.1
 */
public class GeoTest {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		MongodbSuidRichExt suidRichExt=BFX.getMongodbSuidRichExt();
		
		String indexReturn1 = suidRichExt.index("places", "location", IndexType.geo2dsphere);
		Logger.info(indexReturn1);
		
		Places places=new Places();
		places.setName("com");
		List<Places> list2=suidRichExt.near(places, "location", -73.9667, 40.78, 5000D, 1000D);
		Printer.printList(list2);
		
		Condition condition4=BF.getCondition();
		condition4.op("name", Op.likeLeft, "Park2"); //左匹配
		NearPara nearPara=new NearPara("location", -73.9667, 40.78, 5000D, 1000D);
		List<Places> list3=suidRichExt.near(places, nearPara,condition4);
		Printer.printList(list3);
		
		List<Places> list4=suidRichExt.nearSphere(places, nearPara,condition4);
		Printer.printList(list4);
		
		
		System.out.println("---------------geoWithinCenter---------------");
		CenterPara centerPara=new CenterPara("location", -73.9667, 40.78, 5000D);
		List<Places> list5=suidRichExt.geoWithinCenter(places, centerPara,condition4);
		Printer.printList(list5);
		System.out.println("---------------geoWithinCenterSphere---------------");
		list5=suidRichExt.geoWithinCenterSphere(places, centerPara,condition4);
		Printer.printList(list5);
		
		System.out.println("---------------geoWithinBox---------------");
		BoxPara boxPara =new BoxPara("location", -78.9667, 20.78, -70.9667, 60.78);
		list5=suidRichExt.geoWithinBox(places, boxPara, condition4);
		Printer.printList(list5);
	}

}
