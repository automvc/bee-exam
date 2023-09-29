/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 

package org.teasoft.exam.bee.osql.ds;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.annotation.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.core.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

*//**
	* 支持同时使用多种类型数据库的数据源.
	* 同时使用Mysql,Oracle两种DB, 操作同一方法测试
	* <br>support different type database muli-Ds at same time.
	* @author Kingstar
	* @since  1.9
	*//*
		public class DiffDdExam_c3p0 {
		
		//	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
		static {
		//		InitDsUtil.initDS();
			
			ComboPooledDataSource ds0=new ComboPooledDataSource();
		//		ds0.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/bee?characterEncoding=UTF-8&amp;useSSL=false");
		//		ds0.setUser("root");
		//		ds0.setPassword("123456");
			
			ds0.setJdbcUrl("jdbc:ucanaccess://d:/school.accdb");
			ds0.setUser("");
			ds0.setPassword("");
			
			ComboPooledDataSource ds1=new ComboPooledDataSource();
		//		ds1.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/pro?characterEncoding=UTF-8&amp;useSSL=false");
		//		ds1.setUser("root");
		//		ds1.setPassword("123456");
			
			ds1.setJdbcUrl("jdbc:ucanaccess://d:/school-pw3.accdb");
			ds1.setUser("");
			ds1.setPassword("");
			
			Map<String, DataSource> dataSourceMap = new LinkedHashMap<>();
			dataSourceMap.put("ds0", ds0);
			dataSourceMap.put("ds1", ds1); 
			BeeFactory.getInstance().setDataSourceMap(dataSourceMap);
			
		}
		
		public static void main(String[] args) {
			test();
		}
		
		public static void test() {
			HoneyConfig.getHoneyConfig().multiDS_enable = true; //使用多数据源  多个数据源时必须设置
			HoneyConfig.getHoneyConfig().multiDS_differentDbType=true;  //同时要使用多种数据库,一定要设置
			HoneyContext.setConfigRefresh(true); 
			
			SuidRich suidRich1 = BeeFactory.getHoneyFactory().getSuidRich();
			suidRich1.setDataSourceName("ds0");
			test1(suidRich1);
			
			SuidRich suidRich2 = BeeFactory.getHoneyFactory().getSuidRich();
			suidRich2.setDataSourceName("ds1");
			test1(suidRich2);
			
			test1(suidRich1); //suidRich1
				
			}
		
		public static void test1(SuidRich suidRich) {
		
		//		LeafAlloc leafAlloc = new LeafAlloc();
		//		leafAlloc.setBizTag("bee");
		//		LeafAlloc result = suidRich.selectOne(leafAlloc);
		//		if (result != null) Logger.info(result.toString());
		//		
		//		
		//		Condition condition = new ConditionImpl();
		//		condition.setAdd("maxId", "step");
		//		int num = suidRich.update(leafAlloc, condition, "maxId");
		//		Logger.info("---------------------------------update num is :" + num);
		//
		//		//"SELECT biz_tag, max_id, step FROM leaf_alloc WHERE biz_tag = #{tag}"
		//		result = suidRich.selectOne(leafAlloc);
		//		if (result != null) Logger.info(result.toString());
		//
		//		result = suidRich.selectOne(leafAlloc);
		//		if (result != null) Logger.info(result.toString());
		//		Logger.info("-------------1--dbName: "+HoneyConfig.getHoneyConfig().getDbName());
		//		suidRich.select(leafAlloc,0,10);
		//		Logger.info("-------------2--dbName: "+HoneyConfig.getHoneyConfig().getDbName());
		//		suidRich.select(leafAlloc,10);
		//		Logger.info("-------------3--dbName: "+HoneyConfig.getHoneyConfig().getDbName());
		//		suidRich.select(leafAlloc,10);
		//		Logger.info("-------------4--dbName: "+HoneyConfig.getHoneyConfig().getDbName());
		//		
		//		//上个操作test1(),放入缓存,看下下个操作(不同DB类型),是否会从缓存中获取
		//		leafAlloc = new LeafAlloc();
		//		leafAlloc.setBizTag("bee");
		//		result = suidRich.selectOne(leafAlloc);
		//		if (result != null) Logger.info(result.toString()); 
		//		
		//		Logger.info("");
		//		Logger.info("+++++++++++++++++++++++====================================================+++++++++++++++++++++++");
			
			
		     Suid suid=BeeFactory.getHoneyFactory().getSuid();
			
			Orders orders1=new Orders();
		//		orders1.setId(100001L);
		//		orders1.setName("Bee(ORM Framework)");
			
			List<Orders> list1 =suid.select(orders1);  //select
			for (int i = 0; i < list1.size(); i++) {
				Logger.info(list1.get(i).toString());
			}
			
			suid.select(orders1); 
		}
		
		}
		*/