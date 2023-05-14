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
import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.beex.osql.mongodb.MongodbSuidRichExt;
import org.teasoft.beex.osql.shortcut.BFX;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.1
 */
public class GeoTest3 {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		
		MongodbSuidRichExt suidRichExt=BFX.getMongodbSuidRichExt();
		
		Places3 places3=new Places3();
//		places2.setName("com");
		List<Places3> list2=suidRichExt.near(places3, "location", -73.9667, 40.78, 5000D, 1000D);
		Printer.printList(list2);
		
		
		Condition condition3=BF.getCondition();
		condition3.op("name", Op.likeLeft, "Park2"); //左匹配
		NearPara nearPara=new NearPara("location", -73.9667, 40.78, 5000D, 1000D);
		List<Places3> list3=suidRichExt.near(places3, nearPara,condition3);
		Printer.printList(list3);
		
		List<Places3> list4=suidRichExt.nearSphere(places3, nearPara,condition3);
		Printer.printList(list4);
		
		
		System.out.println("---------------geoWithinCenter---------------");
		CenterPara centerPara=new CenterPara("location", -73.9667, 40.78, 5000D);
		List<Places3> list5=suidRichExt.geoWithinCenter(places3, centerPara,condition3);
		Printer.printList(list5);
		System.out.println("---------------geoWithinCenterSphere---------------");
		list5=suidRichExt.geoWithinCenterSphere(places3, centerPara,condition3);
		Printer.printList(list5);
		
		System.out.println("---------------geoWithinBox---------------");
		BoxPara boxPara =new BoxPara("location", -78.9667, 20.78, -70.9667, 60.78);
		list5=suidRichExt.geoWithinBox(places3, boxPara, condition3);
		Printer.printList(list5);
	}

}
