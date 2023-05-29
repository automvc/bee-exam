/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.file;

import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.mongodb.ds.Orderhistory;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.osql.util.DateUtil;


/**
 * @author Kingstar
 * @since  2.1
 */
public class DateTest {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		SuidRich suidRich=BF.getSuidRich();
		
		HoneyConfig.getHoneyConfig().dateFormat="yyyy-MM-dd HH:mm:ss.SSS";
		
		Orderhistory orderhistory0=new Orderhistory();
		orderhistory0.setName("测试时间");
		orderhistory0.setDatetime(DateUtil.currentTimestamp());
//		suidRich.insert(orderhistory0);
		
		Orderhistory orderhistory=new Orderhistory();
//		orderhistory.setDatetime(DateUtil.toTimestamp("2019-02-23 18:20:21"));
		orderhistory.setDatetime(DateUtil.toTimestamp("2023-03-23 10:07:41.235"));
		
		
		
		List<Orderhistory>list=suidRich.select(orderhistory);
		
		Printer.printList(list);
		
		
		
		
	}

}
