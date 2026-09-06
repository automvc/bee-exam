/*
 * Copyright 2022-2026 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.sharding;

import org.junit.Test;
import org.teasoft.exam.bee.osql.sharding.ShardingBatchInsert2Pg;
import org.teasoft.exam.bee.osql.sharding.ShardingPaging02Pg;
import org.teasoft.exam.bee.osql.sharding.ShardingPagingSort2Pg;
import org.teasoft.honey.logging.Logger;

/**
 * @author Kingstar
 * @since  3.0.0
 */
public class ShardingTestPg {

	@Test
	public void test() {
		try {
			ShardingPaging02Pg.test();
			ShardingPagingSort2Pg.test();
			ShardingBatchInsert2Pg.test();
		} catch (Exception e) {
			e.printStackTrace();
			Logger.warn("---ShardingTestPg: " + e.getMessage());
		}
	}

}
