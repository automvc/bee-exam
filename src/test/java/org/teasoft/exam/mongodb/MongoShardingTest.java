package org.teasoft.exam.mongodb;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.exam.bee.mongodb.sharding.*;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.HoneyConfig;

public class MongoShardingTest extends BaseMongoTest2 {

	@Test
	public void test() {

		System.out.println("---Bee MongoShardingTest with junit start:------");

		boolean result = false;
		try {
			HoneyConfig.getHoneyConfig().multiDS_justMongodb=true;
			DdlForShardingTest2.test();
//			Select.test();
			SelectWithFun.test();
			SelectWithFun2.test();
			ShardingPaging.test();
			ShardingPaging2.test();
			ShardingPaging2_deleteCache.test();
			ShardingPaging_between.test();
			ShardingSimpleExam4_2.test();
			ShardingSelectJson.test();
			ShardingSelectListStringArray.test();
			
			Test4_insert.test();
			Test4_insertBroadcastTable.test();
			Test4_insertBroadcastTable2.test();
//			Test4_insertBroadcastTable3.test();
			Test4_insertList.test();
			Test4_selectBroadcastTable.test();
			
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage(), e);
			result = false;
		} finally {
			Assert.assertEquals(result, true);
		}

		System.out.println("---Bee MongoShardingTest with junit end.------");
	}
}
