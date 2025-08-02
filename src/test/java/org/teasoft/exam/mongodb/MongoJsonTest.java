package org.teasoft.exam.mongodb;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.exam.bee.mongodb.json.InventoryTest;
import org.teasoft.exam.bee.mongodb.json.InventoryTestInsert;
import org.teasoft.exam.bee.mongodb.json.InventoryTestJson;
import org.teasoft.exam.bee.mongodb.json.InventoryTestJson2;
import org.teasoft.exam.bee.mongodb.json.InventoryTestJson3;
import org.teasoft.exam.bee.mongodb.json.InventoryTestString;
import org.teasoft.exam.bee.mongodb.json.InventoryTestSub;
import org.teasoft.exam.bee.mongodb.json.ListJsonTest;
import org.teasoft.honey.logging.Logger;

public class MongoJsonTest extends BaseMongoTest {

	@Test
	public void test() {

		System.out.println("---Bee MongoJsonTest with junit start:------");

		boolean result = false;
		try {
			InventoryTest.test();
			InventoryTestInsert.test();
			InventoryTestJson3.test();
			InventoryTestString.test();
			ListJsonTest.test();
			
			InventoryTestJson.test();
			InventoryTestJson2.test();
			InventoryTestSub.test();

			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage(), e);
			result = false;
		} finally {
			Assert.assertEquals(result, true);
		}

		System.out.println("---Bee MongoJsonTest with junit end.------");
	}
}
