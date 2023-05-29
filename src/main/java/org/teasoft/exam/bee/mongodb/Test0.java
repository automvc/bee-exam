/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.util.List;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.mongodb.entity.Orders;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test0 {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		Suid suid=BF.getSuid();
		
		Orders orders=new Orders();
		orders.setAbc("test bee ");
		orders.setName("mongodb");
		orders.setId(10109L);
		
//		suid.insert(orders);
		
		
		
		List<Orders> list=suid.select(new Orders());
		Printer.printList(list);
		
		orders.setRemark("被修改了");
		orders.setAbc("test bee , update!");
		int updateNum=suid.update(orders);
		System.out.println("updateNum: "+updateNum);
		
		
		List<Orders> list2=suid.select(new Orders());
		Printer.printList(list2);
		
		
//		Orders ordersDel=new Orders();
////		ordersDel.setId(10003L);
////		ordersDel.setName("mongodb");
//		ordersDel.setName("mongodb");
//		int delNum=suid.delete(ordersDel);
//		System.out.println("delNum: "+delNum);
		
		System.out.println("finished!");
	}

}
