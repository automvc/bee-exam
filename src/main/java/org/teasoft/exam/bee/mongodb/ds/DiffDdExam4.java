/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.ds;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.mongodb.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 支持同时使用多种类型数据库的数据源.
 * <br>support different type database muli-Ds at same time.
 * @author Kingstar
 * @since  1.9
 */
public class DiffDdExam4 {
	
	static {
//		InitDsUtil.initDS();
	}
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {

		HoneyConfig.getHoneyConfig().multiDS_enable = false;
//		HoneyConfig.getHoneyConfig().multiDS_type = 2; //同时用多种DB,包含有mongodb不能使用multiDS_type = 2,因为mongodb不是使用JDBC的
		HoneyConfig.getHoneyConfig().multiDS_differentDbType=false;
		HoneyConfig.getHoneyConfig().multiDS_defalutDS = "ds0";
		
		SuidRich suidRich =BF.getSuidRichForMongodb();
		Orders orders=new Orders();
		Condition condtion=BF.getCondition();
		
		orders=new Orders();
		List<Orders> list=suidRich.select(orders,condtion);
		Printer.printList(list);
		
	}

}
