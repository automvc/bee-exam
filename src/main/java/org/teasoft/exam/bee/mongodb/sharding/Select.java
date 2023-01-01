/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.sharding;

import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.bee.mongodb.Orders;
import org.teasoft.honey.sharding.config.ShardingConfig;

/**
 * @author Kingstar
 * @since  2.0
 */
public class Select {
	
//	static {
//		ShardingConfig.addShardingBean(Orders.class,new ShardingBean("ds[0..1].orders[0..5]", "userid"));
//	}
	
	public static void main(String[] args) {
		ShardingDoConfig.init();
		
		
	}

}
