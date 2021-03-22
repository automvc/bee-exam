/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.ds;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.bee.osql.transaction.Transaction;
import org.teasoft.exam.bee.osql.entity.LeafAlloc;
import org.teasoft.exam.bee.osql.entity.dynamic.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.core.SessionFactory;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author Kingstar
 * @since  1.9
 */
public class DiffDsExam {
	
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
	static {
       initDS();
	}
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		
			HoneyConfig.getHoneyConfig().enableMultiDs = true;
			HoneyConfig.getHoneyConfig().multiDsType = 2;
			HoneyConfig.getHoneyConfig().multiDsDefalutDS = "ds1";
			
			HoneyConfig.getHoneyConfig().matchEntityClassPath = "ds2:org.teasoft.exam.bee.osql.entity.dynamic.Orders,com.xxx.cc.**;ds3:com.xxx.dd.User";
			HoneyConfig.getHoneyConfig().matchTable = "ds2:user";
			
//			#bee.dosql.multi-DS.different.dbType=true
			
            System.out.println(">>>>>>>>>>>>>>>>>>>test1");
			test1();
            System.out.println(">>>>>>>>>>>>>>>>>>>test2");
			test2(); //oracle
            System.out.println(">>>>>>>>>>>>>>>>>>>test3");
			test3();
		}

	public static void initDS() {
		try {

			DruidDataSource dataSource1;
			dataSource1 = new DruidDataSource();
			dataSource1.setUrl("jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8");
			dataSource1.setUsername("root");
			dataSource1.setPassword("");
			dataSource1.init();

//			DruidDataSource dataSource2;
//			dataSource2 = new DruidDataSource();
//			dataSource2.setUrl("jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8");
//			dataSource2.setUsername("root");
//			dataSource2.setPassword("");
//			dataSource2.init();
			
			DruidDataSource dataSource2;
			dataSource2 = new DruidDataSource();
			dataSource2.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			dataSource2.setUsername("scott");
			dataSource2.setPassword("aaa");
			dataSource2.init();

			DruidDataSource dataSource3;
			dataSource3 = new DruidDataSource();
			dataSource3.setUrl("jdbc:mysql://localhost:3306/pro?characterEncoding=UTF-8");
			dataSource3.setUsername("root");
			dataSource3.setPassword("");
			dataSource3.init();

			Map<String, DataSource> dataSourceMap = new HashMap<>();
			dataSourceMap.put("ds1", dataSource1);
			dataSourceMap.put("ds2", dataSource2); //ds2
			dataSourceMap.put("ds3", dataSource3); //ds3
			BeeFactory.getInstance().setDataSourceMap(dataSourceMap);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void test1() {

		LeafAlloc leafAlloc = new LeafAlloc();
		leafAlloc.setBizTag("bee");
		Condition condition = new ConditionImpl();
		condition.setAdd("maxId", "step");
		int num = suidRich.update(leafAlloc, "maxId", condition);
		Logger.info("---------------------------------update num is :" + num);

		//"SELECT biz_tag, max_id, step FROM leaf_alloc WHERE biz_tag = #{tag}"
		LeafAlloc result = suidRich.selectOne(leafAlloc);
		if (result != null) Logger.info(result.toString());

		result = suidRich.selectOne(leafAlloc);
		if (result != null) Logger.info(result.toString());
		
		suidRich.select(leafAlloc,0,10);
		suidRich.select(leafAlloc,10);
		suidRich.select(leafAlloc,10);
		
//		suidRich.selectOne(leafAlloc);
//		suidRich.selectOne(leafAlloc);
	}
	
	public static void test2() {
		Orders orders=new Orders();
		suidRich.setDynamicParameter("month", "_202007");
		suidRich.select(orders,10);
		List<Orders> list=suidRich.select(orders);
		Printer.printList(list);
		suidRich.select(orders,0,10);
	}

	public static void test3() {
		LeafAlloc result = null;
		Transaction transaction = SessionFactory.getTransaction();
		try {
			transaction.begin();

//			"UPDATE leaf_alloc SET max_id = max_id + step WHERE biz_tag = #{tag}"
			LeafAlloc leafAlloc = new LeafAlloc();
			leafAlloc.setBizTag("bee");
			Condition condition = new ConditionImpl();
			condition.setAdd("maxId", "step");
//		    suidRich.update(leafAlloc, "maxId", condition);
			suidRich.update(leafAlloc, condition); //v1.8

//		    "SELECT biz_tag, max_id, step FROM leaf_alloc WHERE biz_tag = #{tag}"
			result = suidRich.selectOne(leafAlloc);
//			System.err.println(result);
			if(result!=null) Logger.info(result.toString());
			
			suidRich.select(leafAlloc,10);
			suidRich.select(leafAlloc,10);
			suidRich.select(leafAlloc,0,10);

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
	}

}
