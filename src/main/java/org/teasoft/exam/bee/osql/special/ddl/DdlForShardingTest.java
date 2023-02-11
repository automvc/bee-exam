/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special.ddl;

import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.exam.bee.osql.sharding.ShardingInitData;
import org.teasoft.honey.osql.autogen.Ddl;

/**
 * @author Kingstar
 * @since  2.0
 */
public class DdlForShardingTest {

	public static void main(String[] args) {
		
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		
		test();
	}

	public static void test() {
//		Ddl.createTable(Noid1.class,true);
		Ddl.createTable(Noid1.class);  //创建Sharding广播表
	}

}
