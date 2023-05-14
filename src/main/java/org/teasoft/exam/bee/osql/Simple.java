/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.11
 */
public class Simple {
	
	public static void main(String[] args) {
		Suid suid=BF.getSuid();
		Orders orders=new Orders();
		orders.setId(121L);
		List<Orders> list=suid.select(orders);
		Printer.printList(list);
		
		list.get(0).setName("-------------------");
		
		System.err.println("-------------------");
		
		List<Orders> list2=suid.select(orders);
		Printer.printList(list2);
		
		list2=suid.select(orders);
		
		suid.beginSameConnection();
		
		long t1=System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			list2=suid.select(orders);
		}
		suid.endSameConnection();
		
		long t2=System.currentTimeMillis();
		
		System.err.println((t2-t1)); //15143,14292 ;  15478
		//使用同一连接  1143,1221
		//628;533
	}
}
