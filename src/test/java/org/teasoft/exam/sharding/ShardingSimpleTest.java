/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.sharding;

import org.junit.Test;
import org.teasoft.exam.bee.osql.sharding.*;

/**
 * @author Kingstar
 * @since  2.1
 */
public class ShardingSimpleTest extends BaseShardingTest3{
	
	@Test
	public void test() {
		
		System.out.println("---Bee ShardingSimpleTest with junit start:------");
		
		ShardingPaging5.test();
		ShardingSimpleExam9_3.test();
		ShardingSimpleExam9_4.test();
		ShardingSimpleExam9_5.test();
		ShardingSimpleExam9_6.test();
		try {

			ShardingPaging_Just_ShardingTable.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("---Bee ShardingSimpleTest with junit end:------");
	}

}
