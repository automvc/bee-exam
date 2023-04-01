///*
// * Copyright 2016-2023 the original author.All rights reserved.
// * Kingstar(honeysoft@126.com)
// * The license,see the LICENSE file.
// */
//
//package org.teasoft.exam.bee.mongodb.geo;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.teasoft.bee.mongodb.BoxPara;
//import org.teasoft.bee.mongodb.CenterPara;
//import org.teasoft.bee.mongodb.NearPara;
//import org.teasoft.bee.osql.Condition;
//import org.teasoft.bee.osql.Op;
//import org.teasoft.beex.osql.mongodb.MongodbSuidRichExt;
//import org.teasoft.beex.osql.shortcut.BFX;
//import org.teasoft.exam.comm.Printer;
//import org.teasoft.honey.osql.shortcut.BF;
//
///**
// * @author Kingstar
// * @since  2.1
// */
//public class GeoTest_Insert3 {
//	
//	public static void main(String[] args) {
//		
//		
//		MongodbSuidRichExt suidRichExt=BFX.getMongodbSuidRichExt();
//		
//		Places places=new Places();
//		
//		places.setCategory("insert test");
//		places.setName("insert test1");
//		
//		GeomArrayBean location=new GeomArrayBean();
//		location.setType("Point");
//		location.setCoordinates(new Double[]{-73.966,41.78});
//		places.setLocation(location);
//		int insertNum=suidRichExt.insert(places);
//		
//		System.out.println(insertNum);
//	}
//
//}
