/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Orders;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test3_selectString2 {
	
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
		
		System.out.println("------------test cache in selectString--------------");
		list=suidRich.selectString(new Orders(), "remark","name","id");
		Printer.print(list);
		
		
		System.out.println("------------test cache in selectString- use condition-------------");
		Condition c=BF.getCondition();
		c.selectField("remark","name","id");
		list=suidRich.selectString(new Orders(), c); //跟上一个,不用Condition一样的效果,会共用缓存
		Printer.print(list);
		
//		System.out.println("------------test selectJson after selectString cache--------------");
//		String json=suidRich.selectJson(new Orders(), c);
//		System.out.println(json);
//		
//		json=suidRich.selectJson(new Orders(), c);  //test cache
//		System.out.println(json);
		
		System.out.println("finished!");
	}

}
