/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.sharding;

import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.bee.mongodb.Noid0;
import org.teasoft.exam.bee.osql.special.ddl.TestMyUser;
import org.teasoft.honey.sharding.config.ShardingConfig;

/**
 * @author Kingstar
 * @since  2.0
 */
public class ShardingDoConfig {

	public static void init() {
		ShardingConfig.addShardingBean(Orders.class, new ShardingBean("ds[0..1].orders[0..5]", "userid"));

//		ShardingBean broadcastTable1 = new ShardingBean();
//		broadcastTable1.setFullNodes("ds[0..1].noid0[]"); //表名,就是noid0,用于测试
//		ShardingConfig.addShardingBean(Noid0.class, broadcastTable1);
		
		ShardingConfig.addShardingBean(Noid0.class,new ShardingBean("ds[0..1].noid0[]"));
		ShardingConfig.addBroadcastTable("noid0");
		
		ShardingConfig.addShardingBean("test_user",new ShardingBean("ds[0..1].test_user[0..5]", "id"));
		ShardingConfig.addShardingBean(TestMyUser.class,new ShardingBean("ds[0..1].test_my_user[0..5]", "id"));

	}

}
