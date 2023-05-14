/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.sharding;

import org.teasoft.exam.bee.mongodb.entity.Noid0;
import org.teasoft.honey.osql.autogen.Ddl;

/**
 * 创建Sharding分库分表
 * @author Kingstar
 * @since  2.0
 */
public class DdlForShardingTest2 {

	public static void main(String[] args) {
		try {
			ShardingDoConfig.init();
			InitDsAndMongoDsUtil.initDS();
			test();
		} finally {
			ClearDsAndMongoDsUtil.clearConfig();
		}
	}

	public static void test() {
		test0();
		System.out.println("-----------------DdlForShardingTest2-------------");
	}

	public static void test0() {
//		Ddl.createTable(TestUser.class,true); // 创建Sharding分库分表
//		Ddl.createTable(Noid0.class);
		
		Ddl.createTable(Noid0.class,true);
		System.out.println("--createTable finished!");
	}

}
