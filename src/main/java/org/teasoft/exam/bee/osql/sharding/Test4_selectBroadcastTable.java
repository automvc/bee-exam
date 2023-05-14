/*
getMongodbBeeSql() * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding;

import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Noid0;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test4_selectBroadcastTable {

	public static void main(String[] args) {
		ShardingInitData.init();
		InitSameDsUtil.initDS();
		test();
	}

	public static void test() {
		System.out.println("------Sharding test--------Test4_selectBroadcastTable-----");

		SuidRich suidRich = BF.getSuidRich();

		Noid0 noid0 = new Noid0();

		List<Noid0> list = new ArrayList<>();

		list = suidRich.select(noid0);
		Printer.printList(list);

		System.out.println("finished!");
	}

}
