/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.util.List;

import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Orders;
import org.teasoft.exam.bee.mongodb.entity.Orders_F;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.0
 */
public class SelectGroupBy2 {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		SuidRich suidRich=BF.getSuidRich();
		
		Condition c=BF.getCondition(); 
//		c.groupBy(Orders_F.name);
		c.groupBy(Orders_F.id);
		c.selectField(Orders_F.abc);  //不能这样指定要查的字段
		
		List<Orders> list=suidRich.select(new Orders(), c);
//		List<Orders3> list=suidRich.select(new Orders3(), c);
		Printer.printList(list);
	}

}
