/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.util.List;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Orders;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test3_ById {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		SuidRich suidRich =BF.getSuidRich();
		
//		Orders orders=new Orders();
//		orders.setAbc("test bee ");
//		orders.setName("mongodb");
//		orders.setId(10009L);
//		
//		suidRich.insert(orders);
		
		Orders orders=suidRich.selectById(Orders.class,10020L);
		if(orders!=null)System.out.println("selectById orders:"+orders.toString());
		System.out.println("----------------------------");
		
		orders=suidRich.selectById(Orders.class,"10021");
		if(orders!=null)System.out.println("selectById orders:"+orders.toString());
		System.out.println("----------------------------");
		
		List<Orders> list=suidRich.selectByIds(Orders.class,"10020,10021");
		Printer.printList(list);
		
		int delNum=suidRich.deleteById(Orders.class, 10017L);
		System.out.println("delNum:"+delNum);
		
		delNum=suidRich.deleteById(Orders.class, "10090,10091,10092,10093");
		System.out.println("delNum:"+delNum);
		
		System.out.println("finished!");
	}

}
