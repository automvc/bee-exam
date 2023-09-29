/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.dialect;

import java.util.List;

import org.teasoft.bee.osql.DatabaseConst;
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
public class PagingExam2 {
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
	
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		test1011(); //test sql server 2012
		
		//sql server>=2012 ,use old type,用回旧语法
//		HoneyConfig.getHoneyConfig().getDbName();
//		DbFeatureRegistry.register(DatabaseConst.SQLSERVER, null); 
//		HoneyConfig.getHoneyConfig().setDatabaseMajorVersion(0); 
//		test1011(); 

		
	}
	
	private static void test1011() {
		//多表分页
		MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
		org.teasoft.exam.bee.osql.moretable.entity.Orders orders1 = new org.teasoft.exam.bee.osql.moretable.entity.Orders();
		orders1.setUserid("bee");
		orders1.setName("Bee");
		
		TestUser user = new TestUser();
		//			user.setEmail("beeUser@163.com");
		user.setName("Bee");
		orders1.setTestUser(user);
		
		Condition condition10=BF.getCondition();
//		condition10.size(5);
		condition10.start(2).size(5);
		moreTable.select(orders1,condition10);
		
//		List<org.teasoft.exam.bee.osql.moretable.entity.Orders> list10 = moreTable.select(orders1, 0, 10); //select 查询前10条记录
//		List<org.teasoft.exam.bee.osql.moretable.entity.Orders> list10 = moreTable.select(orders1, 2, 10); //select 查询前10条记录
//		Logger.info("size of records:"+list10.size() + "");
	}

}
