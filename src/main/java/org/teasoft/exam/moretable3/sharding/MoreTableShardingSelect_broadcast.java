/*
 * Copyright 2020-2025 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.moretable3.sharding;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.sharding.config.ShardingConfig;

/**
 * 主表与广播子表test_users关联
 * @author Kingstar
 * @since  2.5.2
 */
public class MoreTableShardingSelect_broadcast {
	
	public static void main(String[] args) {
//		ShardingInitData.init();
		ShardingConfig.addShardingBean("Orders", new ShardingBean("ds[0..1].orders[0..5]", "userid"));

		ShardingConfig.addShardingBean(TestUser.class,new ShardingBean("ds[0..1].test_users[]"));
		ShardingConfig.addBroadcastTable("test_users");
		
		InitSameDsUtil.initDS();
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			
			
			Orders orders = new Orders();
//			orders.setId(10002L);
			Long rfId=33L;
			orders.setUserid(rfId);
			orders.setOrderid(rfId);
			
			TestUser testUser=new TestUser();
			testUser.setId(rfId);
			testUser.setUsername("testSharding");
			
			orders.setTestUser(testUser);
			
		
			List<Orders> list=moreTable.select(orders);
			
			Printer.printList(list);
			
			
		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableInsertSharding (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In MoreTableInsertSharding (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}

}
