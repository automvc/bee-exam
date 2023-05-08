/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.sharding;

import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.bee.sharding.ShardingBean;
import org.teasoft.exam.bee.mongodb.entity.Noid0;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.sharding.config.ShardingConfig;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class SelectWithFun2 {
	public static void main(String[] args) {
		try {
			test();
		} finally {
			ClearDsAndMongoDsUtil.clearConfig();
		}
	}

	public static void test() {
		
		ShardingDoConfig.init();
		InitDsAndMongoDsUtil.initDS();
		
		SuidRich suidRich =BF.getSuidRich();
		
		Orders orders=new Orders();
//		orders.setName("2121aa");  //测null值

		String max = suidRich.selectWithFun(orders, FunctionType.MAX, "total", null); // 不是mongodb的string id格式.
		System.out.println("max: "+max);
		
		String min = suidRich.selectWithFun(orders, FunctionType.MIN, "total", null); 
		System.out.println("min: "+min);
		
		String avg = suidRich.selectWithFun(orders, FunctionType.AVG, "total", null); 
		System.out.println("avg: "+avg);
		
		String sum = suidRich.selectWithFun(orders, FunctionType.SUM, "total", null); 
		System.out.println("sum: "+sum);
		
		String count = suidRich.selectWithFun(orders, FunctionType.COUNT, "total", null); 
		System.out.println("count: "+count);

		
		System.out.println("finished!");
	}
}
