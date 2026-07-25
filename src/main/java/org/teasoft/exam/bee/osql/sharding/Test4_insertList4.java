/*
getMongodbBeeSql() * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.sharding;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.exam.bee.osql.sharding.entity.Orders;

/**
 * @author Kingstar
 * @since  2.5.0
 */
public class Test4_insertList4 {
	
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
		
		List<Orders> list=suidRich.select(new Orders());
		System.out.println("-------------- list.size: "+list.size());
		Printer.printList(list);
		
		Orders orders=new Orders();
		
		List<Orders> insertList=new ArrayList<>();
		
		for (int i = 50; i < 60; i++) {
			orders=new Orders();
			orders.setId(i+0L);
			orders.setAbc("test bee ");
			orders.setName("mongodb" + i);
			orders.setUserid(3000L + i);
			orders.setOrderid(3000L + i);
//			orders.setRemark(null); //test null   mongodb,批量插入,不处理null
			orders.setTotal(new BigDecimal((i+i*0.01)+""));
			
			insertList.add(orders);
		}
		
		int insertNum=suidRich.insert(insertList);
		
		System.out.println("insertNum="+insertNum);
		
		list=suidRich.select(new Orders());
		System.out.println("-------------- list.size: "+list.size());
		Printer.printList(list);
		
		System.out.println("finished!");
	}

}
