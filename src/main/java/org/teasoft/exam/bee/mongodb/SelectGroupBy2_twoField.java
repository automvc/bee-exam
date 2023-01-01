/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.0
 */
public class SelectGroupBy2_twoField {
	
	public static void main(String[] args) {
		SuidRich suidRich=BF.getSuidRich();
		
		Condition c=BF.getCondition(); 
//		c.groupBy(Orders_F.abc);
		
//		c.groupBy("abc");
//		c.groupBy("name");
		c.groupBy("abc,name");
		
		List<Orders> list=suidRich.select(new Orders(), c);
//		List<Orders3> list=suidRich.select(new Orders3(), c);
		Printer.printList(list);
	}

}
