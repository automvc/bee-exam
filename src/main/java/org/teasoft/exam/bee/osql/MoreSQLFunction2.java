/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.bee.osql.entity.field.Orders_F;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.17
 */
public class MoreSQLFunction2 {
	
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		testSQLFun();
	}
	
	private static void testSQLFun() {
		Condition condition=BF.getCondition();
		condition
		.selectFun(FunctionType.MAX, Orders_F.id,"maxId")
		.selectFun(FunctionType.MIN, Orders_F.id,"minId");
		
		//不需要在Javabean定义maxId,minId属性,但要记住String[]对应列是什么数据
		List<String[]> list=suidRich.selectString(new Orders(),condition);
		Printer.print(list);
	}

}
