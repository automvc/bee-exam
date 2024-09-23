/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.sharding;

import org.junit.Test;
import org.teasoft.exam.MySqlOneConfig;
import org.teasoft.exam.bee.osql.moretable.modify.MoreInsert40_2;
import org.teasoft.exam.bee.osql.moretable.modify.sharding.MoreInsert40_3;
import org.teasoft.exam.bee.osql.moretable.modify.sharding.MoreInsert40_4;
import org.teasoft.exam.bee.osql.moretable.modify.sharding.MoreInsert40_5;
import org.teasoft.exam.bee.osql.moretable.modify.sharding.MoreInsert40_6;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam11;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam198;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam2;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam3;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam4;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam5;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam6;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam7;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableFun;
import org.teasoft.exam.bee.osql.sharding.moretable.ShardingBatchInsert2;

/**
 * @author Kingstar
 * @since  2.1
 */
public class ShardingMoreTest2 extends BaseShardingTest2 {

	@Test
	public void test() {

		System.out.println("---Bee ShardingMoreTest2 with junit start:------");
		try {
			MoreTableExam.test();
			MoreTableExam11.test();
			MoreTableExam198.test();
			MoreTableFun.test();
			ShardingBatchInsert2.test();
			MoreTableExam2.test();
			MoreTableExam3.test();
			MoreTableExam4.test();
			MoreTableExam5.test();
			MoreTableExam6.test();
			MoreTableExam7.test();
			
			MoreInsert40_2.test();
			MoreInsert40_3.test();
			MoreInsert40_4.test();
			MoreInsert40_5.test();
			MoreInsert40_6.test();

//			try {
//			} catch (Exception e) {
//				e.printStackTrace();
//			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("---Bee ShardingMoreTest2 with junit end:------");
			MySqlOneConfig.reset(); // 预防测试无序,跳到其它类
		}
	}

}
