/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.autogen.Ddl;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.0
 */
public class SuidRichExam4 {

	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

	public static SuidRich getSuidRich() {
		return suidRich;
	}

	public static void setSuidRich(SuidRich suidRich) {
		SuidRichExam4.suidRich = suidRich;
	}

	public static void main(String[] args) {
		test();
	}

	public static void test() {

		try {

//			Ddl.createTable(Orders.class,true);
//			
//			suidRich.delete(new Orders());
//			
			Orders orders0 = new Orders();
			Orders orders1 = new Orders();
			Orders orders2 = new Orders();
			Orders[] ordersArray0 = new Orders[3];
			
//			orders0.setId(1003L);
//			orders1.setId(1004L);
//			orders2.setId(1005L);

//			ordersArray0[0] = orders0;
//			ordersArray0[1] = orders1;
//			ordersArray0[2] = orders2;
//			suidRich.insert(ordersArray0); //先插入几个数据

			
			List<Orders> list=suidRich.select(new Orders());  //在3 有插入,没有清缓存  SQLite
			Printer.printList(list);
			
			orders0.setId(10023L);
			orders1.setId(10024L);
			orders2.setId(10025L);
			ordersArray0 = new Orders[3];
			ordersArray0[0] = orders0;
			ordersArray0[1] = orders1;
			ordersArray0[2] = orders2;
			
			suidRich.insert(ordersArray0); 
			
			orders2.setId(10026L);
//			suidRich.insert(orders2); 
			
			suidRich.select(new Orders());  //在3 有插入,没有清缓存  SQLite

		

		} catch (BeeException e) {
		Logger.error("In SuidRichExam4 (Exception):" + e.getMessage());
		e.printStackTrace();
	} catch (Exception e) {
		Logger.error("In SuidRichExam4 (Exception):" + e.getMessage());
		e.printStackTrace();
	}
		
		
//		suidRich.delete(new Orders());
//		
//		Orders orders0 = new Orders();
//		orders0.setId(1003L);
//		Orders orders1 = new Orders();
//		orders1.setId(1004L);
//		Orders orders2 = new Orders();
//		orders2.setId(1005L);
//		Orders[] ordersArray0 = new Orders[3];
//		ordersArray0[0] = orders0;
//		ordersArray0[1] = orders1;
//		ordersArray0[2] = orders2;
//		suidRich.insert(ordersArray0); //先插入几个数据
		
		
		

	
	}
}
