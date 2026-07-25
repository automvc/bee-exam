/*
 * Copyright 2020-2025 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.moretable3.sharding;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.sharding.config.ShardingConfig;

/**
 * @author Kingstar
 * @since  2.5.2
 */
public class MoreTableShardingDelete {
	
	public static void main(String[] args) {
//		ShardingInitData.init();
		ShardingConfig.addShardingBean("Orders", new ShardingBean("ds[0..1].orders[0..5]", "userid"));
		InitSameDsUtil.initDS();
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			
			
			Orders orders = new Orders();
			orders.setId(10035L);
			Long rfId=35L;
			orders.setUserid(rfId);
			orders.setOrderid(rfId);
			
			TestUser testUser=new TestUser();
			testUser.setId(rfId);
			testUser.setUsername("testSharding");
			
			orders.setTestUser(testUser);
			
			// 表关联,插入; 如何确定分片???
			moreTable.insert(orders);
			Logger.info("after insert, HoneyContext.getTabSuffix():" + HoneyContext.getTabSuffix());
			
			Logger.info("start to update:");
			orders.setRemark("update");
			testUser.setLastName("update lastname");
			moreTable.update(orders);
			
			Logger.info("start to delete:");
			moreTable.delete(orders);
			
		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableInsertSharding (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In MoreTableInsertSharding (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}

}
