/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.teasoft.bee.mongodb.MongodbBeeSql;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.beex.mongodb.MongodbSqlLib;
import org.teasoft.exam.bee.osql.entity.dynamic.Orders;
import org.teasoft.honey.osql.core.MongodbObjSQLRich;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test2_Between2 {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		  SuidRich suidRich0 =BF.getSuidRichForMongodb();
//	       suidRich0.setDataSourceName("ds0");
			
//			System.out.println("==============================================");
			Condition condtion6=BF.getCondition();
//			condtion6.between("total", 72.72, 75.75);
//			System.out.println("--------------------------------");
////			List<Orders> list7=suidRich.select(new Orders(),condtion6);
//			List<Orders> list7=suidRich0.select(new Orders());
//			Printer.printList(list7);
	       
	       condtion6.between("total", 72.72, 75.75);
//			condtion6.between("total", 72, 75.75);
//			condtion6.notBetween("total", 72.72, 75.75);

//			List<Orders> list6=suidRich.select(new Orders(),condtion6);
//			Printer.printList(list6);
			
			System.out.println("--------------------------------");
			condtion6.and();
			condtion6.op("name", Op.eq, "mongodb73");
			List<Orders> list7=suidRich0.select(new Orders(),condtion6);
			Printer.printList(list7);
		
		System.out.println("finished!");
	}

}
