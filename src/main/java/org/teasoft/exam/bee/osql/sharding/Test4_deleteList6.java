/*
getMongodbBeeSql() * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding;

import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.5.0
 */
public class Test4_deleteList6 {
	
	public static void main(String[] args) {
		try {
			InitSameDsUtil2.initDS();
			ShardingInitData2.init();
			test();
		} finally {
		}
	}

	public static void test() {
		
		SuidRich suidRich =BF.getSuidRich();
		
		Orders orders=new Orders();
		List<Orders> list=suidRich.select(new Orders());
		System.out.println("-------------- list.size: "+list.size());
		Printer.printList(list);
		
//		List<Orders> insertList=new ArrayList<>();
		
//		for (int i = 50; i < 60; i++) {
//			orders=new Orders();
//			orders.setId(i+0L);
//			orders.setAbc("test bee ");
//			orders.setName("mongodb" + i);
////			orders.setUserid(3000L + i); //注释,没有分片键时,就走full
////			orders.setRemark(null); //test null   mongodb,批量插入,不处理null
//			orders.setTotal(new BigDecimal((i+i*0.01)+""));
////			int a=suidRich.update(orders);
//			int a=suidRich.delete(orders);
//			System.out.println("delete num:"+a);
////			insertList.add(orders);
//		}
		
		int a = suidRich.deleteById(Orders.class, 51L);
		System.out.println("delete num:"+a);
		
		list=suidRich.select(new Orders());//test clear cache		
		System.out.println("-------------- list.size: "+list.size());
		Printer.printList(list);
		
		System.out.println("finished!");
	}

}
