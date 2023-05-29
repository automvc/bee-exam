/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.util.List;

import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Orders3;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.0
 */
public class SelectOrderBy {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		SuidRich suidRich=BF.getSuidRich();
		
		List<Orders3> list=null;
		
//		list=suidRich.selectOrderBy(new Orders3(), "id", new OrderType[] { OrderType.ASC });
//		Printer.printList(list);
		
		
		Condition condition=BF.getCondition();
		condition.start(0).size(10);
		
		condition.orderBy("id", OrderType.ASC);
		
		list=suidRich.select(new Orders3(), condition);	
		Printer.printList(list);
	
	}

}
