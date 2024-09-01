/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.localdatetime;

import java.sql.Timestamp;
import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;


/**
 * @author Kingstar
 * @since  2.4.0
 */
public class LocalDateTimeExam2 {
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		LocaldatetimeTable bean=new LocaldatetimeTable();
		bean.setId(10);
//		bean.setLocaldatetime(LocalDateTime.now());
		bean.setTimestamp(new Timestamp(System.currentTimeMillis()));
		
		SuidRich suidRich=BF.getSuidRich();
		int a=suidRich.insert(bean);
		Logger.info("insert num:"+a);
		
		LocaldatetimeTable selectBean=new LocaldatetimeTable();
//		selectBean.setId(2);
		selectBean.setId(4);
		List<LocaldatetimeTable> list=suidRich.select(selectBean);
		Printer.printList(list);
	}

}
