/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.sharding;

import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.commomid.Noid;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class SelectWithFun {
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


//		String rs = suidRich.selectWithFun(new Orders(), FunctionType.MAX, "id", null); // 不是mongodb的string id格式.
//		System.out.println("max: "+rs);
//		
//		String min = suidRich.selectWithFun(new Orders(), FunctionType.MIN, "id", null); // 不是mongodb的string id格式.
//		System.out.println("min: "+min);
//		
//		String avg = suidRich.selectWithFun(new Orders(), FunctionType.AVG, "id", null); // 不是mongodb的string id格式.
//		System.out.println("avg: "+avg);
//		
//		String sum = suidRich.selectWithFun(new Orders(), FunctionType.SUM, "id", null); // 不是mongodb的string id格式.
//		System.out.println("sum: "+sum);

		
		String rs = suidRich.selectWithFun(new Noid(), FunctionType.MAX, "num", null); // 不是mongodb的string id格式.
		System.out.println("---max: "+rs);
		
		System.out.println("finished!");
	}
}
