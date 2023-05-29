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
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test2_Between0 {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		SuidRich suidRich =BF.getSuidRich(); //SuidRich是包括Select,update,insert,delete操作的接口
		Condition condtion=BF.getCondition(); //Condition是构造条件的接口
		condtion.between(Orders_F.total, 72.72, 75.75);
//		condtion.and();
//		condtion.op(Orders_F.name, Op.eq, "mongodb73"); //增加过滤条件
		List<Orders> list=suidRich.select(new Orders(),condtion);
//		List<Orders> list=suidRich.select(new Orders()); //查询所有数据
		Printer.printList(list);
		
		System.out.println("finished!");
	}
}
