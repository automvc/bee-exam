/*
getMongodbBeeSql() * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Noid0;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test4_insert {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		SuidRich suidRich =BF.getSuidRich();
		
//		Orders orders=new Orders();
//		
//		List<Orders> insertList=new ArrayList<>();
//		
//		for (int i = 60; i < 70; i++) {
//			orders=new Orders();
//			orders.setAbc("test bee ");
//			orders.setName("mongodb" + i);
//			orders.setId(10100L + i);
//			
//			insertList.add(orders);
//		}
		
//		int insertNum=suidRich.insert(insertList);
//		int insertNum=suidRich.insert(insertList,3);
//		int insertNum=suidRich.insert(insertList,5);
		
//		System.out.println("insertNum="+insertNum);
		
		
		
//		orders=new Orders();
		Noid0 noid0=new Noid0();
//		orders.setAbc("test bee ");
		noid0.setName("mongodb" + 102);
		noid0.setNum(102);
//		orders.setId(10100L + 98);
//		long returnId=suidRich.insertAndReturnId(orders);
		int a=suidRich.insert(noid0);
		System.out.println("a:  "+a);
//		long aa=suidRich.insertAndReturnId(noid0);  //bug
//		System.out.println("aa:  "+aa);
		
		System.out.println("finished!");
	}

}
