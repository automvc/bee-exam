package org.teasoft.exam.mongodb;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.exam.bee.mongodb.raw.MongoshellTest;
import org.teasoft.exam.bee.mongodb.raw.RawSqlTest;
import org.teasoft.honey.logging.Logger;

public class MongoRawTest extends BaseMongoTest {

	@Test
	public void test() {

		System.out.println("---Bee MongoRawTest with junit start:------");

		boolean result = false;
		try {

			RawSqlTest.test();
			MongoshellTest.test();

			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage(), e);
			result = false;
		} finally {
			Assert.assertEquals(result, true);
		}

		System.out.println("---Bee MongoRawTest with junit end.------");
	}
}
