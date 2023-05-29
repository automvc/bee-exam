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
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 支持同时使用多种类型数据库的数据源.
 * <br>support different type database muli-Ds at same time.
 * @author Kingstar
 * @since  1.9
 */
public class DiffDdExam4 {
	
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

//		HoneyConfig.getHoneyConfig().multiDS_enable = true;
////		HoneyConfig.getHoneyConfig().multiDS_type = 2; //同时用多种DB,包含有mongodb不能使用multiDS_type = 2,因为mongodb不是使用JDBC的
//		HoneyConfig.getHoneyConfig().multiDS_differentDbType=true;
		HoneyConfig.getHoneyConfig().multiDS_defalutDS = "ds0";
		HoneyContext.setConfigRefresh(true); //涉及路由信息更新要刷新
		
		SuidRich suidRich =BF.getSuidRichForMongodb();
		Orders orders=new Orders();
		Condition condtion=BF.getCondition();
		
		orders=new Orders();
		List<Orders> list=suidRich.select(orders,condtion);
		Printer.printList(list);
		
	}

}
