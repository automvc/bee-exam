/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.naming;

import java.util.List;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.NameTranslateHandle;
import org.teasoft.honey.osql.name.DbUpperAndJavaLower;
import org.teasoft.honey.osql.name.OriginalName;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.17
 */
public class DiffNamingTest {
	
	private static SuidRich suidRich = BF.getSuidRich();

	public static void main(String[] args) throws Exception {
		test();
	}

	public static void test() throws Exception {

		List<Orders> list = suidRich.select(new Orders(), 10);
		Printer.printList(list);

//		int oldTranslateType=HoneyConfig.getHoneyConfig().naming_translateType;

		// #since 1.17 同时使用多用不同命名转换
		HoneyConfig.getHoneyConfig().naming_useMoreTranslateType = true;

//		Logger.info("===========================naming_translateType=3");
//		HoneyConfig.getHoneyConfig().naming_translateType=3;  //不起作用,系统级别的只会保留启动后初始的命名转换类
		suidRich.setNameTranslateOneTime(new OriginalName()); // 可以在当前对象设置
		list = suidRich.select(new Orders(), 10);
		Printer.printList(list);

		System.out.println(NameTranslateHandle.getNameTranslate().toString());
//		Logger.info("===========================naming_translateType=4");
//		HoneyConfig.getHoneyConfig().naming_translateType=4; //不起作用,系统级别的只会保留启动后初始的命名转换类
		suidRich.setNameTranslateOneTime(new DbUpperAndJavaLower()); // 可以在当前对象设置
		list = suidRich.select(new Orders(), 10);
		System.out.println(NameTranslateHandle.getNameTranslate().toString());
		Printer.printList(list);
		suidRich.select(new Orders(), 10);

//		HoneyConfig.getHoneyConfig().naming_translateType=oldTranslateType;
	}

}
