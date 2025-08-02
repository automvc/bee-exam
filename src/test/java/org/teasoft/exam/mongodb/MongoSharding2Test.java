package org.teasoft.exam.mongodb;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.exam.bee.mongodb.sharding.*;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.HoneyConfig;

public class MongoSharding2Test extends BaseMongoTest2 {

	@Test
	public void test() {

		System.out.println("---Bee MongoSharding2Test with junit start:------");

		boolean result = false;
		try {
			HoneyConfig.getHoneyConfig().multiDS_justMongodb=true;
			System.out.println("---------------db: "+HoneyConfig.getHoneyConfig().getDbName());
			DdlForShardingTest2.test();
			
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage(), e);
			result = false;
		} finally {
			Assert.assertEquals(result, true);
		}

		System.out.println("---Bee MongoSharding2Test with junit end.------");
	}
}
