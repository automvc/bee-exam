/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Orders;
import org.teasoft.exam.bee.osql.entity.Student;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class SelectWithFun {
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		SuidRich suidRich =BF.getSuidRich();


		String rs = suidRich.selectWithFun(new Orders(), FunctionType.MAX, "id", null); // 不是mongodb的string id格式.
		System.out.println("max: "+rs);
		
		String min = suidRich.selectWithFun(new Orders(), FunctionType.MIN, "id", null); // 不是mongodb的string id格式.
		System.out.println("min: "+min);
		
		String avg = suidRich.selectWithFun(new Orders(), FunctionType.AVG, "id", null); // 不是mongodb的string id格式.
		System.out.println("avg: "+avg);
		
		String sum = suidRich.selectWithFun(new Orders(), FunctionType.SUM, "id", null); // 不是mongodb的string id格式.
		System.out.println("sum: "+sum);

//		List<Noid0> list = suidRich.selectByIds(new Noid0(),
//				"63862e06bdcb6d0dac9c02c7,6386323f3f581a223ab8a10e,ewewewewew");
//		Printer.printList(list);
//		List<Noid0> list2 = suidRich.select(new Noid0());
//		Printer.printList(list2);
		
		 rs = suidRich.selectWithFun(new Student(), FunctionType.MAX, "id", null); // 不是mongodb的string id格式.
		System.out.println("---max: "+rs);
		
		System.out.println("finished!");
	}
}
