///*
// * Copyright 2016-2023 the original author.All rights reserved.
// * Kingstar(honeysoft@126.com)
// * The license,see the LICENSE file.
// */
//
//package org.teasoft.exam.bee.mongodb.file;
//
//import java.util.Date;
//import java.util.List;
//
//import org.teasoft.bee.osql.Condition;
//import org.teasoft.bee.osql.Op;
//import org.teasoft.bee.osql.SuidRich;
//import org.teasoft.exam.bee.mongodb.DateTypeTest;
//import org.teasoft.exam.comm.Printer;
//import org.teasoft.honey.osql.shortcut.BF;
//import org.teasoft.honey.osql.util.DateUtil;
//
//
///**
// * @author Kingstar
// * @since  2.1
// */
//public class DateTest2 {
//	
//	public static void main(String[] args) {
//		SuidRich suidRich=BF.getSuidRich();
//		
////		HoneyConfig.getHoneyConfig().dateFormat="yyyy-MM-dd HH:mm:ss.SSS";
//		
//		DateTypeTest orderhistory0=new DateTypeTest();
//		orderhistory0.setName("测试时间");
////		Date d=new Date();
//		Date d=DateUtil.currentDate2();
//		orderhistory0.setDate(d);
////		suidRich.insert(orderhistory0);  //存入数据库的是UTC
//		
//		DateTypeTest orderhistory=new DateTypeTest();
////		orderhistory.setDatetime(DateUtil.toTimestamp("2019-02-23 18:20:21"));
////		orderhistory.setDate(d);
////		orderhistory.setDate(DateUtil.toDate("2023-03-23 10:46:40"));
////		orderhistory.setDate(DateUtil.toDate("2023-03-23 10:57:15"));
//		
//		List<DateTypeTest>list=suidRich.select(orderhistory);
//		
//		Printer.printList(list);
//		
//		
//		DateTypeTest orderhistory2=new DateTypeTest();
////		orderhistory2.setDate(DateUtil.toDate("2023-03-23 10:46:40"));
//		
//		Condition condition=BF.getCondition();
//		condition.op("date", Op.ge, DateUtil.toDate("2023-03-23 10:57:15"));
//		
//		List<DateTypeTest> list2=suidRich.select(orderhistory2,condition);
//		
//		Printer.printList(list2);
//		
//	}
//
//}
