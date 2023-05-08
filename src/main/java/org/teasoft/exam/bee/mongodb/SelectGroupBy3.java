/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Orders;
import org.teasoft.exam.bee.mongodb.entity.Orders_F;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.0
 */
public class SelectGroupBy3 {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		SuidRich suidRich=BF.getSuidRich();
		
		Condition c=BF.getCondition(); 
//		c.groupBy(Orders_F.id);
		c.groupBy(Orders_F.name);
//		c.selectField(Orders_F.abc);
//		c.selectFun(FunctionType.MAX, Orders_F.id);
		c.selectFun(FunctionType.MAX, Orders_F.total,"max_total");
//		c.selectFun(FunctionType.MIN, Orders_F.total,"min_total");
		c.selectFun(FunctionType.COUNT, Orders_F.id);
//		select name,count(*),max(id),min(total) from orders group by name;
		
		List<Orders> list=suidRich.select(new Orders(), c);
		Printer.printList(list);
	}

}
