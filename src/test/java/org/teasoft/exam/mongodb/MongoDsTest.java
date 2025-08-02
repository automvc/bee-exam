package org.teasoft.exam.mongodb;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.exam.MySqlOneConfig;
import org.teasoft.exam.bee.mongodb.ds.*;
import org.teasoft.exam.bee.mongodb.sharding.ClearDsAndMongoDsUtil;
import org.teasoft.honey.logging.Logger;

public class MongoDsTest {

	@Test
	public void test() {

		System.out.println("---Bee MongoDsTest with junit start:------");

		boolean result = false;
		try {
			Start.reMark();
			DiffDdExam2.test();
			DiffDdExam4.test();
			DiffDdExam5.test();
			
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage(), e);
			result = false;
		} finally {
			ClearDsAndMongoDsUtil.clearConfig();
			MySqlOneConfig.reset(); //预防测试无序,跳到其它类
			Assert.assertEquals(result, true);
		}

		System.out.println("---Bee MongoDsTest with junit end.------");
	}
}
