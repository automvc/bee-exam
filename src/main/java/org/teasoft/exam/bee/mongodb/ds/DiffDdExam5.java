/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.ds;

import java.util.List;

import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Orders;
import org.teasoft.exam.bee.mongodb.sharding.ClearDsAndMongoDsUtil;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 支持同时使用多种类型数据库的数据源.
 * <br>support different type database muli-Ds at same time.
 * @author Kingstar
 * @since  1.9
 */
public class DiffDdExam5 {
	
	static {
		System.out.println("----------static--------");
		ClearDsAndMongoDsUtil.clearConfig();
		InitOtherDsAndMongoDsUtil.initDS();
	}
	
	public static void main(String[] args) {
		System.out.println("----------main--------");
		try {
			test();
		} finally {
			System.out.println("----------finally--------");
			ClearDsAndMongoDsUtil.clearConfig();
		}
	}
	
	public static void test() {

		HoneyConfig.getHoneyConfig().multiDS_enable = true;
		HoneyConfig.getHoneyConfig().multiDS_differentDbType=true;
//		HoneyConfig.getHoneyConfig().multiDS_defalutDS = "ds0";
//		HoneyConfig.getHoneyConfig().multiDS_type = 2; //同时用多种DB,包含有mongodb不宜使用multiDS_type = 2,因为mongodb不是使用JDBC的
		
		
		
		mysqlTest();
		
		mongodbTest();
		
//        //clear
//		HoneyConfig.getHoneyConfig().multiDS_enable = false;
//		HoneyConfig.getHoneyConfig().multiDS_type = 0;
//		HoneyConfig.getHoneyConfig().multiDS_differentDbType = false;
//        BeeFactory.getInstance().setDataSource(null);
//        BeeFactory.getInstance().setDataSourceMap(null);
//        HoneyContext.setConfigRefresh(true);
		
	}
	
	public static void mysqlTest() {
		System.out.println("----------mysqlTest--------");
		
		SuidRich suidRich =BF.getSuidRich();
		suidRich.setDataSourceName("ds1"); //set mysql dataSource
		Orders orders=new Orders();
		Condition condtion=BF.getCondition();
		condtion.start(2).size(5);
		condtion.selectField("id,userid,name,total");
		
		orders=new Orders();
		List<Orders> list=suidRich.select(orders,condtion);
		Printer.printList(list);
	}
	
	public static void mongodbTest() {
		System.out.println("----------mongodbTest--------");
		SuidRich suidRich =BF.getSuidRichForMongodb(); // ForMongodb
		suidRich.setDataSourceName("ds0");
		Orders orders=new Orders();
		Condition condtion=BF.getCondition();
		condtion.start(2).size(5);
		
		orders=new Orders();
		List<Orders> list=suidRich.select(orders,condtion);
		Printer.printList(list);
	}

}
