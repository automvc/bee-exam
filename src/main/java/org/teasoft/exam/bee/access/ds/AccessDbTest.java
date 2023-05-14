/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.access.ds;

import java.util.List;

import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.access.Stu;
import org.teasoft.exam.bee.mongodb.sharding.ClearDsAndMongoDsUtil;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * Access 使用ORM
 */
public class AccessDbTest {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		ClearDsAndMongoDsUtil.clearConfig(); //先清空 
		InitSameAccessDsUtil.initDS();
		
		Suid suid=BF.getSuid();
		List<Stu> list=suid.select(new Stu());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		SuidRich suidRich=BF.getSuidRich();
		suidRich.setDataSourceName("ds1");
		List<Stu> list2=suidRich.select(new Stu(),1,2);
		Printer.printList(list2);
		
		System.out.println("finished");
	}
}
