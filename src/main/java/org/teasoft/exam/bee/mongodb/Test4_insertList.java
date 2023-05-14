/*
getMongodbBeeSql() * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Orders;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test4_insertList {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		SuidRich suidRich =BF.getSuidRich();
		
		Orders orders=new Orders();
		
		List<Orders> insertList=new ArrayList<>();
		
		for (int i = 30; i < 40; i++) {
			orders=new Orders();
			orders.setAbc("test bee ");
			orders.setName("mongodb" + i);
//			orders.setId(10200L + i);
			orders.setNum(i);
			orders.setTotal(new BigDecimal((i+i*0.01)+""));
			
			insertList.add(orders);
		}
		
		int insertNum=suidRich.insert(insertList);
//		int insertNum=suidRich.insert(insertList,3);
//		int insertNum=suidRich.insert(insertList,5);
		
		System.out.println("insertNum="+insertNum);
		
		
		
		orders=new Orders();
		orders.setAbc("test bee ");
		orders.setName("mongodb" + 99);
//		orders.setId(10300L + 99);
//		long returnId=suidRich.insertAndReturnId(orders);
		long returnId=suidRich.insertAndReturnId(orders,IncludeType.EXCLUDE_BOTH);
		System.out.println("returnId:  "+returnId);
		
		System.out.println("finished!");
	}

}
