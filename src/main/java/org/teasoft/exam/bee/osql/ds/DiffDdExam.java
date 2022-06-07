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
import org.teasoft.bee.osql.MoreTable;
import org.teasoft.bee.osql.PreparedSql;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.bee.osql.transaction.Transaction;
import org.teasoft.exam.bee.osql.entity.LeafAlloc;
import org.teasoft.exam.bee.osql.entity.dynamic.Orders;
import org.teasoft.exam.bee.osql.moretable.entity.TestUser;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.core.SessionFactory;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 支持同时使用多种类型数据库的数据源.
 * <br>support different type database muli-Ds at same time.
 * @author Kingstar
 * @since  1.9
 */
public class DiffDdExam {
	
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
	private static PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
	static {
		InitDsUtil.initDS();
	}
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		
//		      数据源,也可以通过XML方式配置
//		   (二十二)ORM框架Bee,Spring配置多数据源实例
//		   https://blog.csdn.net/abckingaa/article/details/120956130
		
			HoneyConfig.getHoneyConfig().multiDS_enable = true;
			HoneyConfig.getHoneyConfig().multiDS_type = 2;
			HoneyConfig.getHoneyConfig().multiDS_differentDbType=true;
			HoneyConfig.getHoneyConfig().multiDS_defalutDS = "ds1";
			
			
//			HoneyConfig.getHoneyConfig().multiDs_matchEntityClassPath = "ds2:org.teasoft.exam.bee.osql.entity.dynamic.Orders,com.xxx.cc.**;ds3:com.xxx.dd.User";
//			HoneyConfig.getHoneyConfig().multiDs_matchEntityClassPath = "ds2:org.teasoft.exam.bee.osql.entity.dynamic.Orders,org.teasoft.exam.bee.osql.moretable.entity.**;ds3:com.xxx.dd.User";
			HoneyConfig.getHoneyConfig().multiDS_matchEntityClassPath = "ds2:org.teasoft.exam.bee.osql.entity.dynamic.Orders,org.teasoft.exam.bee.osql.moretable.entity.TestUser,org.teasoft.exam.bee.osql.moretable.entity.Orders;ds3:com.xxx.dd.User";
			HoneyConfig.getHoneyConfig().multiDS_matchTable = "ds2:test_user";
			HoneyContext.setConfigRefresh(true); 
			
            System.out.println(">>>>>>>>>>>>>>>>>>>test1");
			test1();
            System.out.println(">>>>>>>>>>>>>>>>>>>test2");
			test2(); //oracle
            System.out.println(">>>>>>>>>>>>>>>>>>>test3");
//            HoneyConfig.getHoneyConfig().multiDS_defalutDS = "ds2";  // reset  
//            HoneyContext.setConfigRefresh(true);  //要显示刷新才会更改配置.
            test3();
            
            //clear
			HoneyConfig.getHoneyConfig().multiDS_enable = false;
			HoneyConfig.getHoneyConfig().multiDS_type = 0;
			HoneyConfig.getHoneyConfig().multiDS_differentDbType = false;
            BeeFactory.getInstance().setDataSourceMap(null);
            HoneyContext.setConfigRefresh(true);
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
		Logger.info("-------------1--dbName: "+HoneyConfig.getHoneyConfig().getDbName());
		suidRich.select(leafAlloc,0,10);
		Logger.info("-------------2--dbName: "+HoneyConfig.getHoneyConfig().getDbName());
		suidRich.select(leafAlloc,10);
		Logger.info("-------------3--dbName: "+HoneyConfig.getHoneyConfig().getDbName());
		suidRich.select(leafAlloc,10);
		Logger.info("-------------4--dbName: "+HoneyConfig.getHoneyConfig().getDbName());
		
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
		
//		String sql = CustomSql.getCustomSql(Key);
		String sql = "select * from orders where userid=?";
		Logger.info("getCustomSql:  " + sql); 

		preparedSql.select(sql, new Object[] { "bee" }, 1, 3);
//		preparedSql.select(sql, new Object[] { "bee" }, 1, 3);//test: don't use cache
//		preparedSql.select(sql, new Object[] { "bee" }, 1, 3);//test: don't use cache

		List<String[]> lststr=preparedSql.select(sql,new Object[] { "bee" });
		Printer.print(lststr);
		
		List<String[]> lststr2=preparedSql.select("select * from orders");
		Printer.print(lststr2);
		
		List<Orders> list1 = preparedSql.selectSomeField(sql, new Orders(), new Object[] { "bee" }, 2, 3);
		Printer.printList(list1);
		
		System.out.println("========================================MoreTable:   ");
		MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();

		org.teasoft.exam.bee.osql.moretable.entity.Orders orders1 = new org.teasoft.exam.bee.osql.moretable.entity.Orders();
		orders1.setUserid("bee");
		orders1.setName("Bee");
		
		TestUser user = new TestUser();
		user.setName("Bee");
		orders1.setTestUser(user);
		
		//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
		//List<Orders> list3 =moreTable.select(orders1);  //select
		List<org.teasoft.exam.bee.osql.moretable.entity.Orders> list3 = moreTable.select(orders1, 0, 10); //select 查询前10条记录
		if(list3!=null) {
		Logger.info("size of records:"+list3.size() + "");
		Printer.printList(list3);
		}
		
		List<org.teasoft.exam.bee.osql.moretable.entity.Orders> list4 =moreTable.setDynamicParameter("month", "_202007").select(orders1, 0, 10);
		if(list4!=null) Printer.printList(list4);
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
