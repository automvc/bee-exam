//package org.teasoft.exam.mongodb;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.teasoft.exam.bee.mongodb.raw.RawSqlErrorTest;
//import org.teasoft.honey.osql.core.Logger;
//
//public class MongoErrorTest extends BaseMongoTest {
//
//	@Test
//	public void test() {
//
//		System.out.println("---Bee MongoErrorTest with junit start:------");
//
//		boolean result = false;
//		try {
//
////			RawSqlErrorTest.test();
//
//			result = true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			Logger.error(e.getMessage(), e);
//			result = false;
//		} finally {
//			Assert.assertEquals(result, true);
//		}
//
//		System.out.println("---Bee MongoErrorTest with junit end.------");
//	}
//}
