/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Orders;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test2_Between {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
//		MongodbBeeSqlRegister.register(new MongodbSqlLib());
//		SuidRich suidRich =BF.getSuidRich();
		SuidRich suidRich =BF.getSuidRichForMongodb();
		
		Orders orders=new Orders();
		
		
		Condition condtion=BF.getCondition();
		
//		orders=new Orders();
//		List<Orders> list=suidRich.select(orders,condtion);
//		Printer.printList(list);
		
		
		System.out.println("==============================================");
		System.out.println();
		Condition condtion6=BF.getCondition();
		
//		condtion6.between("num", 72, 75);
//		condtion6.notBetween("num", 72, 75);  //num是null的不会查出来
		
		condtion6.between("total", 72.72, 75.75);
//		condtion6.between("total", 72, 75.75);
//		condtion6.notBetween("total", 72.72, 75.75);

//		List<Orders> list6=suidRich.select(new Orders(),condtion6);
//		Printer.printList(list6);
		
		System.out.println("--------------------------------");
		condtion6.and();
		condtion6.op("name", Op.eq, "mongodb73");
		List<Orders> list7=suidRich.select(new Orders(),condtion6);
		Printer.printList(list7);
		
		System.out.println("finished!");
	}

}
