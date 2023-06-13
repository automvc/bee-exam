/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.mongodb;

import org.junit.After;
import org.junit.Before;
import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.exam.MySqlOneConfig;
import org.teasoft.exam.bee.mongodb.sharding.ClearDsAndMongoDsUtil;
import org.teasoft.exam.bee.mongodb.sharding.InitDsAndMongoDsUtil;
import org.teasoft.exam.bee.mongodb.sharding.ShardingDoConfig;
import org.teasoft.exam.comm.TestPrepare;
import org.teasoft.honey.osql.core.HoneyConfig;

/**
 * @author Kingstar
 * @since  2.1
 */
//sharding
public abstract class BaseMongoTest2 {
	
	static {
		System.out.println("---------BaseMongoTest2----------");
		Start.reMark();
//		TestPrepare.init("normal("+DatabaseConst.MongoDB+")");
	}
	
	@Before
	public void setUp() {
		ClearDsAndMongoDsUtil.clearConfig();
		
		InitDsAndMongoDsUtil.initDS();
		ShardingDoConfig.init();
	}

	@After
	public void after() throws Exception {
		HoneyConfig config=HoneyConfig.getHoneyConfig();
		config.setUrl(null);
		ClearDsAndMongoDsUtil.clearConfig();
		
		MySqlOneConfig.reset(); //预防测试无序,跳到其它类
	}

}
