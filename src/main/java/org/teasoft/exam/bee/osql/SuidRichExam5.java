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
public class SuidRichExam5 {

	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

	public static SuidRich getSuidRich() {
		return suidRich;
	}

	public static void setSuidRich(SuidRich suidRich) {
		SuidRichExam5.suidRich = suidRich;
	}

	public static void main(String[] args) {
		test();
	}

	public static void test() {


			Ddl.createTable(Orders.class,true);
			
//			
//			suidRich.delete(new Orders());
			
			Orders orders0 = new Orders();
			Orders orders1 = new Orders();
			Orders orders2 = new Orders();
			Orders[] ordersArray0 = new Orders[3];
			
			orders0.setId(1003L);
			orders1.setId(1004L);
			orders2.setId(1005L);
			ordersArray0[0] = orders0;
			ordersArray0[1] = orders1;
			ordersArray0[2] = orders2;
			suidRich.insert(ordersArray0); //先插入几个数据
			
			
		
		
		

	
	}
}
