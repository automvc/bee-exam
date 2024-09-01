/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.geo;
import java.util.Arrays;

import org.bson.Document;
import org.teasoft.beex.mongodb.ds.SingleMongodbFactory;
import org.teasoft.honey.osql.core.Logger;

import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import com.mongodb.client.result.InsertManyResult;

/**
 * @author Kingstar
 * @since  2.1
 */
public class InsertTest {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
//		Map<String,Object> map00=new LinkedHashMap<>();
//		map00.put("name", "test-geo2d");
//		map00.put("raid", Arrays.asList(10.5, 10));
//		
//		
//		Map<String,Object> map01=new LinkedHashMap<>();
//		map01.put("type", "Point");
//		map01.put("coordinates", Arrays.asList(10.5, 10));
//		map00.put("gps", map01);
////		InsertOneResult a=mc.insertOne(new Document(map00));
////		System.err.println(a.toString());
		
		
		
		Document doc1 = new Document("name", "tom").append("raid", Arrays.asList(10, 10)).append("gps", new Point(new Position(10, 10)));
		Document doc2 = new Document("name", "jone").append("raid", Arrays.asList(10.1, 10)).append("gps", new Point(new Position(10.1, 10)));
		Document doc3 = new Document("name", "john").append("raid", Arrays.asList(10, 10.1)).append("gps", new Point(new Position(10, 10.1)));
		Document doc4 = new Document("name", "jack").append("raid", Arrays.asList(9.9, 10)).append("gps", new Point(new Position(9.9, 10)));
		Document doc5 = new Document("name", "mary").append("raid", Arrays.asList(10, 9.9)).append("gps", new Point(new Position(10, 9.9)));
		Document doc6 = new Document("name", "abby").append("raid", Arrays.asList(10.2, 10)).append("gps", new Point(new Position(10.2, 10)));
		Document doc7 = new Document("name", "adam").append("raid", Arrays.asList(10.3, 10)).append("gps", new Point(new Position(10.3, 10)));
		Document doc8 = new Document("name", "barry").append("raid", Arrays.asList(10.4, 10)).append("gps", new Point(new Position(10.4, 10)));
		Document doc9 = new Document("name", "anne").append("raid", Arrays.asList(10.5, 10)).append("gps", new Point(new Position(10.5, 10)));
		InsertManyResult a=SingleMongodbFactory.getMongoDb().getCollection("hotel").insertMany(Arrays.asList(doc1, doc2, doc3, doc4, doc5, doc6, doc7, doc8, doc9));
	
		Logger.info(a.getInsertedIds().toString());
	}

}
