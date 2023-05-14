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
import org.teasoft.exam.comm.TestPrepare;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;

/**
 * @author Kingstar
 * @since  2.1
 */
public abstract class BaseMongoTest {
	
	static {
		System.out.println("---------BaseMongoTest----------");
		Start.reMark();
	}
	
	@Before
	public void setUp() {
		ClearDsAndMongoDsUtil.clearConfig(); //先清空 
		
		HoneyConfig config=HoneyConfig.getHoneyConfig();
		config.setUrl("mongodb://localhost:27017/bee/");
		config.setUsername("");
		config.setPassword("");
		
//		InitDsAndMongoDsUtil.initDS();
	}

	@After
	public void after() throws Exception {
		HoneyConfig config=HoneyConfig.getHoneyConfig();
		config.setUrl(null);
		ClearDsAndMongoDsUtil.clearConfig();
		
		MySqlOneConfig.reset(); //预防测试无序,跳到其它类
	}

}
