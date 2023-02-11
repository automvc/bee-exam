/*
getMongodbBeeSql() * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.sharding;

import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test4_insert {

	public static void main(String[] args) {

		ShardingDoConfig.init();
		InitDsAndMongoDsUtil.initDS();

		SuidRich suidRich = BF.getSuidRich();

		Orders orders = new Orders();

		orders = new Orders();
		orders.setAbc("test bee ");
		orders.setName("mongodb");
		orders.setId(21L);
		orders.setUserid(21L);
		orders.setRemark(""); //
		orders.setSequence(null);//test null   mongodb,批量插入,不处理null

//		int insertNum = suidRich.insert(orders,IncludeType.INCLUDE_EMPTY);
//		int insertNum = suidRich.insert(orders,IncludeType.INCLUDE_NULL);
		int insertNum = suidRich.insert(orders,IncludeType.INCLUDE_BOTH);
//		int insertNum = suidRich.insert(orders);

		System.out.println("insertNum=" + insertNum);

		System.out.println("finished!");
	}

}
