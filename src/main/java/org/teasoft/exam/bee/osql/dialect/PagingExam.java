/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.dialect;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.bee.osql.MoreTable;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.bee.osql.dialect.DbFeatureRegistry;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.bee.osql.moretable.entity.TestUser;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyUtil;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.17
 */
public class PagingExam {
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
	
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
//		test1011(); //test sql server 2012
		
		//sql server>=2012 ,use old type,用回旧语法
		HoneyConfig.getHoneyConfig().getDbName();
		DbFeatureRegistry.register(DatabaseConst.SQLSERVER, null); 
		HoneyConfig.getHoneyConfig().setDatabaseMajorVersion(0); 
		test1011(); 

		
	}
	
	private static void test1011() {
		Orders exampleField = new Orders();
		exampleField.setUserid("bee");
		//      select some fields
//		List<Orders> selectSomeField = suidRich.select(exampleField, "name,total");
//		List<Orders> selectSomeField = suidRich.select(exampleField,0,5, "name,total");
		List<Orders> selectSomeField = suidRich.select(exampleField,2,5, "name,total");
		
//		List<Orders> selectSomeField = suidRich.select(exampleField, 5);
		Printer.printList(selectSomeField);
		
		Condition condition0=BF.getCondition();
		condition0.selectDistinctField("name");
		condition0.start(0).size(5);
		List<Orders> list1 = suidRich.select(exampleField, condition0);
		Printer.printList(list1);
		
		
		Condition condition02=BF.getCondition();
		condition02.size(5);
		List<Orders> list02 = suidRich.select(exampleField, condition02);
		Printer.printList(list02);
		
		//just use size parameter, and order by
		Condition condition01=BF.getCondition();
		condition01.size(5);
		condition01.orderBy("id", OrderType.DESC);
		List<Orders> list01 = suidRich.select(exampleField, condition01);
		Printer.printList(list01);
		
		Condition condition03=BF.getCondition();
		condition03.start(2).size(5);
//		condition03.orderBy("id", OrderType.DESC);
		condition03.orderBy("id");
		List<Orders> list03 = suidRich.select(exampleField, condition03);
		Printer.printList(list03);
		
		Condition condition04=BF.getCondition();
		condition04.start(2).size(5);
//		condition03.orderBy("id", OrderType.DESC);
		condition04.orderBy("uuId");
		List<Noid2> list04 = suidRich.select(new Noid2(), condition04);
		Printer.printList(list04);
		
		
		Condition condition=BF.getCondition();
//		condition.selectDistinctField("name");
		condition.orderBy("id", OrderType.DESC);
//		condition.start(0).size(5);
		condition.start(2).size(5);
		
		List<Orders> list2 = suidRich.select(exampleField, condition);
		Printer.printList(list2);
		
		List<Orders> list3 = suidRich.select(exampleField,1,3);
		Printer.printList(list3);
		System.err.println("================");
		int  pageSize=3; //每页3条数据
		for (int pageNum = 1; pageNum <= 3; pageNum++) { //查询第1,2,3页
			list3 = suidRich.select(exampleField,(pageNum-1)*pageSize+1,pageSize); //start=(pageNum-1)*pageSize+1
			Printer.printList(list3);
		}
		
//		每页3条数据
//		page1:
//			1
//			2
//			3
//		page2:
//			4
//			5
//			6
		
		//测试自定义主键情形
		List<Noid> list4 = suidRich.select(new Noid(),3);
		Printer.printList(list4);
		
		suidRich.select(new Noid(),2,3);
		suidRich.select(new Noid(),0,3,"uuid");
		String json=suidRich.selectJson(new Noid(),0,3,"uuid");
		Logger.info(json);
		
		Condition condition5=BF.getCondition();
		condition5.size(5);
		List<Noid> list5 = suidRich.select(new Noid(),condition5);
		Printer.printList(list5);
		
		//测试主键字段要命名转换
		suidRich.select(new Noid2(),2,3);
		suidRich.select(new Noid2(),0,3,"uuId");
		
		Condition condition6=BF.getCondition();
		condition6.size(5);
		List<Noid2> list6 = suidRich.select(new Noid2(),condition6);
		
		//多表分页
		MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
		org.teasoft.exam.bee.osql.moretable.entity.Orders orders1 = new org.teasoft.exam.bee.osql.moretable.entity.Orders();
		orders1.setUserid("bee");
		orders1.setName("Bee");
		
		TestUser user = new TestUser();
		//			user.setEmail("beeUser@163.com");
		user.setName("Bee");
		orders1.setTestUser(user);
		
		if(!HoneyUtil.isMongoDB()) { //V2.0 MongoDB不支持多表分页
		Condition condition10=BF.getCondition();
		condition10.size(5);
		moreTable.select(orders1,condition10);
		}
		
//		List<org.teasoft.exam.bee.osql.moretable.entity.Orders> list10 = moreTable.select(orders1, 0, 10); //select 查询前10条记录
//		List<org.teasoft.exam.bee.osql.moretable.entity.Orders> list10 = moreTable.select(orders1, 2, 10); //select 查询前10条记录
//		Logger.info("size of records:"+list10.size() + "");
	}

}
