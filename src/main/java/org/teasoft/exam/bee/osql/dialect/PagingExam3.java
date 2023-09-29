/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.dialect;

import java.util.List;

import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.bee.osql.dialect.DbFeatureRegistry;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.bee.osql.moretable.entity.TestUser;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.17
 */
public class PagingExam3 {
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
	
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
//		test1011(); //test sql server 2012
		
//		sql server>=2012 ,use old type,用回旧语法
		HoneyConfig.getHoneyConfig().getDbName();
		DbFeatureRegistry.register(DatabaseConst.SQLSERVER, null); 
		HoneyConfig.getHoneyConfig().setDatabaseMajorVersion(0); 
		test1011(); 
	}
	
	private static void test1011() {
		Orders exampleField = new Orders();
		exampleField.setUserid("bee");
		
		Condition condition03=BF.getCondition();
		condition03.start(2).size(5);
//		condition03.orderBy("id", OrderType.DESC);
		condition03.orderBy("id");
		List<Orders> list03 = suidRich.select(exampleField, condition03);
		Printer.printList(list03);
		
//		Condition condition0=BF.getCondition();
//		condition0.selectDistinctField("name");
//		condition0.start(0).size(5);
//		List<Orders> list1 = suidRich.select(exampleField, condition0);
//		Printer.printList(list1);
//		
//		
//		Condition condition02=BF.getCondition();
//		condition02.size(5);
//		List<Orders> list02 = suidRich.select(exampleField, condition02);
//		Printer.printList(list02);
//		
//		//just use size parameter, and order by
//		Condition condition01=BF.getCondition();
//		condition01.size(5);
//		condition01.orderBy("id", OrderType.DESC);
//		List<Orders> list01 = suidRich.select(exampleField, condition01);
//		Printer.printList(list01);
	}

}
