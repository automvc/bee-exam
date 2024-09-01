/*
getMongodbBeeSql() * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Orders3;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author AiTeaSoft
 * @since  2.0
 */
public class Test4_insertOrders3 {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		SuidRich suidRich =BF.getSuidRich();
		
		Orders3 orders=new Orders3();
//		
		List<Orders3> insertList=new ArrayList<>();
		orders.setId("0");
		orders.setRemark("changed 12112");
		insertList.add(orders);
//		
		for (int i = 1; i < 30; i++) {
			orders=new Orders3();
			orders.setName("mongodb" + i);
			orders.setId(10100L + i+"");
			orders.setRemark(i+"");
			
			insertList.add(orders);
		}
		
		int insertNum=suidRich.insert(insertList); //直接插入数据,会创建表.
//		int insertNum=suidRich.insert(insertList,3);
//		int insertNum=suidRich.insert(insertList,5);
		
		System.out.println("insertNum="+insertNum);
		
		
		
		
		System.out.println("finished!");
	}

}
