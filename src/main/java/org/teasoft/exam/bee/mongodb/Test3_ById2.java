/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.util.List;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Noid0;
import org.teasoft.exam.bee.mongodb.entity.Orders;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test3_ById2 {
	
	public static void main(String[] args) {
		
		SuidRich suidRich =BF.getSuidRich();
		
//		Orders orders=new Orders();
//		orders.setAbc("test bee ");
//		orders.setName("mongodb");
//		orders.setId(10009L);
//		
//		suidRich.insert(orders);
		
//		Noid0 noid0=suidRich.selectById(new Noid0(),"63862e06bdcb6d0dac9c02c7");
		Noid0 noid0=suidRich.selectById(Noid0.class,"ewewewewew"); //不是mongodb的string id格式.
		if(noid0!=null)System.out.println("selectById Noid0:"+noid0.toString());
		else {
			System.out.println("it is null !");
		}
		
		List<Noid0> list=suidRich.selectByIds(Noid0.class,"63862e06bdcb6d0dac9c02c7,6386323f3f581a223ab8a10e,ewewewewew");
		Printer.printList(list);
		
		System.out.println("---------------test cache  in selectByIds----------------");
		list=suidRich.selectByIds(Noid0.class,"63862e06bdcb6d0dac9c02c7,6386323f3f581a223ab8a10e,ewewewewew");
		Printer.printList(list);
		
		
		List<Noid0> list2=suidRich.select(new Noid0());
		Printer.printList(list2);
		
		System.out.println("---------------test cache,  in select, find all------------");
		list2=suidRich.select(new Noid0());
		Printer.printList(list2);
		
		Orders orders=suidRich.selectById(Orders.class,"10021");
		System.out.println("selectById orders:"+orders.toString());
		System.out.println("---------------test cache,  in selectById----On Record------------");
		orders=suidRich.selectById(Orders.class,"10021");
		System.out.println("selectById orders:"+orders.toString());
//		
//		List<Orders> list=suidRich.selectByIds(new Orders(),"10020,10021");
//		Printer.printList(list);
//		
//		int delNum=suidRich.deleteById(Orders.class, 10017L);
//		System.out.println("delNum:"+delNum);
//		
//		delNum=suidRich.deleteById(Orders.class, "10090,10091,10092,10093");
//		System.out.println("delNum:"+delNum);
		
		System.out.println("finished!");
	}

}
