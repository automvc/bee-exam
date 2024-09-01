/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.geo;

import java.util.List;

import org.teasoft.bee.mongodb.BoxPara;
import org.teasoft.bee.mongodb.CenterPara;
import org.teasoft.bee.mongodb.MongodbRawSql;
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
public class GeoTest2 {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		
		MongodbSuidRichExt suidRichExt=BFX.getMongodbSuidRichExt();
		
//		String createIndex="db.places.createIndex({ location: \"2dsphere\" }) "; 
//		MongodbRawSql raw=BF.getMongodbRawSql();
//		raw.modify(createIndex);
		
		String indexReturn1 = suidRichExt.index("places", "location", IndexType.geo2dsphere);
		Logger.info(indexReturn1);
		
		
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
//		places2.setName("com");
//		List<Places2> list2=suidRichExt.near(places2, "location", -73.9667, 40.78, 1000D,5000D); //maximum>minimum
		List<Places2> list2=suidRichExt.near(places2, "location", -73.9667, 40.78, 5000D, 1000D);
		Printer.printList(list2);
		
//		Condition condition3=BF.getCondition();
//		condition3.op("name", Op.eq, "com");
//		NearPara nearPara=new NearPara("location", -73.9667, 40.78, 5000D, 1000D);
//		List<Places2> list3=suidRichExt.near(places2, nearPara,condition3);
//		Printer.printList(list3);
		
		
		Condition condition4=BF.getCondition();
		condition4.op("name", Op.likeLeft, "Park2"); //左匹配
		NearPara nearPara=new NearPara("location", -73.9667, 40.78, 5000D, 1000D);
		List<Places2> list3=suidRichExt.near(places2, nearPara,condition4);
		Printer.printList(list3);
		
		List<Places2> list4=suidRichExt.nearSphere(places2, nearPara,condition4);
		Printer.printList(list4);
		
		
		System.out.println("---------------geoWithinCenter---------------");
		CenterPara centerPara=new CenterPara("location", -73.9667, 40.78, 5000D);
		List<Places2> list5=suidRichExt.geoWithinCenter(places2, centerPara,condition4);
		Printer.printList(list5);
		System.out.println("---------------geoWithinCenterSphere---------------");
		list5=suidRichExt.geoWithinCenterSphere(places2, centerPara,condition4);
		Printer.printList(list5);
		
		System.out.println("---------------geoWithinBox---------------");
		BoxPara boxPara =new BoxPara("location", -78.9667, 20.78, -70.9667, 60.78);
		list5=suidRichExt.geoWithinBox(places2, boxPara, condition4);
		Printer.printList(list5);
	}

}
