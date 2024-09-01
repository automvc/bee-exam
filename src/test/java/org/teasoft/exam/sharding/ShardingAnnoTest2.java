package org.teasoft.exam.sharding;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.exam.bee.osql.sharding.anno.*;
import org.teasoft.honey.osql.core.Logger;

public class ShardingAnnoTest2 extends BaseShardingTest{
//	public class ShardingAnnoTest2 {
	
	@Test
	public void test() {

		System.out.println("---Bee ShardingAnnoTest with junit start:------");

		boolean result = false;
		try {

			ShardingSimpleExam10.test();
			ShardingSimpleExam7.test();
			ShardingSimpleExam7_1.test();
			ShardingSimpleExam7_2.test();
			ShardingSimpleExam8.test();
			ShardingSimpleExam8_2.test();
//			ShardingSimpleExam8_3.test();
//			ShardingSimpleExam9.test();
//			UseJson.test();
//			UseJson2.test();
//			UseJson3.test();
//			UseJson4.test();
//			UseJson5.test();

			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage(), e);
			result = false;
		} finally {
			Assert.assertEquals(result, true);
		}

		System.out.println("---Bee ShardingAnnoTest with junit end.------");
	}
}
