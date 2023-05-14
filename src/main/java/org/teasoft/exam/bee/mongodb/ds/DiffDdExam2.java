/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.ds;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.MoreTable;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.PreparedSql;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.bee.osql.transaction.Transaction;
import org.teasoft.exam.bee.mongodb.sharding.ClearDsAndMongoDsUtil;
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
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 支持同时使用多种类型数据库的数据源.
 * <br>support different type database muli-Ds at same time.
 * @author Kingstar
 * @since  1.9
 */
public class DiffDdExam2 {
	
//	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
//	private static PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
	
	private static SuidRich suidRich = null;
	private static PreparedSql preparedSql = null;
	
	static {
		ClearDsAndMongoDsUtil.clearConfig();
		InitOtherDsAndMongoDsUtil.initDS();
	}
	
	public static void main(String[] args) {
		try {
			test();
		} finally {
			ClearDsAndMongoDsUtil.clearConfig();
		}
	}
	
	public static void test() {
		
//		      数据源,也可以通过XML方式配置
//		   (二十二)ORM框架Bee,Spring配置多数据源实例
//		   https://blog.csdn.net/abckingaa/article/details/120956130
		
		    //这里这样赋值,是为了同时测试多种方式.  一般这种信息可直接配置在bee.properties
//			HoneyConfig.getHoneyConfig().multiDS_enable = true;
//			HoneyConfig.getHoneyConfig().multiDS_type = 2; //同时用多种DB,包含有mongodb不能使用multiDS_type = 2,因为mongodb不是使用JDBC的
//			HoneyConfig.getHoneyConfig().multiDS_differentDbType=true;
//			HoneyConfig.getHoneyConfig().multiDS_defalutDS = "ds0";
//			
//			HoneyConfig.getHoneyConfig().multiDS_sharding = false;
			
			
			
//			HoneyConfig.getHoneyConfig().multiDs_matchEntityClassPath = "ds2:org.teasoft.exam.bee.osql.entity.dynamic.Orders,com.xxx.cc.**;ds3:com.xxx.dd.User";
//			HoneyConfig.getHoneyConfig().multiDs_matchEntityClassPath = "ds2:org.teasoft.exam.bee.osql.entity.dynamic.Orders,org.teasoft.exam.bee.osql.moretable.entity.**;ds3:com.xxx.dd.User";
//			HoneyConfig.getHoneyConfig().multiDS_matchEntityClassPath = "ds2:org.teasoft.exam.bee.osql.entity.dynamic.Orders,org.teasoft.exam.bee.osql.moretable.entity.TestUser,org.teasoft.exam.bee.osql.moretable.entity.Orders;ds1:com.xxx.dd.User";
//			HoneyConfig.getHoneyConfig().multiDS_matchTable = "ds2:test_user";
//			HoneyContext.setConfigRefresh(true); 
			
//            System.out.println(">>>>>>>>>>>>>>>>>>>test2");
//			test2(); //与test1不同的数据源
//			
//            System.out.println(">>>>>>>>>>>>>>>>>>>test1");
////			test1();
//            System.out.println(">>>>>>>>>>>>>>>>>>>test2");
//			test2(); //与test1不同的数据源
			
			 System.out.println(">>>>>>>>>>>>>>>>>>>testForMongodb");
			 testForMongodb();   // entity.dynamic.Orders; 实体不一样,查不到数据.
			
            System.out.println(">>>>>>>>>>>>>>>>>>>test3");
//            HoneyConfig.getHoneyConfig().multiDS_defalutDS = "ds2";  // reset  
//            HoneyContext.setConfigRefresh(true);  //要显示刷新才会更改配置.
//            test3();
            
           
            
            //clear
//			HoneyConfig.getHoneyConfig().multiDS_enable = false;
//			HoneyConfig.getHoneyConfig().multiDS_type = 0;
//			HoneyConfig.getHoneyConfig().multiDS_differentDbType = false;
//			HoneyConfig.getHoneyConfig().multiDS_sharding=false;
//			BeeFactory.getInstance().setDataSource(null);
//          BeeFactory.getInstance().setDataSourceMap(null);
//          HoneyContext.setConfigRefresh(true);
		}
	
	
	public static void testForMongodb() {
		
		SuidRich suidRich =BF.getSuidRichForMongodb();
		suidRich.setDataSourceName("ds0");
		
		Orders orders=new Orders();
		Condition condtion=BF.getCondition();
		
//		orders=new Orders();
//		List<Orders> list=suidRich.select(orders,condtion);
//		Printer.printList(list);
		
		
		System.out.println("==============================================");
		System.out.println();
		Condition condtion6=BF.getCondition();
		
//		condtion6.between("num", 72, 75);
//		condtion6.notBetween("num", 72, 75);  //num是null的不会查出来
		
		condtion6.between("total", 72.72, 75.75);
//		condtion6.between("total", 72, 75.75);
//		condtion6.notBetween("total", 72.72, 75.75);

//		List<Orders> list6=suidRich.select(new Orders(),condtion6);
//		Printer.printList(list6);
		
		System.out.println("--------------------------------");
		try {
		condtion6.and();
		condtion6.op("name", Op.eq, "mongodb73");
		
			
		
		List<Orders> list7=suidRich.select(new Orders(),condtion6);
		Printer.printList(list7);
		
		} catch (Exception e) {
			System.err.println("===============ddsdsds==============");
			e.printStackTrace();
		}
		
	}
//	public static void test1() {
//
//		LeafAlloc leafAlloc = new LeafAlloc();
//		leafAlloc.setBizTag("bee");
//		Condition condition = new ConditionImpl();
//		condition.setAdd("maxId", "step");
//		int num = suidRich.update(leafAlloc, condition, "maxId");
//		Logger.info("---------------------------------update num is :" + num);
//
//		//"SELECT biz_tag, max_id, step FROM leaf_alloc WHERE biz_tag = #{tag}"
//		LeafAlloc result = suidRich.selectOne(leafAlloc);
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
////		suidRich.selectOne(leafAlloc);
////		suidRich.selectOne(leafAlloc);
//	}
//	
//	public static void test2() {
//		Orders orders=new Orders();
//		suidRich.setDynamicParameter("month", "_202007");
//		suidRich.select(orders,10);
//		List<Orders> list=suidRich.select(orders);
//		Printer.printList(list);
//		suidRich.select(orders,0,10);
//		
////		String sql = CustomSql.getCustomSql(Key);
//		String sql = "select * from orders where userid=?";
//		Logger.info("getCustomSql:  " + sql); 
//
//		preparedSql.select(sql, new Object[] { "bee" }, 1, 3);
////		preparedSql.select(sql, new Object[] { "bee" }, 1, 3);//test: don't use cache
////		preparedSql.select(sql, new Object[] { "bee" }, 1, 3);//test: don't use cache
//
//		List<String[]> lststr=preparedSql.select(sql,new Object[] { "bee" });
//		Printer.print(lststr);
//		
//		List<String[]> lststr2=preparedSql.select("select * from orders");
//		Printer.print(lststr2);
//		
//		List<Orders> list1 = preparedSql.selectSomeField(sql, new Orders(), new Object[] { "bee" }, 2, 3);
//		Printer.printList(list1);
//		
//		System.out.println("========================================MoreTable:   ");
//		MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
//
//		org.teasoft.exam.bee.osql.moretable.entity.Orders orders1 = new org.teasoft.exam.bee.osql.moretable.entity.Orders();
//		orders1.setUserid("bee");
//		orders1.setName("Bee");
//		
//		TestUser user = new TestUser();
//		user.setName("Bee");
//		orders1.setTestUser(user);
//		
//		//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
//		//List<Orders> list3 =moreTable.select(orders1);  //select
//		List<org.teasoft.exam.bee.osql.moretable.entity.Orders> list3 = moreTable.select(orders1, 0, 10); //select 查询前10条记录
//		if(list3!=null) {
//		Logger.info("size of records:"+list3.size() + "");
//		Printer.printList(list3);
//		}
//		
//		List<org.teasoft.exam.bee.osql.moretable.entity.Orders> list4 =moreTable.setDynamicParameter("month", "_202007").select(orders1, 0, 10);
//		if(list4!=null) Printer.printList(list4);
//	}
//
//	public static void test3() {
//		LeafAlloc result = null;
//		Transaction transaction = SessionFactory.getTransaction();
//		try {
//			transaction.begin();
//
////			"UPDATE leaf_alloc SET max_id = max_id + step WHERE biz_tag = #{tag}"
//			LeafAlloc leafAlloc = new LeafAlloc();
//			leafAlloc.setBizTag("bee");
//			Condition condition = new ConditionImpl();
//			condition.setAdd("maxId", "step");
////		    suidRich.update(leafAlloc, "maxId", condition);
//			suidRich.update(leafAlloc, condition); //v1.8
//
////		    "SELECT biz_tag, max_id, step FROM leaf_alloc WHERE biz_tag = #{tag}"
//			result = suidRich.selectOne(leafAlloc);
////			System.err.println(result);
//			if(result!=null) Logger.info(result.toString());
//			
//			suidRich.select(leafAlloc,10);
//			suidRich.select(leafAlloc,10);
//			suidRich.select(leafAlloc,0,10);
//
//			transaction.commit();
//		} catch (Exception e) {
//			transaction.rollback();
//		}
//	}

}
