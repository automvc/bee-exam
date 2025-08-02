/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.localdatetime;

import java.time.LocalDateTime;
import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.shortcut.BF;


/**
 * @author Kingstar
 * @since  2.4.0
 */
public class LocalDateTimeExam {
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		LocaldatetimeTable bean=new LocaldatetimeTable();
		bean.setId(13);
		bean.setLocaldatetime(LocalDateTime.now());
		
		SuidRich suidRich=BF.getSuidRich();
		int a=suidRich.insert(bean);
		Logger.info("insert num:"+a);
		
//		List<LocaldatetimeTable> list=suidRich.select(new LocaldatetimeTable());
//		Printer.printList(list);
	}

}
