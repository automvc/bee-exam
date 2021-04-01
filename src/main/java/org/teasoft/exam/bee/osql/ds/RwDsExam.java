/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.ds;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.bee.osql.transaction.Transaction;
import org.teasoft.exam.bee.osql.entity.LeafAlloc;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.core.SessionFactory;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author Kingstar
 * @since  1.8
 */
public class RwDsExam {

	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
//	private static String oldDbName="";
//	static {
//
//	}

	private static boolean isMysql() {
		return DatabaseConst.MYSQL.equalsIgnoreCase(HoneyContext.getDbDialect());
	}

	public static void test() {
	    String  oldDbName=HoneyConfig.getHoneyConfig().getDbName();
		HoneyConfig.getHoneyConfig().setDbName(DatabaseConst.MYSQL);
		if (isMysql()) initDS();
		
		if (isMysql()) {
			HoneyConfig.getHoneyConfig().multiDS_enable = true;
			HoneyConfig.getHoneyConfig().multiDS_type = 1;
			HoneyConfig.getHoneyConfig().multiDS_defalutDS = "ds1";
			HoneyConfig.getHoneyConfig().multiDS_writeDB = "ds1";
			HoneyConfig.getHoneyConfig().multiDS_readDB = "ds2,ds3";
			HoneyContext.setConfigRefresh(true);

			test1();
			test2();
			
			HoneyConfig.getHoneyConfig().multiDS_enable = false;
			HoneyConfig.getHoneyConfig().multiDS_type = 0;
			HoneyConfig.getHoneyConfig().multiDS_defalutDS = null;
			HoneyConfig.getHoneyConfig().multiDS_writeDB = null;
			HoneyConfig.getHoneyConfig().multiDS_readDB = null;
			BeeFactory.getInstance().setDataSourceMap(null);
			HoneyContext.setConfigRefresh(true);
		}
		
		HoneyConfig.getHoneyConfig().setDbName(oldDbName);
		
	}

	public static void main(String[] args) {
		test();
	}

	public static void initDS() {
		try {

			DruidDataSource dataSource1;
			dataSource1 = new DruidDataSource();
			dataSource1.setUrl("jdbc:mysql://localhost:3306/pro?characterEncoding=UTF-8");
			dataSource1.setUsername("root");
			dataSource1.setPassword("");
			dataSource1.init();

			DruidDataSource dataSource2;
			dataSource2 = new DruidDataSource();
			dataSource2.setUrl("jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8");
			dataSource2.setUsername("root");
			dataSource2.setPassword("");
			dataSource2.init();

			DruidDataSource dataSource3;
			dataSource3 = new DruidDataSource();
			dataSource3.setUrl("jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8");
			dataSource3.setUsername("root");
			dataSource3.setPassword("");
			dataSource3.init();

			Map<String, DataSource> dataSourceMap = new HashMap<>();
			dataSourceMap.put("ds1", dataSource1);
			dataSourceMap.put("ds2", dataSource2); //ds2
			dataSourceMap.put("ds3", dataSource3); //ds3
			BeeFactory.getInstance().setDataSourceMap(dataSourceMap);
			HoneyContext.setConfigRefresh(true);

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
	}

	public static void test2() {
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
			if(result!=null) Logger.info(result.toString());
			
			suidRich.select(leafAlloc,0,10);

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
	}

}
