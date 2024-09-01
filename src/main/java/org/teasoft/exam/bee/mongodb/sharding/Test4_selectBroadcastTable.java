/*
getMongodbBeeSql() * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.sharding;

import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Noid0;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test4_selectBroadcastTable {

	public static void main(String[] args) {
		try {
			InitDsAndMongoDsUtil.initDS();
			ShardingDoConfig.init();
			test();
		} finally {
			ClearDsAndMongoDsUtil.clearConfig();
		}
	}

	public static void test() {

		SuidRich suidRich = BF.getSuidRich();

		Noid0 noid0 = new Noid0();

		List<Noid0> list = new ArrayList<>();

		list = suidRich.select(noid0);
//		Printer.printList(list);
		if(list!=null && list.size()>0)
		 Logger.info(list.get(0).toString());

		System.out.println("finished!");
	}

}
