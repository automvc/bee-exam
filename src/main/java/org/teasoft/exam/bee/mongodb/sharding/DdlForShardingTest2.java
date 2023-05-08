/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.sharding;

import org.teasoft.exam.bee.mongodb.Noid0;
import org.teasoft.honey.osql.autogen.Ddl;

/**
 * 创建Sharding分库分表
 * @author Kingstar
 * @since  2.0
 */
public class DdlForShardingTest2 {

	public static void main(String[] args) {
		try {
			test();
		} finally {
			ClearDsAndMongoDsUtil.clearConfig();
		}
	}

	public static void test() {

//		ShardingInitData.init();
//		InitSameDsUtil.initDS();
		
		ShardingDoConfig.init();
		InitDsAndMongoDsUtil.initDS();

		test0();
		
		System.err.println("-----------------DdlForShardingTest2-------------");
	}

	public static void test0() {
//		Ddl.createTable(TestUser.class,true); // 创建Sharding分库分表
//		Ddl.createTable(Noid0.class);
		Ddl.createTable(Noid0.class,true);  //为什么创建完后,线程不停??? TODO
	}

}
