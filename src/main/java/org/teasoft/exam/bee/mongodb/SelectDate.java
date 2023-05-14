/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.mongodb.entity.Report;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.0
 */
public class SelectDate {
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			
		
		SuidRich suidRich = BF.getSuidRich();
		Report p=new Report();
		SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = defaultFormat.parse("2022-10-14 24:01:00"); //北京时间， 出来也是这个， 储在库的是世界标准时间；所以从库拷贝出来，要加上8,才是北京时间
		Date date = defaultFormat.parse("2022-11-29 24:00:00");  //{"reportDate": {"$date": "2022-11-29T16:00:00Z"}}  已转成UTC
		
//		p.setId("63871dc062add35bac1bacb5");
		p.setReportDate(date);
		
//		p.setRemark("abc");
		
		Condition c=BF.getCondition();
		c.orderBy("id");
		c.start(0).size(3);
//		List<PatientReport> list=suidRich.select(p,0,3);
		List<Report> list=suidRich.select(p,c);
//		List<PatientReport> list=suidRich.select(new PatientReport(),0,1,"id,point9y,reportDate");
		System.err.println(list.size());
		Printer.printList(list);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
