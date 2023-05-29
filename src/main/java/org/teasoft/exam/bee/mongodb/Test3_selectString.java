/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Orders;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test3_selectString {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		SuidRich suidRich =BF.getSuidRich();
		
		System.out.println("----------selectString------------------");
		
//		List<Orders> list=suidRich.select(new Orders(), "name");
		List<String[]> list=null;
		
		list=suidRich.selectString(new Orders(), "name,remark");
		Printer.print(list);
		System.out.println("-------------selectString---------------");
		
		list=suidRich.selectString(new Orders(), "remark","name","abc");
		Printer.print(list);
		
		System.out.println("-------------selectString 包括id---------------");
//		list=suidRich.selectString(new Orders(), "id","remark","name");
		list=suidRich.selectString(new Orders(), "remark","name","id");
		Printer.print(list);
		
//		//select all field
//		System.out.println("-------------selectString(new Orders())---------------");
//		list=suidRich.selectString(new Orders());
//		Printer.print(list);
		
		System.out.println("finished!");
	}

}
