/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.sharding;

import org.junit.Test;
import org.teasoft.exam.bee.osql.moretable.entity.*;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.honey.osql.autogen.Ddl;
import org.teasoft.honey.osql.core.HoneyConfig;

/**
 * createTable in sharding
 * @author Kingstar
 * @since  2.1
 */
public class ShardingGenBeanTest extends BaseShardingTest2{
	
	@Test
	public void test() {
		
		System.out.println("---Bee ShardingGenBeanTest with junit start:------");
		System.out.println("---------------db: "+HoneyConfig.getHoneyConfig().getDbName());
		try {
//			Ddl.createTable(Orders.class,true);
			
			Ddl.createTable(Assignexam.class,true);
//			Ddl.createTable(Assigncourse.class,true);
		
//		HoneyConfig.getHoneyConfig().sharding_forkJoinBatchInsert=true;
//		ShardingBatchInsert2.test();
//		HoneyConfig.getHoneyConfig().sharding_forkJoinBatchInsert=false;
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		System.out.println("---Bee ShardingGenBeanTest with junit end:------");
//		MySqlOneConfig.reset(); //预防测试无序,跳到其它类
	}
	}

}
