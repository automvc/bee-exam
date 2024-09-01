package org.teasoft.exam.mongodb;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.exam.bee.mongodb.file.DateTest;
import org.teasoft.exam.bee.mongodb.file.GridFsFileTest;
import org.teasoft.exam.bee.mongodb.file.GridFsTest;
import org.teasoft.exam.bee.mongodb.geo.GeoTest;
import org.teasoft.exam.bee.mongodb.geo.GeoTest0;
import org.teasoft.exam.bee.mongodb.geo.GeoTest2;
import org.teasoft.exam.bee.mongodb.geo.GeoTest3;
import org.teasoft.exam.bee.mongodb.geo.GeoTest_Insert;
import org.teasoft.exam.bee.mongodb.geo.GeoTest_Insert2;
import org.teasoft.exam.bee.mongodb.geo.InsertAndSelectAllKind;
import org.teasoft.exam.bee.mongodb.geo.InsertAndSelectAllKind2;
import org.teasoft.exam.bee.mongodb.geo.InsertTest;
import org.teasoft.honey.osql.core.Logger;

public class MongoFileAndGeoTest extends BaseMongoTest {

	@Test
	public void test() {

		System.out.println("---Bee MongoFileAndGeoTest with junit start:------");

		boolean result = false;
		try {

			//file:
//			DateTest.test();
//			DateTest2.test();
			GridFsFileTest.test();
//			GridFsFileTest2.test();
			
//			ClearDsAndMongoDsUtil.clearConfig(); //先清空 
//			HoneyConfig config=HoneyConfig.getHoneyConfig();
//			config.setUrl("mongodb://localhost:27017/bee/");
//			config.setUsername("");
//			config.setPassword("");
//			HoneyContext.setConfigRefresh(true);
			
			GridFsTest.test();
			
			
			
			//geo:
			InsertAndSelectAllKind.test();
			InsertAndSelectAllKind2.test();
			InsertTest.test();
			GeoTest_Insert.test();
			GeoTest_Insert2.test();
			
			GeoTest.test();
			GeoTest0.test();
			GeoTest2.test();
			GeoTest3.test();



			
			
			
			
			
			
//			Location.test();
//			Location3.test();
//			Places.test();
//			Places2.test();
//			Places3.test();
//			GeoTest_Insert3.test();
//			Gps.test();
//			Gps2.test();
//			Hotel.test();
//			Hotel2.test();
			
			
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage(), e);
			result = false;
		} finally {
			Assert.assertEquals(result, true);
		}

		System.out.println("---Bee MongoFileAndGeoTest with junit end.------");
	}
}
