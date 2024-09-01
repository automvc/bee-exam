/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.localdatetime.todate;

import java.time.LocalDateTime;
import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class ToDateExam {
	
	public static void main(String[] args) {
		SuidRich suidRich=BF.getSuidRich();
		LocaldatetimeTable selectBean=new LocaldatetimeTable();
		selectBean.setId(4);
		selectBean.setLocaldatetime(LocalDateTime.now());
//		selectBean.setExt("2024-07-04");
		List<LocaldatetimeTable> list=suidRich.select(selectBean);
		Printer.printList(list);
	}

}
